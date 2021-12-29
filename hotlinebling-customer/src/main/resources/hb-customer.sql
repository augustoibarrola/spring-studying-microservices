DROP DATABASE IF EXISTS hotlinebling_customer;
CREATE DATABASE hotlinebling_customer;
USE hotlinebling_customer;

CREATE TABLE Customer(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	middle_name VARCHAR(50),
	age INTEGER,
	phone_number BIGINT,
	e_mail VARCHAR(50),
	address VARCHAR(50),
	plan_id INTEGER,
	phone_id INTEGER,v
	password VARCHAR(50), 
	ssn INTEGER
);

INSERT INTO Customer
	(first_name, last_name, middle_name, age, phone_number, e_mail, address, plan_id, phone_id, password, ssn)
VALUES
('Augusto','Tomas','Ibarrola', 25, 2011234567, 'augusto@email.com', 'address',1, 1,'123', 111);