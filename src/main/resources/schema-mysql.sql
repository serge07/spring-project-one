CREATE DATABASE IF NOT EXISTS `todo` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `todo`;

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tasks` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `description` varchar(100) NOT NULL,
                        `status` enum('IN_PROGRESS','DONE','PAUSED') NOT NULL DEFAULT 'IN_PROGRESS',
                        `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT IGNORE INTO `tasks` (`id`, `description`, `status`) VALUES
                                                               (1, 'Write project proposal', 'DONE'),
                                                               (2, 'Review code with team', 'PAUSED'),
                                                               (3, 'Implement login feature', 'IN_PROGRESS'),
                                                               (4, 'Fix UI bugs on dashboard', 'DONE'),
                                                               (5, 'Prepare test cases', 'PAUSED'),
                                                               (6, 'Write documentation', 'IN_PROGRESS'),
                                                               (7, 'Deploy app to staging', 'DONE'),
                                                               (8, 'Set up CI/CD pipeline', 'PAUSED'),
                                                               (9, 'Integrate payment gateway', 'IN_PROGRESS'),
                                                               (10, 'Update user roles module', 'DONE'),
                                                               (11, 'Create demo presentation', 'PAUSED'),
                                                               (12, 'Refactor API endpoints', 'IN_PROGRESS'),
                                                               (13, 'Test mobile responsiveness', 'DONE'),
                                                               (14, 'Conduct user interviews', 'PAUSED'),
                                                               (15, 'Optimize database queries', 'IN_PROGRESS');
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;