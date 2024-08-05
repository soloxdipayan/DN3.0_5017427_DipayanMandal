## Scenario 3: Ensure data integrity when adding a new customer.
# Question: Write a stored procedure AddNewCustomer that inserts a new customer into the Customers table. If a customer with the same ID already exists, handle the exception by logging an error and preventing the insertion.
# Answer
To maintain the logging and log table has to be created.
```sql
CREATE TABLE ErrorLog (
    ErrorID NUMBER PRIMARY KEY,
    ErrorMessage VARCHAR2(4000),
    ErrorDate DATE
);
```
Stored procedure AddNewCustomer 
```sql
CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_CustomerID IN Customers.CustomerID%TYPE,
    p_Name IN Customers.Name%TYPE,
    p_DOB IN Customers.DOB%TYPE,
    p_Balance IN Customers.Balance%TYPE,
    p_LastModified IN Customers.LastModified%TYPE
) IS
BEGIN
    -- Insert the new customer
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, p_LastModified);

    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES ('Customer ID ' || p_CustomerID || ' already exists.', SYSDATE);
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (SQLERRM, SYSDATE);
        RAISE;
END AddNewCustomer;
/
```