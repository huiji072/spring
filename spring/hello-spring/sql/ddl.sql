drop table if exists member CASCADE;
create table member
(
 id bigint generated by default as identity,
 email varchar(255),
 password varchar(255),
 primary key (id)
);