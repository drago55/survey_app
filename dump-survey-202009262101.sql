-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: survey
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `answer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `option_choice_id` bigint(20) DEFAULT NULL,
  `option_group_id` bigint(20) DEFAULT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  `survey_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeff6c0jv28f9kaacbqcds4u9p` (`option_choice_id`),
  KEY `FK3b18kepmo1vhcp3gxbh9feegj` (`option_group_id`),
  KEY `FK8frr4bcabmmeyyu60qt7iiblo` (`question_id`),
  KEY `FK9mw9ejkvxg91xnpxcg6pljbn2` (`survey_id`),
  KEY `FK68tbcw6bunvfjaoscaj851xpb` (`user_id`),
  CONSTRAINT `FK3b18kepmo1vhcp3gxbh9feegj` FOREIGN KEY (`option_group_id`) REFERENCES `option_group` (`id`),
  CONSTRAINT `FK68tbcw6bunvfjaoscaj851xpb` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK8frr4bcabmmeyyu60qt7iiblo` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
  CONSTRAINT `FK9mw9ejkvxg91xnpxcg6pljbn2` FOREIGN KEY (`survey_id`) REFERENCES `survey` (`id`),
  CONSTRAINT `FKeff6c0jv28f9kaacbqcds4u9p` FOREIGN KEY (`option_choice_id`) REFERENCES `options` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `input_type`
--

DROP TABLE IF EXISTS `input_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `input_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` int(11) DEFAULT NULL,
  `input_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `input_type`
--

LOCK TABLES `input_type` WRITE;
/*!40000 ALTER TABLE `input_type` DISABLE KEYS */;
INSERT INTO `input_type` VALUES (1,0,'CheckBox'),(2,1,'MultiCheckBox'),(3,2,'RadioButton'),(4,3,'LetterBox'),(5,4,'FreeInput');
/*!40000 ALTER TABLE `input_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `option_group`
--

DROP TABLE IF EXISTS `option_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `option_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `question_type` int(11) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `option_group`
--

LOCK TABLES `option_group` WRITE;
/*!40000 ALTER TABLE `option_group` DISABLE KEYS */;
INSERT INTO `option_group` VALUES (1,'Very good',6,0),(2,'Good',6,1),(3,'Fair',6,2),(4,'Poor',6,3),(5,'Very poor',6,4),(6,'Extremely satisfied',5,0),(7,'Very satisfied',5,1),(8,'Neither satisfied nor dissatisfied',5,2),(9,'Not so satisfied',5,3),(10,'Not satisfied ata all',5,4),(11,'Not at all likely',4,0),(12,'',4,1),(13,'',4,2),(14,'',4,3),(15,'',4,4),(16,'',4,5),(17,'',4,6),(18,'',4,7),(19,'',4,8),(20,'Extremely likely',4,9);
/*!40000 ALTER TABLE `option_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `options`
--

DROP TABLE IF EXISTS `options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `options` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `text` varchar(255) DEFAULT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk821m563xwucpkx6ju8r3rkm4` (`question_id`),
  CONSTRAINT `FKk821m563xwucpkx6ju8r3rkm4` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `options`
--

LOCK TABLES `options` WRITE;
/*!40000 ALTER TABLE `options` DISABLE KEYS */;
INSERT INTO `options` VALUES (1,'Yes',1),(2,'No',1),(3,'I don\'t know.',2),(4,'I don\'t like the flavours.',2),(5,'It\'s too far from my house.',2),(6,'I don\'t like the ice cream.',2),(7,'It\'s too expensive.',2),(8,'The service is bad.',2),(9,'Superman.',3),(10,'Other.',3),(11,'Iron Man.',3),(12,'Batman.',3),(13,'Spider-Man.',3),(14,'Scale',4),(15,'LikertScale',5),(16,'free input',6),(17,'Power of completeness',7),(18,'Ease of learning',7),(19,'Quality of technical support',7),(20,'Ease of use',7),(21,'Quality of documentation',7);
/*!40000 ALTER TABLE `options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `options_options_group`
--

DROP TABLE IF EXISTS `options_options_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `options_options_group` (
  `option_id` bigint(20) NOT NULL,
  `option_group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`option_id`,`option_group_id`),
  KEY `FKjtfe63l1tua7thagxubslvu9a` (`option_group_id`),
  CONSTRAINT `FK4lyl933w594mjt1928ga9dkrb` FOREIGN KEY (`option_id`) REFERENCES `options` (`id`),
  CONSTRAINT `FKjtfe63l1tua7thagxubslvu9a` FOREIGN KEY (`option_group_id`) REFERENCES `option_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `options_options_group`
--

LOCK TABLES `options_options_group` WRITE;
/*!40000 ALTER TABLE `options_options_group` DISABLE KEYS */;
INSERT INTO `options_options_group` VALUES (17,1),(18,1),(19,1),(20,1),(21,1),(17,2),(18,2),(19,2),(20,2),(21,2),(17,3),(18,3),(19,3),(20,3),(21,3),(17,4),(18,4),(19,4),(20,4),(21,4),(17,5),(18,5),(19,5),(20,5),(21,5),(15,6),(15,7),(15,8),(15,9),(15,10),(14,11),(14,12),(14,13),(14,14),(14,15),(14,16),(14,17),(14,18),(14,19),(14,20);
/*!40000 ALTER TABLE `options_options_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `allow_multiple_options` bit(1) DEFAULT NULL,
  `question_type` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `input_type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfrbjd65fau9oqfiv00i5a4ngg` (`input_type_id`),
  CONSTRAINT `FKfrbjd65fau9oqfiv00i5a4ngg` FOREIGN KEY (`input_type_id`) REFERENCES `input_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'\0','DICHOTOMOUS_YES_NO','Are you a marketing agency or consultant?',1),(2,'\0','CLOSE_ENDED_QUESTIONS','Why don\'t you eat ice cream  at Fictionals Ice Cream Parlour? \n (Chose at least one answer.)',1),(3,'','MULTIPLE_CHOICE','Who\'s your favorite superhero?',1),(4,'\0','RATING_SCALE','On a scale from 0-10, how likely are you to recommend this product to a friend?',1),(5,'\0','LIKERT_SCALE','How satisfied or dissatisfied are you with the quality of customer support at LeadQuizzes?',1),(6,'\0','OPEN_ENDED_QUESTIONS','Why don\'t you eat ice cream  at Fictionals Ice Cream Parlour?',5),(7,'\0','MATRIX_QUESTIONS','Please rate our software on each of the following items.',3);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey`
--

DROP TABLE IF EXISTS `survey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `survey` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey`
--

LOCK TABLES `survey` WRITE;
/*!40000 ALTER TABLE `survey` DISABLE KEYS */;
INSERT INTO `survey` VALUES (1,'2020-09-26 19:53:21','Demo Survey');
/*!40000 ALTER TABLE `survey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey_questions`
--

DROP TABLE IF EXISTS `survey_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `survey_questions` (
  `survey_id` bigint(20) NOT NULL,
  `question_id` bigint(20) NOT NULL,
  PRIMARY KEY (`survey_id`,`question_id`),
  KEY `FK1sx45629iw4nm4vnufjjlr5sm` (`question_id`),
  CONSTRAINT `FK1sx45629iw4nm4vnufjjlr5sm` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
  CONSTRAINT `FK6d3brrwy6141fd7375ux6udnx` FOREIGN KEY (`survey_id`) REFERENCES `survey` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey_questions`
--

LOCK TABLES `survey_questions` WRITE;
/*!40000 ALTER TABLE `survey_questions` DISABLE KEYS */;
INSERT INTO `survey_questions` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7);
/*!40000 ALTER TABLE `survey_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `e_mail` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `survey_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3un8sx9pbmngbt069xxxrogl2` (`survey_id`),
  CONSTRAINT `FK3un8sx9pbmngbt069xxxrogl2` FOREIGN KEY (`survey_id`) REFERENCES `survey` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'pero.peric@live.com','Pero','Peric',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'survey'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-26 21:01:55
