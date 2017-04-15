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
