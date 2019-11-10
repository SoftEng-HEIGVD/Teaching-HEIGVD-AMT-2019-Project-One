USE `amt_project_one`;

INSERT INTO amt_films(TITLE, RUNNING_TIME, PATH_TO_POSTER, DIRECTOR) VALUES ('Forrest Gump', 142, 'forest_gump.jpg', 'Robert Zemeckis');
INSERT INTO amt_films(TITLE, RUNNING_TIME, PATH_TO_POSTER, DIRECTOR) VALUES ('Fight Club', 119, 'fight_club.jpg', 'David Fincher');
INSERT INTO amt_films(TITLE, RUNNING_TIME, PATH_TO_POSTER, DIRECTOR) VALUES ('The Butler', 132, 'the_butler.jpg', 'Lee Daniels');
INSERT INTO amt_films(TITLE, RUNNING_TIME, PATH_TO_POSTER, DIRECTOR) VALUES ('Scarface', 170, 'scarface.jpg', 'Brian De Palma');

INSERT INTO amt_users(USERNAME, FIRST_NAME, LAST_NAME, EMAIL, HASHED_PW) VALUES ('user1', 'Bob', 'Dylan', 'dylan@email.com', 'asd');
INSERT INTO amt_users(USERNAME, FIRST_NAME, LAST_NAME, EMAIL, HASHED_PW) VALUES ('user2', 'Bob', 'Hope', 'hope@email.com', 'asd');
INSERT INTO amt_users(USERNAME, FIRST_NAME, LAST_NAME, EMAIL, HASHED_PW) VALUES ('user3', 'Mickey', 'Mouse', 'mickey@email.com', 'asdw');

INSERT INTO amt_users(USERNAME, FIRST_NAME, LAST_NAME, EMAIL, HASHED_PW) VALUES ('admin', 'admin', 'admin', 'admin@email.com', 'password');


