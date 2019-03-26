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

SELECT * FROM bookings;
SELECT * FROM customers;
SELECT * FROM films;
SELECT * FROM reservedseats;
SELECT * FROM rooms;
SELECT * FROM screenings;
SELECT * FROM seats;



-- ####################################
-- # INSERT / UPDATE / DELETE på kund #
-- ####################################

SELECT * FROM customers;
-- INSERT
INSERT INTO customers (customerFirstName, customerLastName, customerEmail, customerGender)
VALUES ('Nisse', 'Lind', 'nlind@gmail.com', 'M');

-- UPDATE
UPDATE customers
SET customerEmail = 'nissel@live.com'
WHERE customerFirstName = 'Nisse'
  AND customerLastName = 'Lind';

-- DELETE
DELETE
FROM customers
WHERE customerFirstName = 'Nisse';



-- ###########################
-- # INNER JOIN på bokningar #
-- ###########################

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



-- ########################
-- # INNER JOIN på filmer #
-- ########################

-- Hur många visningar/screenings har varje film
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
-- Hur många ggr har varje film spelats upp i ett visst rum
SELECT r.roomName, f.filmName, COUNT(f.filmsId) AS timesAFilmHasPlayed
FROM screenings s
JOIN films f on s.screeningFilmId = f.filmsId
JOIN rooms r on s.screeningRoomId = r.roomId
GROUP BY f.filmName;



-- ########
-- # VIEW #
-- ########

-- VIEW som visar vilka filmer olika kunder sett
CREATE VIEW customersViewedFilms AS
SELECT c.customerFirstName, c.customerLastName, f.filmName
FROM customers c
JOIN bookings b ON c.customerId = b.bookingCustomerId
JOIN screenings s ON b.bookingScreeningId = s.screeningId
JOIN films f ON s.screeningFilmId = f.filmsId;

-- Lista vilka filmer resp. kunder sett sorterat på kundens efternamn
SELECT *
FROM customersViewedFilms
ORDER BY customerLastName;



-- #########
-- # INDEX #
-- #########

-- Skapa index på titel & kronologisk ordning
CREATE INDEX filmTitel ON films (filmName);
CREATE INDEX filmChronologicalOrder ON films (filmChronologicalOrder);

-- Sök efter Thor
SELECT filmname, filmLengthMinutes, filmChronologicalOrder, filmYear
FROM films
WHERE filmName = 'Thor';

-- Sök efter film x i ordning
SELECT filmname, filmLengthMinutes, filmChronologicalOrder, filmYear
FROM films
WHERE filmChronologicalOrder = '18';



-- #############################
-- # Stored procedure/Triggers #
-- #############################

-- Skapa en funktion som sorterar kunder på efternamn
DELIMITER //
CREATE PROCEDURE GetAllCustomersByLastName()
  BEGIN
  SELECT *  FROM customers
    ORDER BY customerLastName;
  END //
DELIMITER ;

-- Anropa funktionen
CALL GetAllCustomersByLastName();


-- Skapa en funktion som söker kunder på efternamn
DELIMITER //
CREATE PROCEDURE SearchByLastName(IN parameter VARCHAR(30))
  BEGIN
  SELECT * FROM customers
    WHERE customerLastName = parameter;
  END //
DELIMITER ;

-- Anropa funktionen
CALL SearchByLastName('David');