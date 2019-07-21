--liquibase formatted sql


--changeset author:schema-init
create table Author (
    id AUTOINCREMENT PRIMARY KEY,
    first_Name varchar (255),
    last_Name varchar (255),
    year int
);

create table Book (
    id AUTOINCREMENT PRIMARY KEY,
    name varchar (255),
    description varchar (255),
    published varchar (255),
    year int
);
