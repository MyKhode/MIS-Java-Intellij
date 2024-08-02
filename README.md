<div align="center">

# 🏅STUDENT-MIS USING JAVA INTELLIJ🏅

[![pre-commit](https://img.shields.io/badge/pre--commit-enabled-brightgreen?logo=pre-commit&logoColor=white)](https://github.com/pre-commit/pre-commit)
<img alt="GitHub forks" src="https://img.shields.io/github/forks/ikhode-arena/MIS-Java-Intellij">
<img alt="GitHub License" src="https://img.shields.io/github/license/ikhode-arena/MIS-Java-Intellij">
<img alt="GitHub Release" src="https://img.shields.io/github/v/release/ikhode-arena/mis-java-intellij">
<img alt="GitHub code size in bytes" src="https://img.shields.io/github/languages/code-size/ikhode-arena/MIS-Java-Intellij">


</div>

## 🎯TODO

- [X] GUI Swing with java intellij
- [X] Read or Query Data from Mysql 
- [X] Delete Data via Id with mysql db
- [X] Update Data via id
- [X] Reset fill form btn
- [X] Display Query data as JTable
- [ ] Handle error try catch ...

## 💪Installation

```bash
download connector j 
```
```bash
import into intellij project structure 
```
```bash
import mysql db via scripting
```
```bash
run the project via intellij gui btn
```

## 🏹 Mysql Scripting

```
-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 02, 2024 at 12:45 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_activity_1`
--

-- --------------------------------------------------------

--
-- Table structure for table `gender`
--

CREATE TABLE `gender` (
  `id` int(11) NOT NULL,
  `gender_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `gender`
--

INSERT INTO `gender` (`id`, `gender_name`) VALUES
(1, 'Male'),
(2, 'Female'),
(3, 'Other');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name_latin` varchar(200) NOT NULL,
  `name_khmer` varchar(200) NOT NULL,
  `gender_id` int(11) NOT NULL,
  `date_of_birth` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name_latin`, `name_khmer`, `gender_id`, `date_of_birth`) VALUES
(2, 'Jane Smith', '??? ?????', 2, '2001-02-20'),
(3, 'Alex Kim', '????? ???', 3, '1999-05-30'),
(4, 'test', 'តេស', 1, '2024-08-08');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gender`
--
ALTER TABLE `gender`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD KEY `gender_id` (`gender_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `gender`
--
ALTER TABLE `gender`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
```

## 🔯 Demo

![image](https://github.com/user-attachments/assets/57aac562-8651-4e5d-9914-e93bec96e82d)


### ✍️ Citation

```bibtex
@misc{java + intellij,
  author = {SOY TET},
  title = {Student Management Information System },
  year = {2024},
  publisher = {GitHub},
  journal = {GitHub repository}
}
```
#### Used in:
---
### 👨‍🎓 References
---
