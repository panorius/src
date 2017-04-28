-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Ven 28 Avril 2017 à 10:37
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projetoffresstage`
--

-- --------------------------------------------------------

--
-- Structure de la table `cv`
--

CREATE TABLE `cv` (
  `idCV` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  `image` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

CREATE TABLE `entreprise` (
  `idEntreprise` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `numRue` varchar(50) NOT NULL,
  `ville` varchar(10) NOT NULL,
  `cPostal` int(50) NOT NULL,
  `mail` varchar(30) NOT NULL,
  `tel` varchar(10) NOT NULL,
  `secteur` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `entreprise`
--

INSERT INTO `entreprise` (`idEntreprise`, `idUtilisateur`, `nom`, `numRue`, `ville`, `cPostal`, `mail`, `tel`, `secteur`) VALUES
(1, 3, 'JCorp', '6 rue de verdun', 'Brunoy', 91800, 'j@', '0169438876', 'Informatique');

-- --------------------------------------------------------

--
-- Structure de la table `listoffres`
--

CREATE TABLE `listoffres` (
  `idUtilisateur` int(11) NOT NULL,
  `idOffre` int(11) NOT NULL,
  `idEntreprise` int(11) NOT NULL,
  `validation` varchar(30) DEFAULT 'En_Attente'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `listoffres`
--

INSERT INTO `listoffres` (`idUtilisateur`, `idOffre`, `idEntreprise`, `validation`) VALUES
(1, 1, 1, '"En_Attente"'),
(1, 2, 1, '"En_Attente"'),
(1, 3, 1, 'En_Attente');

-- --------------------------------------------------------

--
-- Structure de la table `offres`
--

CREATE TABLE `offres` (
  `idOffre` int(11) NOT NULL,
  `idEntreprise` int(11) NOT NULL,
  `NomEnt` varchar(30) NOT NULL,
  `Domaine` varchar(50) NOT NULL,
  `Libelle` varchar(255) NOT NULL,
  `Date` date NOT NULL,
  `Duree` int(11) NOT NULL,
  `Descriptif` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `offres`
--

INSERT INTO `offres` (`idOffre`, `idEntreprise`, `NomEnt`, `Domaine`, `Libelle`, `Date`, `Duree`, `Descriptif`) VALUES
(1, 1, 'JCorp', 'Informatique', 'Recherche Developpeur', '2017-05-01', 2, 'Wiboo est une agence digitale qui couvre l\'ensemble des besoins en communication numérique des entreprises (cahier des charges, création de sites e-commerce, vitrines, extranet, web app, référencement naturel, campagne d\'emailing, inbound marketing, optimisation des taux de conversion...). L\'agence est plus particulièrement experte en stratégies de génération de trafic.\n    Elle compte parmi ses clients aussi bien des grands comptes tels qu\'Auchan ou Casterman que des TPE au fort développement.\nMission\n\n    Nous recherchons à toute période de l\'année un(e) stagiaire développeur(se)/intégrateur(trice) web ayant déjà une bonne expérience dans l\'intégration de sites Internet.\n\n    Les principales missions confiées au stagiaire sont les suivantes :\n\n    Développement de nouveaux sites (Wordpress / Prestashop essentiellement)\n    Développement et maintenance des sites existants\n    Intégration HTML / CSS / JavaScript ( + Responsive )\n\n    PROFIL RECHERCHÉ\n\n    Dernier niveau d\'études validé avec diplôme : Bac+2\n    Une mention Bien ou Très Bien au Bac est souhaitée.\n    Vous possédez une culture web / mobile\n    Première expérience en développement de site Web.\n\n    COMPÉTENCES REQUISES\n\n    PHP / MYSQL\n    HTML5 / CSS3\n    JavaScript\n    Jquery\n\n    QUALITÉS REQUISES\n\n    Rigueur, autonomie, esprit d\'équipe, sens de l\'organisation.\n\n    Sont appréciées : connaissances WordPress et Prestashop.\n\n    Le stage est obligatoirement conventionné ou en alternance.\n\n    DUREE MINIMUM : 2 mois\n\n    DUREE SOUHAITEE : 4-6 mois\n\n    DEMARRAGE : 2 Novembre\n\n        Secteur : Internet Multimédia\n        Fonction : Programmeur / développeur\n        Démarrage : Avril\n        Durée : Supérieure à 2 mois\n        Type de contrat : Stage conventionné\n        Localisation : Val-de-marne (94)\n        Rémunération : De 500 à 800 Euros\n\nProfil recherché\n\n    Pour mener à bien cette mission, il est souhaitable que vous ayez un niveau d\'étude au minimum Bac+2 en Autre.\n\n    Vous devez avoir comme langue maternelle : Français.\n\n    Le permis voiture n\'est pas indispensable.\n'),
(2, 1, 'JCorp', 'Informatique', 'Recherche Stagiaire', '2017-06-20', 6, '    AJstage est LE service de recrutement spécialisé dans la recherche de stagiaires, apprentis et jeunes diplômés.Véritable atout dans votre recherche, AJstage sera le lien entre vous et les entreprises. Facile, rapide et gratuit, ce service est une solution pour trouver son stage ou son alternance.\nMission\n\n    Attention, aucune candidature ne sera traitée hors du lien suivant: http://ajstage.com/offre/Ingenieur-d-affaires-chez-ASTELIS\n\n\n    Notre vocation première est le service aux entreprises sur l\'ensemble de l\'architecture Systèmes & Réseaux en mode classique ou en mode Cloud Computing\n\n    Astelis se positionne comme l’un des partenaires de référence sur les infrastructures systèmes et réseaux (architecture et SAN) et le Cloud Computing.\n\n    « Optimiser votre outil informatique pour qu’il soit réellement un outil au service des performances de l’entreprise. »\n\n    Spécialisée dans des domaines techniques ciblés, Astelis intervient principalement dans les domaines de la conception, la réalisation, l’optimisation et l’administration des infrastructures des systèmes de communication de l’entreprise en mode classique ou en mode Cloud.\n\n    Forte de son expérience dans le domaine de l’infrastructure Systèmes & Réseaux depuis plus de 15 ans, Astelis a créé Astelis Cloud Computing, spécialisée dans le Cloud afin de proposer son expertise Systèmes & Réseaux au travers du Cloud.\n\n\n    Dans le cadre de notre activité, la société Astelis recrute un ingénieur d’affaires en stage à partir de d’avril 2017 pour une durée de 4 à 6 mois.\n\n    Sous la responsabilité du responsable commerciale, vous développez et fidélisez votre clientèle composée d\'entreprises du middle-market et de grands comptes.\n\n    Votre fonction repose sur les actions suivantes :\n\n    1 - Développement d’affaires (prospects)\n\n    2 -Organisation de la prospection : chasse, détection de projets, rendez-vous et suivi des contacts\n\n    3 - Rédaction des propositions commerciales, négociation et finalisation de l’offre\n\n\n    Les principaux atouts pour réussir à ce poste sont : le goût du challenge, le dynamisme, une bonne aisance relationnelle, un tempérament chasseur et idéalement de bonnes connaissances sur les technologies informatiques.\n\n    La culture d’entreprise repose sur des valeurs d’honnêteté, de transparence et d’implication de tous les acteurs de l’entreprise.\n\n\n    Possibilité d’embauche en fin de stage.\n\n    Le profil recherché\n    De formation BAC+4/+5 orientée Ingénieur d’Affaires\n    Capacités d’écoute\n    Intérêt pour les prestations de haut niveau technique\n    Esprit d’équipe\n\n        Secteur : Conseil, Audit\n        Fonction : Informatique\n        Démarrage : Mai\n        Durée : Supérieure à 2 mois\n        Type de contrat : Stage conventionné\n        Rémunération : Plus de 800 Euros\n\nProfil recherché\n\n    Pour mener à bien cette mission, il est souhaitable que vous ayez un niveau d\'étude au minimum Bac+5 et plus en Ecole d\'Ingénieurs.\n\n    Le permis voiture n\'est pas indispensable.\n'),
(3, 1, 'JCorp', 'bouzdqoilj', 'lqfoilsnl', '2017-04-28', 4, 'emosihdwl');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idUtilisateur` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `mdp` varchar(120) NOT NULL,
  `mail` varchar(50) CHARACTER SET utf8 NOT NULL,
  `role` varchar(40) NOT NULL,
  `entCreer` tinyint(1) NOT NULL DEFAULT '0',
  `idCV` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `nom`, `mdp`, `mail`, `role`, `entCreer`, `idCV`) VALUES
(1, 'm', '202cb962ac59075b964b07152d234b70', 'm@', '1', 0, NULL),
(3, 'j', '202cb962ac59075b964b07152d234b70', 'j@', '2', 1, NULL),
(4, 'a', '202cb962ac59075b964b07152d234b70', 'a@', '3', 0, NULL);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `cv`
--
ALTER TABLE `cv`
  ADD PRIMARY KEY (`idCV`),
  ADD KEY `idUtilisateur` (`idUtilisateur`);

--
-- Index pour la table `entreprise`
--
ALTER TABLE `entreprise`
  ADD PRIMARY KEY (`idEntreprise`),
  ADD UNIQUE KEY `nom` (`nom`),
  ADD KEY `idUtilisateur` (`idUtilisateur`);

--
-- Index pour la table `listoffres`
--
ALTER TABLE `listoffres`
  ADD KEY `idUtilisateur` (`idUtilisateur`,`idOffre`,`idEntreprise`),
  ADD KEY `idEntreprise` (`idEntreprise`),
  ADD KEY `idOffre` (`idOffre`);

--
-- Index pour la table `offres`
--
ALTER TABLE `offres`
  ADD PRIMARY KEY (`idOffre`),
  ADD KEY `idEntreprise` (`idEntreprise`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`),
  ADD UNIQUE KEY `mail` (`mail`),
  ADD UNIQUE KEY `idCV` (`idCV`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `entreprise`
--
ALTER TABLE `entreprise`
  MODIFY `idEntreprise` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `offres`
--
ALTER TABLE `offres`
  MODIFY `idOffre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `cv`
--
ALTER TABLE `cv`
  ADD CONSTRAINT `cv_ibfk_1` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Contraintes pour la table `entreprise`
--
ALTER TABLE `entreprise`
  ADD CONSTRAINT `entreprise_ibfk_1` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Contraintes pour la table `listoffres`
--
ALTER TABLE `listoffres`
  ADD CONSTRAINT `listoffres_ibfk_1` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `listoffres_ibfk_2` FOREIGN KEY (`idEntreprise`) REFERENCES `entreprise` (`idEntreprise`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `listoffres_ibfk_3` FOREIGN KEY (`idOffre`) REFERENCES `offres` (`idOffre`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Contraintes pour la table `offres`
--
ALTER TABLE `offres`
  ADD CONSTRAINT `offres_ibfk_1` FOREIGN KEY (`idEntreprise`) REFERENCES `entreprise` (`idEntreprise`) ON DELETE CASCADE ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
