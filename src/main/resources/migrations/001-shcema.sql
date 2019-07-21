--liquibase formatted sql


--changeset author:schema-init
create table Author (
    id AUTOINCREMENT PRIMARY KEY,
    firstName varchar (255),
    lastName varchar (255),
    year int
);

create table Book (
    id AUTOINCREMENT PRIMARY KEY,
    name varchar (255),
    description varchar (255),
    published varchar (255),
    year int
);
