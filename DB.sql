-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tpanualdds
-- ------------------------------------------------------
-- Server version	9.1.0

USE tpanualdds;

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
-- Table structure for table `canje`
--

DROP TABLE IF EXISTS `canje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `canje` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `fechaDeCanje` timestamp NULL DEFAULT NULL,
  `oferta_id` bigint DEFAULT NULL,
  `personaHumana_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7knehpc4uje9jarey4hv3eks6` (`oferta_id`),
  KEY `FKmlhqkwmcxanl8h251f44t6mth` (`personaHumana_id`),
  CONSTRAINT `FK7knehpc4uje9jarey4hv3eks6` FOREIGN KEY (`oferta_id`) REFERENCES `oferta` (`id`),
  CONSTRAINT `FKmlhqkwmcxanl8h251f44t6mth` FOREIGN KEY (`personaHumana_id`) REFERENCES `personahumana` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canje`
--

LOCK TABLES `canje` WRITE;
/*!40000 ALTER TABLE `canje` DISABLE KEYS */;
INSERT INTO `canje` VALUES (3,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27 21:28:26',6,1,NULL,NULL,NULL),(4,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27 21:28:26',7,1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `canje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direccion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `altura` varchar(255) DEFAULT NULL,
  `calle` varchar(255) DEFAULT NULL,
  `codigoPostal` varchar(255) DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion`
--

LOCK TABLES `direccion` WRITE;
/*!40000 ALTER TABLE `direccion` DISABLE KEYS */;
INSERT INTO `direccion` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','1111','Monroe','1431',NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2222','Triunvirato','1431',NULL,NULL,NULL);
/*!40000 ALTER TABLE `direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distribuciondeviandas`
--

DROP TABLE IF EXISTS `distribuciondeviandas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distribuciondeviandas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `cantidadDeViandas` int DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `motivoDistribucion` varchar(255) DEFAULT NULL,
  `personaHumana_id` bigint DEFAULT NULL,
  `heladeraDestino_id` bigint DEFAULT NULL,
  `heladeraOrigen_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpyy9nypjym7mserulj1ai32on` (`personaHumana_id`),
  KEY `FKk1k27d5k9hjkpupm4d8igpcsb` (`heladeraDestino_id`),
  KEY `FKnymcuk401xjxx2cfwhwuupe7m` (`heladeraOrigen_id`),
  CONSTRAINT `FKk1k27d5k9hjkpupm4d8igpcsb` FOREIGN KEY (`heladeraDestino_id`) REFERENCES `heladera` (`id`),
  CONSTRAINT `FKnymcuk401xjxx2cfwhwuupe7m` FOREIGN KEY (`heladeraOrigen_id`) REFERENCES `heladera` (`id`),
  CONSTRAINT `FKpyy9nypjym7mserulj1ai32on` FOREIGN KEY (`personaHumana_id`) REFERENCES `personahumana` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distribuciondeviandas`
--

LOCK TABLES `distribuciondeviandas` WRITE;
/*!40000 ALTER TABLE `distribuciondeviandas` DISABLE KEYS */;
INSERT INTO `distribuciondeviandas` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',5,'2024-10-27','Distribuir',1,1,2,NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',4,'2024-10-27','Distribuir',2,2,1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `distribuciondeviandas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donaciondedinero`
--

DROP TABLE IF EXISTS `donaciondedinero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donaciondedinero` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `fechaColaboracion` date DEFAULT NULL,
  `frecuencia` varchar(255) DEFAULT NULL,
  `monto` double DEFAULT NULL,
  `personaHumana_id` bigint DEFAULT NULL,
  `personaJuridica_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  `mercadoPagoId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbjohifnykpit54lxla2iwlg97` (`personaHumana_id`),
  KEY `FKi12cf09e8tm61bf439haw3trg` (`personaJuridica_id`),
  CONSTRAINT `FKbjohifnykpit54lxla2iwlg97` FOREIGN KEY (`personaHumana_id`) REFERENCES `personahumana` (`id`),
  CONSTRAINT `FKi12cf09e8tm61bf439haw3trg` FOREIGN KEY (`personaJuridica_id`) REFERENCES `personajuridica` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donaciondedinero`
--

LOCK TABLES `donaciondedinero` WRITE;
/*!40000 ALTER TABLE `donaciondedinero` DISABLE KEYS */;
INSERT INTO `donaciondedinero` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27','MENSUAL',10000,1,NULL,NULL,NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27','ANUAL',2000000,NULL,2,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `donaciondedinero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donaciondevianda`
--

DROP TABLE IF EXISTS `donaciondevianda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donaciondevianda` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `fechaDeColaboracion` date DEFAULT NULL,
  `personaHumana_id` bigint DEFAULT NULL,
  `vianda_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl1lcvxvy623slu24d0eiodpid` (`personaHumana_id`),
  KEY `FKgu0sojruvqboodvwah9iudit1` (`vianda_id`),
  CONSTRAINT `FKgu0sojruvqboodvwah9iudit1` FOREIGN KEY (`vianda_id`) REFERENCES `vianda` (`id`),
  CONSTRAINT `FKl1lcvxvy623slu24d0eiodpid` FOREIGN KEY (`personaHumana_id`) REFERENCES `personahumana` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donaciondevianda`
--

LOCK TABLES `donaciondevianda` WRITE;
/*!40000 ALTER TABLE `donaciondevianda` DISABLE KEYS */;
INSERT INTO `donaciondevianda` VALUES (3,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27',1,6,NULL,NULL,NULL),(4,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27',2,8,NULL,NULL,NULL);
/*!40000 ALTER TABLE `donaciondevianda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donacionoferta`
--

DROP TABLE IF EXISTS `donacionoferta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donacionoferta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `fechaDeColaboracion` date DEFAULT NULL,
  `personaJuridica_id` bigint DEFAULT NULL,
  `oferta_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlg48sh8t6vx96kofft8rn32ho` (`personaJuridica_id`),
  KEY `FKhmmj20ty47cha6h4yw7954qwa` (`oferta_id`),
  CONSTRAINT `FKhmmj20ty47cha6h4yw7954qwa` FOREIGN KEY (`oferta_id`) REFERENCES `oferta` (`id`),
  CONSTRAINT `FKlg48sh8t6vx96kofft8rn32ho` FOREIGN KEY (`personaJuridica_id`) REFERENCES `personajuridica` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donacionoferta`
--

LOCK TABLES `donacionoferta` WRITE;
/*!40000 ALTER TABLE `donacionoferta` DISABLE KEYS */;
INSERT INTO `donacionoferta` VALUES (3,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27',1,6,NULL,NULL,NULL),(4,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27',2,7,NULL,NULL,NULL);
/*!40000 ALTER TABLE `donacionoferta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formulario`
--

DROP TABLE IF EXISTS `formulario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `formulario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formulario`
--

LOCK TABLES `formulario` WRITE;
/*!40000 ALTER TABLE `formulario` DISABLE KEYS */;
INSERT INTO `formulario` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',NULL,NULL,NULL),(3,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',NULL,NULL,NULL);
/*!40000 ALTER TABLE `formulario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formulariorespondido`
--

DROP TABLE IF EXISTS `formulariorespondido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `formulariorespondido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `formulario_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKewi6kf16h0qldaxi7cadyr7f9` (`formulario_id`),
  CONSTRAINT `FKewi6kf16h0qldaxi7cadyr7f9` FOREIGN KEY (`formulario_id`) REFERENCES `formulario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formulariorespondido`
--

LOCK TABLES `formulariorespondido` WRITE;
/*!40000 ALTER TABLE `formulariorespondido` DISABLE KEYS */;
INSERT INTO `formulariorespondido` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',1,NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `formulariorespondido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hacersecargodeheladera`
--

DROP TABLE IF EXISTS `hacersecargodeheladera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hacersecargodeheladera` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `fechaDeColaboracion` date DEFAULT NULL,
  `personaJuridica_id` bigint DEFAULT NULL,
  `heladera_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbess61e7vxm6051lv4kocd9m2` (`personaJuridica_id`),
  KEY `FK2kjp4u2034tpcn5rt6fnynynr` (`heladera_id`),
  CONSTRAINT `FK2kjp4u2034tpcn5rt6fnynynr` FOREIGN KEY (`heladera_id`) REFERENCES `heladera` (`id`),
  CONSTRAINT `FKbess61e7vxm6051lv4kocd9m2` FOREIGN KEY (`personaJuridica_id`) REFERENCES `personajuridica` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hacersecargodeheladera`
--

LOCK TABLES `hacersecargodeheladera` WRITE;
/*!40000 ALTER TABLE `hacersecargodeheladera` DISABLE KEYS */;
INSERT INTO `hacersecargodeheladera` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27',1,1,NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27',2,2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `hacersecargodeheladera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `heladera`
--

DROP TABLE IF EXISTS `heladera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `heladera` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `capacidad` int DEFAULT NULL,
  `latitudCoordenada` int DEFAULT NULL,
  `longuitudCoordenada` int DEFAULT NULL,
  `descripcion` text,
  `estado` varchar(255) DEFAULT NULL,
  `estadoReparacion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `direccion_id` bigint DEFAULT NULL,
  `modelo_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsary5y046htkbl187uvc3o18y` (`direccion_id`),
  KEY `FKp28hsh2kw1uhc9tkv299des9q` (`modelo_id`),
  CONSTRAINT `FKp28hsh2kw1uhc9tkv299des9q` FOREIGN KEY (`modelo_id`) REFERENCES `modeloheladera` (`id`),
  CONSTRAINT `FKsary5y046htkbl187uvc3o18y` FOREIGN KEY (`direccion_id`) REFERENCES `direccion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `heladera`
--

LOCK TABLES `heladera` WRITE;
/*!40000 ALTER TABLE `heladera` DISABLE KEYS */;
INSERT INTO `heladera` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',10,2514836,2784789,'Heladera mediana','Activa','Reparada','Heladera 1',1,1,NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',12,2514789,6843258,'Heladera grande','Activa','Reparada','Heladera 2',2,2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `heladera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hijodepersonavulnerable`
--

DROP TABLE IF EXISTS `hijodepersonavulnerable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hijodepersonavulnerable` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `fechaDeNacimiento` timestamp NULL DEFAULT NULL,
  `apellido` varchar(55) DEFAULT NULL,
  `nombre` varchar(55) DEFAULT NULL,
  `parentesco` varchar(55) DEFAULT NULL,
  `personaVulnerable_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4kv22kdg4kjr00pf7yx4s8yic` (`personaVulnerable_id`),
  CONSTRAINT `FK4kv22kdg4kjr00pf7yx4s8yic` FOREIGN KEY (`personaVulnerable_id`) REFERENCES `personavulnerable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hijodepersonavulnerable`
--

LOCK TABLES `hijodepersonavulnerable` WRITE;
/*!40000 ALTER TABLE `hijodepersonavulnerable` DISABLE KEYS */;
INSERT INTO `hijodepersonavulnerable` VALUES (9,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2022-10-27 21:28:26','Diaz','Lolo','Madre',2,NULL,NULL,NULL),(10,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2020-10-27 21:28:26','Gomez','Lola','Madre',1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `hijodepersonavulnerable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidente`
--

DROP TABLE IF EXISTS `incidente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incidente` (
  `tipo` varchar(31) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `descripcion` text,
  `fechaHoraDelIncidente` timestamp NULL DEFAULT NULL,
  `tipoDeAlerta` varchar(255) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `heladera_id` bigint DEFAULT NULL,
  `personaHumana_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi8xtbci9hnyqe62mmaf98ho3q` (`heladera_id`),
  KEY `FKlrsvr1xx0qhpds5jr2ca71usu` (`personaHumana_id`),
  CONSTRAINT `FKi8xtbci9hnyqe62mmaf98ho3q` FOREIGN KEY (`heladera_id`) REFERENCES `heladera` (`id`),
  CONSTRAINT `FKlrsvr1xx0qhpds5jr2ca71usu` FOREIGN KEY (`personaHumana_id`) REFERENCES `personahumana` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidente`
--

LOCK TABLES `incidente` WRITE;
/*!40000 ALTER TABLE `incidente` DISABLE KEYS */;
INSERT INTO `incidente` VALUES ('TEMP',1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','Temperaturas muy altas','2024-10-27 21:28:26','TEMPERATURA',NULL,1,1,NULL,NULL,NULL),('TEMP',2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','No se reciben temperaturas','2024-10-27 21:28:26','FALLA DE CONEXION',NULL,2,2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `incidente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `intentoapertura`
--

DROP TABLE IF EXISTS `intentoapertura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `intentoapertura` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `fechaHoraAlta` timestamp NULL DEFAULT NULL,
  `fechaHoraEjecucion` timestamp NULL DEFAULT NULL,
  `idHeladera` mediumtext,
  `idTarjeta` int DEFAULT NULL,
  `motivo` varchar(255) DEFAULT NULL,
  `heladera_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5x8jm9cmkp4i09nyokjw4lcnx` (`heladera_id`),
  CONSTRAINT `FK5x8jm9cmkp4i09nyokjw4lcnx` FOREIGN KEY (`heladera_id`) REFERENCES `heladera` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `intentoapertura`
--

LOCK TABLES `intentoapertura` WRITE;
/*!40000 ALTER TABLE `intentoapertura` DISABLE KEYS */;
INSERT INTO `intentoapertura` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',1,1,'2024-10-27 21:28:26','2024-10-27 21:28:26','1',1,'Retiro de vianda',1,NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',1,0,'2024-10-27 21:28:26','2024-10-27 21:28:26','2',2,'Retiro de vianda',2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `intentoapertura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mediodecontacto`
--

DROP TABLE IF EXISTS `mediodecontacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mediodecontacto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `contacto` varchar(255) DEFAULT NULL,
  `tipoMedioContacto` varchar(255) DEFAULT NULL,
  `personaHumana_id` bigint DEFAULT NULL,
  `personaJuridica_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  `tecnico_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3tiikfd48rjyujjrogrkscumq` (`personaHumana_id`),
  KEY `FKssx4mptm6hg7cf9smc54f9n26` (`personaJuridica_id`),
  KEY `FKhobjkuewayora16rq7cx36syb` (`tecnico_id`),
  CONSTRAINT `FK3tiikfd48rjyujjrogrkscumq` FOREIGN KEY (`personaHumana_id`) REFERENCES `personahumana` (`id`),
  CONSTRAINT `FKhobjkuewayora16rq7cx36syb` FOREIGN KEY (`tecnico_id`) REFERENCES `tecnico` (`id`),
  CONSTRAINT `FKssx4mptm6hg7cf9smc54f9n26` FOREIGN KEY (`personaJuridica_id`) REFERENCES `personajuridica` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mediodecontacto`
--

LOCK TABLES `mediodecontacto` WRITE;
/*!40000 ALTER TABLE `mediodecontacto` DISABLE KEYS */;
INSERT INTO `mediodecontacto` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','1184579654','NUMERO_DE_TELEFONO',NULL,1,NULL,NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','mailpersonajuridica@gmail.com','CORREO',NULL,2,NULL,NULL,NULL,NULL),(3,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','1136542489','NUMERO_DE_TELEFONO',1,NULL,NULL,NULL,NULL,NULL),(4,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','mailpersonahumana@gmail.com','CORREO',2,NULL,NULL,NULL,NULL,NULL),(5,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','1157986424','NUMERO_DE_TELEFONO',NULL,NULL,NULL,NULL,NULL,2);
/*!40000 ALTER TABLE `mediodecontacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modeloheladera`
--

DROP TABLE IF EXISTS `modeloheladera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modeloheladera` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `temperaturaMaxima` float DEFAULT NULL,
  `temperaturaMinima` float DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modeloheladera`
--

LOCK TABLES `modeloheladera` WRITE;
/*!40000 ALTER TABLE `modeloheladera` DISABLE KEYS */;
INSERT INTO `modeloheladera` VALUES (1,1,NULL,'2024-09-27 21:28:26','2024-09-27 21:28:26','SuperHeladera',23,-3,NULL,NULL,NULL,NULL),(2,1,NULL,'2024-09-27 21:28:26','2024-09-27 21:28:26','IceCream9000',23,-6,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `modeloheladera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientodeviandas`
--

DROP TABLE IF EXISTS `movimientodeviandas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientodeviandas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `cantidadDeViandasAIngresar` int DEFAULT NULL,
  `cantidadDeViandasARetirar` int DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha` timestamp NULL DEFAULT NULL,
  `heladera_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9gr3p70elbt2e2mj4mueudaxo` (`heladera_id`),
  CONSTRAINT `FK9gr3p70elbt2e2mj4mueudaxo` FOREIGN KEY (`heladera_id`) REFERENCES `heladera` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientodeviandas`
--

LOCK TABLES `movimientodeviandas` WRITE;
/*!40000 ALTER TABLE `movimientodeviandas` DISABLE KEYS */;
INSERT INTO `movimientodeviandas` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',0,1,'Retira de un plato de empanadas','2024-11-27 21:28:26',1,NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',1,0,'Se agrega un plato de fideos','2024-11-27 21:28:26',2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `movimientodeviandas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oferta`
--

DROP TABLE IF EXISTS `oferta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oferta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `descripcionBeneficio` text,
  `nombreBeneficio` varchar(55) DEFAULT NULL,
  `desripcionRubroDescripcion` text,
  `nombreRubroBeneficio` varchar(55) DEFAULT NULL,
  `tipoDeBeneficio` varchar(255) DEFAULT NULL,
  `imagenIlustrativa` varchar(255) DEFAULT NULL,
  `nombre` varchar(55) DEFAULT NULL,
  `puntosNecesarios` float DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oferta`
--

LOCK TABLES `oferta` WRITE;
/*!40000 ALTER TABLE `oferta` DISABLE KEYS */;
INSERT INTO `oferta` VALUES (6,1,NULL,'2024-09-27 21:28:26','2024-09-27 21:28:26','Caja de 24 lapices de todos los colores','Lapices de colores','Libreria','Libreria','PRODUCTO','\\2024-tpa-mi-no-grupo-14\\src\\main\\resources\\public\\img\\OfertaLapices.jpg','Lapices de Colores',3000,NULL,NULL,NULL),(7,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','Set de 6 vasos','Vasos','Hogar y Cocina','Hogar y Cocina','PRODUCTO','\\2024-tpa-mi-no-grupo-14\\src\\main\\resources\\public\\img\\OfertaVasos.jpg','Set de vasos',6000,NULL,NULL,NULL);
/*!40000 ALTER TABLE `oferta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opcion`
--

DROP TABLE IF EXISTS `opcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opcion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `esCorrecta` tinyint(1) DEFAULT NULL,
  `valor` varchar(255) DEFAULT NULL,
  `respuesta_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnq3kt4xbm7u05aa4h84t7cagb` (`respuesta_id`),
  CONSTRAINT `FKnq3kt4xbm7u05aa4h84t7cagb` FOREIGN KEY (`respuesta_id`) REFERENCES `respuesta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opcion`
--

LOCK TABLES `opcion` WRITE;
/*!40000 ALTER TABLE `opcion` DISABLE KEYS */;
INSERT INTO `opcion` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',1,'Si',1,NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',0,'No',1,NULL,NULL,NULL),(3,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',1,'Si',2,NULL,NULL,NULL),(4,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',0,'No',2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `opcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personahumana`
--

DROP TABLE IF EXISTS `personahumana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personahumana` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `numeroDeDocumento` varchar(8) DEFAULT NULL,
  `tipoDocumento` varchar(255) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `apellido` varchar(55) DEFAULT NULL,
  `nombre` varchar(55) DEFAULT NULL,
  `formularioRespondido_id` bigint DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  `direccion_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKppj83mgcw27ue9nnfq5o15cov` (`formularioRespondido_id`),
  KEY `FK9ds4gdel7pab2w4oixo966xsb` (`usuario_id`),
  KEY `FK1928pgbehgxidrmlooxrp9stm` (`direccion_id`),
  CONSTRAINT `FK1928pgbehgxidrmlooxrp9stm` FOREIGN KEY (`direccion_id`) REFERENCES `direccion` (`id`),
  CONSTRAINT `FK9ds4gdel7pab2w4oixo966xsb` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKppj83mgcw27ue9nnfq5o15cov` FOREIGN KEY (`formularioRespondido_id`) REFERENCES `formulariorespondido` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personahumana`
--

LOCK TABLES `personahumana` WRITE;
/*!40000 ALTER TABLE `personahumana` DISABLE KEYS */;
INSERT INTO `personahumana` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','40123584','DNI','2000-10-27','Diaz','Pepito',1,5,NULL,NULL,NULL,1),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','25036147','DNI','1990-10-27','Fernandez','Manolo',2,2,NULL,NULL,NULL,2);
/*!40000 ALTER TABLE `personahumana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personajuridica`
--

DROP TABLE IF EXISTS `personajuridica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personajuridica` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `razonSocial` varchar(255) DEFAULT NULL,
  `desripcionRubroDescripcion` text,
  `nombreRubroBeneficio` varchar(55) DEFAULT NULL,
  `tipo` int DEFAULT NULL,
  `formularioRespondido_id` bigint DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  `direccion_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcqsuqtmfs4wbgsme56b3jruuu` (`formularioRespondido_id`),
  KEY `FKk0nbc8bow979wl6tacecsupki` (`usuario_id`),
  KEY `FK7jw92d0jsyngyc76nh7q7r3jh` (`direccion_id`),
  CONSTRAINT `FK7jw92d0jsyngyc76nh7q7r3jh` FOREIGN KEY (`direccion_id`) REFERENCES `direccion` (`id`),
  CONSTRAINT `FKcqsuqtmfs4wbgsme56b3jruuu` FOREIGN KEY (`formularioRespondido_id`) REFERENCES `formulariorespondido` (`id`),
  CONSTRAINT `FKk0nbc8bow979wl6tacecsupki` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personajuridica`
--

LOCK TABLES `personajuridica` WRITE;
/*!40000 ALTER TABLE `personajuridica` DISABLE KEYS */;
INSERT INTO `personajuridica` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','Delicias Gourmet S.A','Gastronomia','Gastronomia',1,1,1,NULL,NULL,NULL,1),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','Hogares Felices  S.A','Hogar y Cocina','Hogar y Cocina',1,2,2,NULL,NULL,NULL,2);
/*!40000 ALTER TABLE `personajuridica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personavulnerable`
--

DROP TABLE IF EXISTS `personavulnerable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personavulnerable` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `numeroDeDocumento` varchar(8) DEFAULT NULL,
  `tipoDocumento` varchar(255) DEFAULT NULL,
  `fechaDeNacimiento` timestamp NULL DEFAULT NULL,
  `apellido` varchar(55) DEFAULT NULL,
  `nombre` varchar(55) DEFAULT NULL,
  `personaHumanaQueLoRegistro_id` bigint DEFAULT NULL,
  `direccion_id` bigint DEFAULT NULL,
  `tarjetaVulnerable_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  `cantidadDeHijos` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi7riy9fq2diebwy398ryg163w` (`personaHumanaQueLoRegistro_id`),
  KEY `FKt6023ilmdo5as90atos1jlabf` (`direccion_id`),
  KEY `FKmgtc9yvago4cisq2rw4aeyctv` (`tarjetaVulnerable_id`),
  CONSTRAINT `FKi7riy9fq2diebwy398ryg163w` FOREIGN KEY (`personaHumanaQueLoRegistro_id`) REFERENCES `personahumana` (`id`),
  CONSTRAINT `FKmgtc9yvago4cisq2rw4aeyctv` FOREIGN KEY (`tarjetaVulnerable_id`) REFERENCES `tarjetavulnerable` (`id`),
  CONSTRAINT `FKt6023ilmdo5as90atos1jlabf` FOREIGN KEY (`direccion_id`) REFERENCES `direccion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personavulnerable`
--

LOCK TABLES `personavulnerable` WRITE;
/*!40000 ALTER TABLE `personavulnerable` DISABLE KEYS */;
INSERT INTO `personavulnerable` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','44529587','DNI','2002-10-27 21:28:26','Romero','Jazmin',1,1,1,NULL,NULL,NULL,0),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','42598365','DNI','2000-10-27 21:28:26','Rinaldi','Marianella',2,2,2,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `personavulnerable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pregunta`
--

DROP TABLE IF EXISTS `pregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pregunta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `esObligatoria` tinyint(1) DEFAULT NULL,
  `preguntaConcreta` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `formulario_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKphioykcg12i5js5jeat9w7w5m` (`formulario_id`),
  CONSTRAINT `FKphioykcg12i5js5jeat9w7w5m` FOREIGN KEY (`formulario_id`) REFERENCES `formulario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregunta`
--

LOCK TABLES `pregunta` WRITE;
/*!40000 ALTER TABLE `pregunta` DISABLE KEYS */;
INSERT INTO `pregunta` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',1,'Le gusta nuestra pagina?','MULTIPLE',1,NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',0,'Nos recomendaria a sus conocidos?','MULTIPLE',2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `pregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrodepersonasensituacionvulnerable`
--

DROP TABLE IF EXISTS `registrodepersonasensituacionvulnerable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registrodepersonasensituacionvulnerable` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `fechaDeColaboracion` date DEFAULT NULL,
  `personaHumana_id` bigint DEFAULT NULL,
  `personaVulnerable_id` bigint DEFAULT NULL,
  `tarjetaVulnerable_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1yiewdwndxlo5twhe7weathxn` (`personaHumana_id`),
  KEY `FKi632gg9u0c08xbm8jyquq6spf` (`personaVulnerable_id`),
  KEY `FKp9u5prkyp25ruucxemxr0px8y` (`tarjetaVulnerable_id`),
  CONSTRAINT `FK1yiewdwndxlo5twhe7weathxn` FOREIGN KEY (`personaHumana_id`) REFERENCES `personahumana` (`id`),
  CONSTRAINT `FKi632gg9u0c08xbm8jyquq6spf` FOREIGN KEY (`personaVulnerable_id`) REFERENCES `personavulnerable` (`id`),
  CONSTRAINT `FKp9u5prkyp25ruucxemxr0px8y` FOREIGN KEY (`tarjetaVulnerable_id`) REFERENCES `tarjetavulnerable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrodepersonasensituacionvulnerable`
--

LOCK TABLES `registrodepersonasensituacionvulnerable` WRITE;
/*!40000 ALTER TABLE `registrodepersonasensituacionvulnerable` DISABLE KEYS */;
INSERT INTO `registrodepersonasensituacionvulnerable` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27',1,1,1,NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27',2,2,2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `registrodepersonasensituacionvulnerable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuesta`
--

DROP TABLE IF EXISTS `respuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `respuesta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `pregunta_id` bigint DEFAULT NULL,
  `formularioRespondido_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd9oyrwyjw1otr38btjeevanif` (`pregunta_id`),
  KEY `FKhxplr960m1boxyqynlfijehyp` (`formularioRespondido_id`),
  CONSTRAINT `FKd9oyrwyjw1otr38btjeevanif` FOREIGN KEY (`pregunta_id`) REFERENCES `pregunta` (`id`),
  CONSTRAINT `FKhxplr960m1boxyqynlfijehyp` FOREIGN KEY (`formularioRespondido_id`) REFERENCES `formulariorespondido` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta`
--

LOCK TABLES `respuesta` WRITE;
/*!40000 ALTER TABLE `respuesta` DISABLE KEYS */;
INSERT INTO `respuesta` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',1,1,NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',2,2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `respuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicituddeapertura`
--

DROP TABLE IF EXISTS `solicituddeapertura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicituddeapertura` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `horaDeRegistro` datetime DEFAULT NULL,
  `tiempoParaEjecucion` int DEFAULT NULL,
  `heladera_id` bigint DEFAULT NULL,
  `tarjetaColaborador_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjk7sgk4boyxvwgq62wlystqa` (`heladera_id`),
  KEY `FKk521thqbqi7rm526thwlrditn` (`tarjetaColaborador_id`),
  CONSTRAINT `FKjk7sgk4boyxvwgq62wlystqa` FOREIGN KEY (`heladera_id`) REFERENCES `heladera` (`id`),
  CONSTRAINT `FKk521thqbqi7rm526thwlrditn` FOREIGN KEY (`tarjetaColaborador_id`) REFERENCES `tarjetacolaborador` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicituddeapertura`
--

LOCK TABLES `solicituddeapertura` WRITE;
/*!40000 ALTER TABLE `solicituddeapertura` DISABLE KEYS */;
INSERT INTO `solicituddeapertura` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','Retiro de vianda','2024-10-27 18:28:26',20,1,1,NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','Cargar vianda','2024-10-27 18:28:26',10,2,2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `solicituddeapertura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjetacolaborador`
--

DROP TABLE IF EXISTS `tarjetacolaborador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarjetacolaborador` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `codigo` varchar(55) DEFAULT NULL,
  `estaEnUso` tinyint(1) DEFAULT NULL,
  `personaHumana_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr2xbidq3tfvr7lh28r2bt545b` (`personaHumana_id`),
  CONSTRAINT `FKr2xbidq3tfvr7lh28r2bt545b` FOREIGN KEY (`personaHumana_id`) REFERENCES `personahumana` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjetacolaborador`
--

LOCK TABLES `tarjetacolaborador` WRITE;
/*!40000 ALTER TABLE `tarjetacolaborador` DISABLE KEYS */;
INSERT INTO `tarjetacolaborador` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','codigo1',1,1,NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','codigo2',1,2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tarjetacolaborador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjetavulnerable`
--

DROP TABLE IF EXISTS `tarjetavulnerable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarjetavulnerable` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `estaEnUso` tinyint(1) DEFAULT NULL,
  `usosMaximosPermitidos` int DEFAULT NULL,
  `usosMaximosPermitidosPorMenos` int DEFAULT NULL,
  `usosMaximosPropio` int DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjetavulnerable`
--

LOCK TABLES `tarjetavulnerable` WRITE;
/*!40000 ALTER TABLE `tarjetavulnerable` DISABLE KEYS */;
INSERT INTO `tarjetavulnerable` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','111',1,3,4,5,NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','999',1,10,5,5,NULL,NULL,NULL),(3,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','222',0,5,3,5,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tarjetavulnerable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecnico`
--

DROP TABLE IF EXISTS `tecnico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tecnico` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `latitudCoordenada` int DEFAULT NULL,
  `longuitudCoordenada` int DEFAULT NULL,
  `radioCoberturaEnKm` int DEFAULT NULL,
  `cuil` varchar(11) DEFAULT NULL,
  `numeroDeDocumento` varchar(8) DEFAULT NULL,
  `tipoDocumento` varchar(255) DEFAULT NULL,
  `apellido` varchar(55) DEFAULT NULL,
  `nombre` varchar(55) DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr2xbidq3tfvr7lh28r2bt554b` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnico`
--

LOCK TABLES `tecnico` WRITE;
/*!40000 ALTER TABLE `tecnico` DISABLE KEYS */;
INSERT INTO `tecnico` VALUES (2,1,NULL,'2024-09-27 21:28:26','2024-09-27 21:28:26',57556367,58362157,10,'25458426973','45842697','DNI','Perez','Pedro',NULL,NULL,NULL,3),(3,1,NULL,'2024-09-27 21:28:26','2024-09-27 21:28:26',52254687,45285147,7,'52248561856','24856185','DNI','Gomez','Claudio',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tecnico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temperaturaencelcius`
--

DROP TABLE IF EXISTS `temperaturaencelcius`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `temperaturaencelcius` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `fecha` timestamp NULL DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `heladera_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbp0kl82bjm3wyp3med8nmolwu` (`heladera_id`),
  CONSTRAINT `FKbp0kl82bjm3wyp3med8nmolwu` FOREIGN KEY (`heladera_id`) REFERENCES `heladera` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temperaturaencelcius`
--

LOCK TABLES `temperaturaencelcius` WRITE;
/*!40000 ALTER TABLE `temperaturaencelcius` DISABLE KEYS */;
INSERT INTO `temperaturaencelcius` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27 21:28:26',10,1,NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27 21:28:26',12,2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `temperaturaencelcius` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usotarjetacolaborador`
--

DROP TABLE IF EXISTS `usotarjetacolaborador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usotarjetacolaborador` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `fechaUso` timestamp NULL DEFAULT NULL,
  `heladera_id` bigint DEFAULT NULL,
  `solicitudApertura_id` bigint DEFAULT NULL,
  `tarjetaColaborador_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjr4atjqu4sfmltgrsatqvy0j7` (`heladera_id`),
  KEY `FK1kciqh3yjajkw06pel2mo4upi` (`solicitudApertura_id`),
  KEY `FKn6bkdt765oyha0vl7gt2sb0mc` (`tarjetaColaborador_id`),
  CONSTRAINT `FK1kciqh3yjajkw06pel2mo4upi` FOREIGN KEY (`solicitudApertura_id`) REFERENCES `solicituddeapertura` (`id`),
  CONSTRAINT `FKjr4atjqu4sfmltgrsatqvy0j7` FOREIGN KEY (`heladera_id`) REFERENCES `heladera` (`id`),
  CONSTRAINT `FKn6bkdt765oyha0vl7gt2sb0mc` FOREIGN KEY (`tarjetaColaborador_id`) REFERENCES `tarjetacolaborador` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usotarjetacolaborador`
--

LOCK TABLES `usotarjetacolaborador` WRITE;
/*!40000 ALTER TABLE `usotarjetacolaborador` DISABLE KEYS */;
INSERT INTO `usotarjetacolaborador` VALUES (1,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27 21:28:26',1,1,1,NULL,NULL,NULL),(2,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27 21:28:26',2,2,2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usotarjetacolaborador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usotarjetavulnerable`
--

DROP TABLE IF EXISTS `usotarjetavulnerable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usotarjetavulnerable` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `fechaUso` timestamp NULL DEFAULT NULL,
  `heladera_id` bigint DEFAULT NULL,
  `vianda_id` bigint DEFAULT NULL,
  `tarjetaVulnerable_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk0mit42leymj5en9m1orxitq7` (`heladera_id`),
  KEY `FK12l2wviv88fes3uy31asdtb9p` (`vianda_id`),
  KEY `FKmtlijfynk6wkg5tu7o6scc31s` (`tarjetaVulnerable_id`),
  CONSTRAINT `FK12l2wviv88fes3uy31asdtb9p` FOREIGN KEY (`vianda_id`) REFERENCES `vianda` (`id`),
  CONSTRAINT `FKk0mit42leymj5en9m1orxitq7` FOREIGN KEY (`heladera_id`) REFERENCES `heladera` (`id`),
  CONSTRAINT `FKmtlijfynk6wkg5tu7o6scc31s` FOREIGN KEY (`tarjetaVulnerable_id`) REFERENCES `tarjetavulnerable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usotarjetavulnerable`
--

LOCK TABLES `usotarjetavulnerable` WRITE;
/*!40000 ALTER TABLE `usotarjetavulnerable` DISABLE KEYS */;
INSERT INTO `usotarjetavulnerable` VALUES (3,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27 21:28:26',1,6,1,NULL,NULL,NULL),(4,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','2024-10-27 21:28:26',2,7,2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usotarjetavulnerable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `contrasenia` varchar(255) DEFAULT NULL,
  `fechaDeCreacionDeContrasenia` timestamp NULL DEFAULT NULL,
  `nombreDeUsuario` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,NULL,'2024-09-27 21:28:26','2024-09-27 21:28:26','contraseña','2024-09-27 21:28:26','usuario1','ADMINISTRADOR',NULL,NULL,NULL),(2,1,NULL,'2024-09-27 21:28:26','2024-09-27 21:28:26','contraseña','2024-09-27 21:28:26','usuario2','COLABORADOR_HUMANO',NULL,NULL,NULL),(3,1,NULL,'2024-09-27 21:28:26','2024-09-27 21:28:26','Jirafa123!','2024-09-27 21:28:26','usuario3','TECNICO',NULL,NULL,NULL),(4,1,NULL,'2024-09-27 21:28:26','2024-09-27 21:28:26','contraseña','2024-09-27 21:28:26','usuario4','COLABORADOR_JURIDICO',NULL,NULL,NULL),(5,1,NULL,'2024-09-27 21:28:26','2024-09-27 21:28:26','contraseña','2024-09-27 21:28:26','usuario5','COLABORADOR_HUMANO',NULL,NULL,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vianda`
--

DROP TABLE IF EXISTS `vianda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vianda` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `calorias` int DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fechaDeCaducidad` date DEFAULT NULL,
  `fechaDeDonacion` date DEFAULT NULL,
  `peso` int DEFAULT NULL,
  `heladera_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjykc4x07j4yuf457bonqgmoks` (`heladera_id`),
  CONSTRAINT `FKjykc4x07j4yuf457bonqgmoks` FOREIGN KEY (`heladera_id`) REFERENCES `heladera` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vianda`
--

LOCK TABLES `vianda` WRITE;
/*!40000 ALTER TABLE `vianda` DISABLE KEYS */;
INSERT INTO `vianda` VALUES (5,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',500,'Arroz con pollo','FueEntregada','2025-10-27','2024-10-27',600,1,NULL,NULL,NULL),(6,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',600,'Empanadas','FueEntregada','2025-10-27','2024-10-27',400,1,NULL,NULL,NULL),(7,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',700,'Fideos','FueEntregada','2025-10-27','2024-10-27',500,2,NULL,NULL,NULL),(8,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26',550,'Milanesa con ensalada','FueEntregada','2025-10-27','2024-10-27',650,2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `vianda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitatecnico`
--

DROP TABLE IF EXISTS `visitatecnico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitatecnico` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estaActivo` tinyint(1) DEFAULT NULL,
  `fechaBaja` timestamp NULL DEFAULT NULL,
  `fechaAlta` timestamp NULL DEFAULT NULL,
  `fechaUltimaModificacion` timestamp NULL DEFAULT NULL,
  `comentario` text,
  `fechaVisita` date DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `solucionado` tinyint(1) DEFAULT NULL,
  `incidente_id` bigint DEFAULT NULL,
  `tecnico_id` bigint DEFAULT NULL,
  `creadoPor` bigint DEFAULT NULL,
  `editadoPor` bigint DEFAULT NULL,
  `eliminarPor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs1p6w1oy1as3ryauysoiu93fw` (`incidente_id`),
  KEY `FKpw4aju1ujxk6ttirdke52ugrp` (`tecnico_id`),
  CONSTRAINT `FKpw4aju1ujxk6ttirdke52ugrp` FOREIGN KEY (`tecnico_id`) REFERENCES `tecnico` (`id`),
  CONSTRAINT `FKs1p6w1oy1as3ryauysoiu93fw` FOREIGN KEY (`incidente_id`) REFERENCES `incidente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitatecnico`
--

LOCK TABLES `visitatecnico` WRITE;
/*!40000 ALTER TABLE `visitatecnico` DISABLE KEYS */;
INSERT INTO `visitatecnico` VALUES (3,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','Arreglado','2024-10-27',NULL,1,1,3,NULL,NULL,NULL),(4,1,NULL,'2024-10-27 21:28:26','2024-10-27 21:28:26','Arreglado','2024-10-27',NULL,1,2,2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `visitatecnico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-01 17:36:12
