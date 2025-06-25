-- Scenario 1: Calculate the age of customers
CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob IN DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;



-- Scenario 2: Compute monthly installment for a loan
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount IN NUMBER,
    p_annual_rate IN NUMBER,
    p_years IN NUMBER
) RETURN NUMBER IS
    r NUMBER := p_annual_rate / 12 / 100;
    n NUMBER := p_years * 12;
    emi NUMBER;
BEGIN
    emi := (p_loan_amount * r * POWER(1 + r, n)) / (POWER(1 + r, n) - 1);
    RETURN ROUND(emi, 2);
END;



-- Scenario 3: Check if a customer has sufficient balance
CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id IN NUMBER,
    p_amount IN NUMBER
) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    RETURN v_balance >= p_amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;


