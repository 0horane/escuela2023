-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 30, 2023 at 04:20 AM
-- Server version: 11.1.2-MariaDB
-- PHP Version: 8.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `horane_login`
--
CREATE DATABASE IF NOT EXISTS `horane_login` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `horane_login`;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(128) NOT NULL,
  `password` varchar(64) NOT NULL,
  `nick` varchar(64) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `password`, `nick`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'a@a.com', '$2y$10$xsTEssj/KHutA1bW/dAAhu0cn2A1L.eXFssFUsPi386QL8Dy/Wwk.', NULL, '2023-09-29 20:39:16', '2023-09-29 20:39:16', '0000-00-00 00:00:00'),
(2, 'a@b.com', '$2y$10$VqtQBBMP6POGM7Z.UlqruO6lY96aGsUF5nVejeCLaLEpAZW3tuCpy', NULL, '2023-09-29 20:41:45', '2023-09-29 20:41:45', '0000-00-00 00:00:00'),
(3, 'b@c.com', '$2y$10$BZb3Xmizi.Oy6NJ.yjHx6uViZjv2yfIvJHEGCognxvXx1QnLRR5D2', NULL, '2023-09-30 01:18:04', '2023-09-30 01:18:04', NULL),
(4, 'a@c.com', '$2y$10$3GeNMhSiXSQFYvVbo5VFm.4MPG58L6udxAO7X6dnC1wg4Ml25h0.e', NULL, '2023-09-30 01:18:16', '2023-09-30 01:18:16', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `userdetail`
--

CREATE TABLE `userdetail` (
  `Id` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `Name` varchar(32) NOT NULL,
  `Surname` varchar(32) NOT NULL,
  `PhoneNumber` bigint(30) NOT NULL,
  `Company` varchar(32) NOT NULL,
  `Address` varchar(64) NOT NULL,
  `Web` varchar(32) NOT NULL,
  `Birthdate` date NOT NULL,
  `Label` varchar(32) NOT NULL,
  `Nick` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `userdetail`
--

INSERT INTO `userdetail` (`Id`, `UserID`, `Name`, `Surname`, `PhoneNumber`, `Company`, `Address`, `Web`, `Birthdate`, `Label`, `Nick`) VALUES
(1, 1, 'Pedro', 'Sanchez', 324234234, 'Amazon', 'Bolivia', 'a.com', '2023-09-27', 'hol', 'a'),
(4, 4, 'asdds', 'adssd', 3334, 'fd', 'sdf', 'dfs', '2023-08-29', 'fsd', 'df');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userdetail`
--
ALTER TABLE `userdetail`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `userdetail`
--
ALTER TABLE `userdetail`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
