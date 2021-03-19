# ************************************************************
# Sequel Ace SQL dump
# Version 2042
#
# https://sequel-ace.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.33)
# Database: jiayuan_fee
# Generation Time: 2021-03-19 07:46:28 +0000
# ************************************************************

CREATE DATABASE jiayuan_fee CHARACTER SET utf8 COLLATE utf8mb4;

use jiayuan_fee;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table house_fee
# ------------------------------------------------------------

DROP TABLE IF EXISTS `house_fee`;

CREATE TABLE `house_fee` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `house_id` bigint(11) NOT NULL,
  `water_fee` decimal(11,2) NOT NULL,
  `electric_fee` decimal(11,2) NOT NULL,
  `total_fee` decimal(11,2) NOT NULL,
  `start_datetime` date NOT NULL,
  `end_datetime` date NOT NULL,
  `pay_datetime` datetime DEFAULT NULL,
  `remark` varchar(512) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '支付状态，1 未支付 2 支付完成',
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
