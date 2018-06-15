-- phpMyAdmin SQL Dump
-- version 4.4.7
-- http://www.phpmyadmin.net
--
-- Vært: localhost
-- Genereringstid: 15. 06 2018 kl. 02:32:27
-- Serverversion: 5.5.47-MariaDB
-- PHP-version: 5.5.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `CDIOFinal`
--

-- --------------------------------------------------------

--
-- Struktur-dump for tabellen `commodity`
--

CREATE TABLE IF NOT EXISTS `commodity` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `supplierID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Data dump for tabellen `commodity`
--

INSERT INTO `commodity` (`id`, `name`, `supplierID`) VALUES
(1, 'Hoeretelefoner', 1),
(2, 'Mobil', 2),
(3, 'Vand', 3);

-- --------------------------------------------------------

--
-- Struktur-dump for tabellen `commodityBatch`
--

CREATE TABLE IF NOT EXISTS `commodityBatch` (
  `id` int(11) NOT NULL,
  `commodityID` int(11) NOT NULL,
  `amount` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Data dump for tabellen `commodityBatch`
--

INSERT INTO `commodityBatch` (`id`, `commodityID`, `amount`) VALUES
(1, 1, 40),
(2, 2, 30),
(3, 3, 50);

-- --------------------------------------------------------

--
-- Struktur-dump for tabellen `productBatch`
--

CREATE TABLE IF NOT EXISTS `productBatch` (
  `id` int(11) NOT NULL,
  `recipeID` int(11) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Data dump for tabellen `productBatch`
--

INSERT INTO `productBatch` (`id`, `recipeID`, `status`) VALUES
(1, 1, 0),
(2, 2, 2),
(3, 1, 0);

-- --------------------------------------------------------

--
-- Struktur-dump for tabellen `productBatchComponent`
--

CREATE TABLE IF NOT EXISTS `productBatchComponent` (
  `id` int(11) NOT NULL,
  `commodityBatchID` int(11) NOT NULL,
  `productBatchID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `tara` double NOT NULL DEFAULT '0',
  `netto` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktur-dump for tabellen `recipe`
--

CREATE TABLE IF NOT EXISTS `recipe` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Data dump for tabellen `recipe`
--

INSERT INTO `recipe` (`id`, `name`) VALUES
(1, 'Pille 1'),
(2, 'Pille 2'),
(3, 'Pille 3'),
(4, 'Pille 4');

-- --------------------------------------------------------

--
-- Struktur-dump for tabellen `recipeComponent`
--

CREATE TABLE IF NOT EXISTS `recipeComponent` (
  `id` int(1) NOT NULL,
  `recipeID` int(11) NOT NULL,
  `commodityID` int(11) NOT NULL,
  `non_netto` double NOT NULL DEFAULT '0',
  `tolerance` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Data dump for tabellen `recipeComponent`
--

INSERT INTO `recipeComponent` (`id`, `recipeID`, `commodityID`, `non_netto`, `tolerance`) VALUES
(1, 1, 1, 0.3, 15),
(2, 1, 2, 0.2, 15),
(3, 1, 3, 0.4, 15),
(4, 2, 1, 0.3, 15),
(5, 2, 2, 0.2, 15),
(6, 2, 3, 0.4, 15);

-- --------------------------------------------------------

--
-- Struktur-dump for tabellen `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Data dump for tabellen `supplier`
--

INSERT INTO `supplier` (`id`, `name`) VALUES
(1, 'Leverandør 1'),
(2, 'Leverandør 2'),
(3, 'Leverandør 3');

-- --------------------------------------------------------

--
-- Struktur-dump for tabellen `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `ini` varchar(45) NOT NULL,
  `active` int(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

--
-- Data dump for tabellen `user`
--

INSERT INTO `user` (`id`, `name`, `ini`, `active`) VALUES
(1, 'Thomas Helmig', 'TH', 1),
(2, 'Mikkel Hansen', 'MH', 0),
(3, 'Anders Mathiasen', 'AM', 1),
(4, 'Sofie Larsen', 'SL', 0);

--
-- Begrænsninger for dumpede tabeller
--

--
-- Indeks for tabel `commodity`
--
ALTER TABLE `commodity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `supplierID_idx` (`supplierID`);

--
-- Indeks for tabel `commodityBatch`
--
ALTER TABLE `commodityBatch`
  ADD PRIMARY KEY (`id`),
  ADD KEY `commodityID_idx` (`commodityID`);

--
-- Indeks for tabel `productBatch`
--
ALTER TABLE `productBatch`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_idx` (`recipeID`);

--
-- Indeks for tabel `productBatchComponent`
--
ALTER TABLE `productBatchComponent`
  ADD PRIMARY KEY (`id`),
  ADD KEY `commodityBatchID_idx` (`commodityBatchID`),
  ADD KEY `productBatchID_idx` (`productBatchID`),
  ADD KEY `userID_idx` (`userID`);

--
-- Indeks for tabel `recipe`
--
ALTER TABLE `recipe`
  ADD PRIMARY KEY (`id`);

--
-- Indeks for tabel `recipeComponent`
--
ALTER TABLE `recipeComponent`
  ADD PRIMARY KEY (`id`),
  ADD KEY `receptID` (`recipeID`),
  ADD KEY `commodityID` (`commodityID`);

--
-- Indeks for tabel `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- Indeks for tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Brug ikke AUTO_INCREMENT for slettede tabeller
--

--
-- Tilføj AUTO_INCREMENT i tabel `productBatchComponent`
--
ALTER TABLE `productBatchComponent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Tilføj AUTO_INCREMENT i tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=102;
--
-- Begrænsninger for dumpede tabeller
--

--
-- Begrænsninger for tabel `commodity`
--
ALTER TABLE `commodity`
  ADD CONSTRAINT `FK_C_supplierID` FOREIGN KEY (`supplierID`) REFERENCES `supplier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Begrænsninger for tabel `commodityBatch`
--
ALTER TABLE `commodityBatch`
  ADD CONSTRAINT `FK_CB_commodityID` FOREIGN KEY (`commodityID`) REFERENCES `commodity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Begrænsninger for tabel `productBatch`
--
ALTER TABLE `productBatch`
  ADD CONSTRAINT `recipeID` FOREIGN KEY (`recipeID`) REFERENCES `recipe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Begrænsninger for tabel `productBatchComponent`
--
ALTER TABLE `productBatchComponent`
  ADD CONSTRAINT `FK_PBC_commodityBatchID` FOREIGN KEY (`commodityBatchID`) REFERENCES `commodityBatch` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_PBC_productBatchID` FOREIGN KEY (`productBatchID`) REFERENCES `productBatch` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_PBC_userID` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Begrænsninger for tabel `recipeComponent`
--
ALTER TABLE `recipeComponent`
  ADD CONSTRAINT `FK_RC_commodityID` FOREIGN KEY (`commodityID`) REFERENCES `commodity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_RC_receptID` FOREIGN KEY (`recipeID`) REFERENCES `recipe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
