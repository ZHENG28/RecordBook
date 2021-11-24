-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: records
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
-- Table structure for table `achievement`
--

DROP TABLE IF EXISTS `achievement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `achievement` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `introduction` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ranking` varchar(255) DEFAULT NULL,
  `semesters` varchar(255) DEFAULT NULL,
  `student_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9ihd6yxt6kpu0t6rg7joajmio` (`student_id`),
  CONSTRAINT `FK9ihd6yxt6kpu0t6rg7joajmio` FOREIGN KEY (`student_id`) REFERENCES `student` (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achievement`
--

LOCK TABLES `achievement` WRITE;
/*!40000 ALTER TABLE `achievement` DISABLE KEYS */;
/*!40000 ALTER TABLE `achievement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `introduction` varchar(255) DEFAULT NULL,
  `lecturer` varchar(255) DEFAULT NULL,
  `organizer` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `tea_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4yi763dofhjru2cknhisgbupd` (`tea_id`),
  CONSTRAINT `FK4yi763dofhjru2cknhisgbupd` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cclass`
--

DROP TABLE IF EXISTS `cclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cclass` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) DEFAULT NULL,
  `grade_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6tsqms7ruhovb3kyd4lkgpa5o` (`grade_id`),
  CONSTRAINT `FK6tsqms7ruhovb3kyd4lkgpa5o` FOREIGN KEY (`grade_id`) REFERENCES `sgrade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cclass`
--

LOCK TABLES `cclass` WRITE;
/*!40000 ALTER TABLE `cclass` DISABLE KEYS */;
INSERT INTO `cclass` VALUES (1,'计师19',1),(2,'教技19',1),(3,'电师19',1);
/*!40000 ALTER TABLE `cclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuser`
--

DROP TABLE IF EXISTS `cuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuser` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuser`
--

LOCK TABLES `cuser` WRITE;
/*!40000 ALTER TABLE `cuser` DISABLE KEYS */;
INSERT INTO `cuser` VALUES (2,_binary '','$2a$10$AjQbHDWoDjgLTezgTFtnhu9E.zzy6PwpcETbPE85DD5ticid5EDDC','ROLE_STUDENT','cy001'),(3,_binary '','$2a$10$4Z03KNe7CnC4Wuaxl6NcKudYhSvWepVRovJw3FFVc3yfjzW0bRwY6','ROLE_TEACHER','xys001'),(5,_binary '','$2a$10$YzwIt3o/JslOnyHkmlSNLuH/tkDrRH1YBinOZX5zqq5W6l57474Jm','ROLE_STUDENT','cy002'),(6,_binary '','$2a$10$Qh749zm9w6vsESr81Fyk4uCH5MRL3iGeCVRFG.stU3y4uYlx4lNqG','ROLE_STUDENT','cy003');
/*!40000 ALTER TABLE `cuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `engage`
--

DROP TABLE IF EXISTS `engage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `engage` (
  `student_id` bigint NOT NULL,
  `activity_id` bigint NOT NULL,
  PRIMARY KEY (`activity_id`,`student_id`),
  KEY `FKaottaonmuq9ovfls7fp43v9oc` (`student_id`),
  CONSTRAINT `FKaottaonmuq9ovfls7fp43v9oc` FOREIGN KEY (`student_id`) REFERENCES `student` (`stu_id`),
  CONSTRAINT `FKb3q96yqi3ahsmx0kmlf38io4c` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `engage`
--

LOCK TABLES `engage` WRITE;
/*!40000 ALTER TABLE `engage` DISABLE KEYS */;
/*!40000 ALTER TABLE `engage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `learning_records`
--

DROP TABLE IF EXISTS `learning_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `learning_records` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `instructor` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `tutor_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnywrcqjtvtu4gmwu3nbt8g3p4` (`tutor_id`),
  CONSTRAINT `FKnywrcqjtvtu4gmwu3nbt8g3p4` FOREIGN KEY (`tutor_id`) REFERENCES `tutor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `learning_records`
--

LOCK TABLES `learning_records` WRITE;
/*!40000 ALTER TABLE `learning_records` DISABLE KEYS */;
/*!40000 ALTER TABLE `learning_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `ranking` varchar(255) DEFAULT NULL,
  `student_id` bigint DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjvi932wdxw4ux6m7u6abiy7qv` (`student_id`),
  CONSTRAINT `FKjvi932wdxw4ux6m7u6abiy7qv` FOREIGN KEY (`student_id`) REFERENCES `student` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'2019运河杯1','院级',5,'2019'),(2,'2019运河杯2','院级',5,'2019'),(3,'2020运河杯1','校级',2,'2020'),(4,'2020运河杯2','院级',6,'2020'),(5,'2019大创','省级',5,'2019'),(6,'2021互联网+','校级',2,'2021'),(7,'2021工贸85','校级',6,'2021'),(8,'2022运河杯','院级',6,'2022'),(9,'2020工贸85','校级',2,'2020'),(10,'2021运河杯1','院级',2,'2021'),(11,'2020运河杯2','校级',2,'2020');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sgrade`
--

DROP TABLE IF EXISTS `sgrade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sgrade` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `grade_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sgrade`
--

LOCK TABLES `sgrade` WRITE;
/*!40000 ALTER TABLE `sgrade` DISABLE KEYS */;
INSERT INTO `sgrade` VALUES (1,'2019级');
/*!40000 ALTER TABLE `sgrade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stu_learning`
--

DROP TABLE IF EXISTS `stu_learning`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stu_learning` (
  `student_id` bigint NOT NULL,
  `records_id` bigint NOT NULL,
  PRIMARY KEY (`records_id`,`student_id`),
  KEY `FK68tig9d750ek35ingfs6rrql3` (`student_id`),
  CONSTRAINT `FK68tig9d750ek35ingfs6rrql3` FOREIGN KEY (`student_id`) REFERENCES `student` (`stu_id`),
  CONSTRAINT `FKohllpfiteg0qux57ig8uk5x02` FOREIGN KEY (`records_id`) REFERENCES `learning_records` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stu_learning`
--

LOCK TABLES `stu_learning` WRITE;
/*!40000 ALTER TABLE `stu_learning` DISABLE KEYS */;
/*!40000 ALTER TABLE `stu_learning` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `cet` int NOT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `istclass` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `snumber` varchar(255) DEFAULT NULL,
  `stu_id` bigint NOT NULL,
  `timetable` bigint DEFAULT NULL,
  `tutor_id` bigint DEFAULT NULL,
  `class_id` bigint DEFAULT NULL,
  PRIMARY KEY (`stu_id`),
  KEY `FK9ml6uy3kfwk5948t8jkus224n` (`timetable`),
  KEY `FKnq8hvnfuokc5y0gi1hqra5xul` (`tutor_id`),
  KEY `FK75dh6qbtp27cjfcq7a437gjkb` (`class_id`),
  CONSTRAINT `FK75dh6qbtp27cjfcq7a437gjkb` FOREIGN KEY (`class_id`) REFERENCES `cclass` (`id`),
  CONSTRAINT `FK9ml6uy3kfwk5948t8jkus224n` FOREIGN KEY (`timetable`) REFERENCES `timetable` (`id`),
  CONSTRAINT `FKfwhm7v0h05mmn4g4bm71mcyhr` FOREIGN KEY (`stu_id`) REFERENCES `cuser` (`id`),
  CONSTRAINT `FKnq8hvnfuokc5y0gi1hqra5xul` FOREIGN KEY (`tutor_id`) REFERENCES `tutor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (0,NULL,_binary '\0','xys',NULL,NULL,2,NULL,NULL,1),(0,NULL,_binary '\0','zhy',NULL,NULL,5,NULL,NULL,3),(0,NULL,_binary '\0','cy',NULL,NULL,6,NULL,NULL,2);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `name` varchar(255) DEFAULT NULL,
  `teacher_id` bigint NOT NULL,
  PRIMARY KEY (`teacher_id`),
  CONSTRAINT `FK53g2p4wuc2i66dyid23vk9yl6` FOREIGN KEY (`teacher_id`) REFERENCES `cuser` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('许元澍',3);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetable`
--

DROP TABLE IF EXISTS `timetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timetable` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fri_1` int NOT NULL,
  `fri_10` int NOT NULL,
  `fri_11` int NOT NULL,
  `fri_12` int NOT NULL,
  `fri_2` int NOT NULL,
  `fri_3` int NOT NULL,
  `fri_4` int NOT NULL,
  `fri_5` int NOT NULL,
  `fri_6` int NOT NULL,
  `fri_7` int NOT NULL,
  `fri_8` int NOT NULL,
  `fri_9` int NOT NULL,
  `mon_1` int NOT NULL,
  `mon_10` int NOT NULL,
  `mon_11` int NOT NULL,
  `mon_12` int NOT NULL,
  `mon_2` int NOT NULL,
  `mon_3` int NOT NULL,
  `mon_4` int NOT NULL,
  `mon_5` int NOT NULL,
  `mon_6` int NOT NULL,
  `mon_7` int NOT NULL,
  `mon_8` int NOT NULL,
  `mon_9` int NOT NULL,
  `thu_1` int NOT NULL,
  `thu_10` int NOT NULL,
  `thu_11` int NOT NULL,
  `thu_12` int NOT NULL,
  `thu_2` int NOT NULL,
  `thu_3` int NOT NULL,
  `thu_4` int NOT NULL,
  `thu_5` int NOT NULL,
  `thu_6` int NOT NULL,
  `thu_7` int NOT NULL,
  `thu_8` int NOT NULL,
  `thu_9` int NOT NULL,
  `tue_1` int NOT NULL,
  `tue_10` int NOT NULL,
  `tue_11` int NOT NULL,
  `tue_12` int NOT NULL,
  `tue_2` int NOT NULL,
  `tue_3` int NOT NULL,
  `tue_4` int NOT NULL,
  `tue_5` int NOT NULL,
  `tue_6` int NOT NULL,
  `tue_7` int NOT NULL,
  `tue_8` int NOT NULL,
  `tue_9` int NOT NULL,
  `wed_1` int NOT NULL,
  `wed_10` int NOT NULL,
  `wed_11` int NOT NULL,
  `wed_12` int NOT NULL,
  `wed_2` int NOT NULL,
  `wed_3` int NOT NULL,
  `wed_4` int NOT NULL,
  `wed_5` int NOT NULL,
  `wed_6` int NOT NULL,
  `wed_7` int NOT NULL,
  `wed_8` int NOT NULL,
  `wed_9` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetable`
--

LOCK TABLES `timetable` WRITE;
/*!40000 ALTER TABLE `timetable` DISABLE KEYS */;
/*!40000 ALTER TABLE `timetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutor`
--

DROP TABLE IF EXISTS `tutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `introduction` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor`
--

LOCK TABLES `tutor` WRITE;
/*!40000 ALTER TABLE `tutor` DISABLE KEYS */;
/*!40000 ALTER TABLE `tutor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-24 14:48:42
