ALTER TABLE users
ADD COLUMN role_fk INT DEFAULT 2 REFERENCES roles (role_id);

