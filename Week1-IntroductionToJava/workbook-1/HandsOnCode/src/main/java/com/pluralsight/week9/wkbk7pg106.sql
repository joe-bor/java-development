-- 1) Add a new supplier
INSERT INTO Suppliers (SupplierId, CompanyName)
VALUES (9999, "Random");

-- 2) Add a new product provided by that supplier
INSERT INTO Products (ProductId, ProductName, SupplierId, UnitPrice)
VALUES (9999, "RandomProduct", 9999, 1);

-- 3) ist all products and their suppliers
SELECT ProductName, CompanyName
FROM Products p
JOIN Suppliers s
ON p.SupplierID = s.SupplierID
ORDER BY CompanyName;

-- 4) raise ht price of your new product by 15%
UPDATE Products
SET UnitPrice = (UnitPrice * 1.15)
WHERE ProductId = 9999;

-- 5) list the products and prices that belong to new supplioer
SELECT ProductName, UnitPrice
FROM Products
WHERE SupplierID = 9999; -- 9999 is the supplier id used in query#1

-- 6) Delte the new product
DELETE FROM Products
WHERE SupplierId = 9999;

-- 7) delete the new supplioer
DELETE FROM Suppliers
WHERE SupplierID = 9999;

-- 8) list all products
SELECT * FROM Products;

-- 9) list all suppliers
SELECT * FROM Suppliers;
