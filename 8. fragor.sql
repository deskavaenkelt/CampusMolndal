/*
  __
 /\ \
 \_\ \    ____  __  __     __
 /'_` \  /',__\/\ \/\ \  /'__`\
/\ \L\ \/\__, `\ \ \_/ |/\  __/
\ \___,_\/\____/\ \___/ \ \____\
 \/__,_ /\/___/  \/__/   \/____/

*/

USE dsve_cinema_booking_system;

SHOW TABLES;

-- Förslag från Jerry
-- ok INSERT / UPDATE / DELETE på kund
-- ok INNER JOIN på bokningar
-- ok INNER JOIN på filmer
-- ok INNER JOIN på filmer på en biograf/rum
-- ok VIEW antal säten sorterat  GROUP BY per rum
-- ok Index
-- ok Stored procedure/Triggers

SELECT * FROM bookings;
SELECT * FROM customers;
SELECT * FROM films;
SELECT * FROM reservedseats;
SELECT * FROM rooms;
SELECT * FROM screenings;
SELECT * FROM seats;



-- INSERT / UPDATE / DELETE på kund
SELECT * FROM customers;
-- INSERT
INSERT INTO customers (customerFirstName, customerLastName, customerEmail, customerGender)
VALUES ('Nisse', 'Lind', 'nlind@gmail.com', 'M');

-- UPDATE
UPDATE customers
SET customerEmail = 'nissel@gmail.com'
WHERE customerFirstName = 'Nisse'
  AND customerLastName = 'Lind';

-- DELETE
DELETE
FROM customers
WHERE customerFirstName = 'Nisse';



-- INNER JOIN på bokningar
SELECT *
FROM bookings;

-- Vem har bokat vad, bokningsordning?
SELECT b.bookingId, c.customerFirstName, c.customerLastName, f.filmName
FROM bookings b
       INNER JOIN screenings s ON b.bookingScreeningId = s.screeningId
       INNER JOIN customers c ON b.bookingCustomerId = c.customerId
       INNER JOIN films f on s.screeningFilmId = f.filmsId
ORDER BY b.bookingId;


-- Vilken film har mest bokningar?
SELECT f.filmName, COUNT(f.filmName) AS screeningsPerFilm
FROM bookings b
       INNER JOIN screenings s ON b.bookingScreeningId = s.screeningId
       INNER JOIN films f on s.screeningFilmId = f.filmsId
GROUP BY f.filmName
ORDER BY screeningsPerFilm DESC;




-- INNER JOIN på filmer
SELECT * FROM films;

-- Hur många screenings har varje film
SELECT f.filmName, COUNT(s.screeningFilmId) AS numberOfScreenings
FROM films f
       INNER JOIN screenings s on f.filmsId = s.screeningFilmId
GROUP BY f.filmName
ORDER BY numberOfScreenings DESC;

-- Hur många spelminuter*screenings har varje film
SELECT f.filmName, COUNT(s.screeningFilmId) AS numberOfScreenings, (f.filmLengthMinutes * (COUNT(s.screeningFilmId))) AS playedMinutesTotal
FROM films f
       INNER JOIN screenings s on f.filmsId = s.screeningFilmId
GROUP BY f.filmName
ORDER BY playedMinutesTotal DESC;



-- INNER JOIN på filmer på en biograf/rum
SELECT * FROM films;
SELECT * FROM screenings;
SELECT * FROM rooms;

-- Hur många ggr har varje film spelats upp i ett visst rum
SELECT r.roomName, f.filmName, COUNT(f.filmsId) AS timesAFilmHasPlayed
FROM screenings s
JOIN films f on s.screeningFilmId = f.filmsId
JOIN rooms r on s.screeningRoomId = r.roomId
GROUP BY f.filmName;



/*-- --*/
-- VIEW antal säten sorterat  GROUP BY per rum
-- räkna ut hur många ggr ett visst filmId har spelats upp i ett rumsID
SELECT * FROM reservedseats;
SELECT * FROM screenings;

SELECT COUNT(*)
FROM bookings
JOIN screenings s on bookings.bookingScreeningId = s.screeningId
JOIN reservedseats r on bookings.bookingId = r.reservedSeatBookingId
WHERE screeningId = 20;

SELECT * FROM reservedseats WHERE

-- From screnningsId=1 get reservedSeats

CREATE VIEW reservedSeats AS;
SELECT f.filmName, r.roomName, COUNT(r2.reservedSeatSeatId)
FROM screenings s
       JOIN films f ON s.screeningFilmId = f.filmsId
       JOIN rooms r ON s.screeningRoomId = r.roomId
       JOIN seats s2 ON r.roomId = s2.seatRoomId
       JOIN reservedseats r2 ON s2.seatsId = r2.reservedSeatSeatId
GROUP BY roomName;
/*-- --*/


-- Lista vilka filmer resp. kunder sett
SELECT *
FROM customersViewedFilms
ORDER BY customerLastName;


-- VIEW som visar vilka filmer olika kunder sett
CREATE VIEW customersViewedFilms AS
SELECT c.customerFirstName, c.customerLastName, f.filmName
FROM customers c
JOIN bookings b ON c.customerId = b.bookingCustomerId
JOIN screenings s ON b.bookingScreeningId = s.screeningId
JOIN films f ON s.screeningFilmId = f.filmsId;

-- Lista vilka filmer resp. kunder sett
SELECT *
FROM customersViewedFilms
ORDER BY customerLastName;




-- Index
SELECT * FROM films;
-- Filmer sort cron, år, speltid
CREATE INDEX filmTitel ON films (filmName);
CREATE INDEX filmChronologicalOrder ON films (filmChronologicalOrder);
CREATE INDEX filmReleaseYear ON films (filmYear);
CREATE INDEX filmLength ON films (filmLengthMinutes);


SELECT filmname, filmLengthMinutes, filmChronologicalOrder, filmYear
FROM films
WHERE filmName = 'Thor';

SELECT filmname, filmLengthMinutes, filmChronologicalOrder, filmYear
FROM films
WHERE filmChronologicalOrder = '1';

SELECT filmname, filmLengthMinutes, filmChronologicalOrder, filmYear
FROM films
WHERE filmYear = '2011';

SELECT filmname, filmLengthMinutes, filmChronologicalOrder, filmYear
FROM films
WHERE filmLengthMinutes = '124';

-- Stored procedure/Triggers

DELIMITER //
CREATE PROCEDURE GetAllCustomersByLastName()
  BEGIN
  SELECT *  FROM customers
    ORDER BY customerLastName;
  END //
DELIMITER ;

CALL GetAllCustomersByLastName();


DELIMITER //
CREATE PROCEDURE SearchByLastName(IN parameter VARCHAR(30))
  BEGIN
  SELECT * FROM customers
    WHERE customerLastName = parameter;
  END //
DELIMITER ;

CALL SearchByLastName('David');