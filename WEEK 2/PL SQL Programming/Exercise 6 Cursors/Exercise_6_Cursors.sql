-- Scenario 1: Generate monthly statements for all customers
DECLARE
    CURSOR txn_cursor IS
        SELECT C.Name, T.AccountID, T.TransactionDate, T.Amount, T.TransactionType
        FROM Transactions T
        JOIN Accounts A ON T.AccountID = A.AccountID
        JOIN Customers C ON A.CustomerID = C.CustomerID
        WHERE TO_CHAR(T.TransactionDate, 'MM-YYYY') = TO_CHAR(SYSDATE, 'MM-YYYY');

    v_name Customers.Name%TYPE;
    v_acc_id Accounts.AccountID%TYPE;
    v_date DATE;
    v_amount NUMBER;
    v_type VARCHAR2(10);
BEGIN
    OPEN txn_cursor;
    LOOP
        FETCH txn_cursor INTO v_name, v_acc_id, v_date, v_amount, v_type;
        EXIT WHEN txn_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Customer: ' || v_name ||
                             ', Account: ' || v_acc_id ||
                             ', Date: ' || TO_CHAR(v_date, 'YYYY-MM-DD') ||
                             ', Amount: ₹' || v_amount ||
                             ', Type: ' || v_type);
    END LOOP;
    CLOSE txn_cursor;
END;


-- Scenario 2: Apply annual fee to all accounts
DECLARE
    CURSOR acc_cursor IS
        SELECT AccountID, Balance FROM Accounts;

    v_acc_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_fee CONSTANT NUMBER := 100;  -- Example annual fee
BEGIN
    OPEN acc_cursor;
    LOOP
        FETCH acc_cursor INTO v_acc_id, v_balance;
        EXIT WHEN acc_cursor%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - v_fee,
            LastModified = SYSDATE
        WHERE AccountID = v_acc_id;
    END LOOP;
    CLOSE acc_cursor;

    COMMIT;
END;



-- Scenario 3: Update loan interest rates based on a new policy
DECLARE
    CURSOR loan_cursor IS
        SELECT LoanID, LoanAmount, InterestRate FROM Loans;

    v_loan_id Loans.LoanID%TYPE;
    v_amount Loans.LoanAmount%TYPE;
    v_rate Loans.InterestRate%TYPE;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_loan_id, v_amount, v_rate;
        EXIT WHEN loan_cursor%NOTFOUND;

        IF v_amount > 10000 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 0.5
            WHERE LoanID = v_loan_id;
        ELSE
            UPDATE Loans
            SET InterestRate = InterestRate + 0.25
            WHERE LoanID = v_loan_id;
        END IF;
    END LOOP;
    CLOSE loan_cursor;

    COMMIT;
END;
