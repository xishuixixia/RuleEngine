-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (i686)
--
-- Host: 192.168.100.180    Database: rule
-- ------------------------------------------------------
-- Server version	5.5.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `rule`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `rule` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `rule`;

--
-- Table structure for table `t_action`
--

DROP TABLE IF EXISTS `t_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_action` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `date_entered` date DEFAULT NULL,
  `date_modified` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type_id` int(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_action`
--

LOCK TABLES `t_action` WRITE;
/*!40000 ALTER TABLE `t_action` DISABLE KEYS */;
INSERT INTO `t_action` VALUES (1,'2013-04-17','2013-04-17',NULL,NULL,1),(2,'2013-04-17','2013-04-17',NULL,NULL,1),(3,'2013-04-17','2013-04-17',NULL,NULL,1),(4,'2013-04-17','2013-04-17',NULL,NULL,1),(5,'2013-04-17','2013-04-17',NULL,NULL,1),(8,'2013-04-19','2013-04-19',NULL,NULL,3),(9,'2013-04-19','2013-04-19',NULL,NULL,1),(10,'2013-04-19','2013-04-19',NULL,NULL,2),(11,'2013-04-22','2013-04-22',NULL,NULL,1),(12,'2013-04-22','2013-04-22',NULL,NULL,1),(13,'2013-04-22','2013-04-22',NULL,NULL,1),(14,'2013-04-22','2013-04-22',NULL,NULL,1),(15,'2013-04-22','2013-04-22',NULL,NULL,1),(16,'2013-04-22','2013-04-22',NULL,NULL,1),(17,'2013-04-22','2013-04-22',NULL,NULL,1),(18,'2013-04-22','2013-04-22',NULL,NULL,1),(19,'2013-04-23','2013-04-23',NULL,NULL,1),(20,'2013-04-23','2013-04-23',NULL,NULL,1),(21,'2013-04-23','2013-04-23',NULL,NULL,1),(22,'2013-04-23','2013-04-23',NULL,NULL,1),(24,'2013-04-23','2013-04-23',NULL,NULL,1),(25,'2013-04-24','2013-04-24',NULL,NULL,6),(26,'2013-04-24','2013-04-24',NULL,NULL,6),(30,'2013-04-24','2013-04-24',NULL,NULL,6),(31,'2013-04-24','2013-04-24',NULL,NULL,7),(32,'2013-04-24','2013-04-24',NULL,NULL,7),(33,'2013-04-24','2013-04-24',NULL,NULL,7),(34,'2013-04-24','2013-04-24',NULL,NULL,7),(35,'2013-04-24','2013-04-24',NULL,NULL,7),(36,'2013-04-24','2013-04-24',NULL,NULL,7),(37,'2013-04-24','2013-04-24',NULL,NULL,7),(38,'2013-04-25','2013-04-25',NULL,NULL,7),(39,'2013-04-25','2013-04-25',NULL,NULL,8),(41,'2013-04-25','2013-04-25',NULL,NULL,7),(42,'2013-04-25','2013-04-25',NULL,NULL,7),(43,'2013-04-25','2013-04-25',NULL,NULL,7),(44,'2013-04-25','2013-04-25',NULL,NULL,7),(45,'2013-04-25','2013-04-25',NULL,NULL,7),(46,'2013-04-25','2013-04-25',NULL,NULL,7),(47,'2013-04-25','2013-04-25',NULL,NULL,7);
/*!40000 ALTER TABLE `t_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_action_meta`
--

DROP TABLE IF EXISTS `t_action_meta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_action_meta` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `method_c` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_action_meta`
--

LOCK TABLES `t_action_meta` WRITE;
/*!40000 ALTER TABLE `t_action_meta` DISABLE KEYS */;
INSERT INTO `t_action_meta` VALUES (7,'com.hxrainbow.rule.action.PointActionImpl','赠送积分','赠送积分'),(8,'com.hxrainbow.rule.action.PointActionImpl','赠送积分(指定人)','指定人赠送积分');
/*!40000 ALTER TABLE `t_action_meta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_action_meta_variable`
--

DROP TABLE IF EXISTS `t_action_meta_variable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_action_meta_variable` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `identify` varchar(100) DEFAULT NULL,
  `action_meta_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_action_meta_variable`
--

LOCK TABLES `t_action_meta_variable` WRITE;
/*!40000 ALTER TABLE `t_action_meta_variable` DISABLE KEYS */;
INSERT INTO `t_action_meta_variable` VALUES (7,'赠送人','memberId',6),(8,'赠送积分','point',6),(9,'积分数','point',7),(10,'赠送对象','id',8),(11,'赠送积分','point',8);
/*!40000 ALTER TABLE `t_action_meta_variable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_action_variable`
--

DROP TABLE IF EXISTS `t_action_variable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_action_variable` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `action_id` int(10) DEFAULT NULL,
  `variable_id` int(10) DEFAULT NULL,
  `variable_value` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_action_variable`
--

LOCK TABLES `t_action_variable` WRITE;
/*!40000 ALTER TABLE `t_action_variable` DISABLE KEYS */;
INSERT INTO `t_action_variable` VALUES (1,25,7,'222'),(2,25,8,'333'),(3,26,7,'111'),(4,26,8,'2222'),(5,27,7,'111'),(6,27,8,'2222'),(7,28,7,'222'),(8,28,8,'333'),(9,29,7,'11'),(10,29,8,'22'),(11,30,7,'123'),(12,30,8,'12'),(13,31,9,'2'),(14,32,9,'5'),(15,33,9,'10'),(16,34,9,'2'),(17,35,9,'150'),(18,36,9,'15'),(19,37,9,'100'),(20,38,9,'1'),(21,39,10,'$64$'),(22,39,11,'100'),(23,40,9,'100'),(24,41,9,'100'),(25,42,9,'10'),(26,43,9,'$67$*50'),(27,44,9,'50'),(28,45,9,'20'),(29,46,9,'50'),(30,47,9,'$71$*10');
/*!40000 ALTER TABLE `t_action_variable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_condition`
--

DROP TABLE IF EXISTS `t_condition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_condition` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `date_entered` date DEFAULT NULL,
  `date_modified` date DEFAULT NULL,
  `type_id` int(36) DEFAULT NULL,
  `condition_c` varchar(1000) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_condition`
--

LOCK TABLES `t_condition` WRITE;
/*!40000 ALTER TABLE `t_condition` DISABLE KEYS */;
INSERT INTO `t_condition` VALUES (1,NULL,'2013-04-17','2013-04-17',NULL,'$2$>10','$会员的积分$>10'),(2,NULL,'2013-04-17','2013-04-17',NULL,'$2$>101','$gggnnnn的bbbb$>101'),(3,NULL,'2013-04-17','2013-04-17',NULL,'$2$>10','$gggnnnn的bbbb$>10'),(5,NULL,'2013-04-17','2013-04-17',NULL,'$2$','$gggnnnn的bbbb$'),(6,NULL,'2013-04-17','2013-04-17',NULL,'',''),(7,NULL,'2013-04-17','2013-04-17',NULL,'$1$','$gggnnnnuuuu的aaaa$'),(8,NULL,'2013-04-17','2013-04-17',NULL,'$1$','$gggnnnnuuuu的aaaa$'),(9,NULL,'2013-04-17','2013-04-17',NULL,'',''),(10,NULL,'2013-04-17','2013-04-17',NULL,'',''),(11,NULL,'2013-04-17','2013-04-17',NULL,'',''),(12,NULL,'2013-04-17','2013-04-17',NULL,'',''),(13,NULL,'2013-04-17','2013-04-17',NULL,'',''),(14,NULL,'2013-04-17','2013-04-17',NULL,'',''),(15,NULL,'2013-04-17','2013-04-17',NULL,'',''),(16,NULL,'2013-04-17','2013-04-17',NULL,'',''),(17,NULL,'2013-04-18','2013-04-18',NULL,'',''),(18,NULL,'2013-04-18','2013-04-18',NULL,'',''),(19,NULL,'2013-04-18','2013-04-18',NULL,'',''),(20,NULL,'2013-04-18','2013-04-18',NULL,'',''),(21,NULL,'2013-04-18','2013-04-18',NULL,'',''),(22,NULL,'2013-04-18','2013-04-18',NULL,'',''),(23,NULL,'2013-04-18','2013-04-18',NULL,'',''),(24,NULL,'2013-04-18','2013-04-18',NULL,'',''),(25,NULL,'2013-04-18','2013-04-18',NULL,'',''),(26,NULL,'2013-04-18','2013-04-18',NULL,'',''),(27,NULL,'2013-04-18','2013-04-18',NULL,'$53$>10','$gggyyyy的rrrr$>10'),(28,NULL,'2013-04-18','2013-04-18',NULL,'$57$>10','$会员卡的积分$>10'),(37,NULL,'2013-04-19','2013-04-19',NULL,'$57$>10','$会员卡的积分$>10'),(49,NULL,'2013-04-19','2013-04-19',NULL,'$57$>10','$会员卡的积分$>10'),(50,NULL,'2013-04-19','2013-04-19',NULL,'$57$>10','$会员卡的积分$>10'),(51,NULL,'2013-04-22','2013-04-22',NULL,'$59$==123','$会员卡的卡号$==123'),(52,NULL,'2013-04-22','2013-04-22',NULL,'$59$==123','$会员卡的卡号$==123'),(53,NULL,'2013-04-22','2013-04-22',NULL,'$59$==123&&$57$>15','$会员卡的卡号$==123&&$会员卡的积分$>15'),(54,NULL,'2013-04-22','2013-04-22',NULL,'$59$==123&&$57$>15','$会员卡的卡号$==123&&$会员卡的积分$>15'),(55,NULL,'2013-04-22','2013-04-22',NULL,'$59$==12d3&&$57$>15','$会员卡的卡号$==12d3&&$会员卡的积分$>15'),(56,NULL,'2013-04-22','2013-04-22',NULL,'$57$>100','$会员卡的积分$>100'),(57,NULL,'2013-04-22','2013-04-22',NULL,'$62$>=2','$会员的连续登录次数$>=2'),(58,NULL,'2013-04-22','2013-04-22',NULL,'$62$<=2','$会员的连续登录次数$<=2'),(59,NULL,'2013-04-22','2013-04-22',NULL,'$62$>=3&&$62$<15','$会员的连续登录次数$>=3&&$会员的连续登录次数$<15'),(60,NULL,'2013-04-22','2013-04-22',NULL,'$62$>=15','$会员的连续登录次数$>=15'),(61,NULL,'2013-04-23','2013-04-23',NULL,'$62$==3','$会员的连续登录次数$==3'),(62,NULL,'2013-04-23','2013-04-23',NULL,'$62$==15','$会员的连续登录次数$==15'),(63,NULL,'2013-04-23','2013-04-23',NULL,'',''),(64,NULL,'2013-04-23','2013-04-23',NULL,'$62$<=2&&$62$>0','$会员的连续登录次数$<=2&&$会员的连续登录次数$>0'),(66,NULL,'2013-04-23','2013-04-23',NULL,'$62$<=2&&$62$>0','$会员的连续登录次数$<=2&&$会员的连续登录次数$>0'),(67,NULL,'2013-04-24','2013-04-24',NULL,'',''),(68,NULL,'2013-04-24','2013-04-24',NULL,'',''),(72,NULL,'2013-04-24','2013-04-24',NULL,'$62$>=3&&$62$<15','$会员的连续登录次数$>=3&&$会员的连续登录次数$<15'),(73,NULL,'2013-04-24','2013-04-24',NULL,'$62$>=3&&$62$<15','$会员的连续登录次数$>=3&&$会员的连续登录次数$<15'),(74,NULL,'2013-04-24','2013-04-24',NULL,'$62$>=15','$会员的连续登录次数$>=15'),(75,NULL,'2013-04-24','2013-04-24',NULL,'$62$<=2&&$62$>0','$会员的连续登录次数$<=2&&$会员的连续登录次数$>0'),(76,NULL,'2013-04-24','2013-04-24',NULL,'$62$==15','$会员的连续登录次数$==15'),(77,NULL,'2013-04-24','2013-04-24',NULL,'$62$==3','$会员的连续登录次数$==3'),(78,NULL,'2013-04-24','2013-04-24',NULL,'',''),(79,NULL,'2013-04-25','2013-04-25',NULL,'$63$==1&&$65$<100','$会员的是否邀请$==1&&$会员的邀请人已邀请数量$<100'),(80,NULL,'2013-04-25','2013-04-25',NULL,'$63$==1&&$65$<100','$会员的是否邀请$==1&&$会员的邀请人已邀请数量$<100'),(82,NULL,'2013-04-25','2013-04-25',NULL,'$66$>=1','$会员的答题数$>=1'),(83,NULL,'2013-04-25','2013-04-25',NULL,'$67$>=1','$会员的答对数$>=1'),(84,NULL,'2013-04-25','2013-04-25',NULL,'$68$==1','$会员的是否上传头像$==1'),(85,NULL,'2013-04-25','2013-04-25',NULL,'$69$==1','$会员的是否修改昵称$==1'),(86,NULL,'2013-04-25','2013-04-25',NULL,'$70$==1','$会员的是否完成必填资料$==1'),(87,NULL,'2013-04-25','2013-04-25',NULL,'$71$>=1','$会员的非必填字段数量$>=1');
/*!40000 ALTER TABLE `t_condition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_entity`
--

DROP TABLE IF EXISTS `t_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_entity` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `identify` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `package_c` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_entity`
--

LOCK TABLES `t_entity` WRITE;
/*!40000 ALTER TABLE `t_entity` DISABLE KEYS */;
INSERT INTO `t_entity` VALUES (4,'card','会员卡','com.hxrainbow.Card'),(42,'member','会员','com.hxrainbow.Member');
/*!40000 ALTER TABLE `t_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_entity_item`
--

DROP TABLE IF EXISTS `t_entity_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_entity_item` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `field` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type_id` int(10) unsigned DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_entity_item`
--

LOCK TABLES `t_entity_item` WRITE;
/*!40000 ALTER TABLE `t_entity_item` DISABLE KEYS */;
INSERT INTO `t_entity_item` VALUES (1,'aa','aaaa',1,NULL),(3,'gggggg','gggggg',1,NULL),(4,'bb','bbb',11,NULL),(5,'gggnnn','nnnnnnnnnnnnn',11,NULL),(6,'mma','mmn',11,NULL),(7,'lll','llll',11,NULL),(9,'ttt','ttttttttttttt',11,NULL),(10,'uuu','uuuu',11,NULL),(14,'gggnnnnnhhh','hhhhhhhhhhhhhhhhhhh',11,NULL),(15,'mmm','mmmmmmmmmmmmmmmmmmm',15,NULL),(16,'nnnnnnnnnnnnnnnn','nnnnnnnnnnnnnnnnnnn',15,NULL),(17,'adfasdf','asdfasdfasdf',15,NULL),(18,'bbbb','bbbb',16,NULL),(19,'ddd','ddddddddddddddddd',16,NULL),(20,'gggg','ggggg',16,NULL),(21,'nnn','nnnnnnnnnnn',16,NULL),(22,'ggg','ggggggggggggggggggggg',10,NULL),(24,'ggggggggggggggggggg','dddddddd',10,NULL),(41,'1111','aaaa',38,NULL),(42,'333','33333',38,NULL),(45,'uuu111','uuuuu',1,NULL),(52,'yyyr','rtrtr',1,NULL),(57,'point','积分',4,NULL),(59,'num','卡号',4,NULL),(60,'username','用户名',42,NULL),(62,'loginNum','连续登录次数',42,NULL),(63,'isInvite','是否邀请',42,NULL),(64,'from','邀请人',42,NULL),(65,'fromSize','邀请人已邀请数量',42,NULL),(66,'question','答题数',42,NULL),(67,'answerRight','答对数',42,NULL),(68,'avatar','是否上传头像',42,NULL),(69,'nickname','是否修改昵称',42,NULL),(70,'requiredInfo','是否完成必填资料',42,NULL),(71,'nonRequiredInfo','非必填字段数量',42,NULL);
/*!40000 ALTER TABLE `t_entity_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_menu`
--

DROP TABLE IF EXISTS `t_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_menu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `url` varchar(100) NOT NULL,
  `image` varchar(100) NOT NULL,
  `parent_id` int(10) unsigned NOT NULL DEFAULT '0',
  `sequence` int(10) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_menu`
--

LOCK TABLES `t_menu` WRITE;
/*!40000 ALTER TABLE `t_menu` DISABLE KEYS */;
INSERT INTO `t_menu` VALUES (1,'基础管理','','',0,1),(2,'规则管理','','',0,2),(3,'实体管理','entity/listEntity','images/icons/default.png',1,3),(4,'动作类型管理','action/listActionMeta','images/icons/default.png',1,4),(5,'场景管理','scene/listScene','images/icons/default.png',1,5),(8,'系统管理',' ',' ',0,8),(9,'角色管理','role/list','images/icons/default.png',8,9),(10,'答题场景','rule/listRule?sceneId=14','images/icons/default.png',2,8),(12,'登录场景','rule/listRule?sceneId=15','images/icons/default.png',2,9),(13,'注册场景','rule/listRule?sceneId=16','images/icons/default.png',2,10),(14,'资料完善场景','rule/listRule?sceneId=17','images/icons/default.png',2,11);
/*!40000 ALTER TABLE `t_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'sa','系统管理员'),(2,'worker','运维人员');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role_menu`
--

DROP TABLE IF EXISTS `t_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role_menu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(10) unsigned NOT NULL,
  `menu_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role_menu`
--

LOCK TABLES `t_role_menu` WRITE;
/*!40000 ALTER TABLE `t_role_menu` DISABLE KEYS */;
INSERT INTO `t_role_menu` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(10,1,8),(11,1,9),(24,1,10),(32,2,1),(33,2,5),(34,2,2),(35,2,7),(36,2,10),(37,2,8),(38,2,9),(82,1,12),(83,2,12),(85,1,13),(86,2,13),(88,1,14),(89,2,14);
/*!40000 ALTER TABLE `t_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_rule`
--

DROP TABLE IF EXISTS `t_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_rule` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `date_entered` date DEFAULT NULL,
  `date_modified` date DEFAULT NULL,
  `scene_id` int(36) DEFAULT NULL,
  `condition_c` varchar(1000) DEFAULT NULL,
  `action` varchar(1000) DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL,
  `begin` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_rule`
--

LOCK TABLES `t_rule` WRITE;
/*!40000 ALTER TABLE `t_rule` DISABLE KEYS */;
INSERT INTO `t_rule` VALUES (68,'大于等于3且小于15天','2013-04-24','2013-04-24',15,'73','32',1,NULL,NULL),(69,'大于等于15天','2013-04-24','2013-04-24',15,'74','33',1,NULL,NULL),(70,'连续登录<=2','2013-04-24','2013-04-24',15,'75','34',1,NULL,NULL),(71,'等于15','2013-04-24','2013-04-24',15,'76','35',1,NULL,NULL),(72,'等于3','2013-04-24','2013-04-24',15,'77','36',1,NULL,NULL),(75,'邀请送100','2013-04-25','2013-04-25',16,'80','39',1,NULL,NULL),(77,'注册送100分','2013-04-25','2013-04-25',16,'','41',1,NULL,NULL),(78,'答题送10分','2013-04-25','2013-04-25',14,'82','42',1,NULL,NULL),(79,'答对1题送50分','2013-04-25','2013-04-25',14,'83','43',1,NULL,NULL),(80,'上传头像送50分','2013-04-25','2013-04-25',17,'84','44',1,NULL,NULL),(81,'修改昵称送20分','2013-04-25','2013-04-25',17,'85','45',1,NULL,NULL),(82,'完成必填字段送50分','2013-04-25','2013-04-25',17,'86','46',1,NULL,NULL),(83,'完成非必填字段,10分/个','2013-04-25','2013-04-25',17,'87','47',1,NULL,NULL);
/*!40000 ALTER TABLE `t_rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_scene`
--

DROP TABLE IF EXISTS `t_scene`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_scene` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `identify` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_scene`
--

LOCK TABLES `t_scene` WRITE;
/*!40000 ALTER TABLE `t_scene` DISABLE KEYS */;
INSERT INTO `t_scene` VALUES (14,'question','答题场景'),(15,'login','登录场景'),(16,'register','注册场景'),(17,'perfect','资料完善场景');
/*!40000 ALTER TABLE `t_scene` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_scene_entity`
--

DROP TABLE IF EXISTS `t_scene_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_scene_entity` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `entity_id` int(36) DEFAULT NULL,
  `scene_id` int(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8540453 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_scene_entity`
--

LOCK TABLES `t_scene_entity` WRITE;
/*!40000 ALTER TABLE `t_scene_entity` DISABLE KEYS */;
INSERT INTO `t_scene_entity` VALUES (8540415,10,NULL),(8540416,4,NULL),(8540417,6,NULL),(8540447,4,15),(8540448,42,15),(8540449,42,16),(8540451,42,14),(8540452,42,17);
/*!40000 ALTER TABLE `t_scene_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_variable`
--

DROP TABLE IF EXISTS `t_variable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_variable` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `default_value` varchar(255) DEFAULT NULL,
  `dynamic_id` int(36) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_variable`
--

LOCK TABLES `t_variable` WRITE;
/*!40000 ALTER TABLE `t_variable` DISABLE KEYS */;
INSERT INTO `t_variable` VALUES (1,'12',NULL,'测试1',2),(2,'12',NULL,'测试2',1),(3,'12',0,'测试2',4),(4,'12',84834603,'动态测试',4);
/*!40000 ALTER TABLE `t_variable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_log`
--

DROP TABLE IF EXISTS `test_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_log` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `reason` varchar(10) DEFAULT NULL,
  `point` int(10) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_log`
--

LOCK TABLES `test_log` WRITE;
/*!40000 ALTER TABLE `test_log` DISABLE KEYS */;
INSERT INTO `test_log` VALUES (1,'连续登录1次',2,NULL,'2013-04-25 06:04:39',2),(2,'连续登录1次',2,NULL,'2013-04-25 06:09:46',2),(3,'邀请用户注册送积分',100,NULL,'2013-04-25 06:17:18',2),(4,'注册送分',100,NULL,'2013-04-25 06:17:18',15),(5,'上传头像送积分',50,NULL,'2013-04-25 06:26:17',2),(6,'修改昵称送积分',20,NULL,'2013-04-25 06:26:25',2),(7,'完成非必填字段送积分',50,NULL,'2013-04-25 06:26:32',2),(8,'连续登录1次',2,NULL,'2013-04-25 06:29:41',1);
/*!40000 ALTER TABLE `test_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_user`
--

DROP TABLE IF EXISTS `test_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `point` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_user`
--

LOCK TABLES `test_user` WRITE;
/*!40000 ALTER TABLE `test_user` DISABLE KEYS */;
INSERT INTO `test_user` VALUES (1,'alen',271),(2,'lyx',944),(6,'test',NULL),(7,'test1',160),(8,'test3',0),(9,'test4',0),(10,'test5',100),(11,'test6',100),(12,'test7',100),(13,'test8',100),(14,'aa',100),(15,'haha',100);
/*!40000 ALTER TABLE `test_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-04-25 14:31:34
