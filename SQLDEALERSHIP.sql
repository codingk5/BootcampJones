CREATE TABLE dealerships (
DealershipID INT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(50),
Address VARCHAR(50),
Phone VARCHAR(12)
);

INSERT INTO dealerships(Name, Address, Phone)
VALUES ('Local Mobiles', '778 Circle Lane', '4045557959');

INSERT INTO dealerships(Name, Address, Phone)
VALUES ('Luxury Only', '1540 Creek Blvd', '4705559841');

INSERT INTO dealerships(Name, Address, Phone)
VALUES ('Favs Auto Retail', '117 Second Ave', '7705554593');

CREATE TABLE vehicles (
VIN VARCHAR(5) PRIMARY KEY,
Make VARCHAR(15),
Model VARCHAR(15),
Year INT,
Price DECIMAL(7,  2),
Sold BOOLEAN
);


-- Create the vehicles table
CREATE TABLE vehicles (
    VIN VARCHAR(5) PRIMARY KEY,
    Make VARCHAR(15),
    Model VARCHAR(15),
    Year INT,
    Price DECIMAL(7, 2),
    Sold BOOLEAN
);

-- REGULAR MOBILES HAVE M IN VIN
INSERT INTO vehicles (VIN, Make, Model, Year, Price, Sold)
 VALUES
('M1234', 'Toyota', 'Camry', 2021, 15450.00, FALSE),
('M5678', 'Nissan', 'Altima', 2020, 12000.00, TRUE),
('M9012', 'Honda', 'Civic', 2022, 22000.00, FALSE),
('M3456', 'Chevy', 'Malibu', 2019, 16500.00, TRUE),
('M7890', 'Toyota', 'Corolla', 2023, 10999.99, FALSE),
('M2345', 'Nissan', 'Rogue', 2021, 17999.50, TRUE),
('M6789', 'Honda', 'Accord', 2020, 14000.00, FALSE),
('M0123', 'Chevy', 'Impala', 2018, 17500.75, TRUE),
('M4567', 'Toyota', 'RAV4', 2022, 19000.00, FALSE),
('M8901', 'Nissan', 'Sentra', 2023, 13500.00, FALSE);


-- LUURY VEHICLES HAVE L IN VIN
INSERT INTO vehicles (VIN, Make, Model, Year, Price, Sold)
 VALUES
('L1234', 'BMW', 'X5', 2022, 18000.00, TRUE),
('L5678', 'Cadillac', 'Escalade', 2023, 25000.00, FALSE),
('L9012', 'Lincoln', 'Navigator', 2021, 23500.00, TRUE),
('L3456', 'BMW', '3 Series', 2020, 17500.00, FALSE),
('L7890', 'Cadillac', 'XT5', 2022, 21000.00, TRUE),
('L2345', 'Lincoln', 'Aviator', 2023, 24000.00, FALSE),
('L6789', 'BMW', '7 Series', 2021, 17900.00, TRUE),
('L0123', 'Cadillac', 'CT5', 2020, 22000.00, FALSE),
('L4567', 'Lincoln', 'Corsair', 2022, 19500.00, TRUE),
('L8901', 'BMW', 'X3', 2023, 24500.00, FALSE);


-- FAVORITES HAVE F IN VIN
INSERT INTO vehicles (VIN, Make, Model, Year, Price, Sold) 
VALUES
('F1234', 'Chevy', 'Camaro', 2021, 22000.00, TRUE),
('F5678', 'Dodge', 'Charger', 2022, 19000.00, FALSE),
('F9012', 'Dodge', 'Challenger', 2023, 20000.00, TRUE),
('F3456', 'Jeep', 'Trackhawk', 2020, 21000.00, FALSE),
('F7890', 'Ford', 'Mustang', 2021, 17000.00, TRUE),
('F2345', 'Nissan', '370Z', 2020, 25000.00, FALSE),
('F6789', 'Chevy', 'Camaro SS', 2022, 20000.00, TRUE),
('F0123', 'Dodge', 'Charger SRT', 2023, 24500.00, FALSE),
('F4567', 'Ford', 'Mustang GT', 2022, 18500.00, TRUE),
('F8901', 'Nissan', '370Z NISMO', 2021, 27000.00, FALSE);

CREATE TABLE inventory (
DealershipID INT,
    VIN VARCHAR(5),
    PRIMARY KEY (DealershipID, VIN),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);


INSERT INTO inventory (DealershipID, VIN)
SELECT 1, VIN FROM vehicles
WHERE VIN LIKE '%M%';


INSERT INTO inventory (DealershipID, VIN)
SELECT 2, VIN FROM vehicles
WHERE VIN LIKE '%L%';


INSERT INTO inventory (DealershipID, VIN)
SELECT 3, VIN FROM vehicles
WHERE VIN LIKE '%F%';

CREATE TABLE sales_contract(
saleID INT AUTO_INCREMENT PRIMARY KEY,
VIN VARCHAR(5),
DealershipID INT,
sale_date DATE,
sale_price DECIMAL (7, 2),
customer_name VARCHAR(50),
FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);


INSERT INTO sales_contract (VIN, DealershipID, sale_date, sale_price, customer_name) 
VALUES
('M5678', 1, '2025-04-10', 12000.00, 'John Doe'),
('M3456', 1, '2025-03-15', 16500.00, 'Jane Smith'),
('M2345', 1, '2025-05-01', 17999.50, 'Alice Johnson'),
('M0123', 1, '2025-02-20', 17500.75, 'Bob Brown');


INSERT INTO sales_contract (VIN, DealershipID, sale_date, sale_price, customer_name) 
VALUES
('L1234', 2, '2025-04-05', 18000.00, 'Emma Davis'),
('L9012', 2, '2025-03-18', 23500.00, 'Michael Lee'),
('L7890', 2, '2025-05-12', 21000.00, 'Sophia Nguyen'),
('L6789', 2, '2025-04-22', 17900.00, 'James Wilson'),
('L4567', 2, '2025-06-01', 19500.00, 'Olivia Martinez');


INSERT INTO sales_contract (VIN, DealershipID, sale_date, sale_price, customer_name) 
VALUES
('F1234', 3, '2025-04-08', 22000.00, 'Daniel Reed'),
('F9012', 3, '2025-05-20', 20000.00, 'Ava Thompson'),
('F7890', 3, '2025-06-01', 17000.00, 'Liam Carter'),
('F6789', 3, '2025-05-10', 20000.00, 'Mia Walker'),
('F4567', 3, '2025-06-05', 18500.00, 'Noah Ramirez');



-- 1
SELECT distinct Name
FROM dealerships;

-- 2 
SELECT v.*
FROM vehicles v
JOIN inventory i ON v.VIN = i.VIN
WHERE i.DealershipID = 1;

-- 3 
SELECT * 
FROM vehicles
WHERE VIN = 'F4567';

-- 4
SELECT d.Name, d.Address, v.Make, v.Model, v.Year
FROM inventory i
JOIN vehicles v ON i.VIN = v.VIN
JOIN dealerships d ON i.DealershipID = d.DealershipID
WHERE i.VIN = 'L3456';


-- 5
SELECT DISTINCT d.DealershipID, d.Name, d.Address
FROM inventory i
JOIN vehicles v ON i.VIN = v.VIN
JOIN dealerships d ON i.DealershipID = d.DealershipID
WHERE v.Make = 'Dodge';


-- 6
SELECT *
FROM sales_contract
WHERE DealershipID = 1
  AND sale_date BETWEEN '2025-01-01' AND '2025-12-31';











 




 




