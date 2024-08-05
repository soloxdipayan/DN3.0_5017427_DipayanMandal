# Scenario 2: Apply annual fee to all accounts.
## 	Question: Write a PL/SQL block using an explicit cursor ApplyAnnualFee that deducts an annual maintenance fee from the balance of all accounts.
## Answer
```sql
DECLARE
    CURSOR account_cursor IS
        SELECT AccountID, Balance
        FROM Accounts;
    
    v_AccountID Accounts.AccountID%TYPE;
    v_Balance Accounts.Balance%TYPE;
    v_AnnualFee CONSTANT NUMBER := 50; --assuming 50/- as annual fee
BEGIN
    OPEN account_cursor;
    LOOP
        FETCH account_cursor INTO v_AccountID, v_Balance;
        EXIT WHEN account_cursor%NOTFOUND;
        
        UPDATE Accounts
        SET Balance = Balance - v_AnnualFee
        WHERE AccountID = v_AccountID;
    END LOOP;
    CLOSE account_cursor;
    COMMIT;
END;
/
```