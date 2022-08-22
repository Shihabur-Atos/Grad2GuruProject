CREATE DATABASE gameshop;
use gameshop;

CREATE TABLE Customers(
	customerID INT NOT NULL UNIQUE AUTO_INCREMENT,
	customerName VARCHAR(500) NOT NULL,
	age INT,
	email VARCHAR(500),
	PRIMARY KEY(customerID)
);

CREATE TABLE Products(
	productID INT NOT NULL UNIQUE AUTO_INCREMENT,
	productName VARCHAR(500) NOT NULL,
	quantity INT NOT NULL,
	genre VARCHAR(500),
    price decimal(4,2) NOT NULL,
	PRIMARY KEY(productID)
);

CREATE TABLE Orders(
	orderID INT NOT NULL UNIQUE AUTO_INCREMENT,
	customerID INT NOT NULL,
    productID INT NOT NULL,
	quantity INT NOT NULL,
	price decimal(4,2) NOT NULL,
	PRIMARY KEY(orderID),
    FOREIGN KEY (customerID) REFERENCES Customers(customerID),
    FOREIGN KEY (productID) REFERENCES Products(productID)
);

SELECT * FROM Customers;
SELECT * FROM Products;
SELECT * FROM Orders;
--  -------------------Insert Statements for each table--------------------------- 

INSERT INTO Customers(customerName, age, email) VALUES ("Reginald Vanjohnson", 23, "rvanj@aol.com");
INSERT INTO Customers(customerName, age, email) VALUES ("Dwayne Johnson", 38, "therock@wwe.com");
INSERT INTO Customers(customerName, age, email) VALUES ("Big Shaq", 44, "shaq@nba.com");

INSERT INTO Products(productName, genre, price, quantity) VALUES ("FIFA 22", "Sports", 59.99, 250);
INSERT INTO Products(productName, genre, price, quantity) VALUES ("GTA 6", "Action", 49.99, 50);
INSERT INTO Products(productName, genre, price, quantity) VALUES ("Call of Duty MW2", "FPS", 69.99, 950);

INSERT INTO Orders(customerID, productID, quantity, price) VALUES (1, 1, 5, 59.99);
INSERT INTO Orders(customerID, productID, quantity, price) VALUES (2, 2, 2, 49.99);
INSERT INTO Orders(customerID, productID, quantity, price) VALUES (3, 3, 3, 69.99);

