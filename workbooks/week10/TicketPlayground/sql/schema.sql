DROP DATABASE IF EXISTS ticket_playground_db;

CREATE DATABASE IF NOT EXISTS ticket_playground_db;

USE ticket_playground_db;

CREATE TABLE `user` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
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

CREATE TABLE `ticket` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`event_name` VARCHAR(50) NOT NULL,
	`price` FLOAT NOT NULL,
    `type` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`)
)

