DROP DATABASE IF EXISTS fmDB;
CREATE DATABASE fmDB;
USE fmDB;



CREATE TABLE `amt_coaches` (
  `username` varchar(255) UNIQUE NOT NULL,
  `password` varchar(255),
  `first_name` varchar(255),
  `last_name` varchar(255),
  `nameteam` varchar(255),
  `isAdmin` boolean,
  CONSTRAINT FK_Coach_username_ID PRIMARY KEY (username)

);

CREATE TABLE `amt_teams` (
  `name` varchar(255) UNIQUE  NOT NULL,
  `creationDate` date,
  `location` varchar(255),
  CONSTRAINT FK_Teams_name_ID PRIMARY KEY (name)

);

CREATE TABLE `amt_players` (
  `id` INTEGER UNSIGNED AUTO_INCREMENT,
  `first_name` varchar(255),
  `last_name` varchar(255),
  `position` varchar(255),
  `number` int,
  `name_teams`varchar(255) NOT NULL,

  CONSTRAINT FK_Player_id_ID PRIMARY KEY (id)

);

ALTER TABLE amt_coaches ADD CONSTRAINT FK_coach_team
  FOREIGN KEY (nameteam) REFERENCES amt_teams (name);

ALTER TABLE amt_players ADD CONSTRAINT FK_player_team
  FOREIGN KEY (name_teams) REFERENCES amt_teams (name);

INSERT INTO amt_teams VALUES ("HEIG", "2019-10-30", "Yverdon");

INSERT INTO amt_coaches VALUES ("nal", "pass", "Nair", "Alic", NULL, true);
INSERT INTO amt_coaches VALUES ("rtt", "pass", "Robel", "Teklehaimanot", "HEIG", false);



INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Momo", "Mama", "GK", 1,"HEIG");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Momo", "Mama", "RB", 2,"HEIG");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Momo", "Mama", "LB", 3,"HEIG");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Momo", "Mama", "CB", 4,"HEIG");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Momo", "Mama", "SW", 5,"HEIG");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Momo", "Mama", "LM", 6,"HEIG");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Momo", "Mama", "CM", 7,"HEIG");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Momo", "Mama", "RM", 8,"HEIG");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Momo", "Mama", "CF", 9,"HEIG");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Momo", "Mama", "RF", 10,"HEIG");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Momo", "Mama", "LF", 11,"HEIG");



