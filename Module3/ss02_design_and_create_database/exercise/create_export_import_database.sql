drop database if exists export_import_materials;
create database export_import_materials;
use export_import_materials;
create table import_bill(
iId int not null auto_increment primary key,
importDay date not null
);
create table export_bill(
eId int not null auto_increment primary key,
exportDay date not null
);
create table material(
mId int not null auto_increment primary key,
mName varchar(50) not null
);
create table export_bill_detail (
mId int not null,
eId int not null,
exportUnitPrice double not null,
exportQuantity int not null,
primary key (mId, eId),
foreign key (mId) references material(mId),
foreign key (eId) references export_bill(eId)
);
create table import_bill_detail (
mId int not null,
iId int not null,
importUnitPrice double not null,
importQuantity int not null,
primary key (mId, iId),
foreign key (mId) references material(mId),
foreign key (iId) references import_bill(iId)
);
create table products (
pId int not null auto_increment primary key,
pName varchar(50),
address varchar(256)
);
create table products_phone(
pId int not null,
phone varchar(12),
foreign key (pId) references products (pId)
);
create table `order`(
oId int not null auto_increment primary key,
orderDay date not null,
pId int not null,
foreign key (pId) references products(pId)
);
create table order_detail(
mId int not null,
oId int not null,
primary key (mId, oId),
foreign key (mId) references material (mId),
foreign key (oId) references `order` (oId)
);


