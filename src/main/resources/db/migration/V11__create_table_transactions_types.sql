CREATE TABLE transactions_types (
    transaction_type_id SERIAL PRIMARY KEY,
    transaction_type_name VARCHAR NOT NULL,
    transaction_type_created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    transaction_type_updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);