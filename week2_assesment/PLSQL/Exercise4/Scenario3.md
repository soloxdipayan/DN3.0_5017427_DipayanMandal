# Scenario 3: Check if a customer has sufficient balance before making a transaction.
## 	Question: Write a function HasSufficientBalance that takes an account ID and an amount as input and returns a boolean indicating whether the account has at least the specified amount.
## Answer


```sql
CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_AccountID IN Accounts.AccountID%TYPE,
    p_Amount IN NUMBER
) RETURN BOOLEAN IS
    v_Balance Accounts.Balance%TYPE;
BEGIN
    SELECT Balance INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_AccountID;
    
    IF v_Balance >= p_Amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END HasSufficientBalance;
/
```