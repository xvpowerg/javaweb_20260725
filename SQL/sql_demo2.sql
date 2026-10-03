CREATE TABLE customer (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '客戶唯一編號',
    name VARCHAR(100) NOT NULL COMMENT '客戶姓名，姓名可能重複',
    phone VARCHAR(20) COMMENT '電話；沒填寫時可為 NULL'
) ENGINE=InnoDB;

-- customer_profile：一位客戶「最多一份」詳細資料。
-- customer_id 同時是主鍵與外鍵，不能重複，因此形成 1 對 0..1。
CREATE TABLE customer_profile (
    customer_id INT PRIMARY KEY COMMENT '客戶編號，同時作為 PK 與 FK',
    address VARCHAR(200) COMMENT '地址',
    birthday DATE COMMENT '生日，只有年月日',
    CONSTRAINT fk_profile_customer FOREIGN KEY (customer_id)
        REFERENCES customer(id) -- 禁止指向不存在的客戶
) ENGINE=InnoDB;

SELECT * FROM shop_lesson1.customer;

SELECT * FROM customer 
INNER JOIN customer_profile 
ON customer.id = customer_profile.customer_id;

SELECT * FROM customer c
INNER JOIN customer_profile cp
ON c.id = cp.customer_id;

SELECT * FROM customer c
LEFT JOIN customer_profile cp
ON c.id = cp.customer_id;