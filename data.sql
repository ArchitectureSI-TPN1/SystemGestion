-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: systemgestion
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `classement`
--

DROP TABLE IF EXISTS `classement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classement` (
  `idclassement` int NOT NULL,
  `Equipe_idEquipe` int DEFAULT NULL,
  `annee` int DEFAULT NULL,
  `position` int DEFAULT NULL,
  PRIMARY KEY (`idclassement`),
  KEY `Equipe_idEquipe_idx` (`Equipe_idEquipe`),
  CONSTRAINT `idEquipe` FOREIGN KEY (`Equipe_idEquipe`) REFERENCES `equipe` (`idEquipe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classement`
--

LOCK TABLES `classement` WRITE;
/*!40000 ALTER TABLE `classement` DISABLE KEYS */;
INSERT INTO `classement` VALUES (10001,1,2018,1),(10002,1,2019,2),(10003,1,2020,3),(10004,2,2018,2),(10005,2,2019,1),(10006,2,2020,1),(10007,3,2018,3),(10008,3,2019,3),(10009,3,2020,2),(10010,4,2018,4),(10011,4,2019,4),(10012,4,2020,4),(10013,5,2018,5),(10014,5,2019,5),(10015,5,2020,5);
/*!40000 ALTER TABLE `classement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipe` (
  `idEquipe` int NOT NULL,
  `nomEquipe` varchar(45) DEFAULT NULL,
  `nbParticipation` int DEFAULT NULL,
  `nbVictoire` int DEFAULT NULL,
  PRIMARY KEY (`idEquipe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipe`
--

LOCK TABLES `equipe` WRITE;
/*!40000 ALTER TABLE `equipe` DISABLE KEYS */;
INSERT INTO `equipe` VALUES (1,'lakers',16,20),(2,'rockets',16,18),(3,'warriors',16,16),(4,'magic',15,8),(5,'heat',15,13);
/*!40000 ALTER TABLE `equipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `joueur`
--

DROP TABLE IF EXISTS `joueur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `joueur` (
  `idjoueur` int NOT NULL,
  `nomJoueur` varchar(45) DEFAULT NULL,
  `but` int DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `notePrese` float DEFAULT NULL,
  `Equipe_idEquipe` int DEFAULT NULL,
  PRIMARY KEY (`idjoueur`),
  KEY `equipe_idEquipe_idx` (`Equipe_idEquipe`),
  CONSTRAINT `Equipe_idEquipe` FOREIGN KEY (`Equipe_idEquipe`) REFERENCES `equipe` (`idEquipe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `joueur`
--

LOCK TABLES `joueur` WRITE;
/*!40000 ALTER TABLE `joueur` DISABLE KEYS */;
INSERT INTO `joueur` VALUES (1001,'ciro immobile',27,'forward',96,1),(1002,'robert lewandowski',25,'forward',95,1),(1003,'cristiano ronaldo',21,'forward',99.9,2),(1004,'timo werner',21,'forward',95.5,3),(1005,'jamie vardy',19,'forward',94,4),(1006,'lionel andres messi',19,'forward',99.9,5),(1007,'wissam ben yedder',18,'forward',96.5,4),(1008,'kylian mbappe lottin',18,'forward',98,2),(1009,'piere-emerick',17,'forward',94.5,1),(1010,'romelu lukaku',17,'forward',96.5,2);
/*!40000 ALTER TABLE `joueur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `joueur_match`
--

DROP TABLE IF EXISTS `joueur_match`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `joueur_match` (
  `joueur_idJoueur` int NOT NULL,
  `Match_idMatch` int NOT NULL,
  PRIMARY KEY (`joueur_idJoueur`,`Match_idMatch`),
  KEY `Match_idMatch_idx` (`Match_idMatch`),
  CONSTRAINT `Joueur_idJoueur` FOREIGN KEY (`joueur_idJoueur`) REFERENCES `joueur` (`idjoueur`),
  CONSTRAINT `Match_idMatch` FOREIGN KEY (`Match_idMatch`) REFERENCES `matchinfo` (`idmatch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `joueur_match`
--

LOCK TABLES `joueur_match` WRITE;
/*!40000 ALTER TABLE `joueur_match` DISABLE KEYS */;
INSERT INTO `joueur_match` VALUES (1001,101),(1002,101),(1005,101),(1007,101),(1009,101),(1001,102),(1002,102),(1003,102),(1008,102),(1009,102),(1010,102),(1003,103),(1004,103),(1008,103),(1010,103),(1004,104),(1006,104),(1005,105),(1006,105),(1007,105);
/*!40000 ALTER TABLE `joueur_match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `idadmin` int NOT NULL,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idadmin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'admin','admin');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matchinfo`
--

DROP TABLE IF EXISTS `matchinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matchinfo` (
  `idmatch` int NOT NULL,
  `nomMatch` varchar(45) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `ville` varchar(45) DEFAULT NULL,
  `stade` varchar(45) DEFAULT NULL,
  `Equipe_idEquipe1` int DEFAULT NULL,
  `Equipe_idEquipe2` int DEFAULT NULL,
  `pointEquipe1` varchar(45) DEFAULT NULL,
  `pointEquipe2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmatch`),
  KEY `Equipe_idEquipe1_idx` (`Equipe_idEquipe1`),
  KEY `Equipe_idEquipie2_idx` (`Equipe_idEquipe2`),
  CONSTRAINT `Equipe_idEquipe1` FOREIGN KEY (`Equipe_idEquipe1`) REFERENCES `equipe` (`idEquipe`),
  CONSTRAINT `Equipe_idEquipie2` FOREIGN KEY (`Equipe_idEquipe2`) REFERENCES `equipe` (`idEquipe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matchinfo`
--

LOCK TABLES `matchinfo` WRITE;
/*!40000 ALTER TABLE `matchinfo` DISABLE KEYS */;
INSERT INTO `matchinfo` VALUES (101,'regular season','2019-06-08 21:21:21','paris','parc des princes',4,1,'2','1'),(102,'regular season','2019-06-09 22:25:23','roma','stadio olimpico di roma',1,2,'2','1'),(103,'regular season','2019-06-12 20:21:21','turin','juventus stadium',2,3,'3','0'),(104,'regular season','2019-06-08 21:21:21','paris','parc des princes',3,5,'2','1'),(105,'1/4 finals','2019-07-01 21:21:21','barcelone','camp nou',5,4,'5','3');
/*!40000 ALTER TABLE `matchinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-09 18:35:32
