-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2023-04-10 19:20:16
-- 伺服器版本： 10.4.28-MariaDB
-- PHP 版本： 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `itp4511_project`
--

-- --------------------------------------------------------

--
-- 資料表結構 `booking`
--

CREATE TABLE `booking` (
                         `BkingID` int(11) NOT NULL,
                         `VenueID` int(11) NOT NULL,
                         `Guest` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- 資料表結構 `user`
--

CREATE TABLE `user` (
                      `UID` int(30) NOT NULL,
                      `Name` varchar(30) NOT NULL,
                      `Password` varchar(30) NOT NULL,
                      `email` varchar(30) NOT NULL,
                      `PhoneNum` int(10) NOT NULL,
                      `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `user`
--

INSERT INTO `user` (`UID`, `Name`, `Password`, `email`, `PhoneNum`, `role`) VALUES
                                                                              (1, 'Ken', '12345678', 'ken@gmail.com', 12345678, 'Member'),
                                                                              (2, 'Peter', '12345678', 'Peter@gmail.com', 12345623, 'Staff'),
                                                                              (3, 'Dan', '12345678', 'Dan@gmail.com', 12341231, 'Manager');

-- --------------------------------------------------------

--
-- 資料表結構 `venue`
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
                       `BookingFee` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `venue`
--

INSERT INTO `venue` (`VenueID`, `VenueName`, `Img`, `VenueType`, `Capacity`, `Location`, `VenueDesc`, `VenuePerson`, `BookingFee`) VALUES
                                                                                                                                     (10001, 'Tuen Mun ', NULL, 'Sports Ground', 1000, 'Tuen Mun, Hong Kong', 'recreational venue', 'Eunice', 1000),
                                                                                                                                     (10002, 'Sha Tin', NULL, 'Room', 10, 'Sha Tin, Hong Kong', '1', 'Eunice', 100),
                                                                                                                                     (10003, 'Tsing Yi', NULL, 'Hall', 2000, 'Tsing Yi, Hong Kong', 'Big', 'Eunice', 3000),
                                                                                                                                     (10004, 'Lee Wai Lee', NULL, '12', 133, 'Lee Wai Lee, Hong Kong', 'Bar ', 'Eunice', 100),
                                                                                                                                     (10005, 'Chai Wan', NULL, 'Room', 4000, 'Chai Wan, Hong Kong', 'HK', 'Eunice', 3000);

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`BkingID`);

--
-- 資料表索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UID`);

--
-- 資料表索引 `venue`
--
ALTER TABLE `venue`
  ADD PRIMARY KEY (`VenueID`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `booking`
--
ALTER TABLE `booking`
  MODIFY `BkingID` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `user`
--
ALTER TABLE `user`
  MODIFY `UID` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `venue`
--
ALTER TABLE `venue`
  MODIFY `VenueID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10006;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
