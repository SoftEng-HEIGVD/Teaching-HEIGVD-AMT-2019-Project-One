-- TeamEsport Database Schema
-- Version 1.0

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS TeamEsport;
CREATE SCHEMA TeamEsport;
USE TeamEsport;


--
-- Table structure for table `Team`
--

CREATE TABLE IF NOT EXISTS Team (
  team_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY  (team_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `Player`
--

CREATE TABLE IF NOT EXISTS Player (
  player_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  pseudo VARCHAR(45) NOT NULL,
  name VARCHAR(45) NOT NULL,
  team_id SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY  (player_id),
  CONSTRAINT fk_player_team FOREIGN KEY (team_id) REFERENCES Team (team_id) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS Matches (
  match_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  score_team1 SMALLINT UNSIGNED NOT NULL,
  score_team2 SMALLINT UNSIGNED NOT NULL,
  team1_id SMALLINT UNSIGNED NOT NULL,
  team2_id SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY  (match_id),
  CONSTRAINT fk_match_team1 FOREIGN KEY (team1_id) REFERENCES Team (team_id) ON DELETE RESTRICT ON UPDATE CASCADE,
   CONSTRAINT fk_match_team2 FOREIGN KEY (team2_id) REFERENCES Team (team_id) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `Match_player`
--
CREATE TABLE IF NOT EXISTS Matches_Player (
  match_id SMALLINT UNSIGNED NOT NULL ,
  team_id SMALLINT UNSIGNED NOT NULL,
  player_id SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY  (player_id,match_id),
  CONSTRAINT fk_match_player FOREIGN KEY (player_id) REFERENCES Player (player_id) ON DELETE RESTRICT ON UPDATE CASCADE,
   CONSTRAINT fk_match_team FOREIGN KEY (team_id) REFERENCES Team (team_id) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- View structure for view `customer_list`
--

--
-- Dumping data for table player
--

SET AUTOCOMMIT=0;
INSERT INTO `Player`(`player_id`,`pseudo`,`name`,`team_id`) VALUES
    (1,'stanislaw','Peter Jarguz',1),
    (2,'tarik','Tarik Celik',1),
    (3,'Brehze','Vincent Cayonte',1),
    (4,'Ethan','Ethan Arnold',1),
    (5,'CeRq','Tsvetelin Dimitrov',1),
    (6,'Xyp9x','andreas Hojsleth',2),
    (7,'dupreeh','PeterRasmussen',2),
    (8,'gla1ve','Lukas Rossander',2),
    (9,'device','Nicolai Reedtz',2),
    (10,'Magisk','Emil Reif',2),
    (11,'flusha','Robin Ronnquist',3),
    (12,'JW','Jesper Wecksell',3),
    (13,'KRIMZ','Freddy Johansson',3),
    (14,'Golden','Maikil Selim',3),
    (15,'Brollan','Ludvig Brolin',3),
    (16,'nitr0','Nick Cannella',4),
    (17,'NAF','Keith Markovic',4),
    (18,'EliGE','Jonathn Jablonowski',4),
    (19,'Stewie2K','Jake yip',4),
    (20,'Twistzz','Russel Van Dulken',4),
    (21,'shox','Richard Papillon',5),
    (22,'RpK','Cedric Guipouy',5),
    (23,'aPEX','Dan Madesclaire',5),
    (24,'ALEX','Alex McMeekin',5),
    (25,'ZywOo','Mathieu Herbaut',5);

--
-- Dumping data for table Team
--

SET AUTOCOMMIT=0;
INSERT INTO `Team`(`team_id`,`name`) VALUES
    (1,'Evil Geniuses'),
    (2,'Astralis'),
    (3,'fnatic'),
    (4,'Liquid'),
    (5,'Vitality');

SET AUTOCOMMIT=0;
INSERT INTO `Matches`(`match_id`,`score_team1`,`score_team2`,`team1_id`,`team2_id`) VALUES
    (1,15,9,1,2),
    (2,15,2,2,4),
    (3,3,9,5,1),
    (4,7,12,2,3),
    (5,0,5,3,4);
    

INSERT INTO `Matches_Player`(`match_id`,`team_id`,`player_id`) VALUES
    (1,1,1),
    (1,1,2),
    (1,1,3),
    (1,1,4),
    (1,1,5),
    (1,2,6),
    (1,2,7),
    (1,2,8),
    (1,2,9),
    (1,2,10),
    
    (2,1,6),
    (2,1,7),
    (2,1,8),
    (2,1,9),
    (2,1,10),
    (2,2,16),
    (2,2,17),
    (2,2,18),
    (2,2,19),
    (2,2,20),
    
    (3,1,21),
    (3,1,22),
    (3,1,23),
    (3,1,24),
    (3,1,25),
    (3,2,1),
    (3,2,2),
    (3,2,3),
    (3,2,4),
    (3,2,5),
    
    (4,1,6),
    (4,1,7),
    (4,1,8),
    (4,1,9),
    (4,1,10),
    (4,2,11),
    (4,2,12),
    (4,2,13),
    (4,2,14),
    (4,2,15),
    
    (5,1,11),
    (5,1,12),
    (5,1,13),
    (5,1,14),
    (5,1,15),
    (5,2,16),
    (5,2,17),
    (5,2,18),
    (5,2,19),
    (5,2,20);
    
CREATE VIEW MatchWithTeam
AS
SELECT
Matches.match_id as match_id,
 Matches.score_team1 as score_team1 ,
 Matches.score_team2 as score_team2,
 Matches.team1_id as team1_id,
 Matches.team2_id as team2_id,
 t1.name as team1 ,
 t2.name as team2
 from Matches 
inner join Team t1 on Matches.team1_id = t1.team_id
inner join Team t2 on  Matches.team2_id = t2.team_id; 

   
CREATE VIEW PlayerWithTeam
AS 
SELECT 
	Player.player_id AS player_id,
    Player.pseudo AS pseudo, 
    Player.name AS name,
    Team.name AS team,
    Team.team_id AS team_id
FROM
    Player JOIN Team WHERE Player.team_id = Team.team_id;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

