CREATE DATABASE  IF NOT EXISTS `projetoWeb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `projetoWeb`;
-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: projetoWeb
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Marcos','Rua A','899655521'),(2,'Linus','Rua L','988080800');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conta`
--

DROP TABLE IF EXISTS `conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(45) NOT NULL,
  `saldo` double NOT NULL,
  `situacao` varchar(45) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idTipoConta` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Conta_cliente1_idx` (`idCliente`),
  KEY `fk_Conta_tipoConta1_idx` (`idTipoConta`),
  CONSTRAINT `fk_Conta_cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Conta_tipoConta1` FOREIGN KEY (`idTipoConta`) REFERENCES `tipoConta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta`
--

LOCK TABLES `conta` WRITE;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
INSERT INTO `conta` VALUES (2,'288125',5122.36,'ativo',1,1);
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoaFisica`
--

DROP TABLE IF EXISTS `pessoaFisica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoaFisica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(45) NOT NULL,
  `nomeMae` varchar(45) NOT NULL,
  `nomePai` varchar(45) NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pessoaFisica_cliente_idx` (`idCliente`),
  CONSTRAINT `fk_pessoaFisica_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoaFisica`
--

LOCK TABLES `pessoaFisica` WRITE;
/*!40000 ALTER TABLE `pessoaFisica` DISABLE KEYS */;
INSERT INTO `pessoaFisica` VALUES (1,'11122233354','Maria','Adão',1);
/*!40000 ALTER TABLE `pessoaFisica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoaJuridica`
--

DROP TABLE IF EXISTS `pessoaJuridica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoaJuridica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpnj` varchar(45) NOT NULL,
  `nomeFantasia` varchar(45) NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pessoaJuridica_cliente1_idx` (`idCliente`),
  CONSTRAINT `fk_pessoaJuridica_cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoaJuridica`
--

LOCK TABLES `pessoaJuridica` WRITE;
/*!40000 ALTER TABLE `pessoaJuridica` DISABLE KEYS */;
INSERT INTO `pessoaJuridica` VALUES (1,'10010233','OS SA',2);
/*!40000 ALTER TABLE `pessoaJuridica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguro`
--

DROP TABLE IF EXISTS `seguro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seguro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(45) NOT NULL,
  `valor` double NOT NULL,
  `situacao` varchar(45) NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_seguro_cliente1_idx` (`idCliente`),
  CONSTRAINT `fk_seguro_cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguro`
--

LOCK TABLES `seguro` WRITE;
/*!40000 ALTER TABLE `seguro` DISABLE KEYS */;
INSERT INTO `seguro` VALUES (1,'122578',1500.63,'ativo',2);
/*!40000 ALTER TABLE `seguro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoConta`
--

DROP TABLE IF EXISTS `tipoConta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoConta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoConta`
--

LOCK TABLES `tipoConta` WRITE;
/*!40000 ALTER TABLE `tipoConta` DISABLE KEYS */;
INSERT INTO `tipoConta` VALUES (1,'corrente'),(2,'poupança');
/*!40000 ALTER TABLE `tipoConta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-12 15:45:48
