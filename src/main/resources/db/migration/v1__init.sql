create table users (
    id          bigint,
    username    varchar(30) not null unique,
    password    varchar(80) not null,
    email       varchar(50) unique,
    primary key (id)
)

create table roles (
    id          int,
    name        varchar(50) not null,
    primary key (id)
)

create table users_roles (
    user_id     bigint not null,
    role_id     int not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users(id),
    foreign key (role_id) references roles(id)
);

insert into roles (name)
values
('ROLE_ADMIN'), ('ROLE_USER');

insert into users (id, username, password, email)
values
(1, 'admin', '100', 'admin@gmail.com')

insert into users_roles
values
(1, 1), (1, 2)