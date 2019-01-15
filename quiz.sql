-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 15, 2019 at 02:41 PM
-- Server version: 5.5.62
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quiz`
--

-- --------------------------------------------------------

--
-- Table structure for table `answers`
--

CREATE TABLE `answers` (
  `id` int(11) NOT NULL,
  `answer` varchar(200) COLLATE latin1_general_ci NOT NULL,
  `correct` tinyint(1) DEFAULT NULL,
  `question_id` int(11) NOT NULL,
  `pair_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `answers`
--

INSERT INTO `answers` (`id`, `answer`, `correct`, `question_id`, `pair_id`) VALUES
(1, 'Teszt válasz 1', 0, 4, NULL),
(2, 'Teszt válasz 2', 1, 4, NULL),
(3, 'Teszt válasz 1', 1, 5, NULL),
(4, 'Teszt válasz 2 ', 0, 5, NULL),
(85, '80 km/h', 1, 6, NULL),
(86, '70 km/h', 0, 6, NULL),
(87, '90 km/h', 0, 6, NULL),
(88, '60 km/h', 0, 6, NULL),
(89, '0', 1, 7, NULL),
(90, '8', 0, 7, NULL),
(91, '12', 0, 7, NULL),
(92, '16', 0, 7, NULL),
(93, 'Háromujjú lajhár', 1, 8, NULL),
(94, 'Koala', 0, 8, NULL),
(95, 'Panda', 0, 8, NULL),
(96, 'Oroszlán', 0, 8, NULL),
(97, 'Sáskarák', 1, 9, NULL),
(98, 'Kaméleon', 0, 9, NULL),
(99, 'Hangya', 0, 9, NULL),
(100, 'Légy', 0, 9, NULL),
(101, '1', 1, 10, NULL),
(102, '2', 0, 10, NULL),
(103, '3', 0, 10, NULL),
(104, '4', 0, 10, NULL),
(105, 'Ázsia', 1, 12, NULL),
(106, 'Dél-Amerika', 0, 12, NULL),
(107, 'Afrika', 0, 12, NULL),
(108, 'Mariana-árok', 1, 11, NULL),
(109, 'Belize-i Nagy Kék Lyuk', 0, 11, NULL),
(110, 'Tonga-árok', 0, 11, NULL),
(111, 'Marokkó', 1, 13, NULL),
(112, 'Egyiptom', 0, 13, NULL),
(113, 'Algéria', 0, 13, NULL),
(114, 'Dubai', 1, 14, NULL),
(115, 'Peking', 0, 14, NULL),
(116, 'New York', 0, 14, NULL),
(117, '5', 1, 15, NULL),
(118, '6', 0, 15, NULL),
(119, '3', 0, 15, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `id` int(11) NOT NULL,
  `question` varchar(200) COLLATE latin1_general_ci NOT NULL,
  `task_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`id`, `question`, `task_id`, `type_id`) VALUES
(4, 'Teszt kérdés 1', 1, 1),
(5, 'Teszt kérdés 2', 1, 1),
(6, 'Milyen gyorsan képes futni az oroszlán?', 3, 2),
(7, 'Hány foga van a struccnak?', 3, 2),
(8, 'Melyik a leglassabb eml?s?', 3, 2),
(9, 'Melyik állat látja a legtöbb színt?', 3, 2),
(10, 'Mennyi tojást rak le egyszerre egy császárpingvin?', 3, 2),
(11, 'Mi a föld legmélyebb pontja?', 4, 3),
(12, 'Melyik a legnagyobb kontinens?', 4, 3),
(13, 'Melyik országot választja el Spanyolországtól a Gibraltári-szoros?', 4, 3),
(14, 'Melyik városban helyezkedik el a Föld legmagasabb épülete?', 4, 3),
(15, 'Hány tó alkotja a Nagy-tavakat?', 4, 3);

-- --------------------------------------------------------

--
-- Table structure for table `question_types`
--

CREATE TABLE `question_types` (
  `id` int(11) NOT NULL,
  `type` varchar(50) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `question_types`
--

INSERT INTO `question_types` (`id`, `type`) VALUES
(1, 'Teszt'),
(2, 'Allatos'),
(3, 'Foldrajzi');

-- --------------------------------------------------------

--
-- Table structure for table `scores`
--

CREATE TABLE `scores` (
  `id` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `scores`
--

INSERT INTO `scores` (`id`, `score`, `user_id`, `task_id`) VALUES
(10, 40, 1, 1),
(11, 22, 1, 1),
(12, 10, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE `task` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`id`, `name`) VALUES
(1, 'Feladat1'),
(2, 'Feladat2'),
(3, 'Allatos feladat'),
(4, 'Foldrajzi feladat');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(250) COLLATE latin1_general_ci NOT NULL,
  `password` varchar(250) COLLATE latin1_general_ci NOT NULL,
  `email` varchar(200) COLLATE latin1_general_ci DEFAULT NULL,
  `token` varchar(200) COLLATE latin1_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `email`, `token`) VALUES
(1, 'teszt', '1234', 'teszt@teszt.hu', 'aaaa'),
(2, 'teszt2', '1234', 'vdfrgssrg', '0bdc91b4-5920-4654-a3d9-38e3c200fe58'),
(4, 'teszt3', '1234', 'null', 'ba442034-c5a8-46cc-9825-9057d275a19e');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answers`
--
ALTER TABLE `answers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_questions_task_id` (`task_id`),
  ADD KEY `FK_questions_type_id` (`type_id`);

--
-- Indexes for table `question_types`
--
ALTER TABLE `question_types`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `scores`
--
ALTER TABLE `scores`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answers`
--
ALTER TABLE `answers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=120;

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `question_types`
--
ALTER TABLE `question_types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `scores`
--
ALTER TABLE `scores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answers`
--
ALTER TABLE `answers`
  ADD CONSTRAINT `FK_answers_question_id` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `questions`
--
ALTER TABLE `questions`
  ADD CONSTRAINT `FK_questions_task_id` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_questions_type_id` FOREIGN KEY (`type_id`) REFERENCES `question_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `scores`
--
ALTER TABLE `scores`
  ADD CONSTRAINT `FK_scores_task_id` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_scores_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
