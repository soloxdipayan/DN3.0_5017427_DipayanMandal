# Scenario 2: Maintain an audit log for all transactions.
## 	Question: Write a trigger UpdateCustomerLastModified that updates the LastModified column of the Customers table to the current date whenever a customer's record is updated.
## Answer
First to create the AuditLog table:
```sql
CREATE TABLE AuditLog (
    AuditID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    LogDate DATE
);
```

Now to create the trigger:

```sql
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_Balance Accounts.Balance%TYPE;
BEGIN
    -- current balance of account
    SELECT Balance INTO v_Balance
    FROM Accounts
    WHERE AccountID = :NEW.AccountID
    FOR UPDATE;

    -- check if the transaction is withdrawal
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