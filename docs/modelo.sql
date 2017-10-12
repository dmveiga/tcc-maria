-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.2.9-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for tcc
CREATE DATABASE IF NOT EXISTS `tcc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tcc`;

-- Dumping structure for table tcc.dependente
CREATE TABLE IF NOT EXISTS `dependente` (
  `ID_DEPENDENTE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_FUNCIONARIO` int(11) DEFAULT NULL,
  `NOME` varchar(50) DEFAULT NULL,
  `DATA_NASCIMENTO` date DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `PARENTESCO` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`ID_DEPENDENTE`),
  KEY `FK_FUNCIONARIO_DEPENDENTE` (`ID_FUNCIONARIO`),
  CONSTRAINT `FK_FUNCIONARIO_DEPENDENTE` FOREIGN KEY (`ID_FUNCIONARIO`) REFERENCES `funcionario` (`ID_FUNCIONARIO`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table tcc.empresa
CREATE TABLE IF NOT EXISTS `empresa` (
  `ID_EMPRESA` int(11) NOT NULL AUTO_INCREMENT,
  `ID_ENDERECO` int(11) DEFAULT NULL,
  `NOME` varchar(50) DEFAULT NULL,
  `DATA_CRIACAO` date DEFAULT NULL,
  `NUM_FUNCIONARIOS` int(11) DEFAULT NULL,
  `LUCRO` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`ID_EMPRESA`),
  KEY `FK_ENDERECO_EMPRESA` (`ID_ENDERECO`),
  CONSTRAINT `FK_ENDERECO_EMPRESA` FOREIGN KEY (`ID_ENDERECO`) REFERENCES `endereco` (`ID_ENDERECO`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table tcc.endereco
CREATE TABLE IF NOT EXISTS `endereco` (
  `ID_ENDERECO` int(11) NOT NULL AUTO_INCREMENT,
  `PAIS` varchar(50) DEFAULT NULL,
  `ESTADO` char(2) DEFAULT NULL,
  `CIDADE` varchar(50) DEFAULT NULL,
  `BAIRRO` varchar(50) DEFAULT NULL,
  `RUA` varchar(50) DEFAULT NULL,
  `NUMERO` int(11) DEFAULT NULL,
  `CEP` char(8) DEFAULT NULL,
  PRIMARY KEY (`ID_ENDERECO`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table tcc.funcao
CREATE TABLE IF NOT EXISTS `funcao` (
  `ID_FUNCAO` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) NOT NULL DEFAULT '0',
  `DESCRICAO` text DEFAULT NULL,
  PRIMARY KEY (`ID_FUNCAO`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table tcc.funcionario
CREATE TABLE IF NOT EXISTS `funcionario` (
  `ID_FUNCIONARIO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_EMPRESA` int(11) DEFAULT NULL,
  `ID_FUNCAO` int(11) DEFAULT NULL,
  `NOME` varchar(50) DEFAULT NULL,
  `DATA_NASCIMENTO` date DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `ATIVO` tinyint(1) DEFAULT NULL,
  `SALARIO` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`ID_FUNCIONARIO`),
  KEY `FK_EMPRESA_FUNCIONARIO` (`ID_EMPRESA`),
  KEY `FK_FUNCAO_FUNCIONARIO` (`ID_FUNCAO`),
  CONSTRAINT `FK_EMPRESA_FUNCIONARIO` FOREIGN KEY (`ID_EMPRESA`) REFERENCES `empresa` (`ID_EMPRESA`) ON DELETE CASCADE,
  CONSTRAINT `FK_FUNCAO_FUNCIONARIO` FOREIGN KEY (`ID_FUNCAO`) REFERENCES `funcao` (`ID_FUNCAO`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;