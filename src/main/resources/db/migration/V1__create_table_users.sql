create table if not exists users (
    user_id SERIAL primary key,
    user_username VARCHAR(266) not null unique,
    user_firstname VARCHAR(266) not null,
    user_lastname VARCHAR(266) not null,
    user_email VARCHAR(266) not null unique,
    user_password VARCHAR(266) not null,
    user_created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    user_updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);