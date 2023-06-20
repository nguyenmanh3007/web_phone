-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: btlwebd19
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
  `id` varchar(10) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `tag` varchar(45) DEFAULT NULL,
  `be_price` int DEFAULT NULL,
  `des` longtext,
  `img` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `Configuration` varchar(45) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('A7','Cristiano Ronaldo','70000000','real',71000000,'new','img/fe659cd1-27a6-4846-85ad-d27795671d86.jpg','Apple','512Gb-64Gb',0),('AP08','Iphone 8','5000000','new',7000000,'black','img/ip8_Web.jpg','Apple','128Gb-32Gb',0),('AP09','ip9','999','old',123213,'new','img/88849c1e-2e47-43d9-a09b-ff223ce8773a.jpg','Apple','123',0),('AP11','Iphone 11','14000000','new',16000000,'green','img/ip11web.jpg','Apple','128Gb-64Gb',27),('AP11P','Iphone 11 pro','18000000','new',20000000,'white','img/ip11proweb.jpg','Apple','512Gb-64Gb',44),('AP13','Iphone 13','26000000','new',27000000,'yellow','img/ip13proweb.jpg','Apple','512Gb-64Gb',21),('AP13P','Iphone 13 pro','28000000','new',30000000,'gray','img/iphone-13-Pro.jpg','Apple','512Gb-64Gb',25),('AP13PM','Iphone 13 promax','32000000','new',34000000,'white','img/iphone-13-promax.jpg','Apple','512Gb-64Gb',29),('APX','Iphone X','8000000','new',9000000,'white','img/ipxweb.jpg','Apple','128Gb-64Gb',22),('IP15','IP15','123232132','new',263265523,'new','img/20d9359d-a50c-4e83-a60a-e7de0af42b2b.jpg','Apple','512GB-64GB',23),('SS01','samsung galaxy j5','14000000','new',21000000,'black','img/product-1.jpg','Samsung','256Gb-32Gb',92),('SS02','samsung galaxy note 5','15000000','new',17000000,'black','img/product-6.jpg','Samsung','256Gb-32Gb',23);
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

-- Dump completed on 2023-06-21  0:00:34
