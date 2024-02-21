-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ticket4you
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `acquistare`
--

DROP TABLE IF EXISTS `acquistare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acquistare` (
  `ID_utente` int NOT NULL,
  `ID_titolo` int NOT NULL,
  PRIMARY KEY (`ID_utente`,`ID_titolo`),
  KEY `ID_titolo` (`ID_titolo`),
  CONSTRAINT `acquistare_ibfk_1` FOREIGN KEY (`ID_utente`) REFERENCES `utente` (`ID_utente`) ON DELETE CASCADE,
  CONSTRAINT `acquistare_ibfk_2` FOREIGN KEY (`ID_titolo`) REFERENCES `titolo` (`ID_titolo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acquistare`
--

LOCK TABLES `acquistare` WRITE;
/*!40000 ALTER TABLE `acquistare` DISABLE KEYS */;
INSERT INTO `acquistare` VALUES (1,201),(2,202);
/*!40000 ALTER TABLE `acquistare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amministratore`
--

DROP TABLE IF EXISTS `amministratore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amministratore` (
  `ID_utente_amm` int NOT NULL,
  `orario_inizio_sessione` datetime NOT NULL,
  `orario_fine_sessione` datetime NOT NULL,
  `numero_telefono_am` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_utente_amm`),
  CONSTRAINT `ID_utente_amm` FOREIGN KEY (`ID_utente_amm`) REFERENCES `utente` (`ID_utente`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amministratore`
--

LOCK TABLES `amministratore` WRITE;
/*!40000 ALTER TABLE `amministratore` DISABLE KEYS */;
INSERT INTO `amministratore` VALUES (1,'2024-01-01 16:40:00','2024-01-01 17:00:00','33356478'),(2,'2024-01-01 09:10:00','2024-01-01 09:40:00','33987634'),(5,'2024-01-23 12:44:00','2024-01-23 15:00:00','24359520');
/*!40000 ALTER TABLE `amministratore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appartenere`
--

DROP TABLE IF EXISTS `appartenere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appartenere` (
  `ID_titolo` int NOT NULL,
  `ID_pagamento` int NOT NULL,
  PRIMARY KEY (`ID_titolo`,`ID_pagamento`),
  KEY `ID_pagamento` (`ID_pagamento`),
  CONSTRAINT `appartenere_ibfk_1` FOREIGN KEY (`ID_titolo`) REFERENCES `titolo` (`ID_titolo`),
  CONSTRAINT `appartenere_ibfk_2` FOREIGN KEY (`ID_pagamento`) REFERENCES `pagamento` (`ID_pagamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appartenere`
--

LOCK TABLES `appartenere` WRITE;
/*!40000 ALTER TABLE `appartenere` DISABLE KEYS */;
INSERT INTO `appartenere` VALUES (201,401),(202,402),(203,403),(204,404);
/*!40000 ALTER TABLE `appartenere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendario`
--

DROP TABLE IF EXISTS `calendario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calendario` (
  `ID_calendario` int NOT NULL,
  `ID_evento` int NOT NULL,
  `data_calendario` date NOT NULL,
  PRIMARY KEY (`ID_calendario`),
  KEY `ID_evento` (`ID_evento`),
  CONSTRAINT `calendario_ibfk_1` FOREIGN KEY (`ID_evento`) REFERENCES `evento` (`ID_evento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendario`
--

LOCK TABLES `calendario` WRITE;
/*!40000 ALTER TABLE `calendario` DISABLE KEYS */;
INSERT INTO `calendario` VALUES (301,101,'2024-01-15'),(302,102,'2024-03-10'),(303,103,'2024-06-06'),(304,104,'2024-09-03');
/*!40000 ALTER TABLE `calendario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cercare`
--

DROP TABLE IF EXISTS `cercare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cercare` (
  `ID_utente` int NOT NULL,
  `ID_evento` int NOT NULL,
  PRIMARY KEY (`ID_utente`,`ID_evento`),
  KEY `ID_evento` (`ID_evento`),
  CONSTRAINT `cercare_ibfk_1` FOREIGN KEY (`ID_utente`) REFERENCES `utente` (`ID_utente`) ON DELETE CASCADE,
  CONSTRAINT `cercare_ibfk_2` FOREIGN KEY (`ID_evento`) REFERENCES `evento` (`ID_evento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cercare`
--

LOCK TABLES `cercare` WRITE;
/*!40000 ALTER TABLE `cercare` DISABLE KEYS */;
INSERT INTO `cercare` VALUES (1,101),(2,102);
/*!40000 ALTER TABLE `cercare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `effettuare`
--

DROP TABLE IF EXISTS `effettuare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `effettuare` (
  `ID_utente` int NOT NULL,
  `ID_pagamento` int NOT NULL,
  PRIMARY KEY (`ID_utente`,`ID_pagamento`),
  KEY `ID_pagamento` (`ID_pagamento`),
  CONSTRAINT `effettuare_ibfk_1` FOREIGN KEY (`ID_utente`) REFERENCES `utente` (`ID_utente`) ON DELETE CASCADE,
  CONSTRAINT `effettuare_ibfk_2` FOREIGN KEY (`ID_pagamento`) REFERENCES `pagamento` (`ID_pagamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `effettuare`
--

LOCK TABLES `effettuare` WRITE;
/*!40000 ALTER TABLE `effettuare` DISABLE KEYS */;
INSERT INTO `effettuare` VALUES (1,401),(2,402);
/*!40000 ALTER TABLE `effettuare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evento` (
  `ID_evento` int NOT NULL,
  `nome_evento` varchar(100) NOT NULL,
  `posti_disponibili` int NOT NULL,
  `data` date NOT NULL,
  `luogo` varchar(100) NOT NULL,
  `ora` time NOT NULL,
  `tipo` varchar(200) NOT NULL,
  `prezzo` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_evento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (101,'nome1',1,'2024-01-15','Napoli','18:00:00','concerto','10'),(102,'nome2',2,'2024-02-10','Roma','10:30:00','mostra','10'),(103,'nome3',3,'2024-03-06','Milano','20:30:00','musical','10'),(104,'nome4',4,'2024-04-03','Salerno','15:00:00','sportivo','10'),(105,'nome5',5,'2024-05-16','Bologna','17:00:00','concerto','10'),(106,'nome6',6,'2024-06-11','Torino','09:00:00','mostra','10'),(107,'nome7',7,'2024-07-07','Venezia','22:00:00','musical','10'),(108,'nome8',8,'2024-08-08','Bari','15:30:00','sportivo','10'),(109,'nome9',50,'2024-06-19','Paestum','20:45:00','concerto','10'),(110,'nome10',9,'2024-09-11','Cosenza','20:00:00','concerto','10'),(111,'nome11',10,'2024-10-10','Palermo','11:45:00','mostra','10'),(112,'nome12',11,'2024-11-06','Verona','20:00:00','musical','10'),(113,'nome13',12,'2024-12-03','Trieste','20:45:00','sportivo','10'),(114,'nome14',13,'2024-01-16','Gallipoli','19:30:00','concerto','10'),(115,'nome15',14,'2024-02-12','Benevento','00:00:12','mostra','10'),(116,'nome16',15,'2024-01-06','Caserta','22:30:00','musical','10'),(117,'nome17',16,'2024-02-03','Genova','16:00:00','sportivo','10'),(118,'nome18',17,'2024-03-15','Eboli','19:45:00','concerto','10'),(119,'nome19',18,'2024-04-10','Firenze','09:45:00','mostra','10'),(120,'nome20',19,'2024-03-07','Frosinone','19:15:00','musical','10'),(121,'nome21',20,'2024-05-03','Pisa','15:45:00','sportivo','10'),(122,'nome22',21,'2024-06-15','Paestum','20:45:00','concerto','10'),(123,'nome23',22,'2024-07-10','Cagliari','12:30:00','mostra','10'),(124,'nome24',23,'2024-06-06','Reggio Calabria','20:30:00','musical','10'),(125,'nome25',24,'2024-09-03','Diamante','17:00:00','sportivo','10'),(126,'nome26',25,'2024-08-15','Campobasso','18:45:00','concerto','10'),(127,'nome27',26,'2024-10-18','Siena','10:45:00','mostra','10'),(128,'nome28',27,'2024-11-04','Amantea','20:40:00','musical','10'),(129,'nome29',28,'2024-10-02','Nola','17:30:00','sportivo','10'),(130,'nome30',29,'2024-12-23','Catania','14:30:00','sportivo','10'),(131,'nome31',30,'2024-01-17','Napoli','18:00:00','concerto','10'),(132,'nome32',31,'2024-02-11','Roma','10:30:00','mostra','10'),(133,'nome33',32,'2024-03-09','Milano','20:30:00','musical','10'),(134,'nome34',33,'2024-04-08','Salerno','15:00:00','sportivo','10'),(135,'nome35',34,'2024-05-26','Bologna','17:00:00','concerto','10'),(136,'nome36',35,'2024-06-21','Torino','09:00:00','mostra','10'),(137,'nome37',36,'2024-07-31','Venezia','22:00:00','musical','10'),(138,'nome38',37,'2024-08-30','Bari','15:30:00','sportivo','10'),(139,'nome39',38,'2024-09-12','Cosenza','20:00:00','concerto','10'),(140,'nome40',39,'2024-10-30','Palermo','11:45:00','mostra','10'),(141,'nome41',40,'2024-11-25','Verona','20:00:00','musical','10'),(142,'nome42',41,'2024-12-27','Trieste','20:45:00','sportivo','1'),(143,'nome43',42,'2024-01-29','Gallipoli','19:30:00','concerto','10'),(144,'nome44',43,'2024-02-01','Benevento','00:00:12','mostra','90'),(145,'nome45',44,'2024-01-05','Caserta','22:30:00','musical','90'),(146,'nome46',45,'2024-02-03','Genova','16:00:00','sportivo','90'),(147,'nome47',46,'2024-03-14','Eboli','19:45:00','concerto','90'),(148,'nome48',47,'2024-04-13','Firenze','09:45:00','mostra','90'),(149,'nome49',48,'2024-03-17','Frosinone','19:15:00','musical','90'),(150,'nome50',49,'2024-05-23','Pisa','15:45:00','sportivo','90');
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organizzatore`
--

DROP TABLE IF EXISTS `organizzatore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organizzatore` (
  `eventi_organizzati` varchar(100) NOT NULL,
  `piva` varchar(50) NOT NULL,
  `indirizzo_or` varchar(200) NOT NULL,
  `numero_telefono_or` varchar(20) NOT NULL,
  `ID_utente` int NOT NULL,
  PRIMARY KEY (`ID_utente`),
  CONSTRAINT `ID_utente` FOREIGN KEY (`ID_utente`) REFERENCES `utente` (`ID_utente`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizzatore`
--

LOCK TABLES `organizzatore` WRITE;
/*!40000 ALTER TABLE `organizzatore` DISABLE KEYS */;
INSERT INTO `organizzatore` VALUES ('evento1','110','via gallo 2','36463763',1),('evento2','108','via dalmazia 40','33457275',2),('10','24t65','via ao 53','23154361',5);
/*!40000 ALTER TABLE `organizzatore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagamento` (
  `ID_pagamento` int NOT NULL,
  `tipo_pagamento` varchar(200) NOT NULL,
  `somma` float NOT NULL,
  `stato_pagamento` varchar(200) NOT NULL,
  PRIMARY KEY (`ID_pagamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
INSERT INTO `pagamento` VALUES (401,'carta',100,'in elaborazione'),(402,'consegna',80,'completato'),(403,'carta',60,'in attesa'),(404,'consegna',40,'non riuscito');
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `possedere`
--

DROP TABLE IF EXISTS `possedere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `possedere` (
  `ID_evento` int NOT NULL,
  `ID_calendario` int NOT NULL,
  PRIMARY KEY (`ID_evento`,`ID_calendario`),
  KEY `ID_calendario` (`ID_calendario`),
  CONSTRAINT `possedere_ibfk_1` FOREIGN KEY (`ID_evento`) REFERENCES `evento` (`ID_evento`),
  CONSTRAINT `possedere_ibfk_2` FOREIGN KEY (`ID_calendario`) REFERENCES `calendario` (`ID_calendario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `possedere`
--

LOCK TABLES `possedere` WRITE;
/*!40000 ALTER TABLE `possedere` DISABLE KEYS */;
INSERT INTO `possedere` VALUES (101,301),(102,302),(103,303),(104,304);
/*!40000 ALTER TABLE `possedere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `titolo`
--

DROP TABLE IF EXISTS `titolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `titolo` (
  `ID_titolo` int NOT NULL,
  `prezzo_t` varchar(200) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cognome` varchar(200) NOT NULL,
  `posto_prenotato` varchar(100) NOT NULL,
  PRIMARY KEY (`ID_titolo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `titolo`
--

LOCK TABLES `titolo` WRITE;
/*!40000 ALTER TABLE `titolo` DISABLE KEYS */;
INSERT INTO `titolo` VALUES (201,'50.00','silvana','cafaro','01'),(202,'40.00','isabella','sessa','02'),(203,'30.00','andrea','gisolfi','03'),(204,'20.00','giacomo','favale','04'),(205,'50.00','giulia','alfieri','05'),(206,'40.00','maria','esposito','06'),(207,'30.00','massimiliano','caiazzo','07'),(208,'20.00','giacomo','giorgio','08'),(209,'50.00','donato','cafaro','09'),(210,'40.00','michele','boccia','10'),(211,'30.00','carmine','gisolfi','11'),(212,'20.00','elisabetta','canalis','12'),(213,'50.00','ariana','grande','13'),(214,'40.00','maria','la marca','14'),(215,'30.00','andrea','carlucci','15'),(216,'20.00','giacomo','leopardi','16'),(217,'50.00','ludovico','einaudi','17'),(218,'40.00','sandra','marchigiano','18'),(219,'30.00','michele','bosone','19'),(220,'20.00','matteo','di genua','20'),(221,'50.00','carmine','fusco','21'),(222,'40.00','luigi','sorrentino','22'),(223,'30.00','giuseppina','filiberti','23'),(224,'20.00','francesco','carlotti','24'),(225,'50.00','beatrice','gisolfi','25'),(226,'40.00','mario','merola','26'),(227,'30.00','manuela','malinconico','27'),(228,'20.00','teresa','boccia','28'),(229,'50.00','domenico','alfano','29'),(230,'40.00','michela','liguori','30'),(231,'30.00','ginevra','gemito','31'),(232,'20.00','pasquale','gemito','32'),(233,'50.00','giulio','cortese','33'),(234,'40.00','margherita','rainone','34'),(235,'30.00','simona','bosone','35'),(236,'20.00','cristina','pesce','36'),(237,'50.00','angela','napolitano','37'),(238,'40.00','marika','borrelli','38'),(239,'30.00','nino','frassica','39'),(240,'20.00','eugenio','montale','40'),(241,'50.00','linda','simonetti','41'),(242,'40.00','agostino','basilicata','42'),(243,'30.00','carmine','ferrara','43'),(244,'20.00','amedeo','stampati','44'),(245,'50.00','carlotta','lopez','45'),(246,'40.00','raffaella','fernandez','46'),(247,'30.00','bruno','ambrosino','47'),(248,'20.00','antonietta','peluso','48'),(249,'50.00','vincenza','fezza','49'),(250,'40.00','carlotta','ferlito','50');
/*!40000 ALTER TABLE `titolo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `ID_utente` int NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  `org` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID_utente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'simona','vigorito','s.vigorito@virgilio.it','marefuori01',1,0),(2,'tresy','sorrentino','t.sorrentino@gmail.com','arianagrande02',1,0),(5,'Carlos','Carli','carlos@gmail.com','boh123',0,1);
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente_registrato`
--

DROP TABLE IF EXISTS `utente_registrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente_registrato` (
  `ID_utente_reg` int NOT NULL,
  `data_nascita` date NOT NULL,
  `indirizzo_utr` varchar(200) NOT NULL,
  `numero_telefono_utr` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_utente_reg`),
  CONSTRAINT `ID_utente_reg` FOREIGN KEY (`ID_utente_reg`) REFERENCES `utente` (`ID_utente`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente_registrato`
--

LOCK TABLES `utente_registrato` WRITE;
/*!40000 ALTER TABLE `utente_registrato` DISABLE KEYS */;
INSERT INTO `utente_registrato` VALUES (1,'2001-10-18','via garibaldi 2','334689475'),(2,'2002-05-17','via palma 40','38293745'),(5,'1999-02-17','Via kennedy 32','34921530');
/*!40000 ALTER TABLE `utente_registrato` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-21 23:53:50
