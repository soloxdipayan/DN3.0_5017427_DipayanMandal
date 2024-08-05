## Scenario 2: Manage errors when updating employee salaries.
# Question: Write a stored procedure UpdateSalary that increases the salary of an employee by a given percentage. If the employee ID does not exist, handle the exception and log an error message.
# Answer
```sql
CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_EmployeeID IN Employees.EmployeeID%TYPE,
    p_Percentage IN NUMBER
) IS
    v_Salary Employees.Salary%TYPE;
BEGIN
    -- Check employee existence
    SELECT Salary INTO v_Salary
    FROM Employees
    WHERE EmployeeID = p_EmployeeID
    FOR UPDATE;

    
    UPDATE Employees
    SET Salary = Salary + (Salary * p_Percentage / 100)
    WHERE EmployeeID = p_EmployeeID;

    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES ('Employee ID ' || p_EmployeeID || ' does not exist.', SYSDATE);
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (SQLERRM, SYSDATE);
        RAISE;
END UpdateSalary;
/
```