insert into categories values (1, 'головной убор');
insert into categories values (2, 'одежда');
insert into categories values (3, 'другая вещь');
insert into items values (1, 'треуголка',1);
insert into items values (2, 'бандана',1);
insert into items values (3, 'рубашка',2);
insert into attribute values (1, 'цвет');
insert into attribute values (2, 'размер');
insert into attribute values (3, 'материал');
insert into values values (1, 'зеленый',1);
insert into values values (2, 'XL',2);
insert into values values (3, 'хлопок',3);
insert into articles values (1,1200, 10);
insert into item_values values (1, 1,1, 1);
insert into item_values values (2, 1,2, 1);
insert into values values (4,'красный',1);
insert into values values (5,'S',2);
insert into articles values (2,1500,20);
insert into item_values values (3,2,4,2);
insert into item_values values (4,2,5,2);

insert into pirates values (1, 'Андрей');
insert into pirates values (2, 'Глеб');

insert into roles values (1, 'Админ');
insert into roles values (2, 'Пользователь');

insert into pirates_roles values (1, 1);
insert into pirates_roles values (2, 2);

insert into status values (1, 'Выполнен');
insert into status values (2, 'Не выполнен');

insert into orders values (1,'2022-12-26', '2022-12-27',1,1);
insert into orders values (2,'2022-11-25','2022-12-29',2,2);
insert into articles_orders values (1,1, 1, 1);
insert into articles_orders values (2,2,2,1);

insert into credentials values (1,'login', 'password',1,true);
insert into credentials values (2,'login2', 'password2',2,true);


