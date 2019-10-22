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
    FOREIGN KEY (IDSerie) REFERENCES Serie(ID),
    FOREIGN KEY (IDViewer) REFERENCES Viewer(ID)
);