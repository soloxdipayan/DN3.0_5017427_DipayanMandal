# Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.
## Question: Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer.
## Answer
To open the output we have to first run the following sql query:
```sql
SET SERVEROUTPUT ON;
```
Now the following query:
```sql
DECLARE
    v_CustomerName Customers.Name%TYPE;
BEGIN
    FOR loan_rec IN (
        SELECT LoanID, CustomerID, EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        SELECT Name INTO v_CustomerName
        FROM Customers
        WHERE CustomerID = loan_rec.CustomerID;
        
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || v_CustomerName || ', your loan (ID: ' || loan_rec.LoanID || ') is due on ' || loan_rec.EndDate || '.');
    END LOOP;
END;
/
```