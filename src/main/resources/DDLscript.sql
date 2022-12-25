create table pirates
(
    id   int auto_increment primary key,
    name varchar(35) not null
)

create table roles
(
    id int auto_increment primary key,
    name varchar(35) not null
)

create table pirates_roles
(
    pirate_id int null,
    role_id   int null,
    constraint pirate
        foreign key (pirate_id) references pirates (id),
    constraint role
        foreign key (role_id) references roles (id)
)

create table credentials
(
    id        int auto_increment primary key,
    login     varchar(14) not null,
    password  varchar(14) not null,
    pirate_id int         null,
    constraint credentials_pirate
        foreign key (pirate_id) references pirates (id)
)

create table status
(
    id   int auto_increment primary key ,
    name varchar(14) not null
)

create table orders
(
    id             int auto_increment primary key ,
    order_date     datetime not null,
    completed_date datetime null,
    pirate_id      int      null,
    status_id      int      null,
    constraint order_pirate
        foreign key (pirate_id) references pirates (id),
    constraint order_status
        foreign key (status_id) references status (id)
);




