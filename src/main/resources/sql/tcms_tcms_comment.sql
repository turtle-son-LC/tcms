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
-- Table structure for table `tcms_comment`
--

DROP TABLE IF EXISTS `tcms_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tcms_comment` (
  `comment_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `reply_to` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `root_comment_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `deleted` tinyint DEFAULT NULL,
  `create_time` bigint DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `index_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tcms_comment`
--

LOCK TABLES `tcms_comment` WRITE;
/*!40000 ALTER TABLE `tcms_comment` DISABLE KEYS */;
INSERT INTO `tcms_comment` VALUES ('23b55baf2e2240f8817d660687df3a34','werwe','85d8b834429b46ec92c05a5cf2a50867',NULL,NULL,0,1705043211044),('35d725ef533d4926b0144b847454c41f','sdfsdfsdf','85d8b834429b46ec92c05a5cf2a50867',NULL,NULL,0,1705043200354),('469a5e1c973a41afa620a008fe798f6f','xcv','85d8b834429b46ec92c05a5cf2a50867',NULL,NULL,0,1705043214156),('511fb1e0ed1245d8bbfa1e04aab6c6f6','67tyutyu','11111','e23bfac0e67844ab9d365a82de76145a','e23bfac0e67844ab9d365a82de76145a',0,1705046028439),('5a7501e598804c37807b2fcf09aee6f5','67tyutyu','a0df77c836ce43cea60eb15a0185ccae','511fb1e0ed1245d8bbfa1e04aab6c6f6','e23bfac0e67844ab9d365a82de76145a',0,1705046444832),('67ad3fde14c8488e8fa42e72164fa5ec','67tyutyu','11111','e23bfac0e67844ab9d365a82de76145a','e23bfac0e67844ab9d365a82de76145a',0,1705045788245),('82a8458118434bdb932e03cbe306d4a1','sfsdf','85d8b834429b46ec92c05a5cf2a50867',NULL,NULL,0,1705043197734),('906c7163e6504fcca3d79b2ac8c38e05','67tyutyu','85d8b834429b46ec92c05a5cf2a50867',NULL,NULL,0,1705043218574),('95190d004fc247e18e68f4efc86db169','sdfsdfew23234rwersdfghfg','85d8b834429b46ec92c05a5cf2a50867',NULL,NULL,0,1705043208449),('aef9969dd3e04aaa8ecddc56f15bc9ef','sdfsdfewrwersdf','85d8b834429b46ec92c05a5cf2a50867',NULL,NULL,0,1705043202736),('b02f05ef9bd34016a81fdddf0e72b4f0','comment','85d8b834429b46ec92c05a5cf2a50867',NULL,NULL,0,1705042856214),('d2234a845d7241e48dd0582f87ea2938','sdfsdfew23234rwersdf','85d8b834429b46ec92c05a5cf2a50867',NULL,NULL,0,1705043205593),('d69e695625374823be458289bc2da356','564564','85d8b834429b46ec92c05a5cf2a50867','5a7501e598804c37807b2fcf09aee6f5','e23bfac0e67844ab9d365a82de76145a',0,1705053331447),('e23bfac0e67844ab9d365a82de76145a','67tyutyu','11111',NULL,NULL,0,1705045648592),('f7cc2f1b47e746ea84e173d2e41680fa','67tyutyu','85d8b834429b46ec92c05a5cf2a50867','5a7501e598804c37807b2fcf09aee6f5','e23bfac0e67844ab9d365a82de76145a',0,1705046577561);
/*!40000 ALTER TABLE `tcms_comment` ENABLE KEYS */;
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