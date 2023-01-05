INSERT INTO black_ship.public.pirates
VALUES (1, 'Андрей', 'login1', 'password1'),
       (2, 'Саня', 'login2', 'password2'),
       (3, 'Влад', 'login3', 'password3'),
       (4, 'Костян', 'login4', 'password4'),
       (5, 'Глеб', 'login5', 'password5'),
       (6, 'Саня В.', 'login6', 'password6');

INSERT INTO black_ship.public.roles
VALUES (1, 'Капитан'),
       (2, 'Помощник Капитана'),
       (3, 'Пират'),
       (4, 'Сухопутная крыса');

INSERT INTO black_ship.public.pirates_roles
VALUES (1, 1),
       (2, 2),
       (3, 2),
       (4, 2),
       (5, 2),
       (6, 2);

INSERT INTO black_ship.public.statuses
VALUES (1, 'Выполнен'),
       (2, 'Не выполнен'),
       (3, 'Отмена'),
       (4, 'Возврат');

INSERT INTO black_ship.public.orders
VALUES (1, 1, 1, '2022-12-26', '2022-12-30'),
       (2, 2, 2, '2022-12-26', null),
       (3, 3, 1, '2022-12-20', '2022-12-23'),
       (4, 4, 1, '2022-12-25', '2022-12-28'),
       (5, 5, 2, '2022-12-30', null),
       (6, 6, 1, '2022-12-28', '2022-12-31');

INSERT INTO black_ship.public.articles
VALUES (1, 1200, 9),
       (2, 1200, 5),
       (3, 1200, 7),
       (4, 900, 7),
       (5, 900, 6),
       (6, 900, 8),
       (7, 1500, 4),
       (8, 1500, 7),
       (9, 1500, 5);

INSERT INTO black_ship.public.orders_articles
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (2, 6);

INSERT INTO black_ship.public.items
VALUES (1, 'Треуголка'),
       (2, 'Бандана'),
       (3, 'Рубашка'),
       (4, 'Мушкет'),
       (5, 'Рапира'),
       (6, 'Деревянная нога');

INSERT INTO black_ship.public.categories
VALUES (1, 'Головной убор'),
       (2, 'Одежда'),
       (3, 'Обувь'),
       (4, 'Оружие'),
       (5, 'Протез');

INSERT INTO black_ship.public.attributes
VALUES (1, 'Цвет'),
       (2, 'Размер'),
       (3, 'Материал');

INSERT INTO black_ship.public.values
VALUES (1, 'Красный'),
       (2, 'Черный'),
       (3, 'Белый'),
       (4, 'S'),
       (5, 'M'),
       (6, 'L'),
       (7, 'XL'),
       (8, 'Хлопок'),
       (9, 'Лён'),
       (10, 'Шёлк'),
       (11, 'Металл'),
       (12, 'Дерево');

INSERT INTO black_ship.public.factory
VALUES (1, 1, 2, 1),
       (3, 8, 2, 1),
       (1, 2, 2, 2),
       (3, 8, 2, 2),
       (1, 3, 2, 3),
       (3, 8, 2, 3);