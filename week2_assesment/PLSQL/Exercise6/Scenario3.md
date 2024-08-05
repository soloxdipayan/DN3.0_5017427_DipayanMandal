# Scenario 3: Update the interest rate for all loans based on a new policy.
## 	Question: Write a PL/SQL block using an explicit cursor UpdateLoanInterestRates that fetches all loans and updates their interest rates based on the new policy.
## Answer
```sql
DECLARE
    CURSOR loan_cursor IS
        SELECT LoanID, InterestRate
        FROM Loans;
    
    v_LoanID Loans.LoanID%TYPE;
    v_InterestRate Loans.InterestRate%TYPE;
    v_NewInterestRate CONSTANT NUMBER := 5; --as of now 5% is the new interest rate
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_LoanID, v_InterestRate;
        EXIT WHEN loan_cursor%NOTFOUND;
        
        UPDATE Loans
        SET InterestRate = v_NewInterestRate
        WHERE LoanID = v_LoanID;
    END LOOP;
    CLOSE loan_cursor;
    COMMIT;
END;
/
```