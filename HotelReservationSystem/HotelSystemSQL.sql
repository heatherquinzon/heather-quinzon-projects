drop database if exists hotelSystem;

create database hotelSystem;

use hotelSystem;

create table amenities (
id int primary key auto_increment,
`type` varchar(30) not null
);

create table roomType (
id int primary key auto_increment,
`type` varchar(10) not null
);

create table room (
id int primary key auto_increment,
roomNum int not null,
floorNum int not null,
roomTypeId int,
foreign key(roomTypeId) references roomType(id)
);

create table roomAmenities (
id int primary key auto_increment,
roomId int,
foreign key(roomId) references room(id),
amenitiesId int,
foreign key(amenitiesId) references amenities(id)
);

create table customer (
id int primary key auto_increment,
age int,
firstName varchar(10) not null,
lastName varchar(15) not null,
phoneNum varchar(12) not null,
email varchar(45) not null
);

create table guests (
id int primary key auto_increment,
firstName varchar(10) not null,
lastName varchar(15) not null,
customerId int,
foreign key(customerId) references customer(id)
);

create table promotionType (
id int primary key auto_increment,
`type` varchar(10) not null
);

create table promotionCode (
id int primary key auto_increment,
startDate date not null,
endDate date not null,
promotionTypeId int,
foreign key(promotionTypeId) references promotionType(id)
);

create table reservation (
id int primary key auto_increment,
startDate date not null,
endDate date not null,
customerId int,
foreign key(customerId) references customer(id),
promotionCodeId int,
foreign key(promotionCodeId) references promotionCode(id)
);

create table roomReservation (
id int primary key auto_increment,
reservationId int,
foreign key(reservationId) references reservation(id),
roomId int,
foreign key(roomId) references room(id)
);

create table seasonRate (
id int primary key auto_increment,
startDate date not null,
endDate date not null,
rate decimal(7, 2) not null
);

create table addOns (
id int primary key auto_increment,
`name` varchar(20) not null,
price decimal(7, 2) not null
);

create table addOnRates (
id int primary key auto_increment,
addOnId int,
foreign key(addOnId) references addOns(id),
seasonRateId int,
foreign key(seasonRateId) references seasonRate(id)
);

create table roomRates (
id int primary key auto_increment,
roomTypeId int,
foreign key(roomTypeId) references roomType(id),
seasonRateId int,
foreign key(seasonRateId) references seasonRate(id)
);

create table billingDetails (
id int primary key auto_increment,
roomDescription varchar(45) not null,
cost decimal(7,2) not null
);

create table billing (
id int primary key auto_increment,
subTotal decimal(7, 2) not null,
taxTotal decimal(7, 2) not null,
grandTotal decimal(7, 2) not null,
billingDetailsId int,
foreign key(billingDetailsId) references billingDetails(id),
roomReservationId int,
foreign key(roomReservationId) references roomReservation(id)
);
