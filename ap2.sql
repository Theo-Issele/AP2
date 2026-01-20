-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 20 jan. 2026 à 09:33
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ap2`
--

-- --------------------------------------------------------

--
-- Structure de la table `adherent`
--

CREATE TABLE `adherent` (
  `num` varchar(20) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `adherent`
--

INSERT INTO `adherent` (`num`, `nom`, `prenom`, `email`) VALUES
('1', 'Durant', 'Sophie', 'sophie.durand@example.com'),
('10', 'Simon', 'Nathan', 'nathan.simon@example.com'),
('1000000000222', 'qdfg', 'qsefq', 'fsdfgqdf'),
('12', 'test', 'test', 'test@test'),
('2', 'Martin', 'Lucas', 'lucas.martin@example.com'),
('3', 'Bernard', 'Emma', 'emma.bernard@example.com'),
('4', 'Petit', 'Hugo', 'hugo.petit@example.com'),
('5', 'Robert', 'Léa', 'lea.robert@example.com'),
('6', 'Richard', 'Paul', 'paul.richard@example.com'),
('7', 'Dubois', 'Chloé', 'chloe.dubois@example.com'),
('8', 'Moreau', 'Louis', 'louis.moreau@example.com'),
('9', 'Laurent', 'Camille', 'camille.laurent@example.com');

-- --------------------------------------------------------

--
-- Structure de la table `auteur`
--

CREATE TABLE `auteur` (
  `num` varchar(20) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `date_naissance` date DEFAULT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `auteur`
--

INSERT INTO `auteur` (`num`, `nom`, `prenom`, `date_naissance`, `description`) VALUES
('1', 'Ruiz Zafón', 'Carlos', '1964-09-25', 'Écrivain espagnol, auteur de romans à succès comme \"L’Ombre du vent\".'),
('10', 'Camus', 'Albert', '1913-11-07', 'Écrivain et philosophe français, prix Nobel de littérature.'),
('11', 'Corneille', 'Pierre', '1606-06-06', 'Dramaturge français classique, auteur du \"Cid\".'),
('12', 'Racine', 'Jean', '1639-12-22', 'Poète et dramaturge français, auteur de tragédies classiques.'),
('13', 'Zola', 'Émile', '1840-04-02', 'Romancier naturaliste français, auteur de \"Germinal\".'),
('14', 'Stendhal', 'Henri', '1783-01-23', 'Nom de plume de Marie-Henri Beyle, romancier français réaliste.'),
('15', 'Dumas', 'Alexandre', '1802-07-24', 'Grand écrivain français du XIXe siècle, auteur de romans d’aventures.'),
('16', 'Balzac', 'Honoré', '1799-05-20', 'Romancier et dramaturge français, auteur de \"La Comédie humaine\".'),
('17', 'Flaubert', 'Gustave', '1821-12-12', 'Écrivain français, auteur de \"Madame Bovary\".'),
('18', 'Sartre', 'Jean-Paul', '1905-06-21', 'Philosophe et écrivain français, figure de l’existentialisme.'),
('19', 'Proust', 'Marcel', '1871-07-10', 'Romancier français, auteur de \"À la recherche du temps perdu\".'),
('2', 'Audeguy', 'Stéphane', '1964-12-09', 'Écrivain français contemporain, auteur de \"La Théorie des nuages\".'),
('20', 'Molière', 'Jean-Baptiste', '1622-01-15', 'Dramaturge français, maître de la comédie classique.'),
('3', 'Barnes', 'Julian', '1946-01-19', 'Romancier britannique, lauréat du Man Booker Prize.'),
('4', 'Dubreuil', 'Jean-Claude', '1938-07-05', 'Auteur français de romans et récits contemporains.'),
('5', 'North', 'Claire', '1986-11-06', 'Nom de plume de Catherine Webb, auteure britannique de science-fiction.'),
('7', 'de Maupassant', 'Guy', '1850-08-05', 'Auteur français du XIXe siècle, maître de la nouvelle réaliste.'),
('8', 'de Saint-Exupéry', 'Antoine', '1900-06-29', 'Écrivain, poète et aviateur français, auteur du \"Petit Prince\".'),
('9', 'Hugo', 'Victor', '1802-02-26', 'Écrivain, poète et dramaturge français, figure majeure du romantisme.');

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE `livre` (
  `ISBN` varchar(20) NOT NULL,
  `titre` varchar(50) NOT NULL,
  `prix_unitaire` float NOT NULL,
  `emprunteur` varchar(20) DEFAULT NULL,
  `auteur` varchar(20) NOT NULL,
  `id_type` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`ISBN`, `titre`, `prix_unitaire`, `emprunteur`, `auteur`, `id_type`) VALUES
('123456789', 'Test', 16.25, '1', '5', 1),
('9780316498876', 'Sweet Harmony', 14.99, NULL, '5', NULL),
('9782060118190', 'Le Petit Prince', 8.9, '1', '8', NULL),
('9782070101114', 'Le rosier de Madame Husson', 10.5, NULL, '7', NULL),
('9782070101305', 'Germinal', 21, NULL, '13', NULL),
('9782070344635', 'La Théorie des nuages', 18, NULL, '2', NULL),
('9782070360427', 'L’Étranger', 11.5, NULL, '10', NULL),
('9782070368228', 'Bel-Ami', 13, NULL, '7', NULL),
('9782070409182', 'Notre-Dame de Paris', 22, NULL, '9', NULL),
('9782070409304', 'Andromaque', 9.8, NULL, '12', NULL),
('9782070409311', 'Phèdre', 9.8, NULL, '12', NULL),
('9782070409557', 'La Curée', 18.5, NULL, '13', NULL),
('9782070413066', 'La Chartreuse de Parme', 18.5, NULL, '14', 2),
('9782070413110', 'Les Misérables', 25, NULL, '9', 3),
('9782070419982', 'Le Rouge et le Noir', 19.5, NULL, '14', NULL),
('9782070462755', 'Le Cid', 9.8, NULL, '11', NULL),
('9782070612758', 'La Peste', 17.5, NULL, '10', NULL),
('9782246631613', 'L’Ombre du vent', 22.5, NULL, '1', NULL),
('9782715247079', 'La Seule Histoire', 20, NULL, '3', NULL),
('9782952942102', 'Un passé si présent', 16.5, NULL, '4', NULL),
('987654321', 'test', 100, '1', '3', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

CREATE TABLE `type` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `type`
--

INSERT INTO `type` (`id`, `libelle`) VALUES
(1, 'test'),
(2, 'testtest'),
(3, 'numerique'),
(4, 'e6');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adherent`
--
ALTER TABLE `adherent`
  ADD PRIMARY KEY (`num`);

--
-- Index pour la table `auteur`
--
ALTER TABLE `auteur`
  ADD PRIMARY KEY (`num`);

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`ISBN`),
  ADD KEY `fk_livre_adherent` (`emprunteur`) USING BTREE,
  ADD KEY `fk_livre_auteur` (`auteur`) USING BTREE,
  ADD KEY `fk_type_livre` (`id_type`) USING BTREE;

--
-- Index pour la table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `type`
--
ALTER TABLE `type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `livre`
--
ALTER TABLE `livre`
  ADD CONSTRAINT `fk_livre_adherent` FOREIGN KEY (`emprunteur`) REFERENCES `adherent` (`num`),
  ADD CONSTRAINT `fk_livre_auteur` FOREIGN KEY (`auteur`) REFERENCES `auteur` (`num`),
  ADD CONSTRAINT `fk_livre_type` FOREIGN KEY (`id_type`) REFERENCES `type` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
