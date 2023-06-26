ALTER TABLE bills
ADD COLUMN user_fk INT DEFAULT 2 REFERENCES roles (role_id);

INSERT INTO bills (bill_price, bill_name, bill_description, bill_payment_type, bill_installments, bill_due_date, user_fk)
VALUES (100.0, 'Conta de Luz', 'Conta de luz referente ao mês de abril', 'Cartão de Crédito', 1, '2023-05-15',2),
       (50.0, 'Assinatura de Streaming', 'Assinatura mensal do serviço de streaming', 'Débito Automático', 1, '2023-05-20', 2),
       (200.0, 'Aluguel', 'Aluguel do apartamento referente ao mês de maio', 'Boleto Bancário', 1, '2023-06-10', 2),
       (300.0, 'Compra no Supermercado', 'Compras mensais no supermercado', 'Dinheiro', 1, '2023-05-12', 2),
       (150.0, 'Gasolina', 'Abastecimento do carro', 'Cartão de Débito', 1, '2023-05-18', 2);