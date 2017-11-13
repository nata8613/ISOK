-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: isokdb
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `home_age`
--

DROP TABLE IF EXISTS `home_age`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `home_age` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age_num` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home_age`
--

LOCK TABLES `home_age` WRITE;
/*!40000 ALTER TABLE `home_age` DISABLE KEYS */;
INSERT INTO `home_age` (`id`, `age_num`) VALUES (1,'0-10'),(2,'11-30'),(3,'31-60'),(4,'61-100'),(5,'101+');
/*!40000 ALTER TABLE `home_age` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `home_insurance`
--

DROP TABLE IF EXISTS `home_insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `home_insurance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `length` int(11) NOT NULL,
  `start_price` double NOT NULL,
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
-- Table structure for table `home_owner`
--

DROP TABLE IF EXISTS `home_owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `home_owner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `jmbg` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home_owner`
--

LOCK TABLES `home_owner` WRITE;
/*!40000 ALTER TABLE `home_owner` DISABLE KEYS */;
INSERT INTO `home_owner` (`id`, `address`, `full_name`, `jmbg`) VALUES (1,'Knez Mihajlova 1','Milivoje Skiljevic','0302995167842');
/*!40000 ALTER TABLE `home_owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `home_surface`
--

DROP TABLE IF EXISTS `home_surface`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `home_surface` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `surface_num` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home_surface`
--

LOCK TABLES `home_surface` WRITE;
/*!40000 ALTER TABLE `home_surface` DISABLE KEYS */;
INSERT INTO `home_surface` (`id`, `surface_num`) VALUES (1,'1-20'),(2,'21-40'),(3,'41-70'),(4,'71-100'),(5,'100+');
/*!40000 ALTER TABLE `home_surface` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `home_value`
--

DROP TABLE IF EXISTS `home_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `home_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `approx_value` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home_value`
--

LOCK TABLES `home_value` WRITE;
/*!40000 ALTER TABLE `home_value` DISABLE KEYS */;
INSERT INTO `home_value` (`id`, `approx_value`) VALUES (1,'1-15000'),(2,'15001-30000'),(3,'30001-60000'),(4,'60001-100000'),(5,'100001+');
/*!40000 ALTER TABLE `home_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurance_type`
--

DROP TABLE IF EXISTS `insurance_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insurance_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance_type`
--

LOCK TABLES `insurance_type` WRITE;
/*!40000 ALTER TABLE `insurance_type` DISABLE KEYS */;
INSERT INTO `insurance_type` (`id`, `type_name`) VALUES (1,'House'),(2,'Flat'),(3,'Apartment');
/*!40000 ALTER TABLE `insurance_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `email`, `name`) VALUES (1,'marko@live.com','marko'),(2,'dasdas','dasdasda');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-13 16:44:03
