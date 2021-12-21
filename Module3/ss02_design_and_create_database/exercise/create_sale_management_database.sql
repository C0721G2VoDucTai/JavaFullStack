drop database if exists sale_management;
create database sale_management;
use sale_management;
create table customer (
cId int not null auto_increment primary key,
cName varchar(50) not null,
cAge int null
);
insert into customer value 
(1, 'Nguyen Van A', 25),
(2, 'Nguyen Van B', 28),
(3, 'Nguyen Van C', 29),
(4, 'Nguyen Van D', 32);
create table `order` (
oId int not null auto_increment primary key,
cId int not null,
oDate date not null,
oTotalPrice double null,
foreign key (cId) references customer(cId)
);
insert into `order` value
(1,1,'2021-10-12',3),
(2,2,'2021-10-12',3),
(3,2,'2021-10-12',2);
create table product (
pId int not null auto_increment primary key,
pName varchar (50) not null,
pPrice double not null
);
insert into product value
(1,'Iphone13',30000000),
(2,'Iphone12',22000000);
create table order_detail(
oId int not null,
pId int not null,
oderQty int null,
primary key (oId,pId),
foreign key (oId) references `order`(oId),
foreign key (pId) references product(pId)
);
insert into order_detail value
(1,2,10),
(1,1,5);
insert into order_detail value
(2,2,8);