DROP DATABASE IF EXISTS fmDB;
CREATE DATABASE fmDB;
USE fmDB;



CREATE TABLE `amt_coaches` (
  `username` varchar(255) UNIQUE NOT NULL,
  `password` varchar(255),
  `first_name` varchar(255),
  `last_name` varchar(255),
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

CREATE TABLE IF NOT EXISTS `amt_teams_coach` (
  `coach_id` varchar(255)  NOT NULL,
  `team_id` varchar(255) NOT NULL,
  PRIMARY KEY (`coach_id`, `team_id`),
  INDEX `fk_coach_team_team` (`team_id` ASC),
  INDEX `fk_coach_team_coach` (`coach_id` ASC),
  CONSTRAINT `fk_coach_team_coach`
    FOREIGN KEY (`coach_id`)
    REFERENCES `amt_coaches` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_coach_team_team`
    FOREIGN KEY (`team_id`)
    REFERENCES `amt_teams` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


ALTER TABLE amt_players ADD CONSTRAINT FK_player_team
  FOREIGN KEY (name_teams) REFERENCES amt_teams (name);

INSERT INTO amt_teams VALUES ("HEIG", "2019-10-30", "Yverdon");
INSERT INTO amt_teams VALUES ("Bosna", "2013-10-30", "Neuchatel");
INSERT INTO amt_teams VALUES ("Eritrea", "2012-10-30", "Lausanne");


INSERT INTO amt_coaches VALUES ("nal", "pass", "Nair", "Alic", true);
INSERT INTO amt_coaches VALUES ("rtt", "pass", "Robel", "Teklehaimanot", false);

INSERT INTO amt_teams_coach VALUES ("rtt","HEIG");
INSERT INTO amt_teams_coach VALUES ("rtt","Bosna");
INSERT INTO amt_teams_coach VALUES ("rtt","Eritrea");

INSERT INTO amt_teams_coach VALUES ("nal","HEIG");
INSERT INTO amt_teams_coach VALUES ("nal","Bosna");





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

INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Nair", "Mama", "GK", 1,"Bosna");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Nair", "Mama", "RB", 2,"Bosna");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Nair", "Mama", "LB", 3,"Bosna");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Nair", "Mama", "CB", 4,"Bosna");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Nair", "Mama", "SW", 5,"Bosna");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Nair", "Mama", "LM", 6,"Bosna");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Nair", "Mama", "CM", 7,"Bosna");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Nair", "Mama", "RM", 8,"Bosna");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Nair", "Mama", "CF", 9,"Bosna");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Nair", "Mama", "RF", 10,"Bosna");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Nair", "Mama", "LF", 11,"Bosna");

INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Robel", "Mama", "GK", 1,"Eritrea");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Robel", "Mama", "RB", 2,"Eritrea");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Robel", "Mama", "LB", 3,"Eritrea");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Robel", "Mama", "CB", 4,"Eritrea");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Robel", "Mama", "SW", 5,"Eritrea");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Robel", "Mama", "LM", 6,"Eritrea");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Robel", "Mama", "CM", 7,"Eritrea");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Robel", "Mama", "RM", 8,"Eritrea");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Robel", "Mama", "CF", 9,"Eritrea");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Robelinho", "Mama", "RF", 10,"Eritrea");
INSERT INTO amt_players (`first_name`,`last_name`,`position`, `number`, `name_teams`) VALUES ("Robel", "Mama", "LF", 11,"Eritrea");




