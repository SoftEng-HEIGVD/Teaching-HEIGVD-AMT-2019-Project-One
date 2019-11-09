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
-- Table structure for table `Match`
--
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
-- Dumping data for table player
--

SET AUTOCOMMIT=0;
INSERT INTO `Player`(`pseudo`,`name`,`team_id`) VALUES
    ('stanislaw','Peter Jarguz',2),
    ('tarik','Tarik Celik',2),
    ('Brehze','Vincent Cayonte',2),
    ('Ethan','Ethan Arnold',2),
    ('CeRq','Tsvetelin Dimitrov',2),
    ('Xyp9x','andreas Hojsleth',3),
    ('dupreeh','PeterRasmussen',3),
    ('gla1ve','Lukas Rossander',3),
    ('device','Nicolai Reedtz',3),
    ('Magisk','Emil Reif',3),
    ('flusha','Robin Ronnquist',4),
    ('JW','Jesper Wecksell',4),
    ('KRIMZ','Freddy Johansson',4),
    ('Golden','Maikil Selim',4),
    ('Brollan','Ludvig Brolin',4),
    ('nitr0','Nick Cannella',5),
    ('NAF','Keith Markovic',5),
    ('EliGE','Jonathn Jablonowski',5),
    ('Stewie2K','Jake yip',5),
    ('Twistzz','Russel Van Dulken',5),
    ('shox','Richard Papillon',6),
    ('RpK','Cedric Guipouy',6),
    ('aPEX','Dan Madesclaire',6),
    ('ALEX','Alex McMeekin',6),
    ('ZywOo','Mathieu Herbaut',6),
    ('GUINESS','GUINESS',1),
    ('WAHLBERG','WAHLBERG',1),
    ('CHASE','CHASE',1),
    ('DAVIS','DAVIS',1),
    ('LOLLOBRIGIDA','LOLLOBRIGIDA',1),
    ('NICHOLSON','NICHOLSON',1),
    ('MOSTEL','MOSTEL',1),
    ('JOHANSSON','JOHANSSON',1),
    ('SWANK','SWANK',1),
    ('GABLE','GABLE',1),
    ('CAGE','CAGE',1),
    ('BERRY','BERRY',1),
    ('WOOD','WOOD',1),
    ('BERGEN','BERGEN',1),
    ('OLIVIER','OLIVIER',1),
    ('COSTNER','COSTNER',1),
    ('VOIGHT','VOIGHT',1),
    ('TORN','TORN',1),
    ('FAWCETT','FAWCETT',1),
    ('TRACY','TRACY',1),
    ('PALTROW','PALTROW',1),
    ('MARX','MARX',1),
    ('KILMER','KILMER',1),
    ('STREEP','STREEP',1),
    ('BLOOM','BLOOM',1),
    ('CRAWFORD','CRAWFORD',1),
    ('MCQUEEN','MCQUEEN',1),
    ('HOFFMAN','HOFFMAN',1),
    ('WAYNE','WAYNE',1),
    ('PECK','PECK',1),
    ('SOBIESKI','SOBIESKI',1),
    ('HACKMAN','HACKMAN',1),
    ('PECK','PECK',1),
    ('OLIVIER','OLIVIER',1),
    ('DEAN','DEAN',1),
    ('DUKAKIS','DUKAKIS',1),
    ('BOLGER','BOLGER',1),
    ('MCKELLEN','MCKELLEN',1),
    ('BRODY','BRODY',1),
    ('CAGE','CAGE',1),
    ('DEGENERES','DEGENERES',1),
    ('MIRANDA','MIRANDA',1),
    ('JOVOVICH','JOVOVICH',1),
    ('STALLONE','STALLONE',1),
    ('KILMER','KILMER',1),
    ('GOLDBERG','GOLDBERG',1),
    ('BARRYMORE','BARRYMORE',1),
    ('DAY-LEWIS','DAY-LEWIS',1),
    ('CRONYN','CRONYN',1),
    ('HOPKINS','HOPKINS',1),
    ('PHOENIX','PHOENIX',1),
    ('HUNT','HUNT',1),
    ('TEMPLE','TEMPLE',1),
    ('PINKETT','PINKETT',1),
    ('KILMER','KILMER',1),
    ('HARRIS','HARRIS',1),
    ('CRUISE','CRUISE',1),
    ('AKROYD','AKROYD',1),
    ('TAUTOU','TAUTOU',1),
    ('BERRY','BERRY',1),
    ('NEESON','NEESON',1),
    ('NEESON','NEESON',1),
    ('WRAY','WRAY',1),
    ('JOHANSSON','JOHANSSON',1),
    ('HUDSON','HUDSON',1),
    ('TANDY','TANDY',1),
    ('BAILEY','BAILEY',1),
    ('WINSLET','WINSLET',1),
    ('TEMPLE','TEMPLE',1),
    ('PENELOPE','PENELOPE',1),
    ('CARMEN','CARMEN',1),
    ('DARYL','DARYL',1),
    ('GENE','GENE',1),
    ('MEG','MEG',1),
    ('CHRIS','CHRIS',1),
    ('MORGAN','MORGAN',1),
    ('HARRISON','HARRISON',1),
    ('DAN','DAN',1),
    ('RENEE','RENEE',1),
    ('CUBA','CUBA',1),
    ('WARREN','WARREN',1),
    ('PENELOPE','PENELOPE',1),
    ('LIZA','LIZA',1),
    ('SALMA','SALMA',1),
    ('JULIANNE','JULIANNE',1),
    ('SCARLETT','SCARLETT',1),
    ('ALBERT','ALBERT',1),
    ('MERYL','MERYL',1),
    ('IAN','IAN',1),
    ('FAY','FAY',1),
    ('GRETA','GRETA',1),
    ('VIVIEN','VIVIEN',1),
    ('LAURA','LAURA',1),
    ('CHRIS','CHRIS',1),
    ('HARVEY','HARVEY',1),
    ('OPRAH','OPRAH',1),
    ('CHRISTOPHER','CHRISTOPHER',1),
    ('HUMPHREY','HUMPHREY',1),
    ('AL','AL',1),
    ('NICK','NICK',1),
    ('LAURENCE','LAURENCE',1),
    ('WILL','WILL',1),
    ('KENNETH','KENNETH',1),
    ('MENA','MENA',1),
    ('OLYMPIA','OLYMPIA',1),
    ('GROUCHO','GROUCHO',1),
    ('ALAN','ALAN',1),
    ('MICHAEL','MICHAEL',1),
    ('WILLIAM','WILLIAM',1),
    ('JON','JON',1),
    ('GENE','GENE',1),
    ('LISA','LISA',1),
    ('ED','ED',1),
    ('JEFF','JEFF',1),
    ('MATTHEW','MATTHEW',1),
    ('DEBBIE','DEBBIE',1),
    ('RUSSELL','RUSSELL',1),
    ('HUMPHREY','HUMPHREY',1),
    ('MICHAEL','MICHAEL',1),
    ('JULIA','JULIA',1),
    ('RENEE','RENEE',1),
    ('ROCK','ROCK',1),
    ('CUBA','CUBA',1),
    ('AUDREY','AUDREY',1),
    ('GREGORY','GREGORY',1),
    ('JOHN','JOHN',1),
    ('BURT','BURT',1),
    ('MERYL','MERYL',1),
    ('JAYNE','JAYNE',1),
    ('BELA','BELA',1),
    ('REESE','REESE',1),
    ('MARY','MARY',1),
    ('JULIA','JULIA',1),
    ('THORA','THORA',1);

--
-- Dumping data for table Team
--

SET AUTOCOMMIT=0;
INSERT INTO `Team`(`name`) VALUES
	('no_team'),
    ('Evil Geniuses'),
    ('Astralis'),
    ('fnatic'),
    ('Liquid'),
    ('Vitality'),
    ('GUINESS'),
    ('WAHLBERG'),
    ('CHASE'),
    ('DAVIS'),
    ('LOLLOBRIGIDA'),
    ('NICHOLSON'),
    ('MOSTEL'),
    ('JOHANSSON'),
    ('SWANK'),
    ('GABLE'),
    ('CAGE'),
    ('BERRY'),
    ('WOOD'),
    ('BERGEN'),
    ('OLIVIER'),
    ('COSTNER'),
    ('VOIGHT'),
    ('TORN'),
    ('FAWCETT'),
    ('TRACY'),
    ('PALTROW'),
    ('MARX'),
    ('KILMER'),
    ('STREEP'),
    ('BLOOM'),
    ('CRAWFORD'),
    ('MCQUEEN'),
    ('HOFFMAN'),
    ('WAYNE'),
    ('PECK'),
    ('SOBIESKI'),
    ('HACKMAN'),
    ('PECK'),
    ('OLIVIER'),
    ('DEAN'),
    ('DUKAKIS'),
    ('BOLGER'),
    ('MCKELLEN'),
    ('BRODY'),
    ('CAGE'),
    ('DEGENERES'),
    ('MIRANDA'),
    ('JOVOVICH'),
    ('STALLONE'),
    ('KILMER'),
    ('GOLDBERG'),
    ('BARRYMORE'),
    ('DAY-LEWIS'),
    ('CRONYN'),
    ('HOPKINS'),
    ('PHOENIX'),
    ('HUNT'),
    ('TEMPLE'),
    ('PINKETT'),
    ('KILMER'),
    ('HARRIS'),
    ('CRUISE'),
    ('AKROYD'),
    ('TAUTOU'),
    ('BERRY'),
    ('NEESON'),
    ('NEESON'),
    ('WRAY'),
    ('JOHANSSON'),
    ('HUDSON'),
    ('TANDY'),
    ('BAILEY'),
    ('WINSLET'),
    ('TEMPLE'),
    ('PENELOPE'),
    ('CARMEN'),
    ('DARYL'),
    ('GENE'),
    ('MEG'),
    ('CHRIS'),
    ('MORGAN'),
    ('HARRISON'),
    ('DAN'),
    ('RENEE'),
    ('CUBA'),
    ('WARREN'),
    ('PENELOPE'),
    ('LIZA'),
    ('SALMA'),
    ('JULIANNE'),
    ('SCARLETT'),
    ('ALBERT'),
    ('MERYL'),
    ('IAN'),
    ('FAY'),
    ('GRETA'),
    ('VIVIEN'),
    ('LAURA'),
    ('CHRIS'),
    ('HARVEY'),
    ('OPRAH'),
    ('CHRISTOPHER'),
    ('HUMPHREY'),
    ('AL'),
    ('NICK'),
    ('LAURENCE'),
    ('WILL'),
    ('KENNETH'),
    ('MENA'),
    ('OLYMPIA'),
    ('GROUCHO'),
    ('ALAN'),
    ('MICHAEL'),
    ('WILLIAM'),
    ('JON'),
    ('GENE'),
    ('LISA'),
    ('ED'),
    ('JEFF'),
    ('MATTHEW'),
    ('DEBBIE'),
    ('RUSSELL'),
    ('HUMPHREY'),
    ('MICHAEL'),
    ('JULIA'),
    ('RENEE'),
    ('ROCK'),
    ('CUBA'),
    ('AUDREY'),
    ('GREGORY'),
    ('JOHN'),
    ('BURT'),
    ('MERYL'),
    ('JAYNE'),
    ('BELA'),
    ('REESE'),
    ('MARY'),
    ('JULIA'),
    ('THORA');
    
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

