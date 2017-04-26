
-- Create professors
insert into user (userId, lastName, firstName, email, password) values (10, "Roger", "Kraft", "rlkraft@longbottom.edu", "haskellwhiz");
insert into professor (salary, hiredDate, userId) values (120000, now(), 10);

insert into user (userId, lastName, firstName, email, password) values (11, "Alan", "Turing", "aTurning@longbottom.edu", "password");
insert into professor (salary, hiredDate, userId) values (1212000, now(), 11);

-- set admin account name to admin admin
update user set firstName = "Admin", lastName = "1" where userId = 8;
-- Create projects
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
update works_in set accepted = 1 where id = 2;
update works_in set accepted = 1 where id = 3;
update works_in set accepted = 1 where id = 4;
update works_in set accepted = 1 where id = 5;
update works_in set accepted = 1 where id = 6;
update works_in set accepted = 1 where id = 7;
update works_in set accepted = 1 where id = 10;
update works_in set accepted = 1 where id = 11;

-- Big Data
update works_in set accepted = 2 where id = 2;
update works_in set accepted = 2 where id = 3;
update works_in set accepted = 2 where id = 4;
update works_in set accepted = 2 where id = 5;
update works_in set accepted = 2 where id = 6;
update works_in set accepted = 2 where id = 7;
update works_in set accepted = 2 where id = 10;
update works_in set accepted = 2 where id = 11;

-- Learn you a haskell
update works_in set accepted = 12 where id = 4;
update works_in set accepted = 12 where id = 5;
update works_in set accepted = 12 where id = 7;

-- Cyber Security
update works_in set accepted = 22 where id = 3;
update works_in set accepted = 22 where id = 7;
update works_in set accepted = 22 where id = 5;
update works_in set accepted = 22 where id = 0;

-- Autonomous
update works_in set accepted = 32 where id = 5;
update works_in set accepted = 32 where id = 3;
update works_in set accepted = 32 where id = 2;
update works_in set accepted = 32 where id = 6;
update works_in set accepted = 32 where id = 4;

-- AI
update works_in set accepted = 42 where id = 11;
update works_in set accepted = 42 where id = 10;

-- Computer Assisted Edu
update works_in set accepted = 52 where id = 3;
update works_in set accepted = 52 where id = 4;
update works_in set accepted = 52 where id = 6;
update works_in set accepted = 52 where id = 10;
update works_in set accepted = 52 where id = 0;

-- Natural language
update works_in set accepted = 62 where id = 3;
update works_in set accepted = 62 where id = 4;
update works_in set accepted = 62 where id = 6;
update works_in set accepted = 62 where id = 10;
update works_in set accepted = 62 where id = 0;
-- ----------------------------------------------------------------------

-- create posts for project page

-- Software eng
insert into posts(id, projectId, header, body, time_stamp) values (0 , 1, "Final presentation", "You will be presenting your project during class on 4/26/17", now());
insert into posts(id, projectId, header, body, time_stamp) values (0 , 1, "Final presentation", "Great job on everyone's presentation. A's for all.", now());

-- Haskell
insert into posts(id, projectId, header, body, time_stamp) values (10 , 12, "What is haskell?", "Haskell - is a standardized, general-purpose purely functional programming language, with non-strict semantics and strong static typing. It is named after logician Haskell Curry.", now());
insert into posts(id, projectId, header, body, time_stamp) values (10 , 12, "Learn you a Haskell", "Be sure to check out the book Learn you a haskell.", now());
