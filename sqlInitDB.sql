CREATE USER 'application'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON USER_MANAGER.* TO 'application'@'localhost';

CREATE DATABASE USER_MANAGER CHARACTER SET 'utf8';

USE USER_MANAGER;

DROP TABLE USERS;
CREATE TABLE USERS (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
)
ENGINE=INNODB;

SELECT * FROM USERS;

INSERT INTO USERS(name, first_name, username, password) VALUES ('StocKa', 'Jim', 'StocKa', 'password1');
INSERT INTO USERS(name, first_name, username, password) VALUES ('Bedouille', 'Rudi', 'Bedouille', 'password2');
INSERT INTO USERS(name, first_name, username, password) VALUES ('Shinigota', 'Benjamin', 'Shinigota', 'password3');
INSERT INTO USERS(name, first_name, username, password) VALUES ('Tweedz', 'Maxime', 'Tweedz', 'password4');
COMMIT;

SELECT * FROM USERS;