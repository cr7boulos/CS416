update user set password = "wilfred" where userId = 1;
update user set password = "jayw3king" where userId = 2;
update user set password = "doctordes" where userId = 3;
update user set password = "cr7boulos" where userId = 4;
update user set password = "katie.holden" where userId = 5;
update user set password = "polo" where userId = 6;
update user set password = "kylephonedial" where userId = 7;

-- put everyone in the original project
update works_in set accepted = 1 where id = 2;
update works_in set accepted = 1 where id = 3;
update works_in set accepted = 1 where id = 4;
update works_in set accepted = 1 where id = 5;
update works_in set accepted = 1 where id = 6;
update works_in set accepted = 1 where id = 7;

-- create a project that no one is a part of
insert into projects (name, description, time_stamp, manager) values ("Big Data", "Parallel Programming", now(), 0);


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


-- insert a bunch of random chat messages
insert into chat (projectId, time_stamp, text, userId) values (1, now(), "What up 1?", 4);
insert into chat (projectId, time_stamp, text, userId) values (1, now(), "What up 2?", 1);
insert into chat (projectId, time_stamp, text, userId) values (1, now(), "What up 3?", 2);
insert into chat (projectId, time_stamp, text, userId) values (1, now(), "What up 4?", 3);

-- insert different users into various prjects by setting accepted = 1
update works_in set accepted = 0 where id = 2;
update works_in set accepted = 0 where id = 3;
update works_in set accepted = 0 where id = 4;
update works_in set accepted = 0 where id = 5;
update works_in set accepted = 0 where id = 6;
update works_in set accepted = 0 where id = 7;

-- Create professor user
insert into user (userId, lastName, firstName, email, password) values (10, "Roger", "Kraft", "rlkraft@longbottom.edu", "haskellwhiz");

insert into professor (salary, hiredDate, userId) values (120000, now(), 10);
