DROP DATABASE IF EXISTS hb_calandar;
CREATE DATABASE hb_calandar;
USE hb_calandar;

CREATE TABLE Calendar(
	name VARCHAR(50) NOT NULL,
	calendarOwner INTEGER,
	CONSTRAINT Calendar_name_pk PRIMARY KEY (name)
);

CREATE TABLE Event(
	id INT NOT NULL AUTO_INCREMENT,
	eventOwner INTEGER,
	calendar INTEGER,
	eventLocation INTEGER,
	eventDateTime DATETIME,
	startDate DATE,
	endDate DATE,
	startTime DATE,
	endTime DATE,
	shortDescription VARCHAR(50),
	fullDescription TEXT,
	CONSTRAINT Event_id_pk PRIMARY KEY (id)
);

