-- Adminer 4.8.1 MySQL 11.1.2-MariaDB-1:11.1.2+maria~ubu2204 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `atelier`;
CREATE TABLE `atelier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `theme` varchar(255) DEFAULT NULL,
  `placeDispo` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `debut` datetime NOT NULL,
  `fin` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `voeux`;
CREATE TABLE `voeux` (
  `candidat_id` int(11) DEFAULT NULL,
  `atelier_id` int(11) DEFAULT NULL,
  `ordrePrio` int(11) DEFAULT NULL,
  KEY `candidat_id` (`candidat_id`),
  KEY `atelier_id` (`atelier_id`),
  CONSTRAINT `voeux_ibfk_1` FOREIGN KEY (`candidat_id`) REFERENCES `utilisateur` (`id`),
  CONSTRAINT `voeux_ibfk_2` FOREIGN KEY (`atelier_id`) REFERENCES `atelier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- 2024-02-22 16:48:11
