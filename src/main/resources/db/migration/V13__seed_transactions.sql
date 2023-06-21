INSERT INTO transactions_types (transaction_type_name) VALUES
('Payment'),
('Income'),
('Loan');

INSERT INTO transactions (user_id, wallet_id, transaction_amount, transaction_type_id) VALUES
(1, 1, 12000.00, 2),
(1, 2, 12000.00, 2),
(1, 1, 500.00, 1),
(1, 1, 250.75, 1),
(2, 3, 50000.00, 2),
(2, 3, 1250.00, 1),
(2, 3, 5025.00, 1);