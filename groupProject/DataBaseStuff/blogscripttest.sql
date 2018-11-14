drop database if exists blogdb_test;

create database blogdb_test;

use blogdb_test;

create table users (
id int primary key auto_increment,
username varchar(20) not null unique,
pass varchar(100) not null,
enabled boolean not null
);

create table tag (
id int primary key auto_increment,
`name` varchar(25) not null
);

create table category (
id int primary key auto_increment,
`name` varchar(25) not null
);

create table post (
id int primary key auto_increment,
title varchar(100) not null,
postDate datetime not null,
content longtext not null,
userId int not null,
state int not null,
foreign key(userId) references users(id),
referencingId int,
foreign key(referencingId) references post(id),
categoryId int,
foreign key(categoryId) references category(id)
);

create table PostTag (
postId int,
tagId int,
primary key(postId, tagId),
foreign key(postId) references post(id),
foreign key(tagId) references tag(id)
);

create table role (
id int primary key auto_increment,
role varchar(30) not null
);

create table UsersRole (
usersId int,
roleId int,
primary key(usersId, roleId),
foreign key(usersId) references users(id),
foreign key(roleId) references role(id)
);

insert into `users`(`id`,`username`,`pass`,`enabled`)
    values(1,"admin", "password", true),
        (2,"user","password",true);

insert into `role`(`id`,`role`)
    values(1,"ROLE_ADMIN"), (2,"ROLE_USER");
    
insert into `usersRole`(`usersId`,`roleId`)
    values(1,1),(1,2),(2,2);
    
UPDATE users SET pass = '$2a$10$VGQuAOc9KznZbr4GXoCv9eQdpU5jve2vTyR9pmNQ5COnb/DI58zEK' WHERE id = 1;
UPDATE users SET pass = '$2a$10$VGQuAOc9KznZbr4GXoCv9eQdpU5jve2vTyR9pmNQ5COnb/DI58zEK' WHERE id = 2;