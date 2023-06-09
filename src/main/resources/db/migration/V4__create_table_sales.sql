CREATE TABLE sales
(
    sale_id            SERIAL PRIMARY KEY,
    sale_price         NUMERIC(10, 2) NOT NULL,
    sale_status        BOOLEAN        NOT NULL,
    sale_contract_type INTEGER        NOT NULL,
    sale_created_at    TIMESTAMPTZ    NOT NULL DEFAULT NOW(),
    sale_updated_at    TIMESTAMPTZ    NOT NULL DEFAULT NOW(),
    user_id INTEGER REFERENCES users(user_id)
);
