drop table if exists member CASCADE;
create table member
(
 id bigint generated by default as identity,
 email varchar(255),
 password varchar(255),
 primary key (id)
);

drop table if exists product CASCADE;
create table product
(
 id bigint generated by default as identity,
 name varchar(255),
 qty bigint,
 primary key (id)
);



