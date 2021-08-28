-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: quanly_nguyenlieu
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `alert`
--

DROP TABLE IF EXISTS `alert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alert` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `material_id` bigint NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `is_checked` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKalert851997` (`material_id`),
  CONSTRAINT `FKalert851997` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alert`
--

LOCK TABLES `alert` WRITE;
/*!40000 ALTER TABLE `alert` DISABLE KEYS */;
INSERT INTO `alert` VALUES (1,34,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 30% ','red ','2021-07-09',0),(2,57,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 30% ','red ','2021-08-24',0),(3,54,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 30% ','red ','2021-08-04',0),(4,40,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 30% ','red ','2020-10-13',0),(5,42,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 30% ','red ','2020-07-25',0),(6,57,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 30% ','red ','2020-05-20',0),(7,54,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 30% ','red ','2021-04-21',0),(8,52,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 30% ','red ','2020-08-07',0),(9,59,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 30% ','red ','2020-06-12',0),(10,50,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 30% ','red ','2021-03-07',0),(11,52,'Cảnh báo mức lượng nguyên liệu còn lại',' Lượng nguyên liệu còn lại là 50% ',' green ','2020-06-29',0),(12,47,'Cảnh báo mức lượng nguyên liệu còn lại',' Lượng nguyên liệu còn lại là 50% ',' green ','2020-03-05',0),(13,59,'Cảnh báo mức lượng nguyên liệu còn lại',' Lượng nguyên liệu còn lại là 50% ',' green ','2021-01-29',0),(14,47,'Cảnh báo mức lượng nguyên liệu còn lại',' Lượng nguyên liệu còn lại là 50% ',' green ','2020-05-24',0),(15,44,'Cảnh báo mức lượng nguyên liệu còn lại',' Lượng nguyên liệu còn lại là 50% ',' green ','2020-01-11',0),(16,38,'Cảnh báo mức lượng nguyên liệu còn lại',' Lượng nguyên liệu còn lại là 50% ',' green ','2020-11-02',0),(17,59,'Cảnh báo mức lượng nguyên liệu còn lại',' Lượng nguyên liệu còn lại là 50% ',' green ','2020-02-13',0),(18,38,'Cảnh báo mức lượng nguyên liệu còn lại',' Lượng nguyên liệu còn lại là 50% ',' green ','2020-10-23',0),(19,34,'Cảnh báo mức lượng nguyên liệu còn lại',' Lượng nguyên liệu còn lại là 50% ',' green ','2020-06-09',0),(20,53,'Cảnh báo mức lượng nguyên liệu còn lại',' Lượng nguyên liệu còn lại là 50% ',' green ','2021-04-05',0),(21,44,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 5.0%','red','2021-08-20',0),(22,35,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 6.52%','red','2021-08-20',0),(23,35,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 6.52%','red','2021-08-20',0),(24,35,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 6.52%','red','2021-08-20',0),(25,40,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 0.896861%','red','2021-08-24',0),(26,40,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 8.183454%','red','2021-08-24',0),(27,40,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 8.183454%','red','2021-08-24',0),(28,40,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 8.183454%','red','2021-08-24',0),(29,40,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 8.183454%','red','2021-08-24',0),(30,40,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 7.733813%','red','2021-08-24',0),(31,40,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 14.028777%','red','2021-08-24',0),(32,40,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 14.028777%','red','2021-08-28',1),(34,35,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 6.52%','red','2021-08-28',1),(35,35,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 6.52%','red','2021-08-28',1),(36,35,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 6.52%','red','2021-08-28',1),(42,35,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 6.52%','red','2021-08-28',1),(43,35,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 6.52%','red','2021-08-28',1),(44,35,'Cảnh báo mức lượng nguyên liệu còn lại','Lượng nguyên liệu còn lại là 6.52%','red','2021-08-28',1);
/*!40000 ALTER TABLE `alert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `current_amount` float NOT NULL,
  `total_amount` float NOT NULL,
  `expiry` datetime DEFAULT NULL,
  `status` int NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmaterial536567` (`user_id`),
  CONSTRAINT `FKmaterial536567` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (31,1,'hạt cà phê loại 1','hạt','image1.jpg',9,123,'2022-06-10 10:08:55',2,'2022-08-04 11:04:26','2021-08-20 18:16:25'),(32,1,'Hạt Óc chó','hạt','image1.jpg',6,207,'2022-07-04 00:55:42',2,'2021-11-02 09:57:56','2020-08-17 00:30:44'),(33,1,'Hạt Điều','hạt','image1.jpg',87,1300,'2020-11-17 03:22:23',2,'2020-11-17 16:54:25','2021-08-20 22:24:10'),(34,1,'Hạt dẻ','hạt','image1.jpg',9,1088,'2021-12-10 20:16:09',2,'2020-10-11 11:11:56','2020-06-23 09:48:31'),(35,1,'Hạt sen','hạt','image1.jpg',326,5000,'2022-01-05 02:08:53',2,'2021-03-30 15:40:27','2021-08-20 23:08:22'),(36,3,'Vải','quả','image1.jpg',0,246,'2022-04-11 06:54:14',0,'2020-11-11 14:42:49','2021-08-28 17:09:16'),(37,1,'Hạt hướng dương','hạt','image1.jpg',2,733,'2021-10-07 00:19:28',2,'2021-01-31 08:42:44','2020-10-16 21:40:54'),(38,1,'Hạt nho','hạt','image1.jpg',3,6234,'2021-11-22 05:50:33',2,'2022-07-16 13:12:08','2021-08-20 17:47:31'),(39,3,'Hạt bí ngô','hạt','image1.jpg',546,1488,'2022-03-05 11:02:07',2,'2022-07-02 19:40:20','2021-08-28 17:43:44'),(40,1,'hạt macca','hạt','image1.jpg',156,1112,'2022-02-05 22:19:17',2,'2021-02-28 08:21:08','2021-08-24 09:30:07'),(41,3,'Bột bắp','bột','image1.jpg',14702,15340,'2022-02-14 06:18:11',2,'2022-02-21 20:34:27','2021-08-28 17:44:16'),(42,1,'Bột ớt','bột','image1.jpg',5000,6350,'2022-05-14 13:07:11',1,'2022-03-24 13:44:33','2021-08-20 18:00:26'),(43,3,'Bột tiêu sọ trắng','bột','image1.jpg',4793,5389,'2021-10-21 18:31:39',1,'2021-11-19 02:31:31','2021-08-28 17:43:51'),(44,1,'Tinh bột nghệ','bột','image1.jpg',100,2000,'2022-06-22 05:36:01',1,'2021-03-13 17:41:28','2021-08-20 23:10:38'),(45,1,'Tinh bột sẵn','bột','image1.jpg',400,771,'2020-09-05 05:49:21',1,'2022-02-27 03:28:42','2020-04-05 17:13:04'),(46,1,'Gạo','hạt','image1.jpg',1689,1095,'2022-03-15 06:45:41',1,'2021-07-15 05:58:37','2021-08-28 17:46:21'),(47,3,'Gạo lứt','hat','image1.jpg',4737,5696,'2021-03-05 23:01:55',2,'2020-12-30 01:05:56','2021-08-28 17:43:37'),(48,3,'Tinh than tre','bột','image1.jpg',3618,3869,'2021-05-30 07:05:15',2,'2021-03-09 22:13:47','2021-08-28 17:44:05'),(49,3,'Bột sương sáo','bột','image1.jpg',-291,111,'2021-09-22 11:47:00',2,'2021-07-20 03:26:19','2021-08-28 17:43:15'),(50,1,'Bột củ dền','bột','image1.jpg',7,707,'2020-10-04 23:25:35',2,'2021-11-04 10:01:52','2020-04-18 14:50:55'),(51,1,'Quả Dâu','hoa quả','image1.jpg',1000,1887,'2022-05-15 15:42:18',1,'2022-07-08 06:58:19','2021-08-20 17:46:55'),(52,1,'Quả Nho','hoa quả','image1.jpg',60,123,'2021-06-19 15:38:47',1,'2021-11-16 11:15:46','2021-08-20 18:16:05'),(53,1,'hạt cacao loại 9','hoa quả','image1.jpg',100,147,'2021-07-05 18:42:37',1,'2020-12-11 10:16:31','2020-08-29 07:20:44'),(54,3,'Quả Chuối','hoa quả','image1.jpg',10834,11134,'2020-11-14 12:42:32',1,'2021-11-28 11:53:35','2021-08-28 17:43:59'),(55,1,'Quả Táo','hoa quả','image1.jpg',489,778,'2021-11-04 07:44:15',1,'2022-05-11 17:47:04','2021-08-28 17:46:52'),(56,1,'Quả Cam','hoa quả','image1.jpg',2988,6427,'2020-08-19 13:07:51',1,'2022-05-30 09:05:55','2021-08-28 17:46:52'),(57,1,'Quả Mít','hoa quả','image1.jpg',200,339,'2020-12-28 20:17:10',1,'2021-03-05 20:57:28','2020-10-30 20:27:34'),(58,1,'Củ khoai','củ','image1.jpg',2878,9320,'2021-08-26 17:47:42',1,'2020-09-06 16:27:13','2021-08-28 17:45:43'),(59,3,'Nhãn','quả','image1.jpg',0,4953,'2021-02-12 23:39:23',0,'2022-04-11 10:10:05','2021-08-28 17:09:02'),(181,3,'Tỏi','123',NULL,90,100,NULL,0,'2021-08-24 09:37:40','2021-08-28 17:13:47'),(182,3,'Hồ tiêu','3123',NULL,213,213,NULL,1,'2021-08-24 09:59:36','2021-08-28 17:07:22');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material_supplier`
--

DROP TABLE IF EXISTS `material_supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material_supplier` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `supplier_id` bigint NOT NULL,
  `material_id` bigint NOT NULL,
  `amount_material` float NOT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmaterial_s240700` (`material_id`),
  KEY `FKmaterial_s975789` (`supplier_id`),
  CONSTRAINT `FKmaterial_s240700` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`),
  CONSTRAINT `FKmaterial_s975789` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material_supplier`
--

LOCK TABLES `material_supplier` WRITE;
/*!40000 ALTER TABLE `material_supplier` DISABLE KEYS */;
INSERT INTO `material_supplier` VALUES (1,30,54,1551,'2022-07-06 10:03:16'),(2,4,53,4429,'2021-07-19 22:56:33'),(3,7,38,6234,'2020-12-29 15:32:33'),(4,24,34,7130,'2021-02-18 19:51:15'),(6,14,55,8335,'2021-11-18 12:14:55'),(7,3,32,6400,'2021-02-15 13:19:52'),(8,3,46,1095,'2021-04-27 01:03:01'),(9,13,57,7378,'2022-06-24 18:04:35'),(11,23,56,6427,'2021-07-23 02:34:39'),(12,24,51,1887,'2021-10-21 03:26:13'),(17,7,37,1449,'2021-09-07 15:59:10'),(18,4,47,5696,'2021-10-17 21:47:22'),(19,28,58,9320,'2021-12-10 03:50:14'),(21,3,54,9583,'2021-08-12 03:55:46'),(22,16,50,7214,'2021-09-07 13:20:53'),(23,23,41,6552,'2020-12-02 11:18:14'),(24,13,45,3810,'2021-02-23 21:35:13'),(25,9,55,5984,'2022-03-06 20:39:27'),(26,8,41,8788,'2021-05-02 04:53:57'),(30,28,59,4953,'2022-07-13 23:02:53'),(33,13,35,5000,'2022-02-11 14:36:39'),(34,7,53,8278,'2022-03-30 20:44:01'),(35,17,43,5389,'2022-05-09 00:44:31'),(37,30,42,6350,'2021-07-20 11:17:25'),(39,29,48,3869,'2021-11-09 07:15:24'),(40,10,39,1488,'2021-09-08 12:06:03'),(103,7,33,1300,'2021-08-20 17:47:08'),(104,8,52,123,'2021-08-20 18:16:05'),(105,8,31,123,'2021-08-20 18:16:25'),(115,25,40,1000,'2021-08-20 20:57:54'),(116,7,40,112,'2021-08-20 20:57:54'),(121,8,36,123,'2021-08-20 21:02:07'),(122,5,36,123,'2021-08-20 21:02:07'),(123,8,44,2000,'2021-08-20 22:24:41'),(124,7,181,100,'2021-08-24 09:37:40'),(125,6,182,213,'2021-08-24 09:59:36'),(126,8,49,111,'2021-08-28 17:43:15');
/*!40000 ALTER TABLE `material_supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material_warning`
--

DROP TABLE IF EXISTS `material_warning`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material_warning` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `material_id` bigint NOT NULL,
  `warning_threshold_id` bigint NOT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmaterial_w627691` (`warning_threshold_id`),
  KEY `FKmaterial_w153322` (`material_id`),
  CONSTRAINT `FKmaterial_w153322` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`),
  CONSTRAINT `FKmaterial_w627691` FOREIGN KEY (`warning_threshold_id`) REFERENCES `warning_threshold` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material_warning`
--

LOCK TABLES `material_warning` WRITE;
/*!40000 ALTER TABLE `material_warning` DISABLE KEYS */;
INSERT INTO `material_warning` VALUES (2,37,1,'2021-05-12 10:47:58'),(3,34,16,'2020-03-17 14:27:34'),(9,57,19,'2021-05-21 14:35:16'),(10,50,4,'2020-09-25 15:55:50'),(11,45,10,'2022-12-21 00:54:37'),(14,32,8,'2022-03-10 01:42:07'),(15,53,25,'2020-10-29 13:43:02'),(16,50,24,'2020-06-04 18:01:18'),(19,55,9,'2020-03-16 05:19:05'),(20,32,16,'2021-03-12 23:08:32'),(26,46,30,'2021-08-20 17:46:35'),(28,51,30,'2021-08-20 17:46:55'),(30,38,20,'2021-08-20 17:47:31'),(34,56,15,'2021-08-20 17:56:24'),(35,56,10,'2021-08-20 17:56:24'),(36,58,20,'2021-08-20 17:56:39'),(37,42,30,'2021-08-20 18:00:26'),(38,31,30,'2021-08-20 18:16:25'),(40,52,30,'2021-08-20 18:16:47'),(65,33,30,'2021-08-20 22:24:10'),(66,35,30,'2021-08-20 22:24:19'),(67,44,30,'2021-08-20 22:24:41'),(68,40,30,'2021-08-24 09:00:44'),(71,182,30,'2021-08-28 17:07:23'),(73,181,10,'2021-08-28 17:08:31'),(74,59,30,'2021-08-28 17:09:02'),(75,36,30,'2021-08-28 17:09:16'),(76,49,4,'2021-08-28 17:43:15'),(77,49,23,'2021-08-28 17:43:15'),(78,47,25,'2021-08-28 17:43:37'),(79,39,10,'2021-08-28 17:43:44'),(80,43,25,'2021-08-28 17:43:51'),(81,54,25,'2021-08-28 17:43:59'),(82,48,10,'2021-08-28 17:44:05'),(83,41,30,'2021-08-28 17:44:16');
/*!40000 ALTER TABLE `material_warning` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `amount` float NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `status` int NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKproduct4769` (`user_id`),
  CONSTRAINT `FKproduct4769` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (31,1,'Mít khô sấy dẻo',1103,'image1.jpg',2,'2021-04-26 21:02:25','2021-08-17 15:31:39'),(32,1,'seafood',7,'image1.jpg',2,'2020-08-30 06:17:00','2020-02-20 00:03:45'),(33,1,'salads hoa quả',3,'image1.jpg',1,'2020-02-06 02:44:20','2020-04-10 07:00:56'),(34,1,' mì ý pasta',3,'image1.jpg',1,'2021-02-18 22:04:30','2021-07-18 03:10:33'),(35,1,'Hạt điều khô ',14726,'image1.jpg',2,'2021-03-12 13:20:48','2021-08-17 15:30:52'),(36,3,'Hộp hoa quả',123,'image1.jpg',1,'2021-07-31 16:33:10','2021-08-28 17:46:52'),(37,1,'Gói hạt điều',9,'image1.jpg',1,'2021-02-13 04:50:36','2021-08-17 15:56:56'),(38,1,'Chuối sấy',10,'image1.jpg',1,'2020-08-24 19:02:46','2020-10-30 22:23:36'),(39,1,'Gạo đóng bao',5,'image1.jpg',1,'2021-11-15 09:21:41','2020-11-06 22:02:25'),(40,1,'Mì gạo',3,'image1.jpg',1,'2021-06-28 06:44:18','2021-08-17 15:50:24'),(41,1,'Mì ống',2,'image2.jpg',2,'2021-01-29 21:58:11','2021-06-04 22:39:02'),(42,1,'Phở bánh',6,'image2.jpg',1,'2021-01-07 20:57:28','2021-07-11 00:07:20'),(43,1,'Mì tôm',7,'image2.jpg',1,'2021-03-24 23:44:55','2020-08-29 04:17:48'),(44,3,'Bánh quy A',222,'image2.jpg',1,'2021-01-04 09:06:55','2021-08-28 17:45:43'),(45,3,'Bánh quy B',111,'image2.jpg',2,'2020-04-05 06:25:30','2021-08-28 17:46:21'),(46,1,'Bánh quy C',12792,'image2.jpg',2,'2021-01-24 11:56:29','2021-08-17 15:30:36'),(47,1,'Bánh quy D',8,'image2.jpg',1,'2020-12-08 08:25:24','2021-03-15 01:32:48'),(48,1,'Mì trộn',8,'image2.jpg',1,'2020-07-26 04:15:05','2020-09-19 10:26:42'),(49,1,'Sa lát hoa quả',8,'image2.jpg',2,'2020-09-16 07:53:18','2020-07-13 01:12:24'),(50,1,'Nho khô gói',4,'image2.jpg',2,'2021-03-26 07:52:31','2020-08-15 09:10:47'),(51,1,'Hoa quả sấy',33,'download.jpg',1,'2021-08-17 01:52:31','2021-08-17 01:52:31'),(52,1,'Mì tương đen',123,'download.jpg',1,'2021-08-17 19:17:32','2021-08-17 19:17:32'),(53,1,'Mì',12345,'mitron.jpg',1,'2021-08-17 19:21:51','2021-08-17 19:21:51'),(54,1,'Gói hạt nho',1,'nha-cung-cap.png',0,'2021-08-17 19:56:46','2021-08-19 13:25:46'),(55,1,'Gói đậu đỏ',123,'nha-cung-cap.png',1,'2021-08-19 18:23:59','2021-08-19 18:23:59'),(56,1,'Gói đậu đen',123,'nha-cung-cap.png',1,'2021-08-19 18:27:05','2021-08-19 18:27:05'),(57,1,'Gói hạt sen',1234,'mitron.jpg',1,'2021-08-19 18:30:02','2021-08-19 18:30:02'),(58,1,'Gói chuối khô',1234,'mitron.jpg',1,'2021-08-19 18:31:32','2021-08-19 18:44:25'),(59,1,'Gói Táo',321,'nha-cung-cap.png',1,'2021-08-19 18:50:24','2021-08-19 18:50:24'),(60,1,'Gói Cam',321,'nha-cung-cap.png',1,'2021-08-19 18:50:46','2021-08-19 18:50:46'),(61,1,'Gói Mít To 1',32133,'mitron.jpg',2,'2021-08-19 18:52:28','2021-08-19 22:10:15'),(62,1,'Gói hạt điều',123,NULL,1,'2021-08-19 23:03:46','2021-08-20 22:31:16'),(63,1,'Gói chè thập cẩm',123,NULL,1,'2021-08-19 23:05:07','2021-08-20 22:07:14'),(70,3,'Chè Hạt sen',400,NULL,1,'2021-08-20 23:08:19','2021-08-28 17:35:02'),(71,1,'Hộp nghệ tươi',1700,NULL,1,'2021-08-20 23:10:35','2021-08-20 23:10:35'),(72,1,'Macca Gói To',900,NULL,1,'2021-08-24 08:59:06','2021-08-24 09:02:27'),(74,3,'Gói Macca nhỏ',800,NULL,2,'2021-08-24 09:19:12','2021-08-28 17:09:44');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_material`
--

DROP TABLE IF EXISTS `product_material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_material` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `material_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  `amount_material` float NOT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKproduct_ma642624` (`product_id`),
  KEY `FKproduct_ma55373` (`material_id`),
  CONSTRAINT `FKproduct_ma55373` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`),
  CONSTRAINT `FKproduct_ma642624` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_material`
--

LOCK TABLES `product_material` WRITE;
/*!40000 ALTER TABLE `product_material` DISABLE KEYS */;
INSERT INTO `product_material` VALUES (1,54,43,2040,'2020-09-10 07:40:31'),(2,33,32,2578,'2021-09-12 10:11:10'),(3,53,34,7899,'2021-12-08 09:48:52'),(4,36,35,2037,'2022-02-10 02:20:28'),(5,50,38,8430,'2021-03-13 13:09:28'),(6,59,35,9455,'2022-04-22 11:45:31'),(7,52,42,2421,'2021-06-08 00:10:24'),(8,47,37,1928,'2021-04-17 19:15:37'),(9,55,50,3916,'2021-08-23 16:28:01'),(10,53,38,4532,'2021-12-12 03:32:53'),(11,39,37,1057,'2020-09-24 20:22:44'),(12,43,49,4353,'2021-09-29 07:53:35'),(13,49,46,9159,'2021-11-11 23:01:51'),(14,50,43,6574,'2021-07-31 00:44:25'),(15,53,48,1794,'2021-11-17 04:45:15'),(16,34,32,8061,'2020-12-27 06:57:48'),(17,44,49,2302,'2021-04-14 22:08:59'),(18,33,39,8961,'2021-01-24 06:50:29'),(19,50,35,3234,'2022-03-25 15:22:41'),(20,46,40,9358,'2022-05-04 06:34:18'),(21,46,47,7893,'2021-01-09 09:43:46'),(22,51,33,6409,'2021-03-13 16:48:44'),(23,43,41,9393,'2021-06-09 02:44:55'),(24,57,34,3354,'2022-01-31 12:16:03'),(25,39,46,3633,'2021-11-11 20:42:01'),(26,36,39,6535,'2022-05-11 12:22:40'),(27,57,31,1103,'2021-05-22 10:03:55'),(28,44,47,3284,'2021-12-24 02:56:15'),(29,38,34,2652,'2021-05-04 09:30:00'),(30,44,33,6273,'2021-12-20 04:16:11'),(31,57,51,11,NULL),(32,54,51,22,NULL),(33,46,52,123,'2021-08-17 19:17:33'),(34,46,53,12345,'2021-08-17 19:21:51'),(35,38,54,1,'2021-08-17 19:56:47'),(36,38,55,123,'2021-08-19 18:24:00'),(37,32,56,123,'2021-08-19 18:27:05'),(38,35,57,1234,'2021-08-19 18:30:02'),(39,54,58,1234,'2021-08-19 18:31:33'),(40,55,59,321,'2021-08-19 18:50:24'),(41,56,60,321,'2021-08-19 18:50:46'),(42,57,61,32133,'2021-08-19 18:52:28'),(46,35,63,123,'2021-08-20 22:07:14'),(47,33,62,123,'2021-08-20 22:07:34'),(48,35,70,400,'2021-08-20 23:08:22'),(49,44,71,1700,'2021-08-20 23:10:38'),(50,40,72,900,'2021-08-24 08:59:06'),(51,40,74,800,'2021-08-24 09:19:13'),(57,46,44,100,'2021-08-28 17:45:43'),(58,58,44,122,'2021-08-28 17:45:43'),(59,46,45,111,'2021-08-28 17:46:21'),(60,55,36,111,'2021-08-28 17:46:52'),(61,56,36,12,'2021-08-28 17:46:52');
/*!40000 ALTER TABLE `product_material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsupplier837325` (`user_id`),
  CONSTRAINT `FKsupplier837325` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,3,'Auctor Ullamcorper Nisl Company','385-1810 Mauris Road','0911111111','fringilla.Donec@gmail.com','2020-08-23 20:55:54','2021-08-28 16:37:14',1),(2,3,'Luctus Lobortis Class Consulting','Ap #753-6636 Ut, Rd.','0364731912','est@gmail.com','2020-08-23 20:55:54','2021-08-28 16:36:08',1),(3,3,'Semper Tellus Consulting','P.O. Box 173, 3057 Est. St.','0806584019','Ut@gmail.com','2020-08-23 20:55:54','2021-08-28 16:36:19',1),(4,3,'Quisque Consulting','3706 Donec St.','0749761175','libero.Proin@gmail.com','2020-08-23 20:55:54','2021-08-28 16:36:03',2),(5,3,'Suspendisse Corp.','P.O. Box 765, 881 Pellentesque Road','0911111111','Integer.tincidunt.aliquam@gmail.com','2020-08-23 20:55:54','2021-08-28 16:37:17',1),(6,3,'Adipiscing LLC','Ap #630-8665 Quisque St.','0725183705','Pellentesque.ut.ipsum@gmail.com','2020-08-23 20:55:54','2021-08-28 16:35:59',2),(7,3,'PC FOOD','Hà đông , Hà Nội','0970843313','Proin@gmail.com','2020-08-23 20:55:54','2021-08-28 16:36:43',1),(8,3,'Công ty THHH ABC','P.O. Box 363, 5330 Vitae Avenue','0911111111','vitae.sodales.nisi@gmail.com','2020-08-23 20:55:54','2021-08-28 16:37:10',1),(9,3,'Vel Pede Limited','402-2280 Donec Road','0784362411','Pellentesque@gmail.com','2020-08-23 20:55:54','2021-08-28 16:36:22',2),(10,3,'Sapien Imperdiet Ornare PC','804-784 Auctor St.','0707926209','arcu.Sed.et@gmail.com','2020-08-23 20:55:54','2021-08-28 16:35:54',2),(11,3,'A Food','599-703 Sem St.','0922333444','Sed.molestie@gmail.com','2020-08-23 20:55:54','2021-08-28 16:36:51',2),(12,3,'Erat Volutpat Nulla PC','209-3647 Dui. Rd.','0391344847','amet@gmail.com','2020-08-23 20:55:54','2021-08-28 16:36:14',2),(13,3,'AOF Food ','Gia Viễn , Ninh Bình','0922333444','libero@gmail.com','2020-08-23 20:55:54','2021-08-28 16:36:40',2),(14,3,'Nunc Sed PC','P.O. Box 135, 2949 Vulputate Rd.','0859421174','dolor@gmail.com','2020-08-23 20:55:54','2021-08-28 16:35:50',2),(15,3,'Phasellus Dolor Associates','8998 Tristique Ave','0522620769','congue.In.scelerisque@gmail.com','2020-08-23 20:55:54','2021-08-28 16:35:46',1),(16,3,'Nullam Institute','Ap #150-6878 Quam. Av.','0825963799','Vivamus.molestie.dapibus@gmail.com','2020-08-23 20:55:54','2021-08-28 16:35:42',1),(17,3,'Donec Limited','Ap #733-4580 Eu Rd.','0887127078','Duis.mi@gmail.com','2020-08-23 20:55:54','2021-08-28 16:37:38',2),(18,3,'AHA FOOD','Thanh Xuân , Hà Nội','0911111222','augue.id@gmail.com','2020-11-11 12:25:59','2021-08-28 16:36:27',1),(19,3,'Tristique Ac Consulting','109-7869 Varius. St.','0839949252','elit@gmail.com','2020-08-23 20:55:54','2021-08-28 16:37:49',2),(20,3,'Nam PC','P.O. Box 363, 7547 Vulputate Road','0356370287','varius.et@gmail.com','2020-08-26 05:50:39','2021-08-28 16:38:06',2),(21,3,'Eget Consulting','P.O. Box 297, 8812 Montes, Street','0829945522','lacinia.mattis@gmail.com','2020-08-23 20:55:54','2021-08-28 16:39:56',2),(22,3,'Risus Industries','Ap #746-3005 Sed Rd.','0408942674','mi.ac.mattis@email.com','2020-09-13 09:01:10','2021-08-28 16:39:45',2),(23,3,'Erat Associates','9998 Convallis Avenue','0909648550','ac.ipsum@gmail.com','2020-08-23 20:55:54','2021-08-28 16:39:32',2),(24,3,'Convallis In Inc.','P.O. Box 644, 3636 Risus. Av.','0533063416','tristique@aenimSuspendisse.edu','2020-08-23 20:55:54','2021-08-28 16:39:22',2),(25,3,'Integer LLP','Ap #953-4038 Tristique Ave','0683498015','tincidunt.vehicula.risus@gmail.com','2020-08-23 20:55:54','2021-08-28 16:38:59',2),(26,1,'Et Magnis Dis Industries','634-2180 Arcu. Road','0976984874','ipsum.Suspendisse.non@DonecfringillaDonec.org','2020-08-23 20:55:54','2020-08-23 20:55:54',2),(27,3,'Ipsum LLP','P.O. Box 302, 5167 Quisque Avenue','0805947246','Etiam.imperdiet@gmail.com','2020-08-23 20:55:54','2021-08-28 16:39:11',2),(28,3,'ASM Food Company','Hạ Long , Quảng Ninh','0908493605','laoreet@gmail.com','2020-08-23 20:55:54','2021-08-28 16:36:46',2),(29,3,'Dictum Company','Ap #562-8398 Malesuada. St.','0738487912','in@gmail.com','2020-09-28 14:42:34','2021-08-28 16:40:16',2),(30,3,'Metus Vivamus Foundation','623-7899 Cursus Rd.','0569712960','accumsa@gmail.com','2020-08-23 20:55:54','2021-08-28 16:40:26',2),(31,1,'Công ty THHH HFood','Hạ Long','0911111111','email@gmail.com','2021-08-19 23:24:11','2021-08-20 23:20:28',1),(32,1,'Công ty THHH Thăng Long','Hạ Long','0911111111','email@gmail.com','2021-08-19 23:24:28','2021-08-20 23:20:15',1);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` int NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `token_expired` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','2021-08-03','male','admin@gmail.com','0961111111',1,'$2a$10$2E7wVOsna37ntUsbfjhA6uxCOaQ7FpE9qnwbKKetjcfgH1Xbkpkau',NULL,NULL,'2021-08-17 22:08:17','2021-08-28 10:12:27'),(2,'user','2021-08-03','male','user@gmail.com','0968111222',1,'$2a$10$2E7wVOsna37ntUsbfjhA6uxCOaQ7FpE9qnwbKKetjcfgH1Xbkpkau',NULL,NULL,'2021-08-17 22:08:17','2021-08-28 10:12:27'),(3,'test','2021-08-03','male','test@gmail.com','0968111222',1,'$2a$10$QmawA0elQohb6IVUEumpOu0o/i9EbdgD/eGJjr3.3yU8vUbfwn6R6','$2a$10$7wFNWvyUjtCVIHbZS52cR.JcgYH77uS5BX.LXoBeMMWiGwxZUJ21q','2021-08-28 10:12:27','2021-08-17 22:08:17','2021-08-28 10:12:27'),(5,'vuong','2021-08-03','male','buithevuong@gmail.com','0911111111',1,'$2a$10$LaRDSmigNdwSk1zmdX.eSeY5PSsG1PI9QItk9U3/p8NlLLoCpHxVS',NULL,NULL,'2021-08-28 10:31:35','2021-08-28 10:31:35'),(13,'1','2021-08-03','male','test1234567@gmail.com','0911111111',1,'$2a$10$Mb9ItIgUoOe9XqpidiFT9uOAJ4W2EY9l1N/Z9whhyhm.mqSral/tK',NULL,NULL,'2021-08-28 11:12:11','2021-08-28 11:12:11'),(14,'1','2021-08-03','male','abc@gmail.com','0912333444',1,'$2a$10$wRUs2wC5Dt4Hf28./IQCf.ocauBkyn9Z/1dM4bz8VtpsG4nUk0Cwm',NULL,NULL,'2021-08-28 15:52:49','2021-08-28 15:52:49'),(15,'1','2021-08-03','male','abcd@gmail.com','0912333444',1,'$2a$10$uYS7Lo6MaXPk/wVVYLBCDe4jnnCrnUb3yg4CYPU3ymk.BUM70hska',NULL,NULL,'2021-08-28 15:54:33','2021-08-28 15:54:33');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warning_threshold`
--

DROP TABLE IF EXISTS `warning_threshold`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `warning_threshold` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `thresh_hold` float NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warning_threshold`
--

LOCK TABLES `warning_threshold` WRITE;
/*!40000 ALTER TABLE `warning_threshold` DISABLE KEYS */;
INSERT INTO `warning_threshold` VALUES (1,'Cảnh báo mức cao ',1,'red ',NULL,NULL),(2,'Cảnh báo mức cao ',2,'red ',NULL,NULL),(3,'Cảnh báo mức cao ',3,'red ',NULL,NULL),(4,'Cảnh báo mức cao ',4,'red ',NULL,NULL),(5,'Cảnh báo mức cao ',5,'red ',NULL,NULL),(6,'Cảnh báo mức cao ',6,'red ',NULL,NULL),(7,'Cảnh báo mức cao ',7,'red ',NULL,NULL),(8,'Cảnh báo mức cao ',8,'red ',NULL,NULL),(9,'Cảnh báo mức cao ',9,'red ',NULL,NULL),(10,'Cảnh báo mức cao ',10,'red ',NULL,NULL),(11,' Cảnh báo mức thấp ',11,' brown',NULL,NULL),(12,' Cảnh báo mức thấp ',12,' brown',NULL,NULL),(13,' Cảnh báo mức thấp ',13,' brown',NULL,NULL),(14,' Cảnh báo mức thấp ',14,' brown',NULL,NULL),(15,' Cảnh báo mức thấp ',15,' brown',NULL,NULL),(16,' Cảnh báo mức thấp ',16,' brown',NULL,NULL),(17,' Cảnh báo mức thấp ',17,' brown',NULL,NULL),(18,' Cảnh báo mức thấp ',18,' brown',NULL,NULL),(19,' Cảnh báo mức thấp ',19,' brown',NULL,NULL),(20,' Cảnh báo mức thấp ',20,' brown',NULL,NULL),(21,' Cảnh báo mức trung bình',21,' orange',NULL,NULL),(22,' Cảnh báo mức trung bình',22,' orange',NULL,NULL),(23,' Cảnh báo mức trung bình',23,' orange',NULL,NULL),(24,' Cảnh báo mức trung bình',24,' orange',NULL,NULL),(25,' Cảnh báo mức trung bình',25,' orange',NULL,NULL),(26,' Cảnh báo mức trung bình',26,' orange',NULL,NULL),(27,' Cảnh báo mức trung bình',27,' orange',NULL,NULL),(28,' Cảnh báo mức trung bình',28,' orange',NULL,NULL),(29,' Cảnh báo mức trung bình',29,' orange',NULL,NULL),(30,' Cảnh báo mức trung bình',30,' orange',NULL,NULL);
/*!40000 ALTER TABLE `warning_threshold` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-28 17:53:11
