-- Adminer 4.8.1 MySQL 11.1.2-MariaDB-1:11.1.2+maria~ubu2204 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

INSERT INTO `atelier` (`id`, `titre`, `description`, `theme`, `placeDispo`, `image`, `debut`, `fin`) VALUES
(1,	'Italien',	'pate',	'IT',	20,	'https://example.com/image1.jpg',	'2003-05-10 09:00:00',	'2024-02-22 18:45:00'),
(2,	'Français',	'baguette',	'FR',	15,	'https://example.com/image2.jpg',	'0000-00-00 00:00:00',	'0000-00-00 00:00:00'),
(3,	'Amérique du Sud',	'sec',	'MEX',	10,	'https://example.com/image3.jpg',	'0000-00-00 00:00:00',	'0000-00-00 00:00:00'),
(4,	'Japonais',	'udon',	'JP',	25,	'https://example.com/image4.jpg',	'0000-00-00 00:00:00',	'0000-00-00 00:00:00'),
(5,	'Orientale',	'patepate',	'OR',	30,	'https://example.com/image5.jpg',	'0000-00-00 00:00:00',	'0000-00-00 00:00:00'),
(6,	'Grecque',	'souflaki',	'GR',	20,	'https://example.com/image6.jpg',	'0000-00-00 00:00:00',	'0000-00-00 00:00:00');

INSERT INTO `utilisateur` (`id`, `nom`, `admin`, `email`) VALUES
(1,	'Alice',	1,	'alice@mail.com'),
(2,	'Bob',	0,	'bob@mail.com'),
(3,	'Charlie',	0,	'charlie@mail.com'),
(4,	'Diana',	1,	'diana@mail.com'),
(5,	'Eve',	0,	'eve@mail.com'),
(6,	'un',	0,	'ultranigga@mail.com');

INSERT INTO `voeux` (`candidat_id`, `atelier_id`, `ordrePrio`) VALUES
(6,	1,	1),
(6,	4,	2),
(6,	2,	3),
(2,	1,	1),
(3,	2,	2),
(1,	3,	1),
(4,	4,	3),
(5,	5,	2);

-- 2024-02-22 12:59:13
