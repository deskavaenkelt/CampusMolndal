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

ALTER TABLE films
  ADD COLUMN filmChronologicalOrder INT NOT NULL;

ALTER TABLE films
  ADD COLUMN filmYear INT NOT NULL;

SELECT * FROM films;

INSERT INTO films (filmChronologicalOrder, filmName, filmYear, filmLengthMinutes)
VALUES (2, 'Iron Man', 2008, 126),
       (1, 'Captain America: The First Avenger', 2011, 124),
       (4, 'Iron Man 2', 2010, 124),
       (3, 'The Incredible Hulk', 2008, 112),
       (6, 'The Avengers', 2012, 143),
       (5, 'Thor', 2011, 115),
       (8, 'Thor: The Dark World', 2013, 112),
       (7, 'Iron Man 3', 2013, 130),
       (10, 'Guardians of the Galaxy', 2014, 121),
       (9, 'Captain America: The Winter Soldier', 2014, 136),
       (12, 'Avengers: Age of Ultron', 2015, 141),
       (11, 'Guardians of the Galaxy Vol. 2', 2017, 136),
       (14, 'Captain America: Civil War', 2016, 147),
       (13, 'Ant-Man', 2015, 117),
       (16, 'Doctor Strange', 2016, 115),
       (15, 'Spider-Man: Homecoming', 2017, 133),
       (18, 'Black Panther', 2018, 134),
       (19, 'Avengers: Infinity War', 2018, 149),
       (20, 'Ant-Man and the Wasp', 2018, 118),
       (17, 'Thor: Ragnarok', 2017, 130),
       (22, 'Blade Runner 2049', 2017, 153),
       (21, 'Captain Marvel', 2019, 124);

SELECT *
FROM films
ORDER BY filmChronologicalOrder;
