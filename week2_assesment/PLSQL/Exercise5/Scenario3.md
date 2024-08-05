# Scenario 3: Enforce business rules on deposits and withdrawals.
## 	Question: Write a trigger CheckTransactionRules that ensures withdrawals do not exceed the balance and deposits are positive before inserting a record into the Transactions table.
## Answer
```sql
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_Balance Accounts.Balance%TYPE;
BEGIN
    -- fetch current balance of the account
    SELECT Balance INTO v_Balance
    FROM Accounts
    WHERE AccountID = :NEW.AccountID
    FOR UPDATE;

    -- check if  transaction is withdrawal ornot
    IF :NEW.TransactionType = 'Withdrawal' THEN
        IF :NEW.Amount > v_Balance THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds for withdrawal.');
        END IF;
    ELSIF :NEW.TransactionType = 'Deposit' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
        END IF;
    END IF;
END CheckTransactionRules;
/
```
