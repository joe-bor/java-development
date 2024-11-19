-- Workbook 7 Intoduction to SQL (Exercises page 51)
-- 1) Products Table
-- 2)
SELECT ProductID, ProductName, UnitPrice FROM Products;

-- 3)
SELECT ProductID, ProductName, UnitPrice
FROM Products
order by unitprice;

-- 4)
SELECT *
FROM Products
WHERE unitprice <= 7.50;

-- 5)
SELECT *
FROM Products
WHERE UnitsInStock >= 100
ORDER BY unitprice DESC;

-- 6)
SELECT *
FROM Products
WHERE UnitsInStock >= 100
ORDER BY UnitPrice DESC, ProductName ASC;

-- 7)
SELECT *
FROM Products
WHERE UnitsInStock = 0
AND
UnitsOnOrder >= 1
ORDER BY ProductName;

-- 8) Categories

-- 9)
SELECT * FROM Categories;
SELECT CategoryID
FROM Categories
WHERE CategoryName = 'Seafood';

-- 10)
SELECT *
FROM Products
WHERE CategoryID = 8;

-- 11)
SELECT firstname, lastname
FROM Employees;

-- 12)
SELECT *
FROM Employees
WHERE Title
LIKE '%manager%';

-- 13)
SELECT DISTINCT Title
FROM Employees;

-- 14)
SELECT *
FROM Employees
WHERE Salary
BETWEEN 2000 AND 25000;

-- 15)
SELECT *
FROM Suppliers;

-- 16)
-- First I need to find out The SupplierID for Tokyo Traders
-- Then use this to filter out the products table
SELECT *
FROM Products AS p
JOIN Suppliers as S
ON s.SupplierID=p.SupplierID
WHERE s.CompanyName = 'Tokyo Traders';