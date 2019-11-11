-- TeamEsport Database Schema
-- Version 1.0

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS TeamEsport;
CREATE SCHEMA TeamEsport;
USE TeamEsport;


--
-- Table structure for table `User`
--

CREATE TABLE IF NOT EXISTS User (
  user_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  pwd VARCHAR(45) NOT NULL,
  PRIMARY KEY  (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `Team`
--

CREATE TABLE IF NOT EXISTS Team (
  team_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  creator_id INT UNSIGNED NOT NULL,
  PRIMARY KEY  (team_id),
  CONSTRAINT fk_creator_team FOREIGN KEY (creator_id) REFERENCES User (user_id) ON DELETE RESTRICT ON UPDATE CASCADE

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `Player`
--

CREATE TABLE IF NOT EXISTS Player (
  player_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  pseudo VARCHAR(45) NOT NULL,
  name VARCHAR(45) NOT NULL,
  team_id INT UNSIGNED NOT NULL,
creator_id INT UNSIGNED NOT NULL,
  PRIMARY KEY  (player_id),
  CONSTRAINT fk_player_team FOREIGN KEY (team_id) REFERENCES Team (team_id) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT fk_creator_player FOREIGN KEY (creator_id) REFERENCES User (user_id) ON DELETE RESTRICT ON UPDATE CASCADE

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `Match`
--
CREATE TABLE IF NOT EXISTS Matches (
  match_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  score_team1 SMALLINT UNSIGNED NOT NULL,
  score_team2 SMALLINT UNSIGNED NOT NULL,
  team1_id INT UNSIGNED NOT NULL,
  team2_id INT UNSIGNED NOT NULL,
  creator_id INT UNSIGNED NOT NULL,
  PRIMARY KEY  (match_id),
  CONSTRAINT fk_match_team1 FOREIGN KEY (team1_id) REFERENCES Team (team_id) ON DELETE RESTRICT ON UPDATE CASCADE,
   CONSTRAINT fk_match_team2 FOREIGN KEY (team2_id) REFERENCES Team (team_id) ON DELETE RESTRICT ON UPDATE CASCADE,
     CONSTRAINT fk_creator_match FOREIGN KEY (creator_id) REFERENCES User (user_id) ON DELETE RESTRICT ON UPDATE CASCADE

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `Match_player`
--
CREATE TABLE IF NOT EXISTS Matches_Player (
  match_id INT UNSIGNED NOT NULL ,
  team_id INT UNSIGNED NOT NULL,
  player_id INT UNSIGNED NOT NULL,
  PRIMARY KEY  (player_id,match_id),
  CONSTRAINT fk_match_player FOREIGN KEY (player_id) REFERENCES Player (player_id) ON DELETE RESTRICT ON UPDATE CASCADE,
   CONSTRAINT fk_match_team FOREIGN KEY (team_id) REFERENCES Team (team_id) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `User`(`name`,`pwd`) VALUES
	('goturak','password'),
    ('kaer','12345678');

--
-- Dumping data for table Team
--

SET AUTOCOMMIT=0;

LOAD DATA INFILE "/var/lib/mysql-files/teams.csv"
INTO TABLE Team 
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n';

INSERT INTO `Team`(`name`,`creator_id`) VALUES
	('no_team',1),
    ('Evil Geniuses',1),
    ('Astralis',1),
    ('fnatic',1),
    ('Liquid',1),
    ('Vitality',1),
    ('GUINESS',1),
    ('WAHLBERG',1),
    ('CHASE',1),
    ('DAVIS',1),
    ('LOLLOBRIGIDA',1),
    ('NICHOLSON',1),
    ('MOSTEL',1),
    ('JOHANSSON',1),
    ('SWANK',1),
    ('GABLE',1),
    ('CAGE',1),
    ('BERRY',1),
    ('WOOD',1),
    ('BERGEN',1),
    ('OLIVIER',1),
    ('COSTNER',1),
    ('VOIGHT',1),
    ('TORN',1),
    ('FAWCETT',1),
    ('TRACY',1),
    ('PALTROW',1),
    ('MARX',1),
    ('KILMER',1),
    ('STREEP',1),
    ('BLOOM',1),
    ('CRAWFORD',1),
    ('MCQUEEN',1),
    ('HOFFMAN',1),
    ('WAYNE',1),
    ('PECK',1),
    ('SOBIESKI',1),
    ('HACKMAN',1),
    ('PECK',1),
    ('OLIVIER',1),
    ('DEAN',1),
    ('DUKAKIS',1),
    ('BOLGER',1),
    ('MCKELLEN',1),
    ('BRODY',1),
    ('CAGE',1),
    ('DEGENERES',1),
    ('MIRANDA',1),
    ('JOVOVICH',1),
    ('STALLONE',1),
    ('KILMER',1),
    ('GOLDBERG',1),
    ('BARRYMORE',1),
    ('DAY-LEWIS',1),
    ('CRONYN',1),
    ('HOPKINS',1),
    ('PHOENIX',1),
    ('HUNT',1),
    ('TEMPLE',1),
    ('PINKETT',1),
    ('KILMER',1),
    ('HARRIS',1),
    ('CRUISE',1),
    ('AKROYD',1),
    ('TAUTOU',1),
    ('BERRY',1),
    ('NEESON',1),
    ('NEESON',1),
    ('WRAY',1),
    ('JOHANSSON',1),
    ('HUDSON',1),
    ('TANDY',1),
    ('BAILEY',1),
    ('WINSLET',1),
    ('TEMPLE',1),
    ('PENELOPE',1),
    ('CARMEN',1),
    ('DARYL',1),
    ('GENE',1),
    ('MEG',1),
    ('CHRIS',1),
    ('MORGAN',1),
    ('HARRISON',1),
    ('DAN',1),
    ('RENEE',1),
    ('CUBA',1),
    ('WARREN',1),
    ('PENELOPE',1),
    ('LIZA',1),
    ('SALMA',1),
    ('JULIANNE',1),
    ('SCARLETT',1),
    ('ALBERT',1),
    ('MERYL',1),
    ('IAN',1),
    ('FAY',1),
    ('GRETA',1),
    ('VIVIEN',1),
    ('LAURA',1),
    ('CHRIS',1),
    ('HARVEY',1),
    ('OPRAH',1),
    ('CHRISTOPHER',1),
    ('HUMPHREY',1),
    ('AL',1),
    ('NICK',1),
    ('LAURENCE',1),
    ('WILL',1),
    ('KENNETH',1),
    ('MENA',1),
    ('OLYMPIA',1),
    ('GROUCHO',1),
    ('ALAN',1),
    ('MICHAEL',1),
    ('WILLIAM',1),
    ('JON',1),
    ('GENE',1),
    ('LISA',1),
    ('ED',1),
    ('JEFF',1),
    ('MATTHEW',1),
    ('DEBBIE',1),
    ('RUSSELL',1),
    ('HUMPHREY',1),
    ('MICHAEL',1),
    ('JULIA',1),
    ('RENEE',1),
    ('ROCK',1),
    ('CUBA',1),
    ('AUDREY',1),
    ('GREGORY',1),
    ('JOHN',1),
    ('BURT',1),
    ('MERYL',1),
    ('JAYNE',1),
    ('BELA',1),
    ('REESE',1),
    ('MARY',1),
    ('JULIA',1),
    ('THORA',1);
    
    
    SET AUTOCOMMIT=0;
LOAD DATA INFILE "/var/lib/mysql-files/players.csv"
INTO TABLE Player 
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n';
INSERT INTO `Player`(`pseudo`,`name`,`team_id`,`creator_id`) VALUES
    ('stanislaw','Peter Jarguz',2,1),
    ('tarik','Tarik Celik',2,1),
    ('Brehze','Vincent Cayonte',2,1),
    ('Ethan','Ethan Arnold',2,1),
    ('CeRq','Tsvetelin Dimitrov',2,1),
    ('Xyp9x','andreas Hojsleth',3,1),
    ('dupreeh','PeterRasmussen',3,1),
    ('gla1ve','Lukas Rossander',3,1),
    ('device','Nicolai Reedtz',3,1),
    ('Magisk','Emil Reif',3,1),
    ('flusha','Robin Ronnquist',4,1),
    ('JW','Jesper Wecksell',4,1),
    ('KRIMZ','Freddy Johansson',4,1),
    ('Golden','Maikil Selim',4,1),
    ('Brollan','Ludvig Brolin',4,1),
    ('nitr0','Nick Cannella',5,1),
    ('NAF','Keith Markovic',5,1),
    ('EliGE','Jonathn Jablonowski',5,1),
    ('Stewie2K','Jake yip',5,1),
    ('Twistzz','Russel Van Dulken',5,1),
    ('shox','Richard Papillon',6,1),
    ('RpK','Cedric Guipouy',6,1),
    ('aPEX','Dan Madesclaire',6,1),
    ('ALEX','Alex McMeekin',6,1),
    ('ZywOo','Mathieu Herbaut',6,1),
    ('GUINESS','GUINESS',1,1),
    ('WAHLBERG','WAHLBERG',1,1),
    ('CHASE','CHASE',1,1),
    ('DAVIS','DAVIS',1,1),
    ('LOLLOBRIGIDA','LOLLOBRIGIDA',1,1),
    ('NICHOLSON','NICHOLSON',1,1),
    ('MOSTEL','MOSTEL',1,1),
    ('JOHANSSON','JOHANSSON',1,1),
    ('SWANK','SWANK',1,1),
    ('GABLE','GABLE',1,1),
    ('CAGE','CAGE',1,1),
    ('BERRY','BERRY',1,1),
    ('WOOD','WOOD',1,1),
    ('BERGEN','BERGEN',1,1),
    ('OLIVIER','OLIVIER',1,1),
    ('COSTNER','COSTNER',1,1),
    ('VOIGHT','VOIGHT',1,1),
    ('TORN','TORN',1,1),
    ('FAWCETT','FAWCETT',1,1),
    ('TRACY','TRACY',1,1),
    ('PALTROW','PALTROW',1,1),
    ('MARX','MARX',1,1),
    ('KILMER','KILMER',1,1),
    ('STREEP','STREEP',1,1),
    ('BLOOM','BLOOM',1,1),
    ('CRAWFORD','CRAWFORD',1,1),
    ('MCQUEEN','MCQUEEN',1,1),
    ('HOFFMAN','HOFFMAN',1,1),
    ('WAYNE','WAYNE',1,1),
    ('PECK','PECK',1,1),
    ('SOBIESKI','SOBIESKI',1,1),
    ('HACKMAN','HACKMAN',1,1),
    ('PECK','PECK',1,1),
    ('OLIVIER','OLIVIER',1,1),
    ('DEAN','DEAN',1,1),
    ('DUKAKIS','DUKAKIS',1,1),
    ('BOLGER','BOLGER',1,1),
    ('MCKELLEN','MCKELLEN',1,1),
    ('BRODY','BRODY',1,1),
    ('CAGE','CAGE',1,1),
    ('DEGENERES','DEGENERES',1,1),
    ('MIRANDA','MIRANDA',1,1),
    ('JOVOVICH','JOVOVICH',1,1),
    ('STALLONE','STALLONE',1,1),
    ('KILMER','KILMER',1,1),
    ('GOLDBERG','GOLDBERG',1,1),
    ('BARRYMORE','BARRYMORE',1,1),
    ('DAY-LEWIS','DAY-LEWIS',1,1),
    ('CRONYN','CRONYN',1,1),
    ('HOPKINS','HOPKINS',1,1),
    ('PHOENIX','PHOENIX',1,1),
    ('HUNT','HUNT',1,1),
    ('TEMPLE','TEMPLE',1,1),
    ('PINKETT','PINKETT',1,1),
    ('KILMER','KILMER',1,1),
    ('HARRIS','HARRIS',1,1),
    ('CRUISE','CRUISE',1,1),
    ('AKROYD','AKROYD',1,1),
    ('TAUTOU','TAUTOU',1,1),
    ('BERRY','BERRY',1,1),
    ('NEESON','NEESON',1,1),
    ('NEESON','NEESON',1,1),
    ('WRAY','WRAY',1,1),
    ('JOHANSSON','JOHANSSON',1,1),
    ('HUDSON','HUDSON',1,1),
    ('TANDY','TANDY',1,1),
    ('BAILEY','BAILEY',1,1),
    ('WINSLET','WINSLET',1,1),
    ('TEMPLE','TEMPLE',1,1),
    ('PENELOPE','PENELOPE',1,1),
    ('CARMEN','CARMEN',1,1),
    ('DARYL','DARYL',1,1),
    ('GENE','GENE',1,1),
    ('MEG','MEG',1,1),
    ('CHRIS','CHRIS',1,1),
    ('MORGAN','MORGAN',1,1),
    ('HARRISON','HARRISON',1,1),
    ('DAN','DAN',1,1),
    ('RENEE','RENEE',1,1),
    ('CUBA','CUBA',1,1),
    ('WARREN','WARREN',1,1),
    ('PENELOPE','PENELOPE',1,1),
    ('LIZA','LIZA',1,1),
    ('SALMA','SALMA',1,1),
    ('JULIANNE','JULIANNE',1,1),
    ('SCARLETT','SCARLETT',1,1),
    ('ALBERT','ALBERT',1,1),
    ('MERYL','MERYL',1,1),
    ('IAN','IAN',1,1),
    ('FAY','FAY',1,1),
    ('GRETA','GRETA',1,1),
    ('VIVIEN','VIVIEN',1,1),
    ('LAURA','LAURA',1,1),
    ('CHRIS','CHRIS',1,1),
    ('HARVEY','HARVEY',1,1),
    ('OPRAH','OPRAH',1,1),
    ('CHRISTOPHER','CHRISTOPHER',1,1),
    ('HUMPHREY','HUMPHREY',1,1),
    ('AL','AL',1,1),
    ('NICK','NICK',1,1),
    ('LAURENCE','LAURENCE',1,1),
    ('WILL','WILL',1,1),
    ('KENNETH','KENNETH',1,1),
    ('MENA','MENA',1,1),
    ('OLYMPIA','OLYMPIA',1,1),
    ('GROUCHO','GROUCHO',1,1),
    ('ALAN','ALAN',1,1),
    ('MICHAEL','MICHAEL',1,1),
    ('WILLIAM','WILLIAM',1,1),
    ('JON','JON',1,1),
    ('GENE','GENE',1,1),
    ('LISA','LISA',1,1),
    ('ED','ED',1,1),
    ('JEFF','JEFF',1,1),
    ('MATTHEW','MATTHEW',1,1),
    ('DEBBIE','DEBBIE',1,1),
    ('RUSSELL','RUSSELL',1,1),
    ('HUMPHREY','HUMPHREY',1,1),
    ('MICHAEL','MICHAEL',1,1),
    ('JULIA','JULIA',1,1),
    ('RENEE','RENEE',1,1),
    ('ROCK','ROCK',1,1),
    ('CUBA','CUBA',1,1),
    ('AUDREY','AUDREY',1,1),
    ('GREGORY','GREGORY',1,1),
    ('JOHN','JOHN',1,1),
    ('BURT','BURT',1,1),
    ('MERYL','MERYL',1,1),
    ('JAYNE','JAYNE',1,1),
    ('BELA','BELA',1,1),
    ('REESE','REESE',1,1),
    ('MARY','MARY',1,1),
    ('JULIA','JULIA',1,1),
    ('THORA','THORA',1,1);

SET AUTOCOMMIT=0;
  
LOAD DATA INFILE "/var/lib/mysql-files/matches.csv"
INTO TABLE Matches 
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n';
    

LOAD DATA INFILE "/var/lib/mysql-files/matchesPlayer.csv"
INTO TABLE Matches_Player
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n';
    
    

CREATE VIEW Pseudo
AS 
SELECT 
    pseudo, 
    name
FROM
    Player;

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
    Team.team_id as team_id
FROM
    Player JOIN Team ON Player.team_id = Team.team_id;    

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

