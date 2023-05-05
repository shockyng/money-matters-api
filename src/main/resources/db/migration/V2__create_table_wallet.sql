create table if not exists wallets (
    wallet_id SERIAL primary key,
    wallet_user_fk bigint,
    wallet_name varchar(266) not null,
    wallet_created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    wallet_updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT kf_user
        FOREIGN KEY (wallet_user_fk)
        REFERENCES Users(user_id)
);