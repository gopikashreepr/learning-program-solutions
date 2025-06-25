-- Scenario 1: Package for Customer Management
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE);
    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;


CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
    END;

    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name,
            DOB = p_dob,
            LastModified = SYSDATE
        WHERE CustomerID = p_id;
    END;

    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
        RETURN v_balance;
    END;

END CustomerManagement;

-- Scenario 2: Package for Employee Management
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_dept VARCHAR2);
    PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER);
    FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;


CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_dept VARCHAR2) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_id, p_name, p_position, p_salary, p_dept, SYSDATE);
    END;

    PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER) IS
    BEGIN
        UPDATE Employees SET Salary = p_salary WHERE EmployeeID = p_id;
    END;

    FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
        RETURN v_salary * 12;
    END;

END EmployeeManagement;


-- Scenario 3: Package for Account Operations
CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_acc_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER);
    PROCEDURE CloseAccount(p_acc_id NUMBER);
    FUNCTION GetTotalCustomerBalance(p_cust_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(p_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_id, p_cust_id, p_type, p_balance, SYSDATE);
    END;

    PROCEDURE CloseAccount(p_id NUMBER) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_id;
    END;

    FUNCTION GetTotalCustomerBalance(p_cust_id NUMBER) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_total
        FROM Accounts
        WHERE CustomerID = p_cust_id;

        RETURN NVL(v_total, 0);
    END;

END AccountOperations;


