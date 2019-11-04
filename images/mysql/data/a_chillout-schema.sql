#DROP DATABASE IF EXISTS chillout;

CREATE DATABASE IF NOT EXISTS chillout;

CREATE TABLE `chillout`.`Person` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `isAdmin` boolean
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `chillout`.`Client` (
  `id` int(11) UNIQUE NOT NULL AUTO_INCREMENT,
  foreign key (id) references Person(id)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `chillout`.`Volunteer` (
  `id` int(11) UNIQUE NOT NULL AUTO_INCREMENT,
  foreign key (id) references Person(id)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `chillout`.`Supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `chillout`.`Product` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `unitPrice` decimal(10,2) not null
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `chillout`.`OrderItem` (
  `idProduct` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  foreign key (idProduct) references Product(id)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `chillout`.`Order` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `idVolunteer` int(11) NOT NULL,
  `idSupplier` int(11) NOT NULL,
    foreign key (idVolunteer) references Volunteer(id),
    foreign key (idSupplier) references Supplier(id)

  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
