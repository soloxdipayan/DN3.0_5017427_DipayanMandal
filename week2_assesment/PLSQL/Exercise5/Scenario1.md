# Scenario 1: Automatically update the last modified date when a customer's record is updated.
## 	Question: Write a trigger UpdateCustomerLastModified that updates the LastModified column of the Customers table to the current date whenever a customer's record is updated.
## Answer
```sql
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END UpdateCustomerLastModified;
/
```