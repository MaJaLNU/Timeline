-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 24. Nov 2016 um 13:56
-- Server-Version: 10.1.13-MariaDB
-- PHP-Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `starwarstimeline`
--
CREATE DATABASE IF NOT EXISTS `starwarstimeline`;
USE `starwarstimeline`;
DROP TABLE IF EXISTS `movie`;
DROP TABLE IF EXISTS `user`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `movie`
--

CREATE TABLE `movie` (
  `id`          BIGINT(20)    NOT NULL AUTO_INCREMENT,
  `title`       VARCHAR(200)  NOT NULL,
  `rating`      DOUBLE        NOT NULL,
  `releasedate` DATETIME      NOT NULL,
  `director`    VARCHAR(200)  NOT NULL,
  `length`      VARCHAR(200)  NOT NULL,
  `youtube`     VARCHAR(200)  NOT NULL,
  `description` VARCHAR(1000) NOT NULL,
  `image`       VARCHAR(200)  NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

--
-- Daten für Tabelle `movie`
--

INSERT INTO `movie` (`id`, `title`, `rating`, `releasedate`, `director`, `length`, `youtube`, `description`, `image`)
VALUES
  (1, 'Star Wars I', 7.65, '2006-11-10 00:00:00', 'Malte', 'zweiStunden', 'youtube.com/checkthisout',
   'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.',
   'starwars-1.jpg');
INSERT INTO `movie` (`id`, `title`, `rating`, `releasedate`, `director`, `length`, `youtube`, `description`, `image`)
VALUES
  (2, 'Star Wars II', 7.65, '2006-11-10 00:00:00', 'Jan', 'arsch', 'youtube.com/checkthisout',
   'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.',
   'starwars-1.jpg');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE `user` (
  `id`       BIGINT(11)   NOT NULL AUTO_INCREMENT,
  `email`    VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

--
-- Daten für Tabelle `user`
--
INSERT INTO `user` (`id`, `email`, `password`) VALUES
  (1, 'jan@janweiss.org', 'password');

