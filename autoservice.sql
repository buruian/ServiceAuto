CREATE DATABASE  IF NOT EXISTS `autoservice` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `autoservice`;
-- MySQL dump 10.13  Distrib 5.5.34, for debian-linux-gnu (i686)
--
-- Host: 127.0.0.1    Database: autoservice
-- ------------------------------------------------------
-- Server version	5.5.34-0ubuntu0.12.04.1

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
-- Table structure for table `Angajat`
--

DROP TABLE IF EXISTS `Angajat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Angajat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(45) DEFAULT NULL,
  `prenume` varchar(45) DEFAULT NULL,
  `nrTelefon` int(11) DEFAULT NULL,
  `functia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Angajat`
--

LOCK TABLES `Angajat` WRITE;
/*!40000 ALTER TABLE `Angajat` DISABLE KEYS */;
INSERT INTO `Angajat` VALUES (4,'Ion','Banu',47855,'motorist'),(5,'Ion','Banu',47855,'motorist'),(6,'Ion','Banu',47855,'motorist'),(7,'Ion','Banu',47855,'motorist'),(9,'sas','sda',12,'a'),(10,'Ion','Banu',47855,'motorist'),(12,'Ion','Banu',47855,'motorist'),(13,'Ion','Banu',47855,'motorist'),(16,'Ion','Banu',47855,'motorist'),(17,'sgfd','dfx',233,'fd'),(18,'sgfd','dfx',233,'fd'),(19,'hjvhjmm','cbncnbvbn',583435,'nhcghnmjgdcng'),(20,'gsdf','rtgsdf',564,'regsdf'),(21,'tttt','fdfffff',4353454,'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa');
/*!40000 ALTER TABLE `Angajat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masini`
--

DROP TABLE IF EXISTS `masini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `masini` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nrInmatriculare` varchar(45) NOT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `anu` int(11) DEFAULT NULL,
  `combustibil` varchar(45) DEFAULT NULL,
  `modelMotor` varchar(45) DEFAULT NULL,
  `idProprietar` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_masini_1_idx` (`idProprietar`),
  CONSTRAINT `fk_masini_1` FOREIGN KEY (`idProprietar`) REFERENCES `proprietar` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masini`
--

LOCK TABLES `masini` WRITE;
/*!40000 ALTER TABLE `masini` DISABLE KEYS */;
INSERT INTO `masini` VALUES (1,'Nisa','ma','moldova',1950,'fdx','mm',1),(2,'Grisa','marca','model',1950,'fdx','mosd',2),(3,'Maria','sfd','fd',1950,'1','sdf',3),(4,'fsd','jkjk','jklkmml;',2007,'3','hjbhb',4),(5,'bjh','kb','kkj',2007,'2','klm',5),(6,'gf','gf','fg',2012,'1','dfdbh',6),(7,'fd','dfv','df',2008,'1','dfdv',7),(8,'nm','ma','mod',2006,'fdx','mm',8),(9,'nm','ma','mod',2006,'fdx','mm',9),(10,'fd','dfv','df',2006,'1','dfdv',10),(11,'nm','ma','mod',2006,'fdx','mm',11),(12,'nm','ma','mod',2006,'fdx','mm',12),(13,'nm','ma','mod',2006,'fdx','mm',13),(14,'num','marca','model',2006,'fdx','mosd',14),(15,'aaaaaaaaa','ma','mod',2006,'fdx','mm',15),(16,'aaaaaaaa','ma','mod',2006,'fdx','mm',16);
/*!40000 ALTER TABLE `masini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proprietar`
--

DROP TABLE IF EXISTS `proprietar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proprietar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(45) DEFAULT NULL,
  `prenume` varchar(45) DEFAULT NULL,
  `nrTelefon` int(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proprietar`
--

LOCK TABLES `proprietar` WRITE;
/*!40000 ALTER TABLE `proprietar` DISABLE KEYS */;
INSERT INTO `proprietar` VALUES (1,'nume','prenume',1111,'eeee'),(2,'val','bur',1254,'val'),(3,'sfd','sfd',57,'s'),(4,'jkn','klmkml',545,'dsdv'),(5,'kjjjk','jnkn',4444444,'kcx'),(6,'bn','bm',56565,'jbhn'),(7,'df','df',3,'vc'),(8,'nume','prenume',1111,'eeee'),(9,'nume','prenume',1111,'eeee'),(10,'df','df',3,'vc'),(11,'nume','prenume',1111,'eeee'),(12,'nume','prenume',1111,'eeee'),(13,'nume','prenume',1111,'eeee'),(14,'val','bur',444,'val'),(15,'nume','prenume',1111,'eeee'),(16,'nume','prenume',1111,'eeee');
/*!40000 ALTER TABLE `proprietar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reparati`
--

DROP TABLE IF EXISTS `reparati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reparati` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataIntrare` datetime DEFAULT NULL,
  `dataIesire` datetime DEFAULT NULL,
  `probleme` text,
  `idMasina` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reparati_1_idx` (`idMasina`),
  CONSTRAINT `fk_reparati_1` FOREIGN KEY (`idMasina`) REFERENCES `masini` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reparati`
--

LOCK TABLES `reparati` WRITE;
/*!40000 ALTER TABLE `reparati` DISABLE KEYS */;
INSERT INTO `reparati` VALUES (1,'2014-09-11 00:00:00','2014-09-11 00:00:00','new car',2),(2,'2014-09-11 00:00:00','2014-09-11 00:00:00','zza',2),(3,'2014-09-11 00:00:00','2014-09-11 00:00:00','uuuu',2);
/*!40000 ALTER TABLE `reparati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reparatiAngajat`
--

DROP TABLE IF EXISTS `reparatiAngajat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reparatiAngajat` (
  `idReparati` int(11) DEFAULT NULL,
  `idAngajat` int(11) DEFAULT NULL,
  KEY `fk_reparatiAngajat_1_idx` (`idAngajat`),
  KEY `fk_reparatiAngajat_2_idx` (`idReparati`),
  CONSTRAINT `fk_reparatiAngajat_1` FOREIGN KEY (`idAngajat`) REFERENCES `Angajat` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reparatiAngajat_2` FOREIGN KEY (`idReparati`) REFERENCES `reparati` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reparatiAngajat`
--

LOCK TABLES `reparatiAngajat` WRITE;
/*!40000 ALTER TABLE `reparatiAngajat` DISABLE KEYS */;
INSERT INTO `reparatiAngajat` VALUES (1,4),(1,6),(1,9),(2,12),(2,16),(3,17);
/*!40000 ALTER TABLE `reparatiAngajat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-09-11 13:07:42
