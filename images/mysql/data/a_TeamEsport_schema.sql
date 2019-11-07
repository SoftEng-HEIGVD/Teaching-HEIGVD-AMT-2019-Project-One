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
    
    
CREATE VIEW PSeudo
AS 
SELECT 
    pseudo, 
    name
FROM
    Player;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

