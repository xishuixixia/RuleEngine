-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.22-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema rule
--

CREATE DATABASE IF NOT EXISTS rule;
USE rule;

--
-- Definition of table `t_action`
--

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

--
-- Dumping data for table `t_action`
--

/*!40000 ALTER TABLE `t_action` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_action` ENABLE KEYS */;


--
-- Definition of table `t_action_meta`
--

DROP TABLE IF EXISTS `t_action_meta`;
CREATE TABLE `t_action_meta` (
  `id` varchar(36) NOT NULL,
  `method_c` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value_name` varchar(255) DEFAULT NULL,
  `vars_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_action_meta`
--

/*!40000 ALTER TABLE `t_action_meta` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_action_meta` ENABLE KEYS */;


--
-- Definition of table `t_condition`
--

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

--
-- Dumping data for table `t_condition`
--

/*!40000 ALTER TABLE `t_condition` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_condition` ENABLE KEYS */;


--
-- Definition of table `t_entity`
--

DROP TABLE IF EXISTS `t_entity`;
CREATE TABLE `t_entity` (
  `id` varchar(36) NOT NULL,
  `identify` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `package_c` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_entity`
--

/*!40000 ALTER TABLE `t_entity` DISABLE KEYS */;
INSERT INTO `t_entity` (`id`,`identify`,`name`,`package_c`) VALUES 
 ('78b226a4-e946-4d62-b116-89d864ced25d','card','会员卡','com.hxrainbow.Card'),
 ('a14d7d09-8726-46bf-8bef-39f84bd975a6','member','会员','com.hxrainbow.Member');
/*!40000 ALTER TABLE `t_entity` ENABLE KEYS */;


--
-- Definition of table `t_entity_item`
--

DROP TABLE IF EXISTS `t_entity_item`;
CREATE TABLE `t_entity_item` (
  `id` varchar(36) NOT NULL,
  `field` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_entity_item`
--

/*!40000 ALTER TABLE `t_entity_item` DISABLE KEYS */;
INSERT INTO `t_entity_item` (`id`,`field`,`name`,`type_id`) VALUES 
 ('84834603-d26b-43b7-b542-1a61c4dab088','name','名称','a14d7d09-8726-46bf-8bef-39f84bd975a6'),
 ('939338e7-8459-4bbf-bc01-67eb0b11d9a4','point','积分','a14d7d09-8726-46bf-8bef-39f84bd975a6');
/*!40000 ALTER TABLE `t_entity_item` ENABLE KEYS */;


--
-- Definition of table `t_menu`
--

DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `url` varchar(100) NOT NULL,
  `image` varchar(100) NOT NULL,
  `parent_id` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_menu`
--

/*!40000 ALTER TABLE `t_menu` DISABLE KEYS */;
INSERT INTO `t_menu` (`id`,`name`,`url`,`image`,`parent_id`) VALUES 
 (1,'基础管理','','',0),
 (2,'规则管理','','',0),
 (3,'实体管理','entity/listEntity','images/icons/default.png',1),
 (4,'动作类型管理','action/listActionMeta','images/icons/default.png',1),
 (5,'场景管理','scene/listScene','images/icons/default.png',1),
 (6,'变量管理','condition/listCondition','images/icons/default.png',1),
 (7,'登录场景','scene/rule?type=login','images/icons/default.png',2);
/*!40000 ALTER TABLE `t_menu` ENABLE KEYS */;


--
-- Definition of table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_role`
--

/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` (`id`,`name`,`description`) VALUES 
 (1,'sa','系统管理员'),
 (2,'worker','运维人员');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;


--
-- Definition of table `t_role_menu`
--

DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(10) unsigned NOT NULL,
  `menu_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_role_menu`
--

/*!40000 ALTER TABLE `t_role_menu` DISABLE KEYS */;
INSERT INTO `t_role_menu` (`id`,`role_id`,`menu_id`) VALUES 
 (1,1,1),
 (2,1,2),
 (3,1,3),
 (4,1,4),
 (5,1,5),
 (6,1,6),
 (7,1,7),
 (8,2,2),
 (9,2,7);
/*!40000 ALTER TABLE `t_role_menu` ENABLE KEYS */;


--
-- Definition of table `t_rule`
--

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

--
-- Dumping data for table `t_rule`
--

/*!40000 ALTER TABLE `t_rule` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_rule` ENABLE KEYS */;


--
-- Definition of table `t_scene`
--

DROP TABLE IF EXISTS `t_scene`;
CREATE TABLE `t_scene` (
  `id` varchar(36) NOT NULL,
  `identify` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_scene`
--

/*!40000 ALTER TABLE `t_scene` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_scene` ENABLE KEYS */;


--
-- Definition of table `t_scene_entity`
--

DROP TABLE IF EXISTS `t_scene_entity`;
CREATE TABLE `t_scene_entity` (
  `id` varchar(255) NOT NULL,
  `entity_id` varchar(255) DEFAULT NULL,
  `scene_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_scene_entity`
--

/*!40000 ALTER TABLE `t_scene_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_scene_entity` ENABLE KEYS */;


--
-- Definition of table `t_variable`
--

DROP TABLE IF EXISTS `t_variable`;
CREATE TABLE `t_variable` (
  `id` varchar(255) NOT NULL,
  `default_value` varchar(255) DEFAULT NULL,
  `dynamic_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_variable`
--

/*!40000 ALTER TABLE `t_variable` DISABLE KEYS */;
INSERT INTO `t_variable` (`id`,`default_value`,`dynamic_id`,`name`,`type`) VALUES 
 ('1','12',NULL,'测试1',2),
 ('2','12',NULL,'测试2',1),
 ('3','12','','测试2',4),
 ('4','12','84834603-d26b-43b7-b542-1a61c4dab088','动态测试',4);
/*!40000 ALTER TABLE `t_variable` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
