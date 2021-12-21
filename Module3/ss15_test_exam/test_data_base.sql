drop database if exists test_exam;
create database test_exam;
use test_exam;
create table student (
student_id int primary key,
student_name varchar (45),
class varchar (45)
);
insert into student values 
(1, 'Hoang', '10A'),
(2, 'Nam', '10B'),
(3, 'Thai', '10C');

create table book (
book_id varchar (20) primary key,
book_name varchar(45),
writer varchar(45),
`description`  varchar(45),
quantity int
);
insert into book values 
('BO1', 'Connan', 'Aki', 'good book', 5),
('BO2', 'Doraemon', 'Aki', 'good book', 2),
('BO3', 'Wolf', 'Aki', 'good book', 4);
create table ticket (
ticket_id int primary key,
book_id varchar(20),
student_id int,
status varchar(45),
start_day date,
end_day date,
foreign key (student_id)  references student (student_id),
foreign key (book_id)  references book (book_id)
);
insert into ticket values 
(1, 'BO1', 1, 'borow', '2010-10-10' ,'2010-10-10'),
(2, 'BO2', 2, 'finish', '2010-10-11' ,'2010-10-11'),
(3, 'BO3', 1, 'finish', '2010-10-10' ,'2010-10-12');
select b.book_id,b.book_name, s.student_name,s.student_id, t.start_day,t.end_day, t.status, t.ticket_id
from book b
join ticket t on t.book_id = b.book_id
join student s on s.student_id = t.student_id;
update book
set quantity = quantity -1
where book_id = 'BO1'
-- insert into land_type values 
-- (1,'share_land'), (2, 'full_land');
-- select land_id,l.land_status_id,ls.land_status_name,area,floor,l.land_type_id,lt.land_type_name,
-- price,checkin,checkout
-- from land l
-- join land_status ls on ls.land_status_id = l.land_status_id
-- join land_type lt on lt.land_type_id = l.land_type_id;
-- select land_id,l.land_status_id,ls.land_status_name,area,floor,l.land_type_id,lt.land_type_name,
-- price,checkin,checkout
-- from land l
-- join land_status ls on ls.land_status_id = l.land_status_id
-- join land_type lt on lt.land_type_id = l.land_type_id
-- where (lt.land_type_name like concat('%','lan','%')) 
-- and (price = 3000000) 
-- and (floor = 3);
-- update land
-- set land_status_id =?,area =?,floor=?,land_type_id=?,price=?,checkin=?,checkout=?
-- where land_id = ?;

