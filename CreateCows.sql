
-- OOP 2022

DROP DATABASE IF EXISTS `cow_database`;
CREATE DATABASE `cow_database`;
USE `cow_database`;
DROP TABLE IF EXISTS `cow`;
CREATE TABLE `cow` (
  `TAG_ID` int(11) NOT NULL,
  `SEX` varchar(50) NOT NULL,
  `BREED` varchar(50) NOT NULL,
  `YEAR` int(20) NOT NULL,
  `MONTH` int(20) NOT NULL,
  `DAY` int(20) NOT NULL,
  `MILK_YIELD` int(20) NOT NULL,
  PRIMARY KEY  (`TAG_ID`)
  );

INSERT INTO cow VALUES (224, "female", "angus", 2019, 2, 3, 6),
  			           (225, "female", "jersey", 2019, 2, 8, 20),
  			           (226, "female", "jersey", 2019, 2, 11, 20),
                       (227, "female", "angus", 2018, 11, 21, 6),
                       (178, "female", "friesian", 2018, 11, 24, 32),
                       (179, "female", "friesian", 2018, 11, 25, 32),
                       (180, "female", "friesian", 2018, 11, 30, 32),
                       (181, "female", "friesian", 2021, 2, 2, 32),
                       (363, "female", "hereford", 2021, 2, 6, 27),
                       (364, "female", "hereford", 2021, 2, 7, 27);

