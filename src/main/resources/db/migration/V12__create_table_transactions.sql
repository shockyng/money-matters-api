CREATE TABLE transactions (
    transaction_id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    wallet_id BIGINT NOT NULL,
    bill_id BIGINT DEFAULT null,
    transaction_amount DECIMAL(10,2) NOT NULL,
    transaction_type_id BIGINT NOT NULL,
    transaction_created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    transaction_updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (wallet_id) REFERENCES wallets(wallet_id) ON DELETE CASCADE,
    FOREIGN KEY (bill_id) REFERENCES bills(bill_id),
    FOREIGN KEY (transaction_type_id) REFERENCES transactions_types(transaction_type_id)
);