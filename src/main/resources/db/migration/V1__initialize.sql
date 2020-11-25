
drop table if exists category cascade;
create table category (id bigserial, name varchar(255), primary key(id));
insert into category
(name) values
('Meal products'),
('A');

drop table if exists products cascade;
create table products (id bigserial, title varchar(255), description varchar(5000), price int, category_id int, primary key(id));
insert into products
(title, description, price, category_id) values
('Cheese', 'Fresh cheese', 320, 1),
('Milk', 'Fresh milk', 80, 1),
('Apples', 'Fresh apples', 80, 1),
('Bread', 'Fresh bread', 30, 1),
('A1', '', 1, 2),
('A2', '', 2, 2),
('A3', '', 3, 2),
('A4', '', 4, 2),
('A5', '', 5, 2),
('A6', '', 6, 2),
('A7', '', 7, 2),
('A8', '', 8, 2),
('A9', '', 9, 2),
('A10', '', 10, 2),
('A11', '', 11, 2),
('A12', '', 12, 2),
('A13', '', 13, 2),
('A14', '', 14, 2),
('A15', '', 15, 2),
('A16', '', 16, 2),
('A17', '', 17, 2),
('A18', '', 18, 2),
('A19', '', 19, 2),
('A20', '', 20, 2);
