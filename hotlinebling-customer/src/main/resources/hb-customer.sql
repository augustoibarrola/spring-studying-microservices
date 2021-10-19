DROP DATABASE IF EXISTS hotlinebling_customer;
CREATE DATABASE hotlinebling_customer;
USE hotlinebling_customer;

CREATE TABLE Customer(
	customer_id INTEGER PRIMARY KEY AUTO_INCREMENT,
	phone_number BIGINT,
	customer_name VARCHAR(50),
	age INTEGER,
	address VARCHAR(50),
	plan_id INTEGER,
	phone_id INTEGER,
	password VARCHAR(50)
);

INSERT INTO Customer
	(phone_number, customer_name, age, plan_id, password, phone_id)
VALUES
(606060, 'Augusto', 25, 1, '123', 1), 
(101010, 'Anastasia', 6, 2, '123', 2), 
(303030, 'Ricardo', 26, 3, '123', 1), 
(202020, 'Princess', 16, 2, '123', 4), 
(404040, 'Hunter', 8, 1, '123', 1); 
