CREATE TABLE `pizza` (
  `id` int(11) auto_increment NOT NULL,
  `code` varchar(4) NOT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `categorie` varchar(255) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;