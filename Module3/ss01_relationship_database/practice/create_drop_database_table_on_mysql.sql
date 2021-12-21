Drop database if exists my_database;
create database my_database;
use my_database;
create table student( id int not null , 
`name` varchar(45) null, 
age int null, 
country varchar(45) null 
);
insert into student  value 
(1001, 'Nguyen Van A', 18, 'Viet Nam'), 
(1002, 'Nguyen Van B', 18, 'Viet Nam'),
(1003, 'Nguyen Van C', 18, 'Viet Nam'),
(1004, 'Nguyen Van D', 18, 'Viet Nam');
update student 
set `name` = 'Nguyen Van A1', age = 19
where id = 1001;
delete from student
where id = 1004; 