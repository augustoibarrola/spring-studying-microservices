DROP DATABASE IF EXISTS hotlinebling_friendfamily;
CREATE DATABASE hotlinebling_friendfamily;
USE hotlinebling_friendfamily;

CREATE TABLE FriendFamily(
	id INTEGER PRIMARY KEY AUTO_INCREMENT, 
	phone_number BIGINT,
	friend_and_family BIGINT
);

INSERT INTO FriendFamily
VALUES
(1, 606060, 404040), 
(2, 101010, 202020),
(3, 303030, 606060);