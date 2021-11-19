DROP DATABASE IF EXISTS hotlinebling_customer;
CREATE DATABASE hotlinebling_customer;
USE hotlinebling_customer;

CREATE TABLE Customer(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	middle_name VARCHAR(50),
	age INTEGER,
	phone_number BIGINT,
	e_mail VARCHAR(50),
	address VARCHAR(50),
	plan_id INTEGER,
	phone_id INTEGER,
	password VARCHAR(50), 
	ssn INTEGER
);

INSERT INTO Customer
	(first_name, age, phone_number, e_mail, plan_id, phone_id, password)
VALUES
('Augusto', 25, 2011234567, 'augusto@email.com', 1, 1,'123'), 
('Anastasia', 6, 2011234568,'anastasia@email.com', 2, 2, '123'), 
('Ricardo', 27, 2011234569,'ricardo@email.com', 3, 1, '123'), 
('Princess', 16, 2011234570,'princess@email.com', 2, 4,'123'), 
('Hunter', 8, 2011234571,'hunter@email.com',1, 1, '123');
