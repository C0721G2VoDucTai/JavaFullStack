drop database demo;
create database demo;
use demo;
create table product (
id int auto_increment primary key,
product_code varchar(45),
product_name varchar(45),
product_price int,
product_amount int,
product_description text,
product_status bit
);
insert into product (product_code,product_name,product_price,product_status) values
(1001,'Iphone 7', 7000000, 1),
(1002,'Iphone 7 Plus', 8000000, 0),
(1003,'Iphone 8', 9000000, 1),
(1004,'Iphone 11', 12000000, 1),
(1005,'Iphone 12', 20000000, 1),
(1006,'Iphone 13', 3000000, 1);
-- EXPLAIN SELECT * FROM product WHERE product_name = 'Iphone 8'; 
-- create unique index index_product_code on product (product_code);
-- EXPLAIN SELECT * FROM product WHERE product_code = '1002'; 
-- create  index index_name_price on product (product_name, product_price);
-- EXPLAIN SELECT * FROM product WHERE product_name = 'Iphone 8'; 
create view view_product as
select product_code,product_name,product_price,product_status
from product ;
SET SQL_SAFE_UPDATES = 0;
update view_product
set product_price = 7500000
where product_code = '1002';
delete from view_product
where product_code = '1002';
DELIMITER //
create procedure product_display ()
 begin
select*
from product ;
 end //
DELIMITER ;
call product_display();
DELIMITER //
create procedure insert_new_product (product_code varchar(45), product_name varchar(45),
product_price int,product_status bit)
 begin
insert into product (product_code,product_name,product_price,product_status) values
(product_code,product_name,product_price,product_status);
 end //
DELIMITER ;
call insert_new_product(1007,'Iphone 14', 3000000, 1);
DELIMITER //
create procedure edit_product (new_id int,new_code varchar(45), new_name varchar(45),
new_price int,new_status bit)
 begin
update product
set product_code = new_code,
product_name = new_name,
product_price = new_price,
product_status =new_status
where  id = new_id;
 end //
 DELIMITER ;
 call edit_product(7,1008,'Iphone 13 P', 3000000, 1);
DELIMITER //
create procedure delete_product (new_id int)
 begin
delete 
from product
where id = new_id ;
 end //
DELIMITER ;
call delete_product(7);

