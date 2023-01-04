CREATE TABLE IF NOT EXISTS pirates
(
    id       bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name     varchar(55),
    username varchar(15)  NOT NULL UNIQUE,
    password varchar(512) NOT NULL
);

CREATE TABLE IF NOT EXISTS roles
(
    id   bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name varchar(35) NOT NULL
);

CREATE TABLE IF NOT EXISTS pirates_roles
(
    pirate_id bigint REFERENCES pirates (id),
    role_id   bigint REFERENCES roles (id)
);

CREATE TABLE IF NOT EXISTS statuses
(
    id   bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name varchar(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS orders
(
    id             bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    pirate_id      bigint NOT NULL REFERENCES pirates (id),
    status_id      bigint NOT NULL REFERENCES statuses (id),
    order_date     date   NOT NULL,
    completed_date date
);

CREATE TABLE IF NOT EXISTS articles
(
    id     bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    price  bigint,
    amount int
);

CREATE TABLE IF NOT EXISTS articles_orders
(
    order_id   bigint REFERENCES orders (id),
    article_id bigint REFERENCES articles (id)
);

CREATE TABLE IF NOT EXISTS categories
(
    id   bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name varchar(35) NOT NULL
);

CREATE TABLE IF NOT EXISTS items
(
    id          bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    category_id bigint REFERENCES categories (id),
    name        varchar(35) NOT NULL
);

CREATE TABLE IF NOT EXISTS attributeResponseDtos
(
    id   bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name varchar(35) NOT NULL
);

CREATE TABLE IF NOT EXISTS values
(
    id   int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name varchar(35)
);

CREATE TABLE IF NOT EXISTS factory
(
    attribute_id bigint REFERENCES attributeResponseDtos (id),
    value_id     bigint REFERENCES values (id),
    item_id      bigint REFERENCES items (id),
    article_id   bigint REFERENCES articles (id)
);