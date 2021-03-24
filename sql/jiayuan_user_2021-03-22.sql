# ************************************************************
# Sequel Ace SQL dump
# Version 2042
#
# https://sequel-ace.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.33)
# Database: jiayuan_user
# Generation Time: 2021-03-22 07:06:04 +0000
# ************************************************************

CREATE DATABASE jiayuan_user CHARACTER SET utf8;

use jiayuan_user;


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(256) DEFAULT NULL,
  `password` varchar(256) NOT NULL DEFAULT '',
  `user_type` tinyint(1) NOT NULL DEFAULT '3' COMMENT '1:管理 2:业主',
  `real_name` varchar(256) DEFAULT NULL,
  `age` int(11) unsigned DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `username`, `password`, `user_type`, `real_name`, `age`, `create_time`, `update_time`)
VALUES
	(1,'admin','$2a$10$SJtvfrkactbsKsm4ULRNo.Ab8XV40mzRm.lt3ehZ7UsnatjAiB9nG',1,'管理员',22,'2021-03-16 03:13:41','2021-03-17 11:43:35'),
	(2,'caocao','$2a$10$SJtvfrkactbsKsm4ULRNo.Ab8XV40mzRm.lt3ehZ7UsnatjAiB9nG',2,'曹操',22,'2021-03-16 09:34:03','2021-03-19 13:44:27'),
	(3,'sunquan','$2a$10$SJtvfrkactbsKsm4ULRNo.Ab8XV40mzRm.lt3ehZ7UsnatjAiB9nG',2,'孙权',25,'2021-03-17 02:10:13','2021-03-19 13:44:17'),
	(4,'liubei','$2a$10$kOjLpUSKHl3bEc68bxL2KOle/L5krgVv4FMXj2x9g78ByVixANIf2',2,'刘备',22,'2021-03-19 13:46:10',NULL);

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_house
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_house`;

CREATE TABLE `user_house` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `house_id` int(11) NOT NULL,
  `join_time` date NOT NULL,
  `phone` varchar(16) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
