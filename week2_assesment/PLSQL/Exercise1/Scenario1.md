## Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
#  o	Question: Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.
 ## answer

```plsql
DECLARE

    v_customer_id customers.CUSTOMERID%TYPE;
    v_dob customers.DOB%TYPE;
    v_loan_id loans.LOANID%TYPE;
    v_loan_interest_rate loans.INTERESTRATE%TYPE;
    v_age NUMBER;
BEGIN
    FOR rec IN (SELECT c.CUSTOMERID, c.DOB, l.LOANID, l.INTERESTRATE
                FROM customers c
                JOIN loans l ON c.CUSTOMERID = l.CUSTOMERID) LOOP
       
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, rec.dob) / 12);
        
       
        IF v_age > 60 THEN
           
            v_loan_interest_rate := rec.INTERESTRATE * 0.99;
            
          
            UPDATE loans
            SET loans.INTERESTRATE = v_loan_interest_rate
            WHERE loans.LOANID = rec.LOANID;
            
        END IF;
        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || rec.CUSTOMERID ||  ', Updated Loan Interest Rate: ' || v_loan_interest_rate);

    END LOOP;
    
    
    
    COMMIT;
END;
/
```
    