-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: firesale
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cidade` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `uf_codigo` bigint(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_jhjdeckqr7s71jor6uksk2y6r` (`uf_codigo`),
  CONSTRAINT `FK_jhjdeckqr7s71jor6uksk2y6r` FOREIGN KEY (`uf_codigo`) REFERENCES `estado` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `codCliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpfCliente` varchar(15) DEFAULT NULL,
  `emailCliente` varchar(100) DEFAULT NULL,
  `nomeCliente` varchar(100) DEFAULT NULL,
  `telCliente` varchar(15) DEFAULT NULL,
  `cdEndereco` bigint(20) DEFAULT NULL,
  `user_cdUsuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codCliente`),
  KEY `FK_17500r8d86uxrh5i2k3n4sxfs` (`cdEndereco`),
  KEY `FK_p4wpy8ouhbk8k1lky43csydub` (`user_cdUsuario`),
  CONSTRAINT `FK_17500r8d86uxrh5i2k3n4sxfs` FOREIGN KEY (`cdEndereco`) REFERENCES `endereco` (`cdEndereco`),
  CONSTRAINT `FK_p4wpy8ouhbk8k1lky43csydub` FOREIGN KEY (`user_cdUsuario`) REFERENCES `usuario` (`cdUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (2,'888.888.888-88','aaa@aaa.com','Renan','(77)77777-7777',2,1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `cdEndereco` bigint(20) NOT NULL AUTO_INCREMENT,
  `bairroEndereco` varchar(100) DEFAULT NULL,
  `cepEndereco` varchar(10) DEFAULT NULL,
  `cidEndereco` varchar(100) DEFAULT NULL,
  `nuLogradouro` int(11) DEFAULT NULL,
  `ruaEndereco` varchar(100) DEFAULT NULL,
  `cdUf_codigo` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cdEndereco`),
  KEY `FK_e914ue8djk4hf78xqhtvjjk87` (`cdUf_codigo`),
  CONSTRAINT `FK_e914ue8djk4hf78xqhtvjjk87` FOREIGN KEY (`cdUf_codigo`) REFERENCES `estado` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'Humaitá','88704-440','Tubarão',445,'Rua Rubens Faraco',24),(2,'Humaitá','88704-440','Tubarão',445,'Rua Rubens Faraco',24);
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `sigla` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'Acre','AC'),(2,'Alagoas','AL'),(3,'Amazonas','AM'),(4,'Amapá','AP'),(5,'Bahia','BA'),(6,'Ceará','CE'),(7,'Distrito Federal','DF'),(8,'Espírito Santo','ES'),(9,'Goiás','GO'),(10,'Maranhão','MA'),(11,'Minas Gerais','MG'),(12,'Mato Grosso do Sul','MS'),(13,'Mato Grosso','MT'),(14,'Pará','PA'),(15,'Paraíba','PB'),(16,'Pernambuco','PE'),(17,'Piauí','PI'),(18,'Paraná','PR'),(19,'Rio de Janeiro','RJ'),(20,'Rio Grande do Norte','RN'),(21,'Rondônia','RO'),(22,'Roraima','RR'),(23,'Rio Grande do Sul','RS'),(24,'Santa Catarina','SC'),(25,'Sergipe','SE'),(26,'São Paulo','SP'),(27,'Tocantins','TO');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemvenda`
--

DROP TABLE IF EXISTS `itemvenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemvenda` (
  `seqItem` int(11) NOT NULL AUTO_INCREMENT,
  `qtdItem` int(11) DEFAULT NULL,
  `vlrItem` double DEFAULT NULL,
  `codProduto_codProduto` bigint(20) DEFAULT NULL,
  `codVenda_cod_venda` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`seqItem`),
  KEY `FK_77eepyodaosh92hx0u1jfjmot` (`codProduto_codProduto`),
  KEY `FK_qtg2la3tbed3av1sl33qeioxv` (`codVenda_cod_venda`),
  CONSTRAINT `FK_77eepyodaosh92hx0u1jfjmot` FOREIGN KEY (`codProduto_codProduto`) REFERENCES `produto` (`codProduto`),
  CONSTRAINT `FK_qtg2la3tbed3av1sl33qeioxv` FOREIGN KEY (`codVenda_cod_venda`) REFERENCES `venda` (`cod_venda`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemvenda`
--

LOCK TABLES `itemvenda` WRITE;
/*!40000 ALTER TABLE `itemvenda` DISABLE KEYS */;
INSERT INTO `itemvenda` VALUES (2,2,6.58,2,8),(4,3,23.700000000000003,3,6),(5,2,15.8,3,7),(6,2,13.7,1,8),(7,2,15.8,3,9),(8,2,13.7,1,10),(9,2,13.7,1,11),(10,2,13.7,1,12),(11,2,13.7,1,13),(14,4,13.16,2,15),(15,3,23.700000000000003,3,15),(16,2,13.7,1,16),(17,2,13.7,1,16);
/*!40000 ALTER TABLE `itemvenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `codProduto` bigint(20) NOT NULL AUTO_INCREMENT,
  `desProduto` varchar(1000) DEFAULT NULL,
  `nmProduto` varchar(10) DEFAULT NULL,
  `qtdProduto` int(11) DEFAULT NULL,
  `vlrProduto` double DEFAULT NULL,
  PRIMARY KEY (`codProduto`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'coca 2,5L','Coca cola',300,6.85),(2,'Fanta 500ml','Fanta',400,3.29),(3,'Pepsi 3,3L','Pepsi',250,7.9),(4,'Tang maracujá 30g','Tang',1500,0.95),(5,'Sorvete kibom 1L','Sorvete',150,15.9),(6,'teste','teste',77,77);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `cdUsuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `alteraCli` bit(1) DEFAULT NULL,
  `comprar` bit(1) DEFAULT NULL,
  `dsLogin` varchar(100) DEFAULT NULL,
  `dsSenha` varchar(20) DEFAULT NULL,
  `prodAlterar` bit(1) DEFAULT NULL,
  `tpUsuario` char(1) DEFAULT NULL,
  PRIMARY KEY (`cdUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,NULL,'','renan','renan',NULL,'C');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `cod_venda` bigint(20) NOT NULL AUTO_INCREMENT,
  `dat_venda` datetime DEFAULT NULL,
  `vlr_venda` double DEFAULT NULL,
  `cod_cliente_codCliente` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cod_venda`),
  KEY `FK_oy74onto34v8cfct0a02i62yj` (`cod_cliente_codCliente`),
  CONSTRAINT `FK_oy74onto34v8cfct0a02i62yj` FOREIGN KEY (`cod_cliente_codCliente`) REFERENCES `cliente` (`codCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (1,NULL,NULL,NULL),(2,NULL,NULL,NULL),(3,'2017-05-27 14:42:37',NULL,NULL),(4,'2017-05-27 14:45:52',NULL,NULL),(5,'2017-05-27 15:09:55',NULL,NULL),(6,'2017-05-27 15:12:46',NULL,NULL),(7,'2017-05-27 15:16:33',NULL,NULL),(8,'2017-05-27 15:28:59',NULL,NULL),(9,'2017-05-27 15:31:00',NULL,NULL),(10,'2017-05-27 15:32:45',NULL,NULL),(11,'2017-05-27 15:34:28',NULL,NULL),(12,'2017-05-27 15:38:06',NULL,NULL),(13,'2017-05-27 15:41:09',NULL,NULL),(14,'2017-05-27 15:43:25',NULL,NULL),(15,'2017-05-28 17:17:08',NULL,NULL),(16,'2017-05-28 17:30:54',NULL,NULL);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-28 18:16:19
