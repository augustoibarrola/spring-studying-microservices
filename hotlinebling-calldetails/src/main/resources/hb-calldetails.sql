DROP DATABASE IF EXISTS hotlinebling_calldetails;
CREATE DATABASE hotlinebling_calldetails;
USE hotlinebling_calldetails;

CREATE TABLE CallDetails(
	call_id INTEGER PRIMARY KEY AUTO_INCREMENT, 
	call_from BIGINT,
	call_to BIGINT, 
	call_on DATE,
	duration INTEGER
);

INSERT INTO CallDetails
	(call_from, call_to, call_on, duration)
VALUES
	(606060, 101010, '2021-07-03', 34), 
	(303030, 202020, '2021-06-07', 34), 
	(606060, 303030, '2021-05-18', 34), 
	(404040, 101010, '2021-04-10', 34), 
	(606060, 303030, '2021-03-08', 34), 
	(202020, 202020, '2021-02-01', 34),
	(404040, 101010, '2021-01-08', 34), 
	(606060, 202020, '2021-07-13', 34),
	(404040, 303030, '2021-08-04', 34), 
	(101010, 606060, '2021-09-18', 34);
