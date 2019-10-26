DROP DATABASE amtprojectone;
CREATE DATABASE amtprojectone;
USE amtprojectone;


DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
);

DROP TABLE IF EXISTS `Serie`;
CREATE TABLE Serie (
    ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,    
    Title varchar(255),
    Producer varchar(255),
    Synopsis varchar(255),
    Genre varchar(255),
	AgeRestriction INT,
	OwnerID INT,
	FOREIGN KEY (OwnerID) REFERENCES User(ID)
);

DROP TABLE IF EXISTS `Viewer`;
CREATE TABLE Viewer (
    ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,    
    Firstname varchar(255) NOT NULL,
    Lastname varchar(255) NOT NULL,
    Username varchar(255) NOT NULL UNIQUE,
    Genre varchar(255),
    Birthdate DATE,
	OwnerID INT,
	FOREIGN KEY (OwnerID) REFERENCES User(ID)
	ON DELETE CASCADE
);

DROP TABLE IF EXISTS `WatchingInfo`;
CREATE TABLE WatchingInfo (
    IDSerie int NOT NULL,    
    IDViewer int NOT NULL,
    TimeSpent int NOT NULL,
    BeginningDate DATE,
	OwnerID INT,
    PRIMARY KEY (IDSerie, IDViewer),
	FOREIGN KEY (OwnerID) REFERENCES User(ID),
    FOREIGN KEY (IDSerie) REFERENCES Serie(ID) ON DELETE CASCADE,
    FOREIGN KEY (IDViewer) REFERENCES Viewer(ID) ON DELETE CASCADE
);


SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

INSERT INTO `Serie` (`ID`, `Title`, `Producer`, `Synopsis`, `Genre`, `AgeRestriction`, `OwnerID`) VALUES
(1,	'Sherlock',	'BBC',	'Cette adaptation libre des romans et nouvelles d\'Arthur Conan Doyle présente le célèbre duo dans un contexte contemporain. En effet la série transpose l\'époque dans laquelle évoluent les deux personnages de la fin du XIXe siècle au XXIe siècle.  Sherlock Holmes est détective consultant et il accueille comme colocataire le docteur Watson, un ancien médecin de l\'armée britannique blessé en Afghanistan. Il aide Scotland Yard à résoudre des enquêtes ardues en utilisant ses dons d\'observation et de déduction associés aux technologies actuelles comme Internet ou les téléphones portables. ',	'Dramatique',	12,	1),
(2,	'Game of thrones',	'HBO',	' Sur le continent de Westeros, le roi Robert Baratheon gouverne le Royaume des Sept Couronnes depuis plus de dix-sept ans, à la suite de la rébellion qu\'il a menée contre le « roi fou » Aerys II Targaryen. Jon Arryn, époux de la sœur de Lady Catelyn Stark, Lady Arryn, son guide et principal conseiller, vient de décéder, et le roi part alors dans le nord du royaume demander à son vieil ami Eddard « Ned » Stark de remplacer leur regretté mentor au poste de Main du roi. Ned, seigneur suzerain du nord depuis Winterfell et de la maison Stark, est peu désireux de quitter ses terres. Mais il accepte à contre-cœur de partir pour la capitale Port-Réal avec ses deux filles, Sansa et Arya. Juste avant leur départ pour le sud, Bran, l\'un des jeunes fils d\'Eddard, est poussé de l\'une des tours de Winterfell après avoir été témoin de la liaison incestueuse entre la reine Cersei Baratheon et son frère jumeau, Jaime Lannister. Leur frère, Tyrion Lannister, surnommé « le gnome », est alors accusé du crime par Lady Catelyn Stark.\r\nLes neufs Grandes Maisons de la série.\r\n\r\nAu nord-ouest de Westeros, le jeune bâtard de Ned Stark, Jon Snow, se prépare à intégrer la fameuse Garde de nuit. Depuis plus de 8 000 ans, cette confrérie protège et défend le royaume de Westeros de ce qui vit de l\'autre côté du Mur, un gigantesque édifice fait de glace, de pierre et de magie, formant la frontière septentrionale entre les contrées glacées du nord et les Sept Couronnes. Si les Sauvageons ne sont en réalité pas la vraie menace directe, le retour d\'une race d\'anciennes créatures mythiques et légendaires appelée les Marcheurs blancs est en revanche beaucoup plus inquiétant.\r\n\r\nSur le continent d\'Essos, au sud-est au-delà du Détroit, l\'héritier « légitime » en exil des Sept Couronnes, Viserys Targaryen, se prépare à reconquérir le royaume. Prêt à tout, il marie sa jeune sœur, la princesse Daenerys Targaryen, à Khal Drogo, seigneur de guerre des Dothrakis, afin d\'obtenir le soutien de la puissante horde de cavaliers nomades qu\'il dirige. Mais le lunatique Viserys va hériter du même sort que celui de ses parents, laissant à Daenerys le projet de recouvrer sa place sur le Trône de fer, aidée en cela par ses trois dragons.',	'Fantasy médievale',	18,	1);

INSERT INTO `User` (`ID`, `Username`, `Password`) VALUES
(1,	'Obyka',	'password'),
(2,	'JoLaBanane98',	'password');

INSERT INTO `Viewer` (`ID`, `Firstname`, `Lastname`, `Username`, `Genre`, `Birthdate`, `OwnerID`) VALUES
(1,	'Jordan',	'Mercier',	'Jojo',	'Homme',	'2019-10-22',	1),
(2,	'Florian',	'Polier',	'Akybo',	'Homme',	'2019-10-22',	1);

INSERT INTO `WatchingInfo` (`IDSerie`, `IDViewer`, `TimeSpent`, `BeginningDate`, `OwnerID`) VALUES
(1,	1,	120,	'2019-10-22',	1),
(2,	2,	9,	'2019-10-22',	1);