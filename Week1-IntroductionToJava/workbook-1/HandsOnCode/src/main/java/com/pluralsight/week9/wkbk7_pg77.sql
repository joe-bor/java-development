-- 1)
SELECT ProductName
FROM Products
WHERE UnitPrice = (SELECT MAX(UnitPrice) FROM Products);

/*
WITH cte AS (
	SELECT
		MAX(UnitPrice) AS most_expensive_item
	FROM Products )

SELECT
	ProductName
FROM Products
WHERE UnitPrice = (SELECT most_expensive_item
                    FROM cte);
*/

-- 2)
SELECT OrderID, ShipName, ShipAddress
FROM Orders
WHERE ShipVia
IN (SELECT ShipperID FROM Shippers WHERE CompanyName LIKE '%federal shipping%');

-- 3)
SELECT OrderID
FROM `Order Details`
WHERE ProductID
IN (SELECT ProductID
	FROM Products
	WHERE ProductName
    LIKE '%sasquatch ale%');

-- 4)
SELECT FirstName, Lastname
FROM Employees
WHERE EmployeeID IN (
	SELECT EmployeeID
    FROM Orders
    WHERE OrderID = 10266
);

-- 5)
SELECT Contactname
FROM Customers
WHERE CustomerID
IN (
	SELECT CustomerID
    FROM Orders
    WHERE OrderID = 10266
);