drop database if exists superDB;

create database superDB;

use superDB;

create table location (
id int primary key auto_increment,
`name` varchar(20) not null,
`description` varchar(300) not null,
longitude double,
lattitude double,
city varchar(20) not null,
stateInitial char(2) not null,
zipcode varchar(10) not null
);

create table org (
id int primary key auto_increment,
`name` varchar(20) not null,
`description` varchar(300) not null,
phone varchar(12) not null,
email varchar(50) not null,
city varchar(20) not null,
stateInitial char(2) not null,
zipcode varchar(10) not null
);

create table heroVillain (
id int primary key auto_increment,
`name` varchar(20) not null,
`description` varchar(300) not null,
power varchar(30) not null,
`type` varchar(7) not null
);

create table hvOrg (
id int primary key auto_increment,
heroVillainId int,
foreign key(heroVillainId) references heroVillain(id),
orgId int,
foreign key(orgId) references org(id)
);

create table sightings (
id int primary key auto_increment,
locationId int,
foreign key(locationId) references location(id),
`date` date not null
);

create table hvSightings (
id int primary key auto_increment,
sightingsId int,
foreign key(sightingsId) references sightings(id),
heroVillainId int,
foreign key(heroVillainId) references heroVillain(id)
);