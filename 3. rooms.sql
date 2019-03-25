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

DESCRIBE rooms;

SELECT * FROM rooms;


INSERT INTO rooms (roomName, roomNumberOfSeats)
VALUES
       ('Stark',72),
       ('Rogers',36),
       ('Banner',18);

SELECT *
FROM rooms;

SELECT *
FROM rooms
ORDER BY roomName;