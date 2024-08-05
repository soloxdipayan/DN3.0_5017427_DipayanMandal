# Scenario 1: Calculate the age of customers for eligibility checks.
## 	Question: Write a function CalculateAge that takes a customer's date of birth as input and returns their age in years.
## Answer
```sql
CREATE OR REPLACE FUNCTION CalculateAge (
    p_DOB IN DATE
) RETURN NUMBER IS
    v_Age NUMBER;
BEGIN
    v_Age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_DOB) / 12);
    RETURN v_Age;
END CalculateAge;
/
```