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
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `idbill` int NOT NULL,
  `country` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `city` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `county` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `hn` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `date` date DEFAULT NULL,
  `total` int DEFAULT NULL,
  `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `products` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`idbill`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,'VN','Ha Noi','thanh xuan','nguyen trai','0365478854','2023-04-29',64000000,'nguyenvana','Iphone 13 Promax x 2; ',2),(2,'AF','vinh','hung hoa','chu huy man','+84948847875','2023-02-07',56000000,'nmanh3007','Iphone 13 Prox 1; Iphone 13 Prox 1; ',2),(3,'CR','nghe an','vinh','chu huy man','+84948847875','2023-04-26',124000000,'nmanh3007','Iphone 11x1; Iphone 13x1; Cristiano Ronaldox1; Iphone 11x1; ',2),(4,'VN','nghe an','vinh','chu huy man','+84948847875','2023-05-06',210000000,'nmanh3007','Cristiano Ronaldox2; Cristiano Ronaldox1; ',2),(5,'AF','nghe an','vinh','chu huy man','+84948847875','2023-05-06',5000999,'nmanh3007','Iphone 8x1; ip9x1; ',2),(6,'VN','nghe an','vinh','chu huy man','+84948847875','2023-05-06',5000000,'nmanh3007','Iphone 8x1; ',2),(7,'AL','nghe an','vinh','chu huy man','+84948847875','2023-05-10',10001998,'nmanh3007','Iphone 8x1; Iphone 8x1; ip9x1; ip9x1; ',2),(8,'PW','Washington','enoucs','12g Houston','+84948847875','2023-06-25',92000000,'nmanh3007','Iphone 11 x2; Iphone 11 pro x2; Iphone 11 x2; ',2),(9,'AU','nghe an','vinh','chu huy man','+84948847875','2023-07-20',108000000,'nmanh3007','Iphone 11 pro x3; Iphone 13 x1; Iphone 13 pro x1; ',2),(10,'AU','nghe an','vinh','chu huy man','+84948847875','2023-07-20',26000000,'nmanh3007','Iphone 13 x1; ',2),(11,'AU','nghe an','vinh','chu huy man','+84948847875','2023-07-20',44000000,'nmanh3007','Iphone 13 x1; Iphone 11 pro x1; ',1),(12,'HR','nghe an','vinh','chu huy man','+84948847875','2023-07-20',32000000,'nmanh3007','Iphone 11 pro x1; samsung galaxy j5 x1; ',1),(13,'DZ','sudang','cutown','12t fefas','0325257006','2023-08-10',330464264,'nmanh3007','Iphone 13 pro x 3; IP15 x 2; ',1),(14,'CN','guangchoz','saisod','12t fefas','0325257006','2023-08-10',54000000,'nmanh3007','Iphone 11 pro x 3; ',0),(15,'AI','guangchoz','cutown','231r xita','0325257006','2023-08-10',56000000,'nmanh3007','Iphone 13 x 1; samsung galaxy note 5 x 2; ',0);
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

-- Dump completed on 2023-08-15 21:09:02
