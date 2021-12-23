drop database if exists san_pham;
create database san_pham;
use san_pham;

create table san_pham(
id int primary key ,
name varchar (50),
price double,
description varchar(50),
producer varchar(50)
);

insert into san_pham values 
(1,"oto",3440000,"hàhsajfhs","sdasdasd");