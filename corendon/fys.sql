-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Machine: 127.0.0.1
-- Genereertijd: 26 nov 2013 om 14:56
-- Serverversie: 5.5.32
-- PHP-versie: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databank: `fys`
--
CREATE DATABASE IF NOT EXISTS `fys` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `fys`;
DROP TABLE IF EXISTS customer,luggage,user;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `postal_code` varchar(10) NOT NULL,
  `address` varchar(75) NOT NULL,
  `country` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `phone_home` varchar(20) DEFAULT NULL,
  `phone_mobile` varchar(20) DEFAULT NULL,
  `date_changed` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_changed_by` VARCHAR (30) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Gegevens worden uitgevoerd voor tabel `customer`
--

INSERT INTO `customer` (`first_name`, `last_name`, `email`, `postal_code`, `address`, `country`, `city`, `phone_home`, `phone_mobile`, `date_changed`, `last_changed_by`) VALUES 
('Barack', 'Obama', 'me    @yeswecan.gov', '9989US', 'Whitehouselane 1', 'Nederland', 'Washington D.C.', '02015427315', '0612435678', '2013-11-25 02:10:13.0', 'jesspin'),
('Saddam', 'Hoessein', 'peaceandlove@irak.co.uk', '1234AK', 'Bagdadlaan 2', 'Irak', 'Bagdad', '012 - DICTATOR', '0612437586', '2013-11-20 14:56:19.0', 'saulgoo'),
('Dennis', 'Barhorst', 'Dennis@spaceengineers.com', '1826BB', 'Alkmaarlaan 12', 'Nederland', 'Alkmaar', '07215473546', '06341572864', '2013-11-20 14:56:19.0', 'saulgoo'),
('Jesse', 'Baas', 'wdawd@awdawd.com', '1826JC', 'Lalalaan 2', 'Nederland', 'Alkmaar', 'awdawdawd', 'cawdawdawd', '2013-11-20 14:56:19.0', 'saulgoo'),
('habiboela', 'aapje', 'awdawd@awdaw.dawd', '1826AWDAWD', 'awpjoiawd 16', 'Australië', 'awdawdawd', 'awdawdawd', 'awdawdawd', '2013-11-20 14:56:19.0', 'saulgoo'),
('Persoontje', 'awdawd', 'awdawd @wadawda.wd', '15155DAWD', 'dawdawd dwad', 'Nederland', 'awdawdawd', 'awdawdawd', 'awdawdawd', '2013-11-25 10:15:06.0', 'jesspin'),
('Hendrik', 'Henselman', 'hensel @hensel.com', '1899AD', 'Henselweg 15', 'Turkije', 'Henselstad', '06-Hensel', '072-Hopjesdag', '2013-11-25 14:29:09.0', 'jesspin'),
('Poerer', 'Poer', 'poer@poer.tu', '12387NUAWD', 'Poerlaan 18E', 'Turkije', 'Istanbul', '0678945612', '0152468978', '2013-11-20 14:56:19.0', 'saulgoo');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `luggage`
--

CREATE TABLE IF NOT EXISTS `luggage` (
  `luggage_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `location` varchar(50) NOT NULL,
  `date_changed` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_lost` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_handled` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(11) NOT NULL,
  `date_found` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_changed_by` int(50) NOT NULL,
PRIMARY KEY (`luggage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Gegevens worden uitgevoerd voor tabel `luggage`
--

INSERT INTO `luggage` (`customer_id`, `description`, `location`, `date_changed`, `date_lost`, `last_changed_by`, `date_handled`, `status`, `date_found`) VALUES 
(1, 'Krat bierblikjesmetsoep', 'F1.14', '2013-11-25 14:04:05.0', '2013-11-18 09:36:59.0', 'jesspin', '2013-11-20 13:33:49.0', 3, '2013-11-26 15:30:38.556');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) NOT NULL DEFAULT '1',
  `username` varchar(20) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `incorrect_login` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Gegevens worden uitgevoerd voor tabel `user`
--

INSERT INTO `user` (`user_id`, `permission_id`, `username`, `first_name`, `last_name`, `password`, `incorrect_login`) VALUES
(4, 3, 'test', 'test', 'test', '$2a$10$g14FE9AnhJcjBtPaeNpbXOrR43kn1qpHG2u6Qs9PyCKGqjf7NUlbS', 0),
(5, 1, 'medewerker', 'medewerker', 'medewerker', '$2a$10$G3Z2a1Lru/3nCP4.M6aCju5EVAkpdes63H242088Gv.esyzdWh69y', 0),
(6, 2, 'manager', 'manager', 'manager', '$2a$10$kLj0yhGAYh375v7aACokvePOCCad1qk1wvxmVmpjhw/ytfpl.W.qC', 0),
(7, 3, 'beheerder', 'beheerder', 'beheerder', '$2a$10$xPhMEV3Pc627GtXabqhPrObJy..L7YKQYal5./8DIzGelIkCOJZQ2', 0);

-- --------------------------------------------------------

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
