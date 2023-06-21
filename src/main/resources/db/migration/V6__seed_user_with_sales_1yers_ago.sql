insert into users (user_username, user_firstname, user_lastname, user_email, user_password, user_created_at) values
('mdouglas', 'Douglas', 'Lopes', 'douglas@gmail.com', 'password', '2022-01-12 15:49:38.128 -0300'),
('daroz', 'Geraldo', 'Daroz', 'daroz@gmail.com', 'password', '2022-01-27 18:24:38.128 -0300'),
('shockyng', 'Luan', 'Santos', 'shockyng@gmail.com', 'password', '2022-02-20 22:04:38.128 -0300'),
('wdiego', 'Diego', 'Martins', 'wdiego@gmail.com', 'password', '2022-02-01 11:49:38.128 -0300'),
('mariane', 'Mariane', 'Oliveira', 'mariane@gmail.com', 'password', '2022-03-26 16:11:38.128 -0300'),
('fernanda', 'Fernanda', 'Souza', 'fernanda@gmail.com', 'password', '2022-03-02 03:30:38.128 -0300'),
('aline', 'Aline', 'Soares', 'aline@gmail.com', 'password', '2022-03-26 06:28:38.128 -0300'),
('carol', 'Carol', 'Dapieve', 'carol@gmail.com', 'password', '2022-04-30 19:52:38.128 -0300');

insert into sales (user_id, sale_price, sale_status, sale_contract_type, sale_created_at)
select u.user_id, 1000.00, true, 1, '2022-08-05 15:49:38.128 -0300'
from users u
where u.user_username = 'mdouglas';

insert into sales (user_id, sale_price, sale_status, sale_contract_type, sale_created_at)
select u.user_id, 1500.00, true, 2, '2022-09-02 17:21:38.128 -0300'
from users u
where u.user_username = 'daroz';

insert into sales (user_id, sale_price, sale_status, sale_contract_type, sale_created_at)
select u.user_id, 2500.00, true, 4, '2022-09-25 02:14:38.128 -0300'
from users u
where u.user_username = 'shockyng';

insert into sales (user_id, sale_price, sale_status, sale_contract_type, sale_created_at)
select u.user_id, 5000.00, true, 5, '2022-10-09 22:30:38.128 -0300'
from users u
where u.user_username = 'wdiego';

insert into sales (user_id, sale_price, sale_status, sale_contract_type, sale_created_at)
select u.user_id, 1000.00, true, 1, '2022-11-21 06:11:38.128 -0300'
from users u
where u.user_username = 'mariane';

insert into sales (user_id, sale_price, sale_status, sale_contract_type, sale_created_at)
select u.user_id, 1500.00, true, 2, '2022-11-23 13:22:38.128 -0300'
from users u
where u.user_username = 'fernanda';

insert into sales (user_id, sale_price, sale_status, sale_contract_type, sale_created_at)
select u.user_id, 2000.00, true, 3, '2022-12-12 20:19:38.128 -0300'
from users u
where u.user_username = 'aline';

insert into sales (user_id, sale_price, sale_status, sale_contract_type, sale_created_at)
select u.user_id, 2500.00, true, 4, '2022-12-24 12:29:38.128 -0300'
from users u
where u.user_username = 'carol';