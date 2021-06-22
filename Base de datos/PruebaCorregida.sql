-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.33-log

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
-- Table structure for table `agrega`
--

DROP TABLE IF EXISTS `agrega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agrega` (
  `idPlatillo` int(11) NOT NULL,
  `idIngrediente` int(11) NOT NULL,
  PRIMARY KEY (`idPlatillo`,`idIngrediente`),
  KEY `idIngrediente_idx` (`idIngrediente`),
  CONSTRAINT `idIngrediente` FOREIGN KEY (`idIngrediente`) REFERENCES `ingrediente` (`idIngrediente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idPlatillo` FOREIGN KEY (`idPlatillo`) REFERENCES `platillo` (`idPlatillo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agrega`
--

LOCK TABLES `agrega` WRITE;
/*!40000 ALTER TABLE `agrega` DISABLE KEYS */;
INSERT INTO `agrega` VALUES (6,3),(16,3),(17,3),(20,3),(21,3),(3,7),(15,7),(18,7),(19,7),(8,8),(14,8),(15,8),(3,9),(13,9),(19,9),(21,9);
/*!40000 ALTER TABLE `agrega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCliente` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (12,'Alfredo'),(13,'Alfredo'),(14,'Alfredo'),(15,'Alfredo');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contiene`
--

DROP TABLE IF EXISTS `contiene`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contiene` (
  `idPlatillo` int(11) NOT NULL,
  `idOrden` int(11) NOT NULL,
  PRIMARY KEY (`idPlatillo`,`idOrden`),
  KEY `idOrden_idx` (`idOrden`),
  CONSTRAINT `idOrden_contiene` FOREIGN KEY (`idOrden`) REFERENCES `orden` (`idOrden`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idPlatillo_contiene` FOREIGN KEY (`idPlatillo`) REFERENCES `platillo` (`idPlatillo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contiene`
--

LOCK TABLES `contiene` WRITE;
/*!40000 ALTER TABLE `contiene` DISABLE KEYS */;
INSERT INTO `contiene` VALUES (13,11),(14,12),(15,12),(16,12),(17,13),(18,13),(19,13),(20,14),(21,14);
/*!40000 ALTER TABLE `contiene` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario_restaurante`
--

DROP TABLE IF EXISTS `horario_restaurante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horario_restaurante` (
  `dia` varchar(12) NOT NULL,
  `horaApertura` time NOT NULL,
  `horaCierre` time NOT NULL,
  `idRestaurante` int(11) NOT NULL,
  PRIMARY KEY (`dia`,`horaApertura`,`horaCierre`,`idRestaurante`),
  KEY `idRestaurante_idx` (`idRestaurante`),
  CONSTRAINT `idRestaurante_horario` FOREIGN KEY (`idRestaurante`) REFERENCES `restaurante` (`idRestaurante`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario_restaurante`
--

LOCK TABLES `horario_restaurante` WRITE;
/*!40000 ALTER TABLE `horario_restaurante` DISABLE KEYS */;
INSERT INTO `horario_restaurante` VALUES ('lunes','11:11:00','11:11:00',36),('viernes','10:00:00','22:00:00',36);
/*!40000 ALTER TABLE `horario_restaurante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingrediente`
--

DROP TABLE IF EXISTS `ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingrediente` (
  `idIngrediente` int(11) NOT NULL AUTO_INCREMENT,
  `nombreIngrediente` varchar(60) DEFAULT NULL,
  `costoIngrediente` decimal(10,2) NOT NULL,
  PRIMARY KEY (`idIngrediente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingrediente`
--

LOCK TABLES `ingrediente` WRITE;
/*!40000 ALTER TABLE `ingrediente` DISABLE KEYS */;
INSERT INTO `ingrediente` VALUES (3,'fdgdfg',3453.00),(7,'asdas',2452.00),(8,'dsf',0.64),(9,'Queso',20.00);
/*!40000 ALTER TABLE `ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `idMenu` int(11) NOT NULL AUTO_INCREMENT,
  `idRestaurante` int(11) NOT NULL,
  PRIMARY KEY (`idMenu`),
  UNIQUE KEY `idRestaurante` (`idRestaurante`),
  KEY `idRestaurante_idx` (`idRestaurante`),
  CONSTRAINT `idRestaurante` FOREIGN KEY (`idRestaurante`) REFERENCES `restaurante` (`idRestaurante`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (31,36),(32,37);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden`
--

DROP TABLE IF EXISTS `orden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden` (
  `idOrden` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  PRIMARY KEY (`idOrden`),
  KEY `idOrden_idx` (`idOrden`),
  KEY `idCliente` (`idCliente`),
  CONSTRAINT `idCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden`
--

LOCK TABLES `orden` WRITE;
/*!40000 ALTER TABLE `orden` DISABLE KEYS */;
INSERT INTO `orden` VALUES (11,12,'2021-06-22','06:19:57'),(12,13,'2021-06-22','06:22:58'),(13,14,'2021-06-22','06:26:02'),(14,15,'2021-06-22','06:28:34');
/*!40000 ALTER TABLE `orden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `idPago` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) NOT NULL,
  `montoTotal` decimal(10,0) NOT NULL,
  `noCuenta` varchar(18) DEFAULT NULL,
  `cvv` int(4) DEFAULT NULL,
  `fechaCad` date DEFAULT NULL,
  `tipo` tinyint(4) NOT NULL,
  PRIMARY KEY (`idPago`,`idCliente`),
  KEY `idCliente_idx` (`idCliente`),
  CONSTRAINT `idCliente_pago` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
INSERT INTO `pago` VALUES (7,12,70,'5345543',555,'2020-03-25',1),(8,13,71978,'3278378',888,'2020-03-22',1),(9,14,61912,'335783877',333,'2020-03-05',1),(10,15,60411,'04385434',333,'2020-03-15',1);
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platillo`
--

DROP TABLE IF EXISTS `platillo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `platillo` (
  `idPlatillo` int(11) NOT NULL AUTO_INCREMENT,
  `idMenu` int(11) NOT NULL,
  `nombrePlatillo` varchar(45) DEFAULT NULL,
  `costoPlatillo` decimal(10,2) NOT NULL,
  `composicion` varchar(100) DEFAULT NULL,
  `tipo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idPlatillo`),
  KEY `idMenu_idx` (`idMenu`),
  CONSTRAINT `idMenu` FOREIGN KEY (`idMenu`) REFERENCES `menu` (`idMenu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platillo`
--

LOCK TABLES `platillo` WRITE;
/*!40000 ALTER TABLE `platillo` DISABLE KEYS */;
INSERT INTO `platillo` VALUES (2,31,'dasdas',3873.00,'asdasd',0),(3,31,'Hamburguesa doble',50.00,'Doble carne',0),(6,32,'fgfd',53435.00,'dfgdfg',0),(8,31,'sdfsd',12587.00,'sdfsdf',0),(13,31,'Hamburguesa doble',70.00,'Doble carne',1),(14,32,'sdfsd',12587.64,'sdfsdf',1),(15,32,'Hamburguesa doble',2502.64,'Doble carne',1),(16,32,'fgfd',56888.00,'dfgdfg',1),(17,31,'fgfd',56888.00,'dfgdfg',1),(18,31,'Hamburguesa doble',2502.00,'Doble carne',1),(19,31,'Hamburguesa doble',2522.00,'Doble carne',1),(20,31,'fgfd',56888.00,'dfgdfg',1),(21,31,'Hamburguesa doble',3523.00,'Doble carne',1);
/*!40000 ALTER TABLE `platillo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurante`
--

DROP TABLE IF EXISTS `restaurante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurante` (
  `idRestaurante` int(11) NOT NULL AUTO_INCREMENT,
  `nombreRest` varchar(45) DEFAULT NULL,
  `local` int(11) DEFAULT NULL,
  `telefono` bigint(20) DEFAULT NULL,
  `nombreUsuario` varchar(45) DEFAULT NULL,
  `contrasena` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idRestaurante`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurante`
--

LOCK TABLES `restaurante` WRITE;
/*!40000 ALTER TABLE `restaurante` DISABLE KEYS */;
INSERT INTO `restaurante` VALUES (36,'KFC',546,553322566,'bb@bb.bbb','33'),(37,'Burger King',45,5588935852,'Lalonganiza','123');
/*!40000 ALTER TABLE `restaurante` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-22  8:45:44
