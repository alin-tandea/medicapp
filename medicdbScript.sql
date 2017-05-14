CREATE DATABASE  IF NOT EXISTS `medicdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `medicdb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: medicdb
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `consultation`
--

DROP TABLE IF EXISTS `consultation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consultation` (
  `idconsultation` int(11) NOT NULL AUTO_INCREMENT,
  `datestart` datetime DEFAULT NULL,
  `dateend` datetime DEFAULT NULL,
  `reason` varchar(100) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `staff_idstaff` int(11) NOT NULL,
  `patient_idpatient` int(11) NOT NULL,
  PRIMARY KEY (`idconsultation`),
  KEY `FKn1okglyah0obn82nng3rsrqje` (`patient_idpatient`),
  KEY `FKj5ec5cw5pm7rbcuj9h7fa1oge` (`staff_idstaff`),
  CONSTRAINT `FKj5ec5cw5pm7rbcuj9h7fa1oge` FOREIGN KEY (`staff_idstaff`) REFERENCES `staff` (`idstaff`),
  CONSTRAINT `FKn1okglyah0obn82nng3rsrqje` FOREIGN KEY (`patient_idpatient`) REFERENCES `patient` (`idpatient`),
  CONSTRAINT `fk_consultation_patient1` FOREIGN KEY (`patient_idpatient`) REFERENCES `patient` (`idpatient`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_consultation_staff` FOREIGN KEY (`staff_idstaff`) REFERENCES `staff` (`idstaff`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultation`
--

LOCK TABLES `consultation` WRITE;
/*!40000 ALTER TABLE `consultation` DISABLE KEYS */;
INSERT INTO `consultation` VALUES (28,'2017-05-15 12:00:00',NULL,NULL,0,2,26),(29,'2017-05-15 12:30:00',NULL,NULL,0,2,27);
/*!40000 ALTER TABLE `consultation` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `idpatient` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `idcardnumber` varchar(45) DEFAULT NULL,
  `cnp` varchar(45) DEFAULT NULL,
  `birthdate` datetime DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpatient`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (26,'Gheorghe Gheorghiu','MS123456','1951130271615','1995-11-30 00:00:00','random address'),(27,'Ceausescu Nicolae','IF123123','1111111111111','1911-11-11 00:09:32','some address');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `idstaff` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `workdays` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`idstaff`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'Secretary','secretary','123456',2,NULL),(2,'First Medic','medic','123456',1,NULL),(10,'Second Medic','med','123456',1,NULL),(18,'Another Medic','medic1','123456',1,NULL),(31,'Administrator','admin','123456',0,NULL);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workschedule`
--

DROP TABLE IF EXISTS `workschedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workschedule` (
  `idworkschedule` int(11) NOT NULL AUTO_INCREMENT,
  `workday` int(11) DEFAULT NULL,
  `starthour` int(11) DEFAULT NULL,
  `endhour` int(11) DEFAULT NULL,
  `staff_idstaff` int(11) NOT NULL,
  PRIMARY KEY (`idworkschedule`),
  KEY `fk_workschedule_staff1_idx` (`staff_idstaff`),
  CONSTRAINT `FK4vq2d6ofhcrkw8o82f7st3ryk` FOREIGN KEY (`staff_idstaff`) REFERENCES `staff` (`idstaff`),
  CONSTRAINT `fk_workschedule_staff1` FOREIGN KEY (`staff_idstaff`) REFERENCES `staff` (`idstaff`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workschedule`
--

LOCK TABLES `workschedule` WRITE;
/*!40000 ALTER TABLE `workschedule` DISABLE KEYS */;
INSERT INTO `workschedule` VALUES (3,0,-1,-1,2),(4,1,9,15,2),(5,2,8,18,2),(6,3,10,15,2),(7,4,14,20,2),(8,5,9,17,2),(9,6,-1,-1,2),(11,0,-1,-1,10),(12,1,-1,-1,10),(13,2,-1,-1,10),(14,3,-1,-1,10),(15,4,-1,-1,10),(16,5,-1,-1,10),(17,6,-1,-1,10),(19,0,-1,-1,18),(20,1,-1,-1,18),(21,2,-1,-1,18),(22,3,-1,-1,18),(23,4,-1,-1,18),(24,5,-1,-1,18),(25,6,-1,-1,18);
/*!40000 ALTER TABLE `workschedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-14 23:54:57
