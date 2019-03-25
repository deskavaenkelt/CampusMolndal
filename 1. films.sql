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

DESCRIBE films;

SELECT * FROM films;

INSERT INTO films (filmChronologicalOrder, filmName, filmYear, filmLengthMinutes)
VALUES (1, 'Captain America: The First Avenger', 2011, 124),
       (2, 'Captain Marvel', 2019, 124),
       (3, 'Iron Man', 2008, 126),
       (4, 'Iron Man 2', 2010, 124),
       (5, 'The Incredible Hulk', 2008, 112),
       (6, 'Thor', 2011, 115),
       (7, 'The Avengers', 2012, 143),
       (8, 'Thor: The Dark World', 2013, 112),
       (9, 'Guardians of the Galaxy', 2014, 121),
       (10, 'Guardians of the Galaxy Vol. 2', 2017, 136),
       (11, 'Iron Man 3', 2013, 130),
       (12, 'Captain America: The Winter Soldier', 2014, 136),
       (13, 'Avengers: Age of Ultron', 2015, 141),
       (14, 'Ant-Man', 2015, 117),
       (15, 'Captain America: Civil War', 2016, 147),
       (16, 'Black Panther', 2018, 134),
       (17, 'Spider-Man: Homecoming', 2017, 133),
       (18, 'Doctor Strange', 2016, 115),
       (19, 'Thor: Ragnarok', 2017, 130),
       (20, 'Ant-Man and the Wasp', 2018, 118),
       (21, 'Avengers: Infinity War', 2018, 149),
       (22, 'Blade Runner 2049', 2017, 153);

SELECT *
FROM films
ORDER BY filmChronologicalOrder;
