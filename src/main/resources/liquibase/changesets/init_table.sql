--Создание таблицы кошельков в случае ее отсутсвия
CREATE TABLE IF NOT EXISTS wallets
(
    id UUID PRIMARY KEY,
    amount DECIMAL NOT NULL
    );
