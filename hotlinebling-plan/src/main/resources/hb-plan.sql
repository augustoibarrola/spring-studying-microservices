DROP DATABASE IF EXISTS hotlinebling_plan;
CREATE DATABASE hotlinebling_plan;
USE hotlinebling_plan;

CREATE TABLE Plan(
	plan_id INTEGER PRIMARY KEY, 
	plan_name VARCHAR(50),
	local_rate INTEGER
);

INSERT INTO Plan
VALUES
(1, 'IFY_60', 60), 
(2, 'IFY_10', 10),
(3, 'IFY_30', 30);