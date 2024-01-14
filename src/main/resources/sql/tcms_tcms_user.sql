-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: tcms
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `tcms_user`
--

DROP TABLE IF EXISTS `tcms_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tcms_user` (
  `user_id` varchar(255) NOT NULL,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL COMMENT 'password',
  `user_name` varchar(255) DEFAULT NULL COMMENT 'user name',
  `title` varchar(255) DEFAULT NULL,
  `phone_num` varchar(255) DEFAULT NULL COMMENT 'phone number',
  `email` varchar(255) DEFAULT NULL COMMENT 'email',
  `deleted` tinyint DEFAULT NULL COMMENT 'delete mark',
  `create_time` bigint DEFAULT NULL COMMENT 'create time',
  PRIMARY KEY (`user_id`),
  KEY `index_account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tcms_user`
--

LOCK TABLES `tcms_user` WRITE;
/*!40000 ALTER TABLE `tcms_user` DISABLE KEYS */;
INSERT INTO `tcms_user` VALUES ('11111','zhangsan','sssss','zhangsan','title','13456784433','23423@qq.com',0,1704983805498),('85d8b834429b46ec92c05a5cf2a50867','zhangsan2','1234',NULL,NULL,NULL,NULL,0,1704983805498),('a0df77c836ce43cea60eb15a0185ccae','zhangsan1','1234',NULL,NULL,NULL,NULL,0,1704983805498),('cd6cd894ef784b6da8cc1479d7be1d39','zhangsan3','1234',NULL,NULL,NULL,NULL,0,1705045613263),('dde037d76c6b4d6ab7cfca8b5da489b6','zhangsan4','1234',NULL,NULL,NULL,NULL,0,1705045618120),('e228bad21c89415d9c7fa117f752d529','zhangsan5','1234',NULL,NULL,NULL,NULL,0,1705048562089);
/*!40000 ALTER TABLE `tcms_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-12 18:15:26
