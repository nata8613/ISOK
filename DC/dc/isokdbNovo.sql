CREATE DATABASE  IF NOT EXISTS `isokdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `isokdb`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: isokdb
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `category_risk`
--

DROP TABLE IF EXISTS `category_risk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_risk` (
  `category_id` bigint(20) NOT NULL,
  `risk_id` bigint(20) NOT NULL,
  PRIMARY KEY (`category_id`,`risk_id`),
  KEY `FKhunavn8fb9586hwjx19wk9xur` (`risk_id`),
  CONSTRAINT `FK73ir66lgcq1gosaru5wmsbisk` FOREIGN KEY (`category_id`) REFERENCES `insurance_category` (`id`),
  CONSTRAINT `FKhunavn8fb9586hwjx19wk9xur` FOREIGN KEY (`risk_id`) REFERENCES `risk` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_risk`
--

LOCK TABLES `category_risk` WRITE;
/*!40000 ALTER TABLE `category_risk` DISABLE KEYS */;
INSERT INTO `category_risk` VALUES (1,1),(1,2),(1,3),(1,4),(2,5),(2,6),(2,7),(2,8),(3,9),(3,10),(3,11),(3,12);
/*!40000 ALTER TABLE `category_risk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `client_email` varchar(255) NOT NULL,
  `client_name` varchar(255) NOT NULL,
  `client_surname` varchar(255) NOT NULL,
  `jmbg` varchar(255) NOT NULL,
  `passport_num` varchar(255) NOT NULL,
  `tel_num` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `home_insurance`
--

DROP TABLE IF EXISTS `home_insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `home_insurance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `insurance_length` int(11) NOT NULL,
  `jmbg` varchar(255) NOT NULL,
  `owner_name` varchar(255) NOT NULL,
  `owner_surname` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home_insurance`
--

LOCK TABLES `home_insurance` WRITE;
/*!40000 ALTER TABLE `home_insurance` DISABLE KEYS */;
/*!40000 ALTER TABLE `home_insurance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurance_category`
--

DROP TABLE IF EXISTS `insurance_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insurance_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  `client_fee` double NOT NULL,
  `starting_price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance_category`
--

LOCK TABLES `insurance_category` WRITE;
/*!40000 ALTER TABLE `insurance_category` DISABLE KEYS */;
INSERT INTO `insurance_category` VALUES (1,'HomeInsurance',0,100),(2,'TravelInsurance',20,200),(3,'VehicleInsurance',0,100);
/*!40000 ALTER TABLE `insurance_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_license`
--

DROP TABLE IF EXISTS `merchant_license`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `merchant_license` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bank` varchar(255) NOT NULL,
  `merchant_id` varchar(255) NOT NULL,
  `user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK59k0mrqi4v6halsnemi2awl3t` (`user`),
  CONSTRAINT `FK59k0mrqi4v6halsnemi2awl3t` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_license`
--

LOCK TABLES `merchant_license` WRITE;
/*!40000 ALTER TABLE `merchant_license` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_license` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy`
--

DROP TABLE IF EXISTS `policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `policy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contract_end` datetime NOT NULL,
  `contract_start` datetime NOT NULL,
  `price_summed` double NOT NULL,
  `home_insurance_id` bigint(20) DEFAULT NULL,
  `insurance_owner` bigint(20) NOT NULL,
  `travel_insurance_id` bigint(20) NOT NULL,
  `vehicle_insurance_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnfojkw7f5nliru9qp02x7aa5b` (`home_insurance_id`),
  KEY `FK693hprroh5bn75d2cmq4bmbeg` (`insurance_owner`),
  KEY `FKbnky45qv5ka6ab9a8ja1f32f6` (`travel_insurance_id`),
  KEY `FKkgfrku1guey6ve0t5p6pvjj1l` (`vehicle_insurance_id`),
  CONSTRAINT `FK693hprroh5bn75d2cmq4bmbeg` FOREIGN KEY (`insurance_owner`) REFERENCES `client` (`id`),
  CONSTRAINT `FKbnky45qv5ka6ab9a8ja1f32f6` FOREIGN KEY (`travel_insurance_id`) REFERENCES `travel_insurance` (`id`),
  CONSTRAINT `FKkgfrku1guey6ve0t5p6pvjj1l` FOREIGN KEY (`vehicle_insurance_id`) REFERENCES `vehicle_insurance` (`id`),
  CONSTRAINT `FKnfojkw7f5nliru9qp02x7aa5b` FOREIGN KEY (`home_insurance_id`) REFERENCES `home_insurance` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy`
--

LOCK TABLES `policy` WRITE;
/*!40000 ALTER TABLE `policy` DISABLE KEYS */;
/*!40000 ALTER TABLE `policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy_client`
--

DROP TABLE IF EXISTS `policy_client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `policy_client` (
  `client_id` bigint(20) NOT NULL,
  `policy_id` bigint(20) NOT NULL,
  PRIMARY KEY (`client_id`,`policy_id`),
  KEY `FKmp1jcsr2xfdkq2oof6eo8853e` (`policy_id`),
  CONSTRAINT `FKe64nmij6yx5qypsivlr2k561d` FOREIGN KEY (`client_id`) REFERENCES `policy` (`id`),
  CONSTRAINT `FKmp1jcsr2xfdkq2oof6eo8853e` FOREIGN KEY (`policy_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy_client`
--

LOCK TABLES `policy_client` WRITE;
/*!40000 ALTER TABLE `policy_client` DISABLE KEYS */;
/*!40000 ALTER TABLE `policy_client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy_risk_item`
--

DROP TABLE IF EXISTS `policy_risk_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `policy_risk_item` (
  `risk_item_id` bigint(20) NOT NULL,
  `policy_id` bigint(20) NOT NULL,
  PRIMARY KEY (`risk_item_id`,`policy_id`),
  KEY `FKm070chsuwpk5wkikjqt64uy86` (`policy_id`),
  CONSTRAINT `FKbaw8m690qikbs43to12e5ps8j` FOREIGN KEY (`risk_item_id`) REFERENCES `policy` (`id`),
  CONSTRAINT `FKm070chsuwpk5wkikjqt64uy86` FOREIGN KEY (`policy_id`) REFERENCES `risk_item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy_risk_item`
--

LOCK TABLES `policy_risk_item` WRITE;
/*!40000 ALTER TABLE `policy_risk_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `policy_risk_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price_impact_pricelist`
--

DROP TABLE IF EXISTS `price_impact_pricelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price_impact_pricelist` (
  `price_impact_id` bigint(20) NOT NULL,
  `pricelist_id` bigint(20) NOT NULL,
  PRIMARY KEY (`price_impact_id`,`pricelist_id`),
  KEY `FKtaihmstrmgwmccdh47etoy1ho` (`pricelist_id`),
  CONSTRAINT `FKt9f00c56ewai3n5iln5wfi4b2` FOREIGN KEY (`price_impact_id`) REFERENCES `price_list` (`id`),
  CONSTRAINT `FKtaihmstrmgwmccdh47etoy1ho` FOREIGN KEY (`pricelist_id`) REFERENCES `price_impacts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_impact_pricelist`
--

LOCK TABLES `price_impact_pricelist` WRITE;
/*!40000 ALTER TABLE `price_impact_pricelist` DISABLE KEYS */;
INSERT INTO `price_impact_pricelist` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29),(1,30),(1,31),(1,32),(1,33),(1,34),(1,35),(1,36),(1,37),(1,38),(1,39),(1,40),(1,41),(1,42),(1,43),(1,44),(1,45),(1,46),(1,47),(1,48),(1,49),(1,50),(1,51),(1,52),(1,53),(1,54);
/*!40000 ALTER TABLE `price_impact_pricelist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price_impacts`
--

DROP TABLE IF EXISTS `price_impacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price_impacts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` double NOT NULL,
  `item` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlhn0khtufcbmkg2g5m8urjeew` (`item`),
  CONSTRAINT `FKlhn0khtufcbmkg2g5m8urjeew` FOREIGN KEY (`item`) REFERENCES `risk_item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_impacts`
--

LOCK TABLES `price_impacts` WRITE;
/*!40000 ALTER TABLE `price_impacts` DISABLE KEYS */;
INSERT INTO `price_impacts` VALUES (1,0.2,1),(2,0.4,2),(3,0.5,3),(4,0.8,4),(5,0.9,5),(6,0.2,6),(7,0.3,7),(8,0.4,8),(9,0.6,9),(10,0.8,10),(11,0.4,11),(12,0.5,12),(13,0.6,13),(14,0.2,14),(15,0.3,15),(16,0.4,16),(17,0.5,17),(18,0.6,18),(19,0.8,19),(20,0.7,20),(21,0.5,21),(22,0.2,22),(23,0.3,23),(24,0.8,24),(25,0.2,25),(26,0.4,26),(27,0.5,27),(28,0.7,28),(29,0.8,29),(30,0.3,30),(31,0.5,31),(32,0.4,32),(33,0.55,33),(34,0.75,34),(35,0.9,35),(36,0.4,36),(37,0.2,37),(38,0.3,38),(39,0.25,39),(40,0.3,40),(41,0.5,41),(42,0.6,42),(43,0.65,43),(44,0.7,44),(45,0.5,45),(46,0.2,46),(47,0.4,47),(48,0.7,48),(49,0.3,49),(50,0.5,50),(51,0.7,51),(52,0.9,52),(53,0.3,53),(54,0.4,54);
/*!40000 ALTER TABLE `price_impacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price_list`
--

DROP TABLE IF EXISTS `price_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `valid_from` datetime NOT NULL,
  `valid_to` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_list`
--

LOCK TABLES `price_list` WRITE;
/*!40000 ALTER TABLE `price_list` DISABLE KEYS */;
INSERT INTO `price_list` VALUES (1,'2017-10-01 00:00:00','2018-04-10 00:00:00');
/*!40000 ALTER TABLE `price_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `risk`
--

DROP TABLE IF EXISTS `risk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `risk` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `risk_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `risk`
--

LOCK TABLES `risk` WRITE;
/*!40000 ALTER TABLE `risk` DISABLE KEYS */;
INSERT INTO `risk` VALUES (1,'Home age'),(2,'Home surface'),(3,'Insurance Reason'),(4,'Home value'),(5,'Personal age'),(6,'Destination'),(7,'Sport'),(8,'Insurance value'),(9,'Repair Price'),(10,'Hotel Days'),(11,'Alt vehicle'),(12,'Transport km');
/*!40000 ALTER TABLE `risk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `risk_item`
--

DROP TABLE IF EXISTS `risk_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `risk_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) NOT NULL,
  `risk` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKad1un1gq99my84kicdu68klde` (`risk`),
  CONSTRAINT `FKad1un1gq99my84kicdu68klde` FOREIGN KEY (`risk`) REFERENCES `risk` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `risk_item`
--

LOCK TABLES `risk_item` WRITE;
/*!40000 ALTER TABLE `risk_item` DISABLE KEYS */;
INSERT INTO `risk_item` VALUES (1,'0-10',1),(2,'11-30',1),(3,'31-60',1),(4,'61-100',1),(5,'101+',1),(6,'1-20',2),(7,'21-40',2),(8,'41-70',2),(9,'71-100',2),(10,'100+',2),(11,'Flood',3),(12,'Fire',3),(13,'Robbery',3),(14,'Other',3),(15,'1-15000',4),(16,'15001-30000',4),(17,'30001-60000',4),(18,'60001-100000',4),(19,'100001+',4),(20,'0-10',5),(21,'11-18',5),(22,'19-40',5),(23,'41-65',5),(24,'66+',5),(25,'Europe',6),(26,'Eastern Asia',6),(27,'Western Asia',6),(28,'Africa',6),(29,'Australia',6),(30,'North America',6),(31,'South America',6),(32,'Diving',7),(33,'Skiing',7),(34,'Mountain climbing',7),(35,'Motorsports',7),(36,'Athletics',7),(37,'Parenting',7),(38,'Water Sports',7),(39,'0-10000',8),(40,'10000-35000',8),(41,'35000+',8),(42,'0 - 500e',9),(43,'500 - 1500e',9),(44,'1500e +',9),(45,'0-2',10),(46,'2-5',10),(47,'5-10',10),(48,'10+',10),(49,'Car',11),(50,'Van',11),(51,'0-5',12),(52,'5-50',12),(53,'50-100',12),(54,'100+',12);
/*!40000 ALTER TABLE `risk_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permission`
--

DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_permission` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `FKf8yllw1ecvwqy3ehyxawqa1qp` (`permission_id`),
  CONSTRAINT `FKa6jx8n8xkesmjmv6jqug6bg68` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKf8yllw1ecvwqy3ehyxawqa1qp` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission`
--

LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rules`
--

DROP TABLE IF EXISTS `rules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rules` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rule` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rules`
--

LOCK TABLES `rules` WRITE;
/*!40000 ALTER TABLE `rules` DISABLE KEYS */;
/*!40000 ALTER TABLE `rules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel_insurance`
--

DROP TABLE IF EXISTS `travel_insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `travel_insurance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contact_mail` varchar(255) NOT NULL,
  `num_of_persons` int(11) NOT NULL,
  `price_sum` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel_insurance`
--

LOCK TABLES `travel_insurance` WRITE;
/*!40000 ALTER TABLE `travel_insurance` DISABLE KEYS */;
/*!40000 ALTER TABLE `travel_insurance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_insurance`
--

DROP TABLE IF EXISTS `vehicle_insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle_insurance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_and_type` varchar(255) NOT NULL,
  `chassis_num` varchar(255) NOT NULL,
  `jmbg` varchar(255) NOT NULL,
  `owner_name` varchar(255) NOT NULL,
  `owner_surname` varchar(255) NOT NULL,
  `production_year` varchar(255) NOT NULL,
  `reg_num` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_insurance`
--

LOCK TABLES `vehicle_insurance` WRITE;
/*!40000 ALTER TABLE `vehicle_insurance` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehicle_insurance` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-26  0:18:35
