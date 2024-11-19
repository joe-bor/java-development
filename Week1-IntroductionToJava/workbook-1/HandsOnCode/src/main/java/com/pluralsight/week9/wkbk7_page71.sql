-- 1) How many suppliers are there?
SELECT COUNT(*) FROM northwind.Suppliers;

-- 2) What is the sun of all the nmeployees salaries?
SELECT SUM(Salary) FROM Employees;

-- 3) What is the price of the cheapest item that nortwin sells
SELECT MIN(UnitPrice) FROM Products;

-- 4) What is the avg price of items that northwin sells
SELECT AVG(Unitprice) FROM Products;

-- 5) What is the price of the msot expensice item that northwin sells
SELECT MAX(UnitPrice) FROM Products;

-- 6) What is the supplioerID of each supplier and the number of items they supply?? use producs table
SELECT SupplierID, COUNT(*) AS '# of Item'
FROM Products
group by SupplierID;

-- 7) What is the caregoryu id of eac category and avg price of each item in the category? use products
SELECT CategoryID, AVG(UnitPrice) AS 'AvgPrice'
FROM Products
group by CategoryID;

-- 8)
SELECT SupplierID, COUNT(*) AS Num
FROM Products
GROUP BY SupplierID
HAVING Num >= 5;

-- 9)
SELECT productId, productname, (UnitPrice * UnitsInStock) AS Inventory_Value
FROM Products
ORDER BY Inventory_Value DESC, ProductName;