-- Adminer 4.8.1 MySQL 11.1.2-MariaDB-1:11.1.2+maria~ubu2204 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

INSERT INTO `atelier` (`id`, `titre`, `description`, `theme`, `placeDispo`, `image`, `debut`, `fin`) VALUES
(1,	'Italien',	'pate',	'IT',	20,	'https://s1.1zoom.me/b4844/104/Liguria_Cinque_Terre_park_Italy_Houses_Coast_523833_1920x1080.jpg',	'2024-02-22 09:00:00',	'2024-02-22 18:45:00'),
(2,	'Français',	'baguette',	'FR',	15,	'https://s1.1zoom.me/b8048/487/Sky_Evening_France_Eiffel_Tower_Paris_From_above_520603_1920x1080.jpg',	'2024-03-22 09:00:00',	'2024-03-22 12:00:00'),
(3,	'Amérique du Sud',	'sec',	'MEX',	10,	'https://www.borispatagonia.com/images/mag/les-andes-patagonie-chili-amerique-du-sud.jpg',	'2024-03-11 09:00:00',	'2024-04-22 15:00:00'),
(4,	'Japonais',	'udon',	'JP',	25,	'https://s1.1zoom.me/big7/850/Mountains_Pagodas_Japan_Mount_Fuji_Mount_Fuji_576681_1920x1080.jpg',	'2024-02-22 09:00:00',	'2024-02-22 10:00:00'),
(5,	'Orientale',	'patepate',	'OR',	30,	'https://i.pinimg.com/originals/d7/c6/f7/d7c6f739c55a93b2b1deccf927bddeb6.jpg',	'2024-02-24 09:00:00',	'2024-02-25 09:00:00'),
(6,	'Grecque',	'souflaki',	'GR',	20,	'https://s1.1zoom.me/b5050/712/Greece_Coast_Sea_Houses_501550_1920x1080.jpg',	'2024-02-22 09:00:00',	'2024-02-23 12:00:00');

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `admin`, `email`) VALUES
(1,	'Alice', 'thunderberg',	1,	'alice@mail.com'),
(2,	'Bob', 'thunderberg',	0,	'bob@mail.com'),
(3,	'Charlie', 'thunderberg',	0,	'charlie@mail.com'),
(4,	'Diana', 'thunderberg',	1,	'diana@mail.com'),
(5,	'Eve', 'thunderberg',	0,	'eve@mail.com'),
(6,	'un', 'thunderberg',	0,	'ultranigga@mail.com');

INSERT INTO `voeux` (`candidat_id`, `atelier_id`, `ordrePrio`) VALUES
(6,	1,	1),
(6,	4,	2),
(6,	2,	3),
(2,	1,	1),
(3,	2,	2),
(1,	3,	1),
(4,	4,	3),
(5,	5,	2);

-- 2024-02-22 16:48:29
