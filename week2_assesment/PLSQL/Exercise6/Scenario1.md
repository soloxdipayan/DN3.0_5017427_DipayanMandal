# Scenario 1: Generate monthly statements for all customers.
## Question: Write a PL/SQL block using an explicit cursor GenerateMonthlyStatements that retrieves all transactions for the current month and prints a statement for each customer.
## Answer
```sql
DECLARE
    CURSOR transaction_cursor IS
        SELECT t.TransactionID, t.AccountID, t.TransactionDate, t.Amount, t.TransactionType, c.CustomerID, c.Name
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE t.TransactionDate BETWEEN TRUNC(SYSDATE, 'MM') AND LAST_DAY(SYSDATE);
    
    v_TransactionID Transactions.TransactionID%TYPE;
    v_AccountID Transactions.AccountID%TYPE;
    v_TransactionDate Transactions.TransactionDate%TYPE;
    v_Amount Transactions.Amount%TYPE;
    v_TransactionType Transactions.TransactionType%TYPE;
    v_CustomerID Customers.CustomerID%TYPE;
    v_CustomerName Customers.Name%TYPE;
BEGIN
    OPEN transaction_cursor;
    LOOP
        FETCH transaction_cursor INTO v_TransactionID, v_AccountID, v_TransactionDate, v_Amount, v_TransactionType, v_CustomerID, v_CustomerName;
        EXIT WHEN transaction_cursor%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Customer: ' || v_CustomerName || ' (ID: ' || v_CustomerID || ')');
        DBMS_OUTPUT.PUT_LINE('Transaction ID: ' || v_TransactionID || ', Date: ' || v_TransactionDate || ', Amount: ' || v_Amount || ', Type: ' || v_TransactionType);
        DBMS_OUTPUT.PUT_LINE('----------------------------------------');
    END LOOP;
    CLOSE transaction_cursor;
END;
/
```
