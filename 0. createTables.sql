/*
  __
 /\ \
 \_\ \    ____  __  __     __
 /'_` \  /',__\/\ \/\ \  /'__`\
/\ \L\ \/\__, `\ \ \_/ |/\  __/
\ \___,_\/\____/\ \___/ \ \____\
 \/__,_ /\/___/  \/__/   \/____/

*/

SHOW DATABASES;

CREATE DATABASE dsve_cinema_booking_system;
USE dsve_cinema_booking_system;

-- 1
CREATE TABLE films
(
  filmsId                 INT PRIMARY KEY AUTO_INCREMENT,
  filmName                VARCHAR(45) NOT NULL UNIQUE,
  filmLengthMinutes       INT         NOT NULL,
  filmChronologicalOrder  INT         NOT NULL,
  filmYear                INT         NOT NULL
);
DESCRIBE films;


-- 2
CREATE TABLE customers
(
  customerId        INT PRIMARY KEY AUTO_INCREMENT,
  customerFirstName VARCHAR(45),
  customerLastName  VARCHAR(45),
  customerGender    ENUM ('M', 'F') NOT NULL,
  customerEmail     VARCHAR(45)     NOT NULL UNIQUE
);
DESCRIBE customers;


-- 3
CREATE TABLE rooms
(
  roomId            INT PRIMARY KEY AUTO_INCREMENT,
  roomName          VARCHAR(45) NOT NULL,
  roomNumberOfSeats INT         NOT NULL
);
DESCRIBE rooms;


-- 4
CREATE TABLE screenings
(
  screeningId        INT PRIMARY KEY AUTO_INCREMENT,
  screeningStartTime DATETIME NOT NULL,
  screeningFilmId    INT      NOT NULL,
  screeningRoomId    INT      NOT NULL,
  FOREIGN KEY (screeningFilmId) REFERENCES films (filmsId),
  FOREIGN KEY (screeningRoomId) REFERENCES rooms (roomId)
);
DESCRIBE screenings;


-- 5
CREATE TABLE seats
(
  seatsId    INT PRIMARY KEY AUTO_INCREMENT,
  seatRow    CHAR(1) NOT NULL,
  seatNumber INT     NOT NULL,
  seatRoomId INT     NOT NULL,
  FOREIGN KEY (seatRoomId) REFERENCES rooms (roomId)
);
DESCRIBE seats;


-- 6
CREATE TABLE bookings
(
  bookingId          INT PRIMARY KEY AUTO_INCREMENT,
  bookingScreeningId INT NOT NULL,
  bookingCustomerId  INT NOT NULL,
  FOREIGN KEY (bookingScreeningId) REFERENCES screenings (screeningId),
  FOREIGN KEY (bookingCustomerId) REFERENCES customers (customerId)
);
DESCRIBE bookings;


-- 7
CREATE TABLE reservedSeats
(
  reservedSeatId        INT PRIMARY KEY AUTO_INCREMENT,
  reservedSeatBookingId INT NOT NULL,
  reservedSeatSeatId    INT NOT NULL,
  FOREIGN KEY (reservedSeatBookingId) REFERENCES bookings (bookingId),
  FOREIGN KEY (reservedSeatSeatId) REFERENCES seats (seatsId)
);
DESCRIBE reservedSeats;


SHOW TABLES;