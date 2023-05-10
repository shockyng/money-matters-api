CREATE TABLE sales
(
    sale_id            SERIAL PRIMARY KEY,
    sale_price         NUMERIC(10, 2) NOT NULL,
    sale_status        BOOLEAN        NOT NULL,
    sale_contract_type INTEGER        NOT NULL,
    user_fk            INTEGER        NOT NULL REFERENCES users (user_id),
    sale_created_at    TIMESTAMPTZ    NOT NULL DEFAULT NOW(),
    sale_updated_at    TIMESTAMPTZ    NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_sales_users FOREIGN KEY (user_fk) REFERENCES users (user_id)
);
