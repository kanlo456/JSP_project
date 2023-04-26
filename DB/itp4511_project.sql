-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 24, 2023 at 07:46 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `itp4511_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `BkingID` int(11) NOT NULL,
  `VenueID` int(11) NOT NULL,
  `MemberID` int(10) NOT NULL,
  `Guest` int(11) NOT NULL,
  `Fee` int(20) NOT NULL,
  `BkDate` date NOT NULL,
  `StartTime` time NOT NULL,
  `EndTime` time NOT NULL,
  `Hour` int(10) NOT NULL,
  `RequestState` varchar(20) NOT NULL DEFAULT 'processing',
  `CheckState` varchar(20) NOT NULL DEFAULT 'waiting'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `bookingfee`
--

CREATE TABLE `bookingfee` (
  `FeeID` int(5) NOT NULL,
  `Year` year(4) NOT NULL,
  `VenueID` int(5) NOT NULL,
  `Fee` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bookingfee`
--

INSERT INTO `bookingfee` (`FeeID`, `Year`, `VenueID`, `Fee`) VALUES
(10001, '2022', 10001, 100),
(10002, '2022', 10004, 250),
(10003, '2023', 10005, 230),
(10004, '2023', 10001, 100),
(10005, '2023', 10002, 150),
(10006, '2023', 10003, 110),
(10007, '2023', 10004, 125);

-- --------------------------------------------------------

--
-- Table structure for table `guest`
--

CREATE TABLE `guest` (
  `GuestID` int(5) NOT NULL,
  `BkingID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `management`
--

CREATE TABLE `management` (
  `MID` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `management`
--

INSERT INTO `management` (`MID`, `role`) VALUES
('M001', 'Manager'),
('M002', 'Member'),
('M003', 'Staff');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `UID` int(30) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `PhoneNum` int(10) NOT NULL,
  `role` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UID`, `Name`, `Password`, `email`, `PhoneNum`, `role`) VALUES
(2, 'Peter', '12345678', 'Peter@gmail.com', 12345623, 'Member'),
(3, 'Dan', '12345678', 'Dan@gmail.com', 1234231, 'Manager'),
(3127, 'Ken', '12345678', '21321312', 213123, 'Staff');

-- --------------------------------------------------------

--
-- Table structure for table `venue`
--

CREATE TABLE `venue` (
  `VenueID` int(5) NOT NULL,
  `VenueName` varchar(50) NOT NULL,
  `Img` mediumblob DEFAULT NULL,
  `VenueType` varchar(50) NOT NULL,
  `Capacity` int(5) NOT NULL,
  `Location` varchar(50) NOT NULL,
  `VenueDesc` varchar(50) NOT NULL,
  `VenuePerson` varchar(50) NOT NULL,
  `State` varchar(20) NOT NULL DEFAULT 'Open'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `venue`
--

INSERT INTO `venue` (`VenueID`, `VenueName`, `Img`, `VenueType`, `Capacity`, `Location`, `VenueDesc`, `VenuePerson`, `State`) VALUES
(10001, 'Tuen Mun ', '', 'Sports Ground', 1000, 'Tuen Mun, Hong Kong', 'recreational venue', 'Eunice', 'Close'),
(10002, 'Sha Tin', '', 'Room', 10, 'Sha Tin, Hong Kong', '1', 'Eunice', 'Close'),
(10003, 'Tsing Yi', NULL, 'Hall', 2000, 'Tsing Yi, Hong Kong', 'Big', 'Eunice', 'Open'),
(10004, 'Lee Wai Lee', NULL, '12', 133, 'Lee Wai Lee, Hong Kong', 'Bar ', 'Eunice', 'Open'),
(10005, 'Chai Wan', '', 'Room', 4000, 'Chai Wan, Hong Kong', 'HK', 'Eunice', 'Open');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`BkingID`),
  ADD KEY `mk` (`MemberID`);

--
-- Indexes for table `bookingfee`
--
ALTER TABLE `bookingfee`
  ADD PRIMARY KEY (`FeeID`),
  ADD KEY `vID_fk` (`VenueID`);

--
-- Indexes for table `guest`
--
ALTER TABLE `guest`
  ADD PRIMARY KEY (`GuestID`),
  ADD KEY `booking_fk` (`BkingID`);

--
-- Indexes for table `management`
--
ALTER TABLE `management`
  ADD PRIMARY KEY (`MID`),
  ADD UNIQUE KEY `role` (`role`),
  ADD UNIQUE KEY `MID` (`MID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UID`),
  ADD UNIQUE KEY `PhoneNum` (`PhoneNum`),
  ADD KEY `roleR` (`role`);

--
-- Indexes for table `venue`
--
ALTER TABLE `venue`
  ADD PRIMARY KEY (`VenueID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `BkingID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `bookingfee`
--
ALTER TABLE `bookingfee`
  MODIFY `FeeID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10008;

--
-- AUTO_INCREMENT for table `guest`
--
ALTER TABLE `guest`
  MODIFY `GuestID` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `UID` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3131;

--
-- AUTO_INCREMENT for table `venue`
--
ALTER TABLE `venue`
  MODIFY `VenueID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10009;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `mk` FOREIGN KEY (`MemberID`) REFERENCES `user` (`UID`);

--
-- Constraints for table `bookingfee`
--
ALTER TABLE `bookingfee`
  ADD CONSTRAINT `vID_fk` FOREIGN KEY (`VenueID`) REFERENCES `venue` (`VenueID`);

--
-- Constraints for table `guest`
--
ALTER TABLE `guest`
  ADD CONSTRAINT `booking_fk` FOREIGN KEY (`BkingID`) REFERENCES `booking` (`BkingID`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `roleR` FOREIGN KEY (`role`) REFERENCES `management` (`role`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;