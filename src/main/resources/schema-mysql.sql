CREATE DATABASE IF NOT EXISTS `todo` DEFAULT CHARACTER SET utf8mb4;
USE `todo`;

DROP TABLE IF EXISTS `tasks`;
CREATE TABLE `tasks` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `description` varchar(100) NOT NULL,
                         `status` enum('IN_PROGRESS','DONE','PAUSED') NOT NULL DEFAULT 'IN_PROGRESS',
                         `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4;

-- Each INSERT is a complete statement with semicolon
INSERT INTO `tasks` (description, status) VALUES ('Write project proposal', 'DONE');
INSERT INTO `tasks` (description, status) VALUES ('Review code with team', 'PAUSED');
INSERT INTO `tasks` (description, status) VALUES ('Implement login feature', 'IN_PROGRESS');
-- Continue with all other rows as individual INSERT statements