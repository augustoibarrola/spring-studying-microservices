DROP DATABASE IF EXISTS hotlinebling_phone;
CREATE DATABASE hotlinebling_phone;
USE hotlinebling_phone;

CREATE TABLE Phone(
	phone_id INTEGER PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50),
	os VARCHAR(50) 
);

INSERT INTO Phone
	(name, os)
VALUES
('iPhone', 'iOS'),
('Pixel', 'Andriod'),
('Sidekick', 'Danger OS'),
('Razor', 'Andriod');