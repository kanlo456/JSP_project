-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 09, 2023 at 02:11 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `IT4511_Project`
--

-- --------------------------------------------------------

--
-- Table structure for table `Booking`
--

CREATE TABLE `Booking` (
  `BkingID` int(11) NOT NULL,
  `VenueID` int(11) NOT NULL,
  `Guest` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `Venue`
--

CREATE TABLE `Venue` (
  `VenueID` int(5) NOT NULL,
  `VenueName` varchar(50) NOT NULL,
  `Img` mediumblob DEFAULT NULL,
  `VenueType` varchar(50) NOT NULL,
  `Capacity` int(5) NOT NULL,
  `Location` varchar(50) NOT NULL,
  `VenueDesc` varchar(50) NOT NULL,
  `VenuePerson` varchar(50) NOT NULL,
  `BookingFee` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Venue`
--

INSERT INTO `Venue` (`VenueID`, `VenueName`, `Img`, `VenueType`, `Capacity`, `Location`, `VenueDesc`, `VenuePerson`, `BookingFee`) VALUES
(10001, 'Tuen Mun ', NULL, 'Sports Ground', 1000, 'Tuen Mun, Hong Kong', 'recreational venue', 'Eunice', 1000),
(10002, 'Sha Tin', NULL, 'Room', 10, 'Sha Tin, Hong Kong', '1', 'Eunice', 100),
(10003, 'Tsing Yi', NULL, 'Hall', 2000, 'Tsing Yi, Hong Kong', 'Big', 'Eunice', 3000),
(10004, 'Lee Wai Lee', NULL, '12', 133, 'Lee Wai Lee, Hong Kong', 'Bar ', 'Eunice', 100),
(10005, 'Chai Wan', NULL, 'Room', 4000, 'Chai Wan, Hong Kong', 'HK', 'Eunice', 3000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Booking`
--
ALTER TABLE `Booking`
  ADD PRIMARY KEY (`BkingID`);

--
-- Indexes for table `Venue`
--
ALTER TABLE `Venue`
  ADD PRIMARY KEY (`VenueID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Booking`
--
ALTER TABLE `Booking`
  MODIFY `BkingID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Venue`
--
ALTER TABLE `Venue`
  MODIFY `VenueID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10006;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
