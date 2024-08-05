# Scenario 3: Customers should be able to transfer funds between their accounts.
## 	Question: Write a stored procedure TransferFunds that transfers a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.
## Answer
To maintain the logging and log table has to be created.
```sql
CREATE TABLE ErrorLog (
    ErrorID NUMBER PRIMARY KEY,
    ErrorMessage VARCHAR2(4000),
    ErrorDate DATE
);
```
Stored procedure TransferFunds 
```sql
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_FromAccountID IN Accounts.AccountID%TYPE,
    p_ToAccountID IN Accounts.AccountID%TYPE,
    p_Amount IN NUMBER
) IS
    v_FromBalance Accounts.Balance%TYPE;
BEGIN
    -- Check from account's sufficient funds
    SELECT Balance INTO v_FromBalance
    FROM Accounts
    WHERE AccountID = p_FromAccountID
    FOR UPDATE;

    IF v_FromBalance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the source account.');
    END IF;

    -- Deduct amount from source acc
    UPDATE Accounts
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_FromAccountID;

    -- Add amount to destination acc
    UPDATE Accounts
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_ToAccountID;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (SQLERRM, SYSDATE);
        RAISE;
END TransferFunds;
/
```