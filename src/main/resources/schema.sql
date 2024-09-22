CREATE SCHEMA IF NOT EXISTS netology;

CREATE TABLE IF NOT EXISTS netology.customers (
   id SERIAL PRIMARY KEY,
   name VARCHAR(50) NOT NULL,
   surname VARCHAR(50) NOT NULL,
   age INT,
   phone_number VARCHAR(15)
);

INSERT INTO netology.customers (name, surname, age, phone_number)
VALUES ('Виктор', 'Петров', 25, '8-999-999-99-99'),
       ('Иван', 'Смирнов', 27, '8-999-888-88-88'),
       ('Алексей', 'Васильев', 30, '8-999-555-55-55');

CREATE TABLE IF NOT EXISTS netology.orders (
   id SERIAL PRIMARY KEY,
   date DATE NOT NULL,
   customer_id INT REFERENCES netology.customers(id),
   product_name VARCHAR(100) NOT NULL,
   amount DECIMAL(10, 2) NOT NULL
);

INSERT INTO netology.orders (date, customer_id, product_name, amount)
VALUES ('2024-09-17', 2, 'Смартфон', 20000.00),
       ('2024-09-18', 1, 'Планшет', 16000.00),
       ('2024-09-20', 3, 'Телевизор', 50000.00);

SELECT * FROM netology.orders;

SELECT * FROM netology.customers;

SELECT A.product_name
FROM netology.orders A
JOIN netology.customers B ON A.customer_id = B.id
WHERE LOWER(B.name) = LOWER(:name);

SELECT * FROM INFORMATION_SCHEMA.SETTINGS WHERE NAME = 'MODE';
