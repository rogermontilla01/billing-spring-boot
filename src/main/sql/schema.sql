DROP DATABASE IF EXISTS billing;

CREATE DATABASE billing;

CREATE TABLE billing.clients (
    PRIMARY KEY (client_id),
	client_id int NOT NULL AUTO_INCREMENT,
    dni int NOT NULL,
    name varchar(255) NOT NULL,
    lastname varchar(255)
);

CREATE TABLE billing.products (
	PRIMARY KEY (product_id),
	product_id int NOT NULL AUTO_INCREMENT,
    product_code int NOT NULL,
	description varchar(255),
	quantity int NOT NULL,
	price float
);

CREATE TABLE billing.receipts (
    PRIMARY KEY (receipt_id),
    receipt_id int NOT NULL AUTO_INCREMENT,
    quantity int NOT NULL,
    price float,
    client_id int,
    CONSTRAINT FK_client FOREIGN KEY (client_id)
    REFERENCES clients(client_id)
);

CREATE TABLE billing.sales (
  	PRIMARY KEY (sale_id),
    sale_id int NOT NULL AUTO_INCREMENT,
    description varchar(255) NOT NULL,
    quantity int,
    price float,
    receipt_id int NOT NULL,
    product_id int NOT NULL,
    CONSTRAINT FK_receipts FOREIGN KEY (receipt_id)
    REFERENCES receipts(receipt_id),
    CONSTRAINT FK_product FOREIGN KEY (product_id)
    REFERENCES products(product_id)
);
