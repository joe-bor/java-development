-- 1
SELECT * FROM Dealerships;

-- 2
SELECT v.VehicleVIN, DealershipName
FROM Dealerships d
JOIN Inventory i
ON d.DealershipID = i.DealershipID
JOIN Vehicles v
ON i.VehicleVIN = v.vehicleVIN
WHERE d.DealershipID = 1;

 -- 3
SELECT *
FROM Vehicles
WHERE VehicleVIN = 1;

-- 4
SELECT DealershipName, DealershipAddress
FROM Dealerships d
JOIN Inventory i
ON d.DealershipID = i.DealershipID
JOIN Vehicles v
ON i.VehicleVIN = v.VehicleVIN
WHERE v.VehicleVIN = 'xyz35';

-- 5
SELECT *
FROM Dealerships d
JOIN Inventory i
ON d.DealershipID = i.DealershipID
JOIN Vehicles v
ON i.VehicleVIN = v.VehicleVIN
WHERE v.Color = 'red';

-- 6
SELECT *
FROM `Sales Contracts` AS s
JOIN Inventory as i
ON s.VehicleVIN = i.VehicleVIN
JOIN Dealerships as d
ON i.DealershipID = d.DealershipID
WHERE d.DealershipID = 1
AND s.`Date`
BETWEEN '2024-10-10' AND '2024-12-10';