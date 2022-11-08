-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost:3306
-- Üretim Zamanı: 08 Kas 2022, 01:08:40
-- Sunucu sürümü: 10.5.18-MariaDB
-- PHP Sürümü: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `yazili26_AutoGalleryKotlin`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `adverts`
--

CREATE TABLE `adverts` (
  `id` int(11) UNSIGNED NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `advert_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `advert_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `advert_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `explanation` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `price` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `serial` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `model` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `year` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `fuel` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `gear` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `vehicleStatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `km` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `caseType` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `motorPower` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `motorCapacity` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `traction` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `guarantee` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `swap` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `phoneNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Tablo döküm verisi `adverts`
--

INSERT INTO `adverts` (`id`, `user_id`, `advert_no`, `advert_date`, `advert_title`, `explanation`, `price`, `address`, `brand`, `serial`, `model`, `year`, `fuel`, `gear`, `vehicleStatus`, `km`, `caseType`, `motorPower`, `motorCapacity`, `traction`, `color`, `guarantee`, `swap`, `phoneNumber`) VALUES
(1, '1', '', '', '1', '1', '1', 'Elazığ, merkez, çayda çıralll', '1', '2', '2', '3', '3', '3', '3', '5', '4', '4', '3', '6', '6', '6', '6', '0(553) 581 83 10'),
(2, '1', '', '', '11', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(15, '2', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(16, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(17, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(7, '2', '', '', '2', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(13, '1', '', '', 'Talha', 'sefa', '480.000 TL', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(14, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(18, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(19, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(20, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(21, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(22, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(23, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(171, '3', '', '', 'Ahmet', '', '100.000.000 TL', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'Evet', '', '0(537) 425 70 54'),
(25, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(26, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(27, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(28, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(29, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(30, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(31, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(32, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(33, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(34, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(35, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(36, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(37, '1', '', '', 'saddsa', 'dsadsa', '321.321 TL', 'Elazığ, merkez, çayda çıralll', 'das', 'adasd', 'sdas', '2332', 'Dizel', 'Yarı Otomatik', 'İkinci El', '23 KM', 'dasasd', 'dasdas', 'sdassdasdas', 'dadas', 'asdasdas', 'Hayır', 'Evet', '0(553) 581 83 10'),
(38, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(39, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(40, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(41, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(42, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(43, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', 'Gri', '', '', '0(553) 581 83 10'),
(44, '1', '', '', 'sadasd', 'dsaasd', '23 TL', 'Elazığ, merkez, çayda çıralll', 'sdasd', 'dsa', 'asdads', '34234', 'Benzin', 'Manuel', 'Sıfır', '23 KM', 'ds', 'dsfsd', 'dsfds', 'fsdfds', 'Gri', 'Evet', 'Evet', '0(553) 581 83 10'),
(45, '1', '', '', 'sadasd', 'dsaasd', '23 TL', 'Elazığ, merkez, çayda çıralll', 'sdasd', 'dsa', 'asdads', '34234', 'Benzin', 'Manuel', 'Sıfır', '23 KM', 'ds', 'dsfsd', 'dsfds', 'fsdfds', 'Gri', 'Evet', 'Evet', '0(553) 581 83 10'),
(46, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(47, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(48, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(49, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(50, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(51, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(52, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(53, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(54, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(55, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(56, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(57, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(58, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(59, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(60, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(61, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(62, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(63, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(64, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(65, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(66, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(67, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(68, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(69, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(70, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(71, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(72, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(73, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(74, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(173, '5', '', '', '', '', '', 'Elazig, Merkez, Cayda cira', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0553581831011'),
(76, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(172, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(103, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(80, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(81, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(82, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(83, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(84, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(85, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(86, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(87, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(88, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(89, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(90, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(91, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(92, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(93, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(94, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(95, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(96, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(97, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(98, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(99, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(100, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(101, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(102, '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(104, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(105, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(106, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(107, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10'),
(108, '1', '', '', '', '', '', 'Elazığ, merkez, çayda çıralll', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0(553) 581 83 10');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `advert_images`
--

CREATE TABLE `advert_images` (
  `id` int(11) UNSIGNED NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `advert_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `image_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `image_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Tablo döküm verisi `advert_images`
--

INSERT INTO `advert_images` (`id`, `user_id`, `advert_id`, `image_title`, `image_path`) VALUES
(11, '1', '1', 'Ky1rncERv69fDd5YiP7HWuMw0SajUl', 'advertiseImage/Ky1rncERv69fDd5YiP7HWuMw0SajUl.png'),
(12, '1', '2', '0clRhbdOovgCMtNYiPnWKL3SmU2VXB', 'advertiseImage/0clRhbdOovgCMtNYiPnWKL3SmU2VXB.png'),
(28, '1', '13', '', 'advertiseImage/6v4L1GJQlrjVMhokHCD0AZ5OSPBamN.png\r\n'),
(29, '1', '13', '', 'advertiseImage/6v4L1GJQlrjVMhokHCD0AZ5OSPBamN.png\r\n'),
(30, '1', '13', '', 'advertiseImage/6v4L1GJQlrjVMhokHCD0AZ5OSPBamN.png\r\n'),
(40, '1', '37', '9Xd0HCynt2KePhTlf58u73NBIMY4Aw', 'advertiseImage/9Xd0HCynt2KePhTlf58u73NBIMY4Aw.png'),
(17, '2', '15', 'BmCaDbSPE2y1kWUO3V6hsMRdiulrNY', 'advertiseImage/BmCaDbSPE2y1kWUO3V6hsMRdiulrNY.png'),
(39, '1', '37', 'grc8DZ7IMWxveP2bYL6dzhEKutQXTn', 'advertiseImage/grc8DZ7IMWxveP2bYL6dzhEKutQXTn.png'),
(38, '1', '30', 'BfnhYVb5Ui94gCqIyeMSKxQtl3OEwr', 'advertiseImage/BfnhYVb5Ui94gCqIyeMSKxQtl3OEwr.png'),
(37, '1', '25', '4BeZR0YdiCS63xIz2cJAo58vElN1mh', 'advertiseImage/4BeZR0YdiCS63xIz2cJAo58vElN1mh.png'),
(113, '3', '171', 'hR23MienqOw9dt8VXEWaT1CZ7YNvuI', 'advertiseImage/hR23MienqOw9dt8VXEWaT1CZ7YNvuI.png'),
(114, '1', '172', '3aiDnJQywHK6sEm1PeXBtb8kC5f7zo', 'advertiseImage/3aiDnJQywHK6sEm1PeXBtb8kC5f7zo.png'),
(34, '1', '13', '', 'advertiseImage/araba.png'),
(41, '1', '37', '3DqJF4AcLSiXhOz1eyTGHQvakn2m5w', 'advertiseImage/3DqJF4AcLSiXhOz1eyTGHQvakn2m5w.png'),
(42, '1', '45', 'SfDJH1gwzlbirmy8nxGBF2jhcZQ0N3', 'advertiseImage/SfDJH1gwzlbirmy8nxGBF2jhcZQ0N3.png'),
(43, '1', '49', 'b632hiFWd7OYzJu15SnaZvxHIDVGEL', 'advertiseImage/b632hiFWd7OYzJu15SnaZvxHIDVGEL.png'),
(44, '1', '50', 'HDOCxPvUW95oIak7KVf1BhyQns3NJb', 'advertiseImage/HDOCxPvUW95oIak7KVf1BhyQns3NJb.png'),
(115, '5', '173', 's7XmuafWxKjIThywtvJg4E9ozLrC1B', 'advertiseImage/s7XmuafWxKjIThywtvJg4E9ozLrC1B.png'),
(50, '1', '105', 'rKVXHme2wv3oMiu69R8PIyZhCcA0bj', 'advertiseImage/rKVXHme2wv3oMiu69R8PIyZhCcA0bj.png');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `favorite_adverts`
--

CREATE TABLE `favorite_adverts` (
  `id` int(11) UNSIGNED NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `advert_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Tablo döküm verisi `favorite_adverts`
--

INSERT INTO `favorite_adverts` (`id`, `user_id`, `advert_id`) VALUES
(22, '2', '15'),
(32, '1', '15'),
(62, '3', '45'),
(40, '1', '37'),
(35, '1', ''),
(39, '1', '45'),
(71, '3', '30'),
(42, '1', '13'),
(44, '1', '1'),
(45, '1', '2'),
(46, '1', '25'),
(47, '1', '50'),
(61, '3', '15'),
(56, '3', '37'),
(64, '3', '50'),
(70, '3', '105'),
(67, '3', '116'),
(72, '3', '171');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `reset_passwords`
--

CREATE TABLE `reset_passwords` (
  `id` int(11) NOT NULL,
  `users_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `code` varchar(255) NOT NULL,
  `active` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Tablo döküm verisi `reset_passwords`
--

INSERT INTO `reset_passwords` (`id`, `users_email`, `code`, `active`) VALUES
(1, 'talhayldrm23@gmail.com', '983413', '0'),
(2, 'talhayldrm23@gmail.com', '845765', '1'),
(3, 'talhayldrm23@gmail.com', '367980', '1'),
(4, 'talhayldrm23@gmail.com', '621034', '1'),
(5, 'talhayldrm23@gmail.com', '883822', '1');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `users`
--

CREATE TABLE `users` (
  `id` int(11) UNSIGNED NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci DEFAULT NULL,
  `surname` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci DEFAULT NULL,
  `active` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Tablo döküm verisi `users`
--

INSERT INTO `users` (`id`, `name`, `surname`, `email`, `password`, `active`, `code`) VALUES
(1, 'talha', 'yıldırım', 'talhayldrm23@gmail.com', '123456', '1', '388898'),
(2, 'sefa', 'yıldırım', 'talhayldrm123@gmail.com', '123456', '1', '925089'),
(3, 'merve', 'yıldırım', 'merveyldrm23@gmail.com', '123456', '1', '111111'),
(4, 'fhhf', 'dhch', 'vnnv@gmail.com', 'cnnvcnnvnv', '0', '549509'),
(5, 'talha', 'yldrm', 'beseta23@gmail.com', '252525', '1', '940511');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `adverts`
--
ALTER TABLE `adverts`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `advert_images`
--
ALTER TABLE `advert_images`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `favorite_adverts`
--
ALTER TABLE `favorite_adverts`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `reset_passwords`
--
ALTER TABLE `reset_passwords`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `adverts`
--
ALTER TABLE `adverts`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=174;

--
-- Tablo için AUTO_INCREMENT değeri `advert_images`
--
ALTER TABLE `advert_images`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;

--
-- Tablo için AUTO_INCREMENT değeri `favorite_adverts`
--
ALTER TABLE `favorite_adverts`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

--
-- Tablo için AUTO_INCREMENT değeri `reset_passwords`
--
ALTER TABLE `reset_passwords`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
