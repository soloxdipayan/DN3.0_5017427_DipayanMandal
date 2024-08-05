# Scenario 3: Group all account-related operations into a package.
## 	Question: Create a package AccountOperations with procedures for opening a new account, closing an account, and a function to get the total balance of a customer across all accounts.
## Answer
Package Specification:
```sql
CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(
        p_AccountID IN Accounts.AccountID%TYPE,
        p_CustomerID IN Accounts.CustomerID%TYPE,
        p_AccountType IN Accounts.AccountType%TYPE,
        p_Balance IN Accounts.Balance%TYPE,
        p_LastModified IN Accounts.LastModified%TYPE
    );

    PROCEDURE CloseAccount(
        p_AccountID IN Accounts.AccountID%TYPE
    );

    FUNCTION GetTotalBalance(
        p_CustomerID IN Accounts.CustomerID%TYPE
    ) RETURN NUMBER;
END AccountOperations;
/
```
Package Body:
```sql
CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE OpenAccount(
        p_AccountID IN Accounts.AccountID%TYPE,
        p_CustomerID IN Accounts.CustomerID%TYPE,
        p_AccountType IN Accounts.AccountType%TYPE,
        p_Balance IN Accounts.Balance%TYPE,
        p_LastModified IN Accounts.LastModified%TYPE
    ) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_AccountID, p_CustomerID, p_AccountType, p_Balance, p_LastModified);
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Account ID ' || p_AccountID || ' already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END OpenAccount;

    PROCEDURE CloseAccount(
        p_AccountID IN Accounts.AccountID%TYPE
    ) IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_AccountID;
        COMMIT;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Account ID ' || p_AccountID || ' does not exist.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END CloseAccount;

    FUNCTION GetTotalBalance(
        p_CustomerID IN Accounts.CustomerID%TYPE
    ) RETURN NUMBER IS
        v_TotalBalance NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_TotalBalance
        FROM Accounts
        WHERE CustomerID = p_CustomerID;
        RETURN v_TotalBalance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            RETURN NULL;
    END GetTotalBalance;
END AccountOperations;
/
```