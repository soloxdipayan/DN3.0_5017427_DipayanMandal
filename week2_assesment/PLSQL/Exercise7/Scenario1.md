# 
## 	
## Answer
Package Specification:
```sql
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddNewCustomer(
        p_CustomerID IN Customers.CustomerID%TYPE,
        p_Name IN Customers.Name%TYPE,
        p_DOB IN Customers.DOB%TYPE,
        p_Balance IN Customers.Balance%TYPE,
        p_LastModified IN Customers.LastModified%TYPE
    );

    PROCEDURE UpdateCustomerDetails(
        p_CustomerID IN Customers.CustomerID%TYPE,
        p_Name IN Customers.Name%TYPE,
        p_DOB IN Customers.DOB%TYPE,
        p_Balance IN Customers.Balance%TYPE
    );

    FUNCTION GetCustomerBalance(
        p_CustomerID IN Customers.CustomerID%TYPE
    ) RETURN NUMBER;
END CustomerManagement;

/
```
Package Body:

```sql
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddNewCustomer(
        p_CustomerID IN Customers.CustomerID%TYPE,
        p_Name IN Customers.Name%TYPE,
        p_DOB IN Customers.DOB%TYPE,
        p_Balance IN Customers.Balance%TYPE,
        p_LastModified IN Customers.LastModified%TYPE
    ) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, p_LastModified);
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Customer ID ' || p_CustomerID || ' already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END AddNewCustomer;

    PROCEDURE UpdateCustomerDetails(
        p_CustomerID IN Customers.CustomerID%TYPE,
        p_Name IN Customers.Name%TYPE,
        p_DOB IN Customers.DOB%TYPE,
        p_Balance IN Customers.Balance%TYPE
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_Name, DOB = p_DOB, Balance = p_Balance, LastModified = SYSDATE
        WHERE CustomerID = p_CustomerID;
        COMMIT;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Customer ID ' || p_CustomerID || ' does not exist.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END UpdateCustomerDetails;

    FUNCTION GetCustomerBalance(
        p_CustomerID IN Customers.CustomerID%TYPE
    ) RETURN NUMBER IS
        v_Balance Customers.Balance%TYPE;
    BEGIN
        SELECT Balance INTO v_Balance
        FROM Customers
        WHERE CustomerID = p_CustomerID;
        RETURN v_Balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            RETURN NULL;
    END GetCustomerBalance;
END CustomerManagement;

/
```

