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

CREATE TABLE order_details (
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

-- user
INSERT INTO user(`first_name`, `last_name`) VALUES('Selam', 'Nur');
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

-- ticket
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('Taylor Swift', 1000.00, 'concert');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('Van Gogh Exhibit', 50.00, 'museum');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('Super Bowl', 1500.00, 'sports');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('League of Legends World Championship', 200.00, 'e_sports');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('Comic-Con', 250.00, 'convention');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('Modern Art Exhibit', 30.00, 'exhibit');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('NBA Finals', 1200.00, 'sports');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('E3 Expo', 300.00, 'convention');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('Fortnite Championship Series', 150.00, 'e_sports');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('Renaissance Art Exhibit', 40.00, 'museum');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('FIFA World Cup', 1800.00, 'sports');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('BlizzCon', 200.00, 'convention');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('Overwatch League Grand Finals', 180.00, 'e_sports');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('Historical Artifacts Exhibit', 25.00, 'museum');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('Wimbledon Finals', 900.00, 'sports');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('CES', 350.00, 'convention');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('Dota 2 The International', 250.00, 'e_sports');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('Ancient Egypt Exhibit', 35.00, 'museum');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('UEFA Champions League Final', 1100.00, 'sports');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('PAX West', 220.00, 'convention');
INSERT INTO ticket(`event_name`, `price`, `type`) VALUES('Call of Duty League Championship', 190.00, 'e_sports');

-- order
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(1, 7, 5, false);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(2, 1, 3, true);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(3, 5, 2, true);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(4, 2, 1, false);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(5, 8, 4, false);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(6, 3, 2, true);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(7, 12, 3, false);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(8, 6, 1, true);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(9, 14, 2, false);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(10, 18, 4, true);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(11, 11, 5, false);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(12, 20, 2, true);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(13, 10, 1, false);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(14, 16, 3, false);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(15, 4, 2, false);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(16, 19, 5, true);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(17, 9, 4, false);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(18, 13, 1, true);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(19, 15, 3, false);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(2, 17, 2, true);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(3, 1, 4, false);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(4, 6, 5, false);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(5, 8, 1, false);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(6, 2, 2, true);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(7, 9, 3, false);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(8, 3, 4, true);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(9, 14, 1, false);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(10, 18, 2, true);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(11, 4, 5, false);
INSERT INTO order_details(`user_id`, `ticket_id`, `quantity`, `is_redeemed`) VALUES(12, 7, 3, false);


DROP PROCEDURE IF EXISTS `FilterNameAndPrice`;
DELIMITER $$
CREATE PROCEDURE `FilterNameAndPrice`(in AtEventName varchar(5), in AtPrice float)
BEGIN
SELECT * FROM ticket
	WHERE (event_name LIKE AtEventName)
    AND price < AtPrice
    ORDER BY price, event_name
    LIMIT 2;
END $$


