-- Set students


-- Create admin
insert into user (userId, lastName, firstName, email, password) values (20, "Admin", "1", "admin@longbottom.edu", "admin");
insert into admin (userId, id) VALUES (20, 1);
-- Create professors
insert into user (userId, lastName, firstName, email, password) values (10, "Roger", "Kraft", "rlkraft@longbottom.edu", "haskellwhiz");
insert into professor (salary, hiredDate, userId) values (120000, now(), 10);

insert into user (userId, lastName, firstName, email, password) values (11, "Alan", "Turing", "aTurning@longbottom.edu", "password");
insert into professor (salary, hiredDate, userId) values (1212000, now(), 11);

-- Create projects
insert into projects (name, description, time_stamp, manager) VALUES ("Software Engineering", "Software engineering", now(), 0);
insert into projects (name, description, time_stamp, manager) values ("Big Data", "Parallel Programming", now(), 0);
insert into projects (name, description, time_stamp, manager) values ("Learn you a Haskell", "Learn the functional programming language Haskell", now(), 10);
insert into projects (name, description, time_stamp, manager) values ("Cyber Security", "Research project involving cyber security.", now(), 10);
insert into projects (name, description, time_stamp, manager) values ("Autonomous Vehicles", "Research into autonomous vehicles", now(), 11);
insert into projects (name, description, time_stamp, manager) values ("Artificial Intelligence", "Research into artificial intelligence", now(), 0);
insert into projects (name, description, time_stamp, manager) values ("Computer-assisted education", "Developing a plan on how to implement CS into highschool curiculum", now(), 11);
insert into projects (name, description, time_stamp, manager) values ("Natural language processing", "Research into natural language processing", now(), 11);


-- add a bunch of emails change the from, to columns as needed
insert into email (email.from, email.to, time_stamp, subject, body) values (1, 3, now(), "What up?", "Hey, this is Max!");
insert into email (email.from, email.to, time_stamp, subject, body) values (2, 4, now(), "What up?", "Hey, this is Japji!");
insert into email (email.from, email.to, time_stamp, subject, body) values (3, 5, now(), "What up?", "Hey, this is Brian!");
insert into email (email.from, email.to, time_stamp, subject, body) values (5, 7, now(), "What up?", "Hey, this is Katie!");
insert into email (email.from, email.to, time_stamp, subject, body) values (6, 2, now(), "What up?", "Hey, this is Jacob!");
insert into email (email.from, email.to, time_stamp, subject, body) values (7, 4, now(), "What up?", "Hey, this is Kyle!");

insert into email (email.from, email.to, time_stamp, subject, body) values (1, 10, now(), "What up?", "Hey, this is Max!");
insert into email (email.from, email.to, time_stamp, subject, body) values (2, 10, now(), "What up?", "Hey, this is Japji!");
insert into email (email.from, email.to, time_stamp, subject, body) values (3, 10, now(), "What up?", "Hey, this is Brian!");
insert into email (email.from, email.to, time_stamp, subject, body) values (5, 10, now(), "What up?", "Hey, this is Katie!");
insert into email (email.from, email.to, time_stamp, subject, body) values (6, 10, now(), "What up?", "Hey, this is Jacob!");
insert into email (email.from, email.to, time_stamp, subject, body) values (7, 10, now(), "What up?", "Hey, this is Kyle!");

-- put users into projects --------------------------------------------
-- Software eng
insert into works_in (projectId, userId, id, accepted) VALUES (12, 1, 1, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (12, 2, 2, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (12, 3, 3, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (12, 4, 4, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (12, 5, 5, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (12, 6, 6, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (12, 7, 7, 1);

-- Big Data
insert into works_in (projectId, userId, id, accepted) VALUES (22, 1, 8, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (22, 2, 9, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (22, 5, 10, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (22, 6, 11, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (22, 7, 12, 1);


-- Learn you a haskell
insert into works_in (projectId, userId, id, accepted) VALUES (32, 1, 13, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (32, 2, 14, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (32, 3, 15, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (32, 4, 16, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (32, 5, 17, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (32, 6, 18, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (32, 7, 19, 1);

-- Cyber Security
insert into works_in (projectId, userId, id, accepted) VALUES (42, 1, 20, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (42, 2, 21, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (42, 3, 22, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (42, 4, 23, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (42, 5, 24, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (42, 6, 25, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (42, 7, 26, 1);

-- Autonomous
insert into works_in (projectId, userId, id, accepted) VALUES (52, 1, 27, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (52, 2, 28, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (52, 3, 29, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (52, 4, 30, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (52, 5, 31, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (52, 6, 32, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (52, 7, 33, 1);

-- AI
insert into works_in (projectId, userId, id, accepted) VALUES (62, 1, 34, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (62, 2, 35, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (62, 3, 36, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (62, 4, 37, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (62, 5, 38, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (62, 6, 39, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (62, 7, 40, 1);

-- Computer Assisted Edu
insert into works_in (projectId, userId, id, accepted) VALUES (72, 1, 41, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (72, 2, 42, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (72, 3, 43, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (72, 4, 44, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (72, 5, 45, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (72, 6, 46, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (72, 7, 47, 1);

-- Natural language
insert into works_in (projectId, userId, id, accepted) VALUES (82, 1, 48, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (82, 2, 49, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (82, 3, 50, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (82, 4, 51, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (82, 5, 52, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (82, 6, 53, 1);
insert into works_in (projectId, userId, id, accepted) VALUES (82, 7, 54, 1);
-- ----------------------------------------------------------------------

-- create posts for project page ----------------------------------------

-- Software eng
insert into posts(id, projectId, header, body, time_stamp) values (0 , 1, "Final presentation", "You will be presenting your project during class on 4/26/17", now());
insert into posts(id, projectId, header, body, time_stamp) values (1 , 1, "Final presentation", "Great job on everyone's presentation. A's for all.", now());

-- Haskell
insert into posts(id, projectId, header, body, time_stamp) values (11 , 12, "What is haskell?", "Haskell - is a standardized, general-purpose purely functional programming language, with non-strict semantics and strong static typing. It is named after logician Haskell Curry.", now());
insert into posts(id, projectId, header, body, time_stamp) values (12 , 12, "Learn you a Haskell", "Be sure to check out the book Learn you a haskell.", now());
-- -----------------------------------------------------------------------