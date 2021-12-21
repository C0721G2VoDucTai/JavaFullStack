drop database if exists my_database;
CREATE DATABASE my_database;
USE my_database;
CREATE TABLE student(
id INT primary key auto_increment,
name VARCHAR(45) NULL,
age INT NULL,
country VARCHAR(45) Null
);
CREATE TABLE class(
id INT primary key auto_increment,
name VARCHAR(45) NULL
);
CREATE TABLE teacher(
id INT primary key auto_increment,
name VARCHAR(45) NULL,
age INT NULL,
country VARCHAR(45) Null
);