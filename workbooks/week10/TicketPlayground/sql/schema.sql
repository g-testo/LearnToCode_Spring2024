DROP DATABASE IF EXISTS ticket_playground_db;

CREATE DATABASE IF NOT EXISTS ticket_playground_db;

USE ticket_playground_db;

CREATE TABLE `user` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `ticket` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`event_name` VARCHAR(50) NOT NULL,
	`price` FLOAT NOT NULL,
    `type` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `order` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `user_id` INTEGER NOT NULL,
    `ticket_id` INTEGER NOT NULL,
    `quantity` INTEGER NOT NULL,
    `is_redeemed` BOOLEAN NOT NULL DEFAULT FALSE,
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
	FOREIGN KEY (`ticket_id`) REFERENCES `ticket`(`id`),
	PRIMARY KEY (`id`)
);

-- Seed 
INSERT INTO user(`first_name`, `last_name`) VALUES('Michael', 'Johnson');
INSERT INTO user(`first_name`, `last_name`) VALUES('Emily', 'Brown');
INSERT INTO user(`first_name`, `last_name`) VALUES('David', 'Williams');
INSERT INTO user(`first_name`, `last_name`) VALUES('Sarah', 'Jones');
INSERT INTO user(`first_name`, `last_name`) VALUES('James', 'Garcia');
INSERT INTO user(`first_name`, `last_name`) VALUES('Olivia', 'Martinez');
INSERT INTO user(`first_name`, `last_name`) VALUES('Robert', 'Rodriguez');
INSERT INTO user(`first_name`, `last_name`) VALUES('Sophia', 'Hernandez');
INSERT INTO user(`first_name`, `last_name`) VALUES('William', 'Lopez');
INSERT INTO user(`first_name`, `last_name`) VALUES('Ava', 'Gonzalez');
INSERT INTO user(`first_name`, `last_name`) VALUES('Daniel', 'Wilson');
INSERT INTO user(`first_name`, `last_name`) VALUES('Mia', 'Anderson');
INSERT INTO user(`first_name`, `last_name`) VALUES('Matthew', 'Thomas');
INSERT INTO user(`first_name`, `last_name`) VALUES('Abigail', 'Taylor');
INSERT INTO user(`first_name`, `last_name`) VALUES('Joseph', 'Moore');
INSERT INTO user(`first_name`, `last_name`) VALUES('Isabella', 'Jackson');
INSERT INTO user(`first_name`, `last_name`) VALUES('Charles', 'Martin');
INSERT INTO user(`first_name`, `last_name`) VALUES('Charlotte', 'Lee');
