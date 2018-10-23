drop database if exists superDB;

create database superDB;

use superDB;

create table location (
id int primary key auto_increment,
`name` varchar(20) not null,
`description` varchar(45) not null,
longitude double not null,
lattitude double not null,
city varchar(15) not null,
stateInitial char(2) not null,
zipcode varchar(10) not null
);

create table org (
id int primary key auto_increment,
`name` varchar(15) not null,
`description` varchar(45) not null,
phone varchar(10) not null,
email varchar(30) not null,
city varchar(15) not null,
stateInitial char(2) not null,
zipcode varchar(10) not null
);

create table heroVillain (
id int primary key auto_increment,
`name` varchar(15) not null,
`description` varchar(45) not null,
power varchar(15) not null,
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
`date` datetime not null
);

create table hvSightings (
id int primary key auto_increment,
sightingsId int,
foreign key(sightingsId) references sightings(id),
heroVillainId int,
foreign key(heroVillainId) references heroVillain(id)
);


