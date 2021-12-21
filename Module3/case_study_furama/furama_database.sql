drop database if exists furama_resort;
create database furama_resort;
use furama_resort;
create table position (
position_id int primary key,
position_name varchar(45)
);
insert position values 
(1,'GM'),(2,'Manager'),(3,'Supervisor'),(4,'staff'), (5,'sever'),(6, 'receptionist');
create table education_level (
level_id int primary key,
level_name varchar (45) 
);
insert education_level values
(1, 'THS'),(2,'DH'),(3,'CD'),(4,'TC');
create table part (
part_id int primary key,
part_name varchar (45)
);
insert part values 
(1,'operation'),(2,'Service'),(3,'Administrative'), (4,'Sale-Marketing');
create table staff (
staff_id int primary key auto_increment,
staff_name varchar (45),
position_id int,
level_id int,
part_id int,
day_of_birth date,
id_number varchar(12),
salary varchar(45),
phone_number varchar(20),
email varchar(45),
address varchar(45),
foreign key (position_id) references position (position_id),
foreign key (level_id) references education_level (level_id),
foreign key (part_id) references part (part_id)
);
insert into staff  values
(1001,'Truong Hung',1,1,1,'1989-09-09','197200000','20000',null,null,null),
(1002,'Hoang Hanh',2,2,1,'1987-09-09','197200000','15000',null,null,null),
(1003,'Tran Khai',3,2,3,'1989-09-09','197200000','10000',null,null,'Hai Chau - Da Nang'),
(1005,'Tran Viet',5,2,3,'1984-09-09','197200000','10000',null,null,null),
(1004,'Nguyen Nam',4,3,2,'1989-09-09','197200000','7000',null,null,null),
(1006,'Vu Hoang',3,2,2,'1989-09-09','197200000','60000',null,null,'Son Tra - Da Nang'),
(1007,'Hoang Ha',5,2,2,'1989-09-09','197200000','60000',null,null,null);
create table type_of_customer(
type_id int primary key,
type_name varchar(45)
);
insert type_of_customer values
(1,'Diamond'),(2,'Platium'),(3,'Gold'),(4,'Sliver'),(5,'Member');
create table customer (
customer_id int primary key auto_increment,
type_id int,
foreign key (type_id) references type_of_customer (type_id),
customer_name varchar (45),
day_of_birth date,
id_number varchar(12),
phone_number varchar(20),
email varchar(45),
address varchar(45)
);
insert customer(customer_id,type_id,customer_name,day_of_birth,address, phone_number) values
(101,2,'Nguyen An', '1980-10-20', 'Da Nang','0918000000'),
(102,1,'Nguyen Binh', '1989-10-20', 'Quang Tri','0938000000'),
(103,2,'Nguyen Anh', '1965-10-20', 'Quang Nam','0988000000'),
(104,1,'Nguyen Trung', '1988-11-20', 'Quang Ngai','0948000000'),
(105,3,'Nguyen Tuong', '1982-11-20', 'Quang Tri','0968000000'),
(106,2,'Nguyen Hoang', '1982-11-20', 'Quang Binh','0968000000');
create table accompanied_service (
a_id int primary key auto_increment,
a_name varchar(45),
a_price int,
unit int,
status bit
);
insert accompanied_service values
(1,'Pool',100,1,null),(2,'Breakfas',50,1,null), (3,'Massage',200,1,null);
create table type_of_service(
type_service_id int primary key auto_increment,
type_nervice_name varchar(45)
);
insert type_of_service values (1,'Room'),(2,'House'),(3,'Villa');
create table type_of_rental(
type_rental_id int primary key auto_increment,
type_rental_name varchar(45),
rental_price int
);
insert type_of_rental values (1,'Day',1000),(2,'Week',5000),(3,'Month',1500);
create table service(
service_id int primary key auto_increment,
service_name varchar(45),
area int,
number_of_floors int,
number_of_person int,
cost varchar(45),
type_rental_id int,
type_service_id int,
status bit,
foreign key (type_rental_id) references type_of_rental(type_rental_id),
foreign key (type_service_id) references type_of_service(type_service_id)
);
insert service values 
(101,'Villa_A',50, 2,10, 3000,1,3,null),
(102,'Villa_B',60, 2,8, 3500,1,3,null),
(103,'House_A',30, 1,4, 1500,2,2,null),
(104,'House_B',40, 2,2, 2000,1,2,null),
(105,'Room_A',20, 1,2, 800,1,1,null),
(106,'Room_B',20, 1,2, 800,1,1,null),
(107,'Room_C',20, 1,2, 800,1,1,null);
create table contract(
contract_id int primary key auto_increment,
staff_id int,
customer_id int,
service_id int,
check_in date,
check_out date,
deposit int,
total_money int,
foreign key (staff_id) references staff (staff_id),
foreign key (customer_id)  references customer (customer_id),
foreign key (service_id) references service (service_id)

);
insert contract values 
(1,1006,104,104,'2019-12-12','2019-12-15',1000,2000),
(10,1003,104,104,'2019-12-12','2019-12-13',1000,2000),
(2,1003,102,104,'2019-12-12','2019-12-15',1000,2000),
(3,1002,102,104,'2019-10-12','2019-10-13',1000,2000),
(4,1002,103,102,'2019-05-12','2019-05-13',1000,2000),
(5,1006,101,105,'2019-02-15','2019-02-18',400,5000),
(6,1006,101,104,'2019-02-16','2019-02-18',400,5000),
(7,1006,101,103,'2018-02-15','2018-02-18',400,800),
(8,1006,103,101,'2019-01-15','2019-01-18',400,10000),
(9,1006,103,101,'2015-01-15','2015-01-18',400,10000);
create table detail_contract (
detail_contract_id int primary key auto_increment,
a_id int,
contract_id int,
quantity int,
-- unique (contract_id,quantity),
foreign key (contract_id) references contract (contract_id),
foreign key (a_id)  references accompanied_service (a_id)
);
insert detail_contract values
(1,1,1,1),
(2,3,2,11),(3,2,3,2),(4,2,3,12);
-- -- Task 2
-- select *
-- from staff
-- where ((staff_name like 'T%' or staff_name like 'H%' or 
-- staff_name like 'K%') and length(staff_name)) <15;
-- -- Task 3
-- select *
-- from customer
-- where ((DATEDIFF(CURDATE(),customer.day_of_birth)/365) <50) 
-- and (customer.address like 'Da Nang' or customer.address like 'Quang Tri');
-- -- Task 4
-- select customer.customer_name, count(customer.customer_id) as `time`
-- from contract
-- join customer on customer.customer_id = contract.customer_id
-- join type_of_customer on type_of_customer.type_id =customer.type_id
-- where type_of_customer.type_name = 'Diamond'
-- group by contract.customer_id 
-- order by count(customer.customer_id);
-- Task 5
-- Th có nhiều dịch vụ đi kèm trong hd
-- select c.customer_id, c.customer_name, t.type_name, ctr.contract_id, s.service_name,
-- ctr.check_in, ctr.check_out,
-- (s.cost + dc.quantity*acs.a_price) as totalPrice
-- from contract ctr
-- left join customer c on c.customer_id = ctr.customer_id
-- left join type_of_customer t on t.type_id = c.type_id
-- left join service s on s.service_id = ctr.service_id
-- left join detail_contract dc on dc.contract_id = ctr.contract_id
-- left join accompanied_service acs on acs.a_id = dc.a_id
-- group by contract_id;
-- Task 6
select s.service_id, s.service_name, s.area, s.cost, c.check_in, ts.type_nervice_name
from contract c
right join service s on s.service_id = c.service_id
right join type_of_service ts on ts.type_service_id = s.type_service_id
where (year(c.check_in) > '2019') or (year(c.check_in) = '2019'and month(c.check_in) >3)
or (c.service_id is null)
group by c.service_id ;
-- Task 7
-- select s.service_id, s.service_name, s.area, s.number_of_person, s.cost, 
-- ts.type_nervice_name
-- from contract c
-- right join service s on s.service_id = c.service_id
-- right join type_of_service ts on ts.type_service_id = s.type_service_id
-- where (year(c.check_in) = '2018') and s.service_id not in (
-- select s.service_id
-- from contract c
-- right join service s on s.service_id = c.service_id
-- right join type_of_service ts on ts.type_service_id = s.type_service_id
-- where (year(c.check_in) = '2019'));
-- -- Task 8 (chưa hoàn thiện)
-- select c.customer_name
-- from customer c 
-- left join contract ctr on c.customer_id = ctr.customer_id
-- union
-- select c.customer_name
-- from customer c 
-- left join contract ctr on c.customer_id = ctr.customer_id;
-- Cách 2 dùng group by
-- Cách 3 dùng SELECT DISTINCT column_name1, column_name2 FROM table_name;
 -- -- Task 9
select check_in, count(contract_id) as Total
from contract 
where year(check_in) = 2019 
group by month(check_in)
order by month(check_in);
--  -- --Task 10
-- select ctr.contract_id, count(detail_contract_id) as Total
-- from contract ctr
-- join detail_contract dc on dc.contract_id = ctr.contract_id
-- join accompanied_service acs on acs.a_id = dc.a_id
-- group by dc.detail_contract_id;
-- -- Task 11 
-- select c.customer_id, c.customer_name, acs.a_name
-- from customer c
-- join type_of_customer tc on tc.type_id = c.type_id
-- join contract ctr on c.customer_id = ctr.customer_id
-- join detail_contract dc on dc.contract_id = ctr.contract_id
-- join accompanied_service acs on acs.a_id = dc.a_id
-- where tc.type_name = 'Diamond' and 
-- (c.address like 'Vinh' or c.address like 'Quang Ngai');
-- -- Task 12
-- create view Task12 as
--  select ctr.contract_id, s.staff_name, c.customer_name, c.phone_number,
--  sv.service_name, dc.quantity, ctr.deposit
--  from contract ctr
--  join customer c on c.customer_id = ctr.customer_id
--  join staff s on s.staff_id = ctr.staff_id
--  join service sv on sv.service_id = ctr.service_id
--  join detail_contract dc on dc.contract_id = ctr.contract_id
--  where  year(ctr.check_in) =2019 and month(ctr.check_in) >9 and ctr.service_id not in (
-- 	select ctr.contract_id
-- 	from contract ctr
-- 	join service sv on sv.service_id = ctr.service_id
-- 	join detail_contract dc on dc.contract_id = ctr.contract_id
-- 	where  year(ctr.check_in) =2019 and month(ctr.check_in) <=6);
-- Task 13
select ctr.contract_id, dc.a_id, acs.a_name, sum(quantity) as Total
from contract ctr
join detail_contract dc on dc.contract_id = ctr.contract_id
join accompanied_service acs on acs.a_id = dc.a_id
group by ctr.contract_id having Total >= all 
	(select sum(quantity)
	from contract ctr 
    join detail_contract dc on dc.contract_id = ctr.contract_id
	join accompanied_service acs on acs.a_id = dc.a_id
    group by dc.detail_contract_id);
-- -- Task 14
-- select ctr.contract_id, dc.a_id, acs.a_name, sum(quantity) as Total
-- from contract ctr
-- join detail_contract dc on dc.contract_id = ctr.contract_id
-- join accompanied_service acs on acs.a_id = dc.a_id
-- group by acs.a_id having Total = 1;
-- -- Task 15 Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, 
-- -- TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.
select s.staff_id, s.staff_name, p.part_name, s.phone_number, s.address
,count(ctr.staff_id) as Total
from staff s
join part p on p.part_id = s.part_id
left join contract ctr on ctr.staff_id = s.staff_id
where (year(ctr.check_in) between 2018 and 2019) or ctr.staff_id is null
group by staff_id having total <4
order by Total asc;
-- -- Task 16
-- delete
-- from staff s
-- where staff_id not in (
-- select staff_id
-- from contract
-- where year(check_in) between 2017 and 2019);
-- -- Task 17
SET SQL_SAFE_UPDATES = 0;
update customer c
set c.type_id = 1
where c.customer_id in (
select customer_id
from contract 
where year(check_in) = 2019
group by customer_id having sum(total_money)>=10000);
SET SQL_SAFE_UPDATES = 1;
-- task 18 Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).
-- SET SQL_SAFE_UPDATES = 0;
-- delete
-- from customer 
-- where customer_id not in ( 
-- select customer_id 
-- from contract 
-- where year(check_in) < 2016);
-- SET SQL_SAFE_UPDATES = 1;
-- -- task 19 Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
-- SET SQL_SAFE_UPDATES = 0;
-- update accompanied_service
-- set a_price = a_price*2
-- where a_id in (select* from(
-- select acs.a_id
-- from accompanied_service acs
-- join detail_contract dc on acs.a_id = dc.a_id
-- join contract ctr on dc.contract_id = ctr.contract_id
-- group by dc.a_id having sum(dc.quantity) >= 10)tblTmc);
-- SET SQL_SAFE_UPDATES = 1;
-- -- task 20 Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống,
-- thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
-- select staff_id as id , staff_name as name, email, phone_number, day_of_birth, address
-- from staff
-- union
-- select 
-- customer_id,customer_name, email, phone_number, day_of_birth, address
-- from customer ;
-- --task 21 Tạo view có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là
 -- -- “Hải Châu” và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”
-- create view v_staff as 
-- select distinct s.staff_id, s.staff_name, p.position_name, pa.part_name, s.address
-- from staff s
-- join position p on p.position_id = s.position_id
-- join part pa on pa.part_id = s.part_id
-- join contract ctr on ctr.staff_id = s.staff_id
-- where ctr.check_in = '2019-12-12' and s.address like 'Hai Chau%';
-- -- task 22 Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối
-- -- với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.
-- SET SQL_SAFE_UPDATES = 0;
-- update v_staff 
-- set s.address = 'Lien Chieu - Da Nang'
-- where s.staff_id in (select s.staff_id from v_staff);
-- SET SQL_SAFE_UPDATES = 1;
-- -- task 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với
-- -- Id Khách hàng được truyền vào như là 1 tham số của Sp_1
-- DELIMITER //
-- create procedure delete_customer (delete_id int)
--  begin
-- delete 
-- from customer
-- where customer_id = delete_id ;
--  end //
-- DELIMITER ;
-- call delete_customer(106);
-- -- task 24 Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải
-- -- thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khó chính 
-- -- và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan
-- DELIMITER //
-- -- SET FOREIGN_KEY_CHECKS=0;
-- create procedure add_contract (new_contract_id int,
-- new_staff_id int ,
-- new_customer_id int,
-- new_service_id int,
-- check_in date,
-- check_out date,
-- deposit int,
-- total_money int
-- )
--  begin
-- if new_contract_id in (select contract_id from contract) then 
-- select 'contract_id is duplicate';
-- -- select concat(new_contract_id, 'duplication') as contrac; 
-- elseif new_staff_id not in (select staff_id from staff) then
-- select 'staff_id is not exists';
-- elseif new_customer_id not in (select customer_id from customer) then
-- select 'customer_id is not exists';
-- elseif new_service_id not in (select service_id from service) then
-- select 'service_id is not exists';
-- else
-- insert into contract value 
-- (new_contract_id,new_staff_id,new_customer_id,new_service_id,
-- check_in,check_out, deposit,total_money) ;
-- -- SET FOREIGN_KEY_CHECKS=1;
-- end if;
--  end //
-- DELIMITER ;
-- call add_contract (11,1006,104,103,'2019-12-12','2019-12-13',100,200);

