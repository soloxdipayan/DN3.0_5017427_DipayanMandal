# Scenario 2: A customer can be promoted to VIP status based on their balance.
## Question: Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000.
## Answer
First IsVIP column is added  to the Customers table:
```sql
ALTER TABLE Customers ADD (IsVIP VARCHAR2(3) DEFAULT 'NO');
```
pl/sql-
```sql
BEGIN
    UPDATE Customers
    SET IsVIP = 'YES'
    WHERE Balance > 10000;
    COMMIT;
END;
/
```
