-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 28, 2019 at 02:56 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestionecole`
--

-- --------------------------------------------------------

--
-- Table structure for table `annee`
--

DROP TABLE IF EXISTS `annee`;
CREATE TABLE IF NOT EXISTS `annee` (
  `id_annee` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_annee`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bulletin`
--

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE IF NOT EXISTS `bulletin` (
  `id_bulletin` int(11) NOT NULL AUTO_INCREMENT,
  `appreciation` text,
  `id_trimestre` int(11) NOT NULL,
  `id_inscription` int(11) NOT NULL,
  PRIMARY KEY (`id_bulletin`),
  KEY `#trimestre_bulletin` (`id_trimestre`),
  KEY `#bulletin_inscrit` (`id_inscription`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `id_classe` int(11) NOT NULL AUTO_INCREMENT,
  `nom` text NOT NULL,
  `niveau` text NOT NULL,
  `annee_classe` int(11) NOT NULL,
  PRIMARY KEY (`id_classe`),
  KEY `#anneeclasse` (`annee_classe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `detailbulletin`
--

DROP TABLE IF EXISTS `detailbulletin`;
CREATE TABLE IF NOT EXISTS `detailbulletin` (
  `id_detailbulletin` int(11) NOT NULL AUTO_INCREMENT,
  `appreciation` text,
  `id_enseignement` int(11) NOT NULL,
  `id_bulletin` int(11) NOT NULL,
  PRIMARY KEY (`id_detailbulletin`),
  KEY `#detailbulletin_enseignement` (`id_enseignement`),
  KEY `#detailbulletin_bulletin` (`id_bulletin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `enseignement`
--

DROP TABLE IF EXISTS `enseignement`;
CREATE TABLE IF NOT EXISTS `enseignement` (
  `id_enseignement` int(11) NOT NULL AUTO_INCREMENT,
  `nom` text NOT NULL,
  `id_enseignant` int(11) NOT NULL,
  `id_classe` int(11) NOT NULL,
  PRIMARY KEY (`id_enseignement`),
  KEY `#enseignement _enseignant` (`id_enseignant`),
  KEY `#classe_enseignement` (`id_classe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `id_evaluation` int(11) NOT NULL AUTO_INCREMENT,
  `note` int(11) NOT NULL,
  `appreciation_evaluation` text,
  `id_detailbulletin` int(11) NOT NULL,
  PRIMARY KEY (`id_evaluation`),
  KEY `#evaluation_detailbulletin` (`id_detailbulletin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `id_inscription` int(11) NOT NULL AUTO_INCREMENT,
  `id_eleve_inscrit` int(11) NOT NULL,
  `id_classe_eleve` int(11) NOT NULL,
  PRIMARY KEY (`id_inscription`),
  KEY `#id_eleve_inscrit` (`id_eleve_inscrit`),
  KEY `#id_classe_eleve` (`id_classe_eleve`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id_personne` int(11) NOT NULL AUTO_INCREMENT,
  `nom` text NOT NULL,
  `prenom` text NOT NULL,
  `est_enseignant` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_personne`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `trimestre`
--

DROP TABLE IF EXISTS `trimestre`;
CREATE TABLE IF NOT EXISTS `trimestre` (
  `id_trimestre` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  `moisdebut` int(11) NOT NULL,
  `moisfin` int(11) NOT NULL,
  `anneedebut` int(11) NOT NULL,
  `anneefin` int(11) NOT NULL,
  PRIMARY KEY (`id_trimestre`),
  KEY `#anneedebut` (`anneedebut`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bulletin`
--
ALTER TABLE `bulletin`
  ADD CONSTRAINT `#bulletin_inscrit` FOREIGN KEY (`id_inscription`) REFERENCES `inscription` (`id_eleve_inscrit`),
  ADD CONSTRAINT `#trimestre_bulletin` FOREIGN KEY (`id_trimestre`) REFERENCES `trimestre` (`id_trimestre`);

--
-- Constraints for table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `#anneeclasse` FOREIGN KEY (`annee_classe`) REFERENCES `annee` (`id_annee`);

--
-- Constraints for table `detailbulletin`
--
ALTER TABLE `detailbulletin`
  ADD CONSTRAINT `#detailbulletin_bulletin` FOREIGN KEY (`id_bulletin`) REFERENCES `bulletin` (`id_bulletin`),
  ADD CONSTRAINT `#detailbulletin_enseignement` FOREIGN KEY (`id_enseignement`) REFERENCES `enseignement` (`id_enseignement`);

--
-- Constraints for table `enseignement`
--
ALTER TABLE `enseignement`
  ADD CONSTRAINT `#classe_enseignement` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`),
  ADD CONSTRAINT `#enseignement _enseignant` FOREIGN KEY (`id_enseignant`) REFERENCES `personne` (`id_personne`);

--
-- Constraints for table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `#evaluation_detailbulletin` FOREIGN KEY (`id_detailbulletin`) REFERENCES `detailbulletin` (`id_detailbulletin`);

--
-- Constraints for table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `#id_classe_eleve` FOREIGN KEY (`id_classe_eleve`) REFERENCES `classe` (`id_classe`),
  ADD CONSTRAINT `#id_eleve_inscrit` FOREIGN KEY (`id_eleve_inscrit`) REFERENCES `personne` (`id_personne`);

--
-- Constraints for table `trimestre`
--
ALTER TABLE `trimestre`
  ADD CONSTRAINT `#anneedebut` FOREIGN KEY (`anneedebut`) REFERENCES `annee` (`id_annee`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
