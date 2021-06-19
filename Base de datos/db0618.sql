-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.20

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
  `idPlatillo` int NOT NULL,
  `idIngrediente` int NOT NULL,
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
INSERT INTO `agrega` VALUES (41,1),(42,1),(41,2),(42,2),(41,3),(42,3),(41,4),(42,4),(41,5),(42,5);
/*!40000 ALTER TABLE `agrega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `nombreCliente` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contiene`
--

DROP TABLE IF EXISTS `contiene`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contiene` (
  `idPlatillo` int NOT NULL,
  `idOrden` int NOT NULL,
  PRIMARY KEY (`idPlatillo`,`idOrden`),
  KEY `idOrden_idx` (`idOrden`),
  CONSTRAINT `idOrden_contiene` FOREIGN KEY (`idOrden`) REFERENCES `orden` (`idOrden`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idPlatillo_contiene` FOREIGN KEY (`idPlatillo`) REFERENCES `platillo` (`idPlatillo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contiene`
--

LOCK TABLES `contiene` WRITE;
/*!40000 ALTER TABLE `contiene` DISABLE KEYS */;
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
  `idRestaurante` int NOT NULL,
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
INSERT INTO `horario_restaurante` VALUES ('Domingo','11:00:00','20:00:00',1),('Jueves','11:00:00','20:00:00',1),('Lunes','11:00:00','20:00:00',1),('Martes','11:00:00','20:00:00',1),('Miercoles','11:00:00','20:00:00',1),('Sabado','11:00:00','20:00:00',1),('Viernes','11:00:00','20:00:00',1),('Domingo','10:00:00','20:00:00',2),('Jueves','10:00:00','20:00:00',2),('Lunes','10:00:00','20:00:00',2),('Martes','10:00:00','20:00:00',2),('Miercoles','10:00:00','20:00:00',2),('Sabado','10:00:00','20:00:00',2),('Viernes','10:00:00','20:00:00',2),('Domingo','10:00:00','19:00:00',3),('Jueves','10:00:00','19:00:00',3),('Lunes','10:00:00','19:00:00',3),('Martes','10:00:00','19:00:00',3),('Miercoles','10:00:00','19:00:00',3),('Sabado','10:00:00','19:00:00',3),('Viernes','10:00:00','19:00:00',3),('Domingo','10:30:00','19:00:00',4),('Jueves','10:30:00','19:00:00',4),('Lunes','10:30:00','19:00:00',4),('Martes','10:30:00','19:00:00',4),('Miercoles','10:30:00','19:00:00',4),('Sabado','10:30:00','19:00:00',4),('Viernes','10:30:00','19:00:00',4);
/*!40000 ALTER TABLE `horario_restaurante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingrediente`
--

DROP TABLE IF EXISTS `ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingrediente` (
  `idIngrediente` int NOT NULL AUTO_INCREMENT,
  `nombreIngrediente` varchar(60) DEFAULT NULL,
  `costoIngrediente` decimal(10,0) NOT NULL,
  PRIMARY KEY (`idIngrediente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingrediente`
--

LOCK TABLES `ingrediente` WRITE;
/*!40000 ALTER TABLE `ingrediente` DISABLE KEYS */;
INSERT INTO `ingrediente` VALUES (1,'Shot extra esperesso',10),(2,'Shot extra Descafeinado',10),(3,'Shot extra Mexico Oaxaca',10),(4,'Leche Deslactosada',8),(5,'Bebida soya',9);
/*!40000 ALTER TABLE `ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `idMenu` int NOT NULL,
  `idRestaurante` int NOT NULL,
  PRIMARY KEY (`idMenu`),
  KEY `idRestaurante_idx` (`idRestaurante`),
  CONSTRAINT `idRestaurante` FOREIGN KEY (`idRestaurante`) REFERENCES `restaurante` (`idRestaurante`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,1),(2,2),(3,3),(4,4);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden`
--

DROP TABLE IF EXISTS `orden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden` (
  `idOrden` int NOT NULL AUTO_INCREMENT,
  `idCliente` int NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  PRIMARY KEY (`idOrden`),
  KEY `idOrden_idx` (`idOrden`),
  KEY `idCliente` (`idCliente`),
  CONSTRAINT `idCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden`
--

LOCK TABLES `orden` WRITE;
/*!40000 ALTER TABLE `orden` DISABLE KEYS */;
/*!40000 ALTER TABLE `orden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `idPago` int NOT NULL AUTO_INCREMENT,
  `idCliente` int NOT NULL,
  `montoTotal` decimal(10,0) NOT NULL,
  `noCuenta` int DEFAULT NULL,
  `cvv` int DEFAULT NULL,
  `fechaCad` date DEFAULT NULL,
  `tipo` tinyint NOT NULL,
  PRIMARY KEY (`idPago`,`idCliente`),
  KEY `idCliente_idx` (`idCliente`),
  CONSTRAINT `idCliente_pago` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platillo`
--

DROP TABLE IF EXISTS `platillo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `platillo` (
  `idPlatillo` int NOT NULL AUTO_INCREMENT,
  `idMenu` int NOT NULL,
  `nombrePlatillo` varchar(45) DEFAULT NULL,
  `costoPlatillo` decimal(10,0) NOT NULL,
  `composicion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idPlatillo`),
  KEY `idMenu_idx` (`idMenu`),
  CONSTRAINT `idMenu` FOREIGN KEY (`idMenu`) REFERENCES `menu` (`idMenu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platillo`
--

LOCK TABLES `platillo` WRITE;
/*!40000 ALTER TABLE `platillo` DISABLE KEYS */;
INSERT INTO `platillo` VALUES (1,1,'1 pieza',25,'1 pieza de pollo'),(2,1,'3 piezas',70,'3 piezas de pollo'),(3,1,'5 piezas ',110,'5 piezas de pollo'),(4,1,'10 piezas ',230,'10 piezas de pollo'),(5,1,'15 piezas',350,'15 piezas de pollo'),(6,1,'20 piezas',460,'20 piezas de pollo'),(7,1,'ensalada chico',30,'Ensalada para una persona'),(8,1,'ensalada medio',37,'Ensalada para 2 o 3 personas'),(9,1,'ensalada grande',42,'Ensalada para 4 personas'),(10,1,'coca-cola de lata',20,'refresco coca cola de lata de 355ml'),(11,1,'coca-cola botella',31,'refresco coca cola de 600ml'),(12,1,'coca-cola grande',45,'refresco coca cola de 2L'),(13,2,'Hamburguesa sencilla',40,'Hamburguesa basica de carne de res 100%'),(14,2,'Hamburguesa doble',50,'Hamburguesa consta de doble carne 100% res'),(15,2,'Hamburguesa crispy onion',62,'contiene tocino, cebolla grilleada, cebolla crujiente, queso blanco, salsa BBQ, carne 100% de res '),(16,2,'Hamburguesa super carne',62,'dos carnes de res,tocino, queso americano, cátsup y mayonesa'),(17,2,'Hamburguesa Jr',33,'Hamburguesa chica para niños'),(18,2,'Papas chica',25,'Papas a la francesa chica'),(19,2,'Papas mediana',32,'Papas a la francesa mediana'),(20,2,'Papas grande',38,'Papas a la francesca grande'),(21,2,'Coca-cola de lata',20,'refresco coca cola de lata de 355ml'),(22,2,'Coca-cola botella',31,'refresco coca cola de 600ml'),(23,2,'Coca-cola grande',45,'refresco coca cola de 2L'),(24,3,'Pizza pepperon medianai',85,'Pizza de pepperoni mediana (30cm)'),(25,3,'Pizza pepperoni grande',99,'Pizza de pepperoni grande (35cm)'),(26,3,'Pizza hawaiana mediana',91,'Pizza hawaiana de piña, jamon y tocino (30cm)'),(27,3,'Pizza hawaiana grande',105,'Pizza hawaiana de piña, jamon y tocino (35cm)'),(28,3,'Pizza de cuatro quesos mediana',91,'Pizza de Queso mozzarella, queso crema, queso cheddar, queso parmesano (30cm)'),(29,3,'Pizza de cuatro quesos grande',105,'Pizza de Queso mozzarella, queso crema, queso cheddar, queso parmesano (35cm)'),(30,3,'Pizza deluxe mediana',100,'Pizza de Pepperoni, carne molida, champiñones, pimiento, cebolla (30cm)'),(31,3,'Pizza deluxe grande',115,'Pizza de pepperoni, carne molida, champiñones, pimiento, cebolla.(35cm)'),(32,3,'Coca-cola de lata',20,'refresco coca cola de lata de 355ml'),(33,3,'Coca-cola botella',31,'refresco coca cola de 600ml'),(34,3,'Coca-cola grande',45,'refresco coca cola de 2L'),(35,4,'Dona Maple ',30,'Dona cubierta sabor maple'),(36,4,'Dona Homero',30,'Dona francesa de vainilla con fondant rosa y granillo'),(37,4,'Dona Azucar',30,'Dona francesa de vainilla con azucar y canela'),(38,4,'Dona Glasse',30,'Dona francesa con cobertura de glase blanco'),(39,4,'Dona chocolate',30,'Dona cobertura de chocolate'),(40,4,'Dona fresa',30,'Dona cobertura de fresa'),(41,4,'Latte ',50,'Cafe espresso con leche vaporizada'),(42,4,'Latte Helado',50,'Cafe espresso mezclado con leche y hielo'),(43,4,'Espresso Americano',38,'Cafe espresso con agua caliente '),(44,4,'Espresso Americano Helado',38,'Cafe espresso con agua yy hielos'),(45,4,'Chocolate ',50,'Chocolate caliente'),(46,4,'Chocolate helado',50,'Chocolate con hielo');
/*!40000 ALTER TABLE `platillo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurante`
--

DROP TABLE IF EXISTS `restaurante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurante` (
  `idRestaurante` int NOT NULL AUTO_INCREMENT,
  `nombreRest` varchar(45) DEFAULT NULL,
  `local` int DEFAULT NULL,
  `telefono` bigint DEFAULT NULL,
  `nombreUsuario` varchar(45) DEFAULT NULL,
  `contrasena` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idRestaurante`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurante`
--

LOCK TABLES `restaurante` WRITE;
/*!40000 ALTER TABLE `restaurante` DISABLE KEYS */;
INSERT INTO `restaurante` VALUES (1,'Chicken Lover',1,1111111111,'chickenlover','cl123'),(2,'Burger Land',2,2222222222,'buergerland','bl123'),(3,'Mi Pizza',3,3333333333,'mipizza','mp123'),(4,'Donas Donuts',4,4444444444,'donasdonuts','dd123');
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

-- Dump completed on 2021-06-18 20:33:33
