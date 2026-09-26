CREATE DATABASE IF NOT EXISTS shop_lesson1
	CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE shop_lesson1

INSERT INTO product(name,price,stock)VALUES('1號漢堡',12.50,2)
INSERT INTO product(name,price,stock)VALUES('2號薯條',80,10);
INSERT INTO product(name,price,stock)VALUES('3號雞塊',65,20);
INSERT INTO product(name,price,stock)VALUES('4號豬肉漢堡',18,20);
INSERT INTO product(name,price,stock)VALUES('5號可樂',25,20);
INSERT INTO product(name,price,stock)VALUES('4暗黑食物',10000,1);

UPDATE product SET price = 60 WHERE id = 2 
DELETE FROM product WHERE id = 4
SELECT * FROM product


SELECT * FROM product ORDER BY id DESC

SELECT name as product_name,price as unit_price FROM product

SELECT id,name,price from product WHERE price > 15  ORDER BY price 
SELECT id,name,price from product WHERE price = 25 
-- 不等於
SELECT id,name,price from product WHERE price <> 25 
SELECT id,name,price from product WHERE name='1號漢堡' OR name= '3號雞塊'
SELECT id,name,price from product WHERE  price > 20 AND price <= 60
SELECT  id,name,price,`CONSTRAINT`  FROM product WHERE price IS NOT NULL
SELECT  id,name,price,`CONSTRAINT`  FROM product WHERE `CONSTRAINT` IS NOT NULL