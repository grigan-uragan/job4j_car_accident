create table users (
    username varchar(50) primary key,
    password varchar(100),
    enabled boolean default true
);

create table authorities (
    username varchar(50) not null references users(username),
    authority varchar(50) not null
);