CREATE TABLE IF NOT EXISTS products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    purchase_date DATE,
    expiry_date DATE,
    description VARCHAR(255),
    store_name VARCHAR(255),
    review_stars INT NOT NULL,
    used_quantity INT NOT NULL
);
