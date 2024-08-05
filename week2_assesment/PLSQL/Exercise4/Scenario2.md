# Scenario 2: The bank needs to compute the monthly installment for a loan.
## 	Question: Write a function CalculateMonthlyInstallment that takes the loan amount, interest rate, and loan duration in years as input and returns the monthly installment amount.
## Answer



```sql
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_LoanAmount IN NUMBER,
    p_InterestRate IN NUMBER,
    p_LoanDurationYears IN NUMBER
) RETURN NUMBER IS
    v_MonthlyRate NUMBER;
    v_NumberOfPayments NUMBER;
    v_MonthlyInstallment NUMBER;
BEGIN
    v_MonthlyRate := p_InterestRate / 12 / 100;
    v_NumberOfPayments := p_LoanDurationYears * 12;
    
    v_MonthlyInstallment := p_LoanAmount * v_MonthlyRate / (1 - POWER(1 + v_MonthlyRate, -v_NumberOfPayments));
    
    RETURN v_MonthlyInstallment;
END CalculateMonthlyInstallment;
/
```