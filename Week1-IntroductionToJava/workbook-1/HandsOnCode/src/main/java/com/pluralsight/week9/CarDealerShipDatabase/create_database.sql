DROP DATABASE IF EXISTS CarDealerShipDatabase;

CREATE DATABASE IF NOT EXISTS CarDealerShipDatabase;

USE CarDealerShipDatabase;

CREATE TABLE `Dealerships` (
    `DealershipID` INTEGER NOT NULL AUTO_INCREMENT,
    `DealershipName` VARCHAR(50),
    `DealershipAddress` VARCHAR(50),
    `DealershipPhone` VARCHAR(12),
    CONSTRAINT `PK_Dealerships` PRIMARY KEY (`DealershipID`)
);

CREATE TABLE `Vehicles` (
    `VehicleVIN` VARCHAR(5),
    `Sold` TIMESTAMP,
    `Color` TEXT, -- lets see if this works
    PRIMARY KEY (`VehicleVIN`)
);

CREATE TABLE `Inventory` (
    `DealershipID` INTEGER NOT NULL,
    `VehicleVIN` VARCHAR(5) NOT NULL,
    FOREIGN KEY (DealershipID) REFERENCES Dealerships (DealershipID),
    FOREIGN KEY (VehicleVIN) REFERENCES Vehicles (VehicleVIN)
);

CREATE TABLE `Sales Contracts` (
    `Date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `ContractID` INTEGER NOT NULL AUTO_INCREMENT,
    `VehicleVIN` VARCHAR(5) NOT NULL,
    FOREIGN KEY (VehicleVIN) REFERENCES Vehicles (VehicleVIN),
    PRIMARY KEY (ContractID)
);

CREATE TABLE `Lease Contracts` (
    `Date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `ContractID` INTEGER NOT NULL AUTO_INCREMENT,
    `VehicleVIN` VARCHAR(5) NOT NULL,
    FOREIGN KEY (VehicleVIN) REFERENCES Vehicles (VehicleVIN),
    PRIMARY KEY (ContractID)
)