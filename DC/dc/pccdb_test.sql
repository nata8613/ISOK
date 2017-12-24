-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: pccdb
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
-- Table structure for table `bank`
--

DROP TABLE IF EXISTS `bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank` (
  `bankid` bigint(20) NOT NULL AUTO_INCREMENT,
  `billing_account` varchar(255) NOT NULL,
  `code` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `swift_code` varchar(255) NOT NULL,
  PRIMARY KEY (`bankid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank`
--

LOCK TABLES `bank` WRITE;
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
INSERT INTO `bank` VALUES (1,'1235896485695846',123,'Bank1','12345678'),(2,'1235896485695846',123,'Bank1','12345678'),(3,'456896485695846',456,'Bank2','45645678'),(5,'58791618561648',658,'nije test','78912345');
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit_card`
--

DROP TABLE IF EXISTS `credit_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credit_card` (
  `pan` bigint(20) NOT NULL AUTO_INCREMENT,
  `card_holder_name` varchar(255) NOT NULL,
  `expiration_date` date NOT NULL,
  `security_code` int(11) NOT NULL,
  `bank` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pan`),
  KEY `FK575qks61bhtthr30knr1340uj` (`bank`),
  CONSTRAINT `FK575qks61bhtthr30knr1340uj` FOREIGN KEY (`bank`) REFERENCES `bank` (`bankid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_card`
--

LOCK TABLES `credit_card` WRITE;
/*!40000 ALTER TABLE `credit_card` DISABLE KEYS */;
INSERT INTO `credit_card` VALUES (1,'pera','2017-01-28',879846,1),(2,'mika','2018-06-17',75100,2),(3,'maja','2016-03-15',220145,3),(4,'maja','2017-12-22',321478,3),(5,'pera','2017-01-28',879846,1),(6,'mika','2018-06-17',75100,2),(7,'maja','2016-03-15',220145,3),(8,'maja','2017-12-22',321478,3);
/*!40000 ALTER TABLE `credit_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant`
--

DROP TABLE IF EXISTS `merchant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `merchant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchantid` varchar(255) NOT NULL,
  `merchant_password` varchar(255) NOT NULL,
  `bank` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrxrug5qomk2npid6kjkpbcf56` (`bank`),
  CONSTRAINT `FKrxrug5qomk2npid6kjkpbcf56` FOREIGN KEY (`bank`) REFERENCES `bank` (`bankid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant`
--

LOCK TABLES `merchant` WRITE;
/*!40000 ALTER TABLE `merchant` DISABLE KEYS */;
INSERT INTO `merchant` VALUES (1,'id za merch1','pass123',1),(2,'id za merch1','pass123',2),(3,'id za merch2','pass456',3),(4,'54893656','root',5),(5,'98751698','neki pass',5),(6,'11036982','888888',3),(7,'36978000','passpasspass',1);
/*!40000 ALTER TABLE `merchant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `orderid` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` bigint(20) NOT NULL,
  `order_timestamp` datetime NOT NULL,
  `paymentid` bigint(20) NOT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (4,15000,'2013-08-05 18:19:03',14),(5,2000,'2015-11-05 22:44:53',36),(6,15890,'2016-10-26 10:33:14',55),(7,35000,'2016-11-28 16:58:08',17);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactionspcc`
--

DROP TABLE IF EXISTS `transactionspcc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactionspcc` (
  `transactionid` bigint(20) NOT NULL AUTO_INCREMENT,
  `paymentid` bigint(20) NOT NULL,
  `status` varchar(255) NOT NULL,
  `acquirer` bigint(20) DEFAULT NULL,
  `issuer` bigint(20) DEFAULT NULL,
  `merchant` bigint(20) DEFAULT NULL,
  `order_num` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`transactionid`),
  KEY `FKo0ll9vdxr43dpy4kjntd5livc` (`acquirer`),
  KEY `FKm3kq0qhlnypgtkvrld88aeumg` (`issuer`),
  KEY `FK80urdgs9rtc1bdspyy6wxtiju` (`merchant`),
  KEY `FKt9xcykxnkbprjal4eys54k3cr` (`order_num`),
  CONSTRAINT `FK80urdgs9rtc1bdspyy6wxtiju` FOREIGN KEY (`merchant`) REFERENCES `merchant` (`id`),
  CONSTRAINT `FKm3kq0qhlnypgtkvrld88aeumg` FOREIGN KEY (`issuer`) REFERENCES `bank` (`bankid`),
  CONSTRAINT `FKo0ll9vdxr43dpy4kjntd5livc` FOREIGN KEY (`acquirer`) REFERENCES `bank` (`bankid`),
  CONSTRAINT `FKt9xcykxnkbprjal4eys54k3cr` FOREIGN KEY (`order_num`) REFERENCES `orders` (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactionspcc`
--

LOCK TABLES `transactionspcc` WRITE;
/*!40000 ALTER TABLE `transactionspcc` DISABLE KEYS */;
INSERT INTO `transactionspcc` VALUES (1,14,'done',1,3,1,4),(2,17,'cancelled',2,2,2,7);
/*!40000 ALTER TABLE `transactionspcc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-23 23:20:59
