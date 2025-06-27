CREATE DATABASE PracticeDB;
USE PracticeDB;
CREATE TABLE Products (
    ProductID INT,
    ProductName VARCHAR(100),
    Category VARCHAR(50),
    Price DECIMAL(10,2)
);

INSERT INTO Products (ProductID, ProductName, Category, Price)
VALUES
(1, 'Laptop', 'Electronics', 80000),
(2, 'Mobile', 'Electronics', 50000),
(3, 'Camera', 'Electronics', 50000),
(4, 'Jeans', 'Clothing', 2000),
(5, 'T-Shirt', 'Clothing', 1000),
(6, 'Jacket', 'Clothing', 2000),
(7, 'Apple', 'Groceries', 100),
(8, 'Banana', 'Groceries', 40),
(9, 'Mango', 'Groceries', 100);

SELECT * FROM Products;
SELECT 
    ProductID,
    ProductName,
    Category,
    Price,
    ROW_NUMBER() OVER (PARTITION BY Category ORDER BY Price DESC) AS RowNum,
    RANK()       OVER (PARTITION BY Category ORDER BY Price DESC) AS RankNum,
    DENSE_RANK() OVER (PARTITION BY Category ORDER BY Price DESC) AS DenseRankNum
FROM Products;

WITH RankedProducts AS (
    SELECT *,
           ROW_NUMBER() OVER (PARTITION BY Category ORDER BY Price DESC) AS RowNum
    FROM Products
)
SELECT *
FROM RankedProducts
WHERE RowNum <= 3;
