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
DESCRIBE bookings;
DESCRIBE customers;
DESCRIBE films;
DESCRIBE reservedseats;
DESCRIBE rooms;
DESCRIBE screenings;
DESCRIBE seats;

SELECT * FROM bookings;
SELECT * FROM customers;
SELECT * FROM films;
SELECT * FROM reservedseats;
SELECT * FROM rooms;
SELECT * FROM screenings;
SELECT * FROM seats;

-- Create view tables
CREATE VIEW ;

-- OK  UPDATE på kund
-- OK  DELETE på kund
-- INNER JOIN på bokningar
-- INNER JOIN på filmer
-- INNER JOIN på filmer på en biograf/rum
-- VIEW antal säten sorterat  GROUP BY per rum
-- Index
-- Stored procedure/Triggers
-- Filmer sort cron, år, speltid

SELECT customerFirstName, customerLastName
FROM bookings b
       JOIN customers c on b.bookingCustomerId = c.customerId
JOIN reservedseats r on b.bookingId = r.reservedSeatBookingId;



SELECT *
FROM reservedseats
ORDER BY reservedSeatSeatId;





-- Insert
INSERT INTO customers (customerFirstName, customerLastName, customerEmail, customerGender)
VALUES ('Nisse', 'Lind', 'nlind@gmail.com', 'M');

-- Update
UPDATE customers
SET customerEmail = 'nissel@gmail.com'
WHERE customerFirstName = 'Nisse'
  AND customerLastName = 'Lind';

-- Delete

