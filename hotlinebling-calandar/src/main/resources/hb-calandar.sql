DROP DATABASE IF EXISTS hb_calandar;
CREATE DATABASE hb_calandar;
USE hb_calandar;

CREATE TABLE Event(
	event_id INTEGER PRIMARY KEY AUTO_INCREMENT,
	customer_id INTEGER NOT NULL,
	description TEXT(500), 
	event_year YEAR, 
	event_date DATE, 
	event_time TIME, 
	event_datetime DATETIME
);

