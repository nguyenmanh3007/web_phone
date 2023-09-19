-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: db_web_phone
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `be_price` int NOT NULL,
  `configuration` varchar(255) COLLATE utf8_bin NOT NULL,
  `des` varchar(255) COLLATE utf8_bin NOT NULL,
  `img` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `model` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `price` varchar(255) COLLATE utf8_bin NOT NULL,
  `quantity` int NOT NULL,
  `tag` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('AP08',7000000,'128Gb-32Gb','black','img/ip8_Web.jpg','Apple','Iphone 8','5000000',0,'new'),('AP11',16000000,'128Gb-64Gb','green','img/ip11web.jpg','Apple','Iphone 11','14000000',33,'new'),('AP11P',20000000,'512Gb-64Gb','white','img/ip11proweb.jpg','Apple','Iphone 11 pro','18000000',5,'new'),('AP13',27000000,'512Gb-64Gb','yellow','img/ip13proweb.jpg','Apple','Iphone 13','26000000',21,'new'),('AP13P',30000000,'512Gb-64Gb','gray','img/iphone-13-Pro.jpg','Apple','Iphone 13 pro','28000000',54,'new'),('AP13PM',34000000,'512Gb-64Gb','white','img/iphone-13-promax.jpg','Apple','Iphone 13 promax','32000000',12,'new'),('SS01',21000000,'256Gb-32Gb','black','img/product-1.jpg','Samsung','samsung galaxy j5','14000000',65,'new'),('SS02',17000000,'256Gb-32Gb','black','img/product-6.jpg','Samsung','samsung galaxy note 5','15000000',0,'new');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-19 14:21:20
