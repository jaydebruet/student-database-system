-- phpMyAdmin SQL Dump
-- version 2.11.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 05, 2015 at 06:03 AM
-- Server version: 5.0.51
-- PHP Version: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cse11`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_address`
--

CREATE TABLE IF NOT EXISTS `tbl_address` (
  `Roll` int(6) default NULL,
  `Name` varchar(20) default NULL,
  `address` varchar(40) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_address`
--

INSERT INTO `tbl_address` (`Roll`, `Name`, `address`) VALUES
(113001, 'Manika Kabir', 'Rajshahi'),
(113002, 'Hasin E Jannat', 'Lalpur,Nator'),
(113003, 'Shakhar', 'Dinajpur');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_info`
--

CREATE TABLE IF NOT EXISTS `tbl_info` (
  `Roll` int(6) default NULL,
  `CGPA` double default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_info`
--

INSERT INTO `tbl_info` (`Roll`, `CGPA`) VALUES
(113001, 3.77),
(112031, 3.7),
(113031, 3.6),
(113052, 3.62),
(113003, 3.78),
(113020, 3.4),
(113002, 3.45),
(113020, 3.4),
(113014, 3.5),
(113043, 3.05),
(122015, 3.4),
(113052, 3.62);
