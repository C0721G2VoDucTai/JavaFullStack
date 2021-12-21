drop database if exists furama_resort;
create database furama_resort;
use furama_resort;
create table position (
position_id int primary key,
position_name varchar(45)
);
insert position values 
(1,'GM'),(2,'Manager'),(3,'Supervisor'),(4,'Employee'), (5,'Sever'),(6, 'Receptionist');
create table education_degree (
degree_id int primary key,
degree_name varchar (45) 
);
insert education_degree values
(1, 'THS'),(2,'DH'),(3,'CD'),(4,'TC');
create table division (
division_id int primary key,
division_name varchar (45)
);
insert division values 
(1,'Operation'),(2,'Service'),(3,'Administrative'), (4,'Sale-Marketing');
create table employee (
employee_id varchar (45) primary key,
employee_name varchar (100),
position_id int,
degree_id int,
division_id int,
birthday date,
id_card varchar(12),
salary varchar(45),
phone varchar(20),
email varchar(100),
address varchar(100),
foreign key (position_id) references position (position_id),
foreign key (degree_id) references education_degree (degree_id),
foreign key (division_id) references division (division_id)
);
insert into employee  values
(1001,'Truong Hung',1,1,1,'1989-09-09','197200000','20000',null,null,null),
(1002,'Hoang Hanh',2,2,1,'1987-09-09','197200000','15000',null,null,null),
(1003,'Tran Khai',3,2,3,'1989-09-09','197200000','10000',null,null,'Hai Chau - Da Nang'),
(1005,'Tran Viet',5,2,3,'1984-09-09','197200000','10000',null,null,null),
(1004,'Nguyen Nam',4,3,2,'1989-09-09','197200000','7000',null,null,null),
(1006,'Vu Hoang',3,2,2,'1989-09-09','197200000','60000',null,null,'Son Tra - Da Nang'),
(1007,'Hoang Ha',5,2,2,'1989-09-09','197200000','60000',null,null,null);
create table customer_type(
customer_type_id int primary key,
customer_type_name varchar(45)
);
insert customer_type values
(1,'Diamond'),(2,'Platium'),(3,'Gold'),(4,'Sliver'),(5,'Member');
create table customer (
customer_id int primary key auto_increment,
customer_type_id int,
foreign key (customer_type_id) references customer_type (customer_type_id),
customer_name varchar (45),
birthday date,
gender varchar(10),
id_card varchar(12),
phone varchar(20),
email varchar(45),
address varchar(45)
);
insert customer(customer_id,customer_type_id,customer_name,birthday,address, phone) values
(101,2,'Nguyen An', '1980-10-20', 'Da Nang','0918000000'),
(102,1,'Nguyen Binh', '1989-10-20', 'Quang Tri','0938000000'),
(103,2,'Nguyen Anh', '1965-10-20', 'Quang Nam','0988000000'),
(104,1,'Nguyen Trung', '1988-11-20', 'Quang Ngai','0948000000'),
(105,3,'Nguyen Tuong', '1982-11-20', 'Quang Tri','0968000000'),
(106,2,'Nguyen Hoang', '1982-11-20', 'Quang Binh','0968000000');
create table attach_service (
a_id int primary key auto_increment,
a_name varchar(45),
a_price int,
unit int,
`status` bit
);
insert attach_service values
(1,'Pool',100,1,null),(2,'Breakfas',50,1,null), (3,'Massage',200,1,null);
create table service_type(
service_type_id int primary key auto_increment,
service_type_name varchar(45)
);
insert service_type values (1,'Room'),(2,'House'),(3,'Villa');
create table rental_type(
rental_type_id int primary key auto_increment,
rental_type_name varchar(45)
);
insert rental_type values (1,'Day'),(2,'Week'),(3,'Month');

create table service(
service_id int primary key auto_increment,
service_name varchar(45),
area int,
cost int,
number_of_person int,
rental_type_id int,
service_type_id int,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area int,
number_of_floors int,
foreign key (rental_type_id) references rental_type(rental_type_id),
foreign key (service_type_id) references service_type(service_type_id)
);
insert service values 
(101,'Villa_A',50,300,2,1,3,null,null,null,null),
(102,'Villa_B',60,400,4,1,3,null,null,null,null),
(103,'House_A',30,200,2,1,2,null,null,null,null),
(104,'House_B',40,250,2,2,2,null,null,null,null),
(105,'Room_A',20, 100,1,1,1,null,null,null,null),
(106,'Room_B',20, 100,2,1,1,null,null,null,null),
(107,'Room_C',20, 100,1,2,1,null,null,null,null);
create table contract(
contract_id int primary key auto_increment,
employee_id varchar(45),
customer_id int,
service_id int,
check_in	 varchar (45),
check_out varchar (45),
deposit int,
total_money int,
foreign key (employee_id) references employee (employee_id),
foreign key (customer_id)  references customer (customer_id),
foreign key (service_id) references service (service_id)
);
create table detail_contract (
detail_contract_id int primary key auto_increment,
a_id int,
contract_id int,
quantity int,
-- unique (contract_id,quantity),
foreign key (contract_id) references contract (contract_id),
foreign key (a_id)  references attach_service (a_id)
);
insert into contract values
(1,1004,101,101,'2018-09-11','2018-09-15',1000,2000),
(2,1005,102,102,'2018-10-11','2018-10-15',1000,2000),
(3,1006,104,102,'2019-10-11','2019-10-15',1000,2000);
insert detail_contract values
(1,1,1,1),
(2,3,2,11),
(3,2,3,2);
select 
sv.service_id,sv.service_name,sv.area,sv.cost,sv.number_of_person,sv.rental_type_id,
rt.rental_type_name, sv.service_type_id,st.service_type_name,sv.standard_room,
sv.description_other_convenience,sv.pool_area,sv.number_of_floors
from service sv
join rental_type rt on rt.rental_type_id =sv.rental_type_id
join service_type st on st.service_type_id = sv.service_type_id;
-- insert into service(service_name,area,cost,number_of_person,rental_type_id,service_type_id,
--  standard_room,description_other_convenience,pool_area,number_of_floors)
-- value(?,?,?,?,?,?,?,?,?,?,?);
select * from service_type;
select ct.contract_id, e.employee_name, c.customer_name,s.service_name,
ct.check_in,ct.check_in,ct.deposit,ct.total_money
from contract ct
join customer c on c.customer_id = ct.customer_id
join service s on s.service_id = ct.service_id
join employee e on e.employee_id = ct.employee_id;
select*
from employee
where employee_name like concat('%','Hung','%');
select c.customer_id, c.customer_name, ty.customer_type_name, s.service_name, a.a_name
from contract ct
join customer c on c.customer_id = ct.customer_id
join customer_type ty on ty.customer_type_id = c.customer_type_id
join service s on s.service_id = ct.service_id
join detail_contract d on d.contract_id = ct.contract_id
join attach_service a on a.a_id = d.a_id;
select c.customer_id, ct.customer_type_id, c.customer_name, c.birthday, c.gender, c.id_card, c.phone
, c.email, c.address
from customer c
join customer_type ct on ct.customer_type_id  =  c.customer_type_id
where (c.customer_name  like concat('%','An','%'))
and (ct.customer_type_name like concat('%','Platium', '%'))
and (c.address like concat('%','Da','%'));


