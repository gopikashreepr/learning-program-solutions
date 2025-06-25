-- Scenario 1: Handle exceptions during fund transfers between accounts
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account_id;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
    END IF;

    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account_id;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account_id;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

--  Scenario 2: Manage errors when updating employee salaries
CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_emp_id IN NUMBER,
    p_percent IN NUMBER
) AS
    v_error_msg VARCHAR2(4000);
BEGIN
    -- Try to update employee salary
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percent / 100)
    WHERE EmployeeID = p_emp_id;

    -- If no rows were updated, raise an error manually
    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Employee ID not found');
    END IF;

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        v_error_msg := SQLERRM;
        INSERT INTO ErrorLog (ErrorMessage, ErrorTime)
        VALUES (v_error_msg, SYSTIMESTAMP);
END;



-- Scenario 3: Ensure data integrity when adding a new customer
CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_id IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
) AS
    v_error_msg VARCHAR2(4000);
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);

    COMMIT;

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        v_error_msg := 'Customer already exists with ID ' || p_id;
        INSERT INTO ErrorLog (ErrorMessage, ErrorTime)
        VALUES (v_error_msg, SYSTIMESTAMP);

    WHEN OTHERS THEN
        ROLLBACK;
        v_error_msg := SQLERRM;
        INSERT INTO ErrorLog (ErrorMessage, ErrorTime)
        VALUES (v_error_msg, SYSTIMESTAMP);
END;

