-- 1)
SELECT ProductID, ProductName, UnitPrice, CategoryName
FROM Products p
JOIN Categories c
ON p.CategoryID = c.CategoryID
ORDER BY CategoryName, ProductName;

-- 2)
SELECT ProductID, ProductName, UnitPrice, CompanyName
FROM Products p
JOIN Suppliers s
ON p.SupplierID = s.SupplierID
WHERE UnitPrice > 75
ORDER BY ProductName;

-- 3)
SELECT ProductID, ProductNAme, UnitPrice, CompanyName, CategoryName
FROM Products p
JOIN Suppliers s
ON p.SupplierId = s.SupplierID
JOIN Categories c
ON p.CategoryID = c.CategoryID
ORDER BY ProductName;

 -- 4)
 SELECT ProductName, CategoryName
 FROM Products p
 JOIN Categories c
 ON p.CategoryID = c.CategoryID
 WHERE UnitPrice = (
	SELECT MAX(UnitPrice)
    FROM Products
 );


 -- 5)
 SELECT OrderID, ShipName, ShipAddress, ShipName
 FROM Orders o
 WHERE ShipCountry = 'Germany';


 -- 6)
 SELECT o.OrderID, OrderDate, ShipName, ShipAddress
 FROM Orders AS o
 JOIN `Order Details` AS od
 ON o.OrderID = od.OrderID
 WHERE od.ProductID IN (
	SELECT Products.ProductID FROM Products WHERE ProductName LIKE '%sasquatch ale%'
 )