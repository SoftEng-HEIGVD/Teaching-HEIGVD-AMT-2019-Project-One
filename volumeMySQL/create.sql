CREATE DATABASE amtprojectone;
USE amtprojectone;

CREATE TABLE Serie (
    ID int NOT NULL PRIMARY KEY,    
    Title varchar(255),
    Producer varchar(255),
    Synopsis varchar(255),
    Genre varchar(255),
	AgeRestriction int 
);

CREATE TABLE Viewer (
    ID int NOT NULL PRIMARY KEY,    
    Firstname varchar(255) NOT NULL,
    Lastname varchar(255) NOT NULL,
    Username varchar(255) NOT NULL UNIQUE,
    Genre varchar(255),
    Birthdate DATE
);

CREATE TABLE WatchingInfo (
    IDSerie int NOT NULL,    
    IDViewer int NOT NULL,
    TimeSpent int NOT NULL,
    BeginningDate DATE,
    PRIMARY KEY (IDSerie, IDViewer),
    FOREIGN KEY (IDSerie) REFERENCES Serie(ID),
    FOREIGN KEY (IDViewer) REFERENCES Viewer(ID)
);