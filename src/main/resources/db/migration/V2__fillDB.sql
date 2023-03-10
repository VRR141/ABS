insert into categories
values (1, 'головной убор'),
       (2, 'одежда'),
       (3, 'другая вещь');

insert into items
values (1, 'треуголка', 1),
       (2, 'бандана', 1),
       (3, 'рубашка', 2);

insert into attribute
values (1, 'цвет'),
       (2, 'размер'),
       (3, 'материал');

insert into values
values (1, 'зеленый', 1),
       (2, 'XL', 2),
       (3, 'хлопок', 3);

insert into articles
values (1, 1200, 10);

insert into item_values
values (1, 1, 1, 1),
       (2, 1, 2, 1);

insert into values
values (4, 'красный', 1),
       (5, 'S', 2);

insert into articles
values (2, 1500, 20);

insert into item_values
values (3, 2, 4, 2),
       (4, 2, 5, 2);

insert into pirates
values (1, 'Андрей', 'mockLog','mockPass'),
       (2, 'Глеб', 'mockLog1', 'mockPass');

insert into roles
values (1, 'ADMIN'),
       (2, 'USER');

insert into pirates_roles
values (1, 1),
       (2, 2);

insert into status
values (1, 'Выполнен'),
       (2, 'Не выполнен');

insert into orders
values (1, '2022-12-26', '2022-12-27', 1, 1),
       (2, '2022-11-25', '2022-12-29', 2, 2);

insert into articles_orders
values (1, 1, 1, 1),
       (2, 2, 2, 1);