# SimpleTest

Script Base de Datos

DROP DATABASE stock;
CREATE DATABASE stock;
USE stock;
CREATE TABLE stock.legends (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, meaning VARCHAR(100), color VARCHAR(20), hex VARCHAR(7), status boolean);
INSERT INTO legends (meaning, color, hex, status) VALUES ('Not enough product', 'Red', '#d80808', 1);
INSERT INTO legends (meaning, color, hex, status) VALUES ('More than necessary', 'Yellow', '#eee210', 1);
INSERT INTO legends (meaning, color, hex, status) VALUES ('Full capacity', 'Green', '#4bdc0f', 1);
CREATE TABLE stock.warehouse (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), product_min int(20), product_max int(7), status boolean);
INSERT INTO warehouse (name, product_min, product_max, status) VALUES ('Plant 1', 10, 100, 1);
INSERT INTO warehouse (name, product_min, product_max, status) VALUES ('Plant 2', 5, 10, 1);
INSERT INTO warehouse (name, product_min, product_max, status) VALUES ('Plant 3', 7, 75, 1);
CREATE TABLE stock.products (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, idwarehouse int, idlegend int, name varchar(50), total_qty int, remaining_qty int, status boolean,  FOREIGN KEY (idwarehouse) references warehouse(id), FOREIGN KEY (idlegend) references legends(id));
INSERT INTO products (idwarehouse , idlegend, name, total_qty, remaining_qty, status) VALUES (2, 1, 'Sprite', 45, 3, 1);
INSERT INTO products (idwarehouse , idlegend, name, total_qty, remaining_qty, status) VALUES (3, 2, 'Dr.Pepper', 90, 85, 1);
INSERT INTO products (idwarehouse , idlegend, name, total_qty, remaining_qty, status) VALUES (2, 3, 'Canada Dry', 95, 50, 1);
