# Scenario 2: Create a package to manage employee data.
## Question: Write a package EmployeeManagement with procedures to hire new employees, update employee details, and a function to calculate annual salary.
## Answer
Package Specification:
```sql
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(
        p_EmployeeID IN Employees.EmployeeID%TYPE,
        p_Name IN Employees.Name%TYPE,
        p_Position IN Employees.Position%TYPE,
        p_Salary IN Employees.Salary%TYPE,
        p_Department IN Employees.Department%TYPE,
        p_HireDate IN Employees.HireDate%TYPE
    );

    PROCEDURE UpdateEmployeeDetails(
        p_EmployeeID IN Employees.EmployeeID%TYPE,
        p_Name IN Employees.Name%TYPE,
        p_Position IN Employees.Position%TYPE,
        p_Salary IN Employees.Salary%TYPE,
        p_Department IN Employees.Department%TYPE
    );

    FUNCTION CalculateAnnualSalary(
        p_EmployeeID IN Employees.EmployeeID%TYPE
    ) RETURN NUMBER;
END EmployeeManagement;

/
```
Package Body:
```sql
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireEmployee(
        p_EmployeeID IN Employees.EmployeeID%TYPE,
        p_Name IN Employees.Name%TYPE,
        p_Position IN Employees.Position%TYPE,
        p_Salary IN Employees.Salary%TYPE,
        p_Department IN Employees.Department%TYPE,
        p_HireDate IN Employees.HireDate%TYPE
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_EmployeeID, p_Name, p_Position, p_Salary, p_Department, p_HireDate);
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Employee ID ' || p_EmployeeID || ' already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END HireEmployee;

    PROCEDURE UpdateEmployeeDetails(
        p_EmployeeID IN Employees.EmployeeID%TYPE,
        p_Name IN Employees.Name%TYPE,
        p_Position IN Employees.Position%TYPE,
        p_Salary IN Employees.Salary%TYPE,
        p_Department IN Employees.Department%TYPE
    ) IS
    BEGIN
        UPDATE Employees
        SET Name = p_Name, Position = p_Position, Salary = p_Salary, Department = p_Department
        WHERE EmployeeID = p_EmployeeID;
        COMMIT;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Employee ID ' || p_EmployeeID || ' does not exist.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END UpdateEmployeeDetails;

    FUNCTION CalculateAnnualSalary(
        p_EmployeeID IN Employees.EmployeeID%TYPE
    ) RETURN NUMBER IS
        v_Salary Employees.Salary%TYPE;
    BEGIN
        SELECT Salary INTO v_Salary
        FROM Employees
        WHERE EmployeeID = p_EmployeeID;
        RETURN v_Salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            RETURN NULL;
    END CalculateAnnualSalary;
END EmployeeManagement;

/
```