-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Nov 23, 2019 at 05:49 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inch2inchdb`
--
CREATE DATABASE IF NOT EXISTS `inch2inchdb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `inch2inchdb`;

-- --------------------------------------------------------

--
-- Table structure for table `bill_detail`
--

CREATE TABLE `bill_detail` (
  `id` int(5) NOT NULL,
  `bill_date` date DEFAULT NULL,
  `deliver_date` date DEFAULT NULL,
  `amount` decimal(8,2) DEFAULT NULL,
  `customer_id` int(5) DEFAULT NULL,
  `fabric_id` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(5) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `address` varchar(60) NOT NULL,
  `chest` double(4,2) DEFAULT NULL,
  `neck` double(4,2) DEFAULT NULL,
  `pant_length` double(4,2) DEFAULT NULL,
  `shirt_length` double(4,2) DEFAULT NULL,
  `sleave_length` double(4,2) DEFAULT NULL,
  `waist` double(4,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `email`, `mobile`, `address`, `chest`, `neck`, `pant_length`, `shirt_length`, `sleave_length`, `waist`) VALUES
(32, 'Chintan', 'gohel962@gmail.com', '7802801658', 'gota', 22.22, 22.22, 22.22, 22.22, 22.22, 22.22),
(33, 'Chintan', 'gohel762@gmail.com', '7802801758', 'gota', 22.22, 22.22, 22.22, 22.22, 22.22, 22.22);

-- --------------------------------------------------------

--
-- Table structure for table `fabric`
--

CREATE TABLE `fabric` (
  `id` int(5) NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `fabric_type` varchar(255) NOT NULL,
  `price` decimal(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fabric`
--

INSERT INTO `fabric` (`id`, `image_path`, `fabric_type`, `price`) VALUES
(2, 'fabricOne.jpg', 'Cotton', '500.68'),
(3, 'fabricTwo.jpg', 'Silk', '600.50');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(5) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `fabric_id` (`fabric_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `mobile` (`mobile`);

--
-- Indexes for table `fabric`
--
ALTER TABLE `fabric`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `mobile` (`mobile`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill_detail`
--
ALTER TABLE `bill_detail`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `fabric`
--
ALTER TABLE `fabric`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD CONSTRAINT `bill_detail_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `bill_detail_ibfk_2` FOREIGN KEY (`fabric_id`) REFERENCES `fabric` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
