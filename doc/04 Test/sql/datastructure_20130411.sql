/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.12 : Database - rule
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rule` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `rule`;

/*Table structure for table `t_action` */

DROP TABLE IF EXISTS `t_action`;

CREATE TABLE `t_action` (
  `id` varchar(36) NOT NULL,
  `date_entered` date DEFAULT NULL,
  `date_modified` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type_id` varchar(36) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `vars` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_action_meta` */

DROP TABLE IF EXISTS `t_action_meta`;

CREATE TABLE `t_action_meta` (
  `id` varchar(36) NOT NULL,
  `method_c` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value_name` varchar(255) DEFAULT NULL,
  `vars_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_condition` */

DROP TABLE IF EXISTS `t_condition`;

CREATE TABLE `t_condition` (
  `id` varchar(36) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `date_entered` date DEFAULT NULL,
  `date_modified` date DEFAULT NULL,
  `type_id` varchar(36) DEFAULT NULL,
  `condition` varchar(1000) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_entity` */

DROP TABLE IF EXISTS `t_entity`;

CREATE TABLE `t_entity` (
  `id` varchar(36) NOT NULL,
  `identify` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `package_c` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_entity_item` */

DROP TABLE IF EXISTS `t_entity_item`;

CREATE TABLE `t_entity_item` (
  `id` varchar(36) NOT NULL,
  `field` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_rule` */

DROP TABLE IF EXISTS `t_rule`;

CREATE TABLE `t_rule` (
  `id` varchar(36) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `date_entered` date DEFAULT NULL,
  `date_modified` date DEFAULT NULL,
  `scene_id` varchar(36) DEFAULT NULL,
  `condition` varchar(1000) DEFAULT NULL,
  `action` varchar(1000) DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL,
  `begin` date DEFAULT NULL,
  `end` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_scene` */

DROP TABLE IF EXISTS `t_scene`;

CREATE TABLE `t_scene` (
  `id` varchar(36) NOT NULL,
  `identify` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_scene_entity` */

DROP TABLE IF EXISTS `t_scene_entity`;

CREATE TABLE `t_scene_entity` (
  `id` varchar(255) NOT NULL,
  `entity_id` varchar(255) DEFAULT NULL,
  `scene_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_variable` */

DROP TABLE IF EXISTS `t_variable`;

CREATE TABLE `t_variable` (
  `id` varchar(255) NOT NULL,
  `default_value` varchar(255) DEFAULT NULL,
  `dynamic_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
