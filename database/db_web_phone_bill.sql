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
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `idbill` int NOT NULL,
  `city` varchar(255) COLLATE utf8_bin NOT NULL,
  `country` varchar(255) COLLATE utf8_bin NOT NULL,
  `county` varchar(255) COLLATE utf8_bin NOT NULL,
  `date` varchar(255) COLLATE utf8_bin NOT NULL,
  `hn` varchar(255) COLLATE utf8_bin NOT NULL,
  `phone` varchar(255) COLLATE utf8_bin NOT NULL,
  `products` varchar(255) COLLATE utf8_bin NOT NULL,
  `status` int NOT NULL,
  `total` int NOT NULL,
  `userId` int NOT NULL,
  PRIMARY KEY (`idbill`),
  KEY `FK3qits8kw6sy106fgdpdr3llb3` (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,'guangchoz','AU','cutown','2023/09/18','12t fefas','0325257006','Iphone 13 x2; Iphone 11 pro x1; Iphone 11 pro x1; ',2,88000000,1),(2,'sudang','AR','saisod','2023/09/18','231r xita','0325257006','Iphone 13 x2; Iphone 11 pro x1; Iphone 11 pro x1; ',1,88000000,1),(3,'guangchoz','AO','cutown','2023/09/19','12t fefas','0325257006','Iphone 11 pro x1; Iphone 11 pro x1; Iphone 11 x1; ',0,50000000,1);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
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
