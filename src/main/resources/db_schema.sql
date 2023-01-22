DROP TABLE IF EXISTS users;

CREATE TABLE users (
    userId   varchar(12) not null,
    password varchar(12) not null,
    userName varchar(12) not null,
    primary key (userId)
);

