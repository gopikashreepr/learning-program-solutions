
-- Scenario 1: Apply interest rate discount for senior citizens
BEGIN
  FOR cust IN (SELECT CustomerID FROM Customers 
               WHERE MONTHS_BETWEEN(SYSDATE, DOB)/12 > 60) LOOP
    UPDATE Loans
    SET InterestRate = InterestRate - 1
    WHERE CustomerID = cust.CustomerID;
  END LOOP;
  COMMIT;
END;
/

-- Scenario 2: Promote to VIP status
ALTER TABLE Customers ADD IsVIP CHAR(1);

BEGIN
  FOR cust IN (SELECT CustomerID FROM Customers WHERE Balance > 10000) LOOP
    UPDATE Customers
    SET IsVIP = 'Y'
    WHERE CustomerID = cust.CustomerID;
  END LOOP;
  COMMIT;
END;
/

-- Scenario 3: Send loan due reminders
BEGIN
  FOR l IN (SELECT L.LoanID, C.Name, L.EndDate
            FROM Loans L
            JOIN Customers C ON C.CustomerID = L.CustomerID
            WHERE L.EndDate BETWEEN SYSDATE AND SYSDATE + 30) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || l.LoanID || ' for ' || l.Name || ' is due on ' || TO_CHAR(l.EndDate, 'YYYY-MM-DD'));
  END LOOP;
END;
/ 