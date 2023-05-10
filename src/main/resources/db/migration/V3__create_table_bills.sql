CREATE TABLE bills
(
    bill_id           SERIAL PRIMARY KEY,
    bill_price        DOUBLE PRECISION,
    bill_name         TEXT,
    bill_description  TEXT,
    bill_payment_type TEXT,
    bill_installments INTEGER,
    bill_due_date     DATE,
    bill_created_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    bill_updated_at   TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
