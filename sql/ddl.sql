/*
   User Table
*/

create table user(
id int primary key auto_increment,
username varchar(20) not null unique,
email varchar(100) not null unique,
mobile varchar(10) not null unique,
password varchar(15) not null
);