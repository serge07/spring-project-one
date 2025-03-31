CREATE DATABASE IF NOT EXISTS `todo` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `todo`;

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `description` varchar(100) NOT NULL,
                        `status` enum('IN_PROGRESS','DONE','PAUSED') NOT NULL DEFAULT 'IN_PROGRESS',
                        `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT IGNORE INTO `task` (`id`, `description`, `status`) VALUES
                                                              (1,'aaa','DONE'),
                                                              (2,'bbb','PAUSED'),
                                                              (3,'ccc','IN_PROGRESS'),
                                                              (4,'ddd','DONE'),
                                                              (5,'eee','PAUSED'),
                                                              (6,'fff','IN_PROGRESS'),
                                                              (7,'ggg','DONE'),
                                                              (8,'hhh','PAUSED'),
                                                              (9,'jjj','IN_PROGRESS'),
                                                              (10,'kkk','DONE'),
                                                              (11,'lll','PAUSED'),
                                                              (12,'mmm','IN_PROGRESS'),
                                                              (13,'nnn','DONE'),
                                                              (14,'ooo','PAUSED'),
                                                              (15,'ppp','IN_PROGRESS');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;