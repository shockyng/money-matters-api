CREATE TABLE bills (
    bill_id SERIAL PRIMARY KEY,
    bill_price DOUBLE PRECISION,
    bill_name TEXT,
    bill_description TEXT,
    bill_payment_type TEXT,
    bill_installments INTEGER,
    bill_due_date DATE
);
