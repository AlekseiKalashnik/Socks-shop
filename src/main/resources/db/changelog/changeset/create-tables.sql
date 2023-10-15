create table socks (
    id int primary key auto_increment,
    color varchar(32) not null,
    cotton_part int not null check ( cotton_part >= 0 AND cotton_part <= 100 ),
    quantity int check ( quantity >= 0 )
);