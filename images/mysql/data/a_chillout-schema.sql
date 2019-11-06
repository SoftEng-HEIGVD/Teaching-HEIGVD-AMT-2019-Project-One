DROP DATABASE IF EXISTS chillout;

CREATE DATABASE chillout;

Use chillout;

CREATE TABLE Client (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `isAdmin` boolean
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Product (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `unitPrice` decimal(10,2) not null,
  `description` TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Order (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `idClient` int(11) NOT NULL,
  `command` varchar(256),
    foreign key (idClient) references Client(id)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
