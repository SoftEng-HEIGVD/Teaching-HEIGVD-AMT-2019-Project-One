SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

SET @@global.time_zone = '+00:00';
SET @@session.time_zone = '+00:00';

DROP SCHEMA IF EXISTS FlightCompany;
CREATE SCHEMA FlightCompany;
USE FlightCompany;

--
-- Table structure for table `customer`
--

CREATE TABLE customer (
  customer_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  customer_pseudo VARCHAR(45) NOT NULL,
  firstname VARCHAR(20) NOT NULL,
  lastname VARCHAR(20) NOT NULL,
  age SMALLINT NOT NULL,
  customer_pw VARCHAR(45) NOT NULL,
  PRIMARY KEY  (customer_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `flight`
--

CREATE TABLE flight (
  flight_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  departure_time INT NOT NULL,
  arrival_time INT NOT NULL,
  start_point VARCHAR(20) NOT NULL,
  end_point_point VARCHAR(20) NOT NULL,
  price INT NOT NULL,
  PRIMARY KEY  (product_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `flightReservation`
--

CREATE TABLE flightReservation (
  customer_id SMALLINT UNSIGNED NOT NULL,
  flight_id SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY  (customer_id,flight_id),
  FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (flight_id) REFERENCES flight (flight_id) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;