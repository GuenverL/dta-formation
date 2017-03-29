CREATE TABLE `pizza` (
  `id` int(11) auto_increment NOT NULL,
  `code` varchar(4) NOT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `categorie` varchar(255) check (`categorie` in('Viande','Sans_Viande','Poisson'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;