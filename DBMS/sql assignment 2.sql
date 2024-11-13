       -- table creation
CREATE TABLE Customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(15),
    address VARCHAR(255)
);

CREATE TABLE Rooms (
    room_id INT PRIMARY KEY AUTO_INCREMENT,
    room_type VARCHAR(20) CHECK (room_type IN ('single', 'double', 'suite')),
    price_per_night DECIMAL(10, 2),
    status VARCHAR(20) CHECK (status IN ('available', 'occupied', 'under maintenance')),
    floor_number INT
);


CREATE TABLE Reservations (
    reservation_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    room_id INT,
    reservation_date DATE,
    check_in_date DATE,
    check_out_date DATE,
    status VARCHAR(20) CHECK (status IN ('confirmed', 'cancelled', 'completed')),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (room_id) REFERENCES Rooms(room_id)
);


CREATE TABLE Payments (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    reservation_id INT,
    payment_date DATE,
    amount_paid DECIMAL(10, 2),
    payment_method VARCHAR(20) CHECK (payment_method IN ('credit card', 'cash')),
    FOREIGN KEY (reservation_id) REFERENCES Reservations(reservation_id) 
);


CREATE TABLE Staff (
    staff_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    role VARCHAR(20) CHECK (role IN ('receptionist', 'manager', 'housekeeper')),
    hire_date DATE
);

CREATE TABLE RoomAssignments (
    assignment_id INT PRIMARY KEY AUTO_INCREMENT,
    staff_id INT,
    room_id INT,
    assignment_date DATE,
    task_description VARCHAR(255),
    FOREIGN KEY (staff_id) REFERENCES Staff(staff_id),
    FOREIGN KEY (room_id) REFERENCES Rooms(room_id)
);

                -- INSERTION -------------

INSERT INTO Customers (first_name, last_name, email, phone_number, address)
VALUES
('Adithya', 'K', 'adithya@gmail.com', '9934567890', 'Abc house'),
('Varun', 'S', 'varun@gmail.com', '8987654321', 'Oak Ave'),
('Amit', 'B', 'amit@gmail.com', '7122334455', 'Pine Blvd'),
('Alice', 'C', 'alice@gmail.com', '8677889900', 'Maple St'),
('Micky', 'J', 'micky@gmail.com', '9344556677', 'Birch Rd');

INSERT INTO Rooms (room_type, price_per_night, status, floor_number)
VALUES
('single', 80.00, 'available', 1),
('double', 120.00, 'occupied', 2),
('suite', 200.00, 'available', 3),
('double', 150.00, 'under maintenance', 1),
('suite', 220.00, 'available', 2);

INSERT INTO Reservations (customer_id, room_id, reservation_date, check_in_date, check_out_date, status)
VALUES
(1, 1, '2024-11-10', '2024-11-15', '2024-11-18', 'confirmed'),
(2, 2, '2024-11-12', '2024-11-20', '2024-11-23', 'completed'),
(3, 3, '2024-11-14', '2024-11-25', '2024-11-30', 'confirmed'),
(4, 4, '2024-11-16', '2024-12-01', '2024-12-05', 'cancelled'),
(5, 5, '2024-11-18', '2024-12-10', '2024-12-15', 'confirmed');

INSERT INTO Payments (reservation_id, payment_date, amount_paid, payment_method)
VALUES
(1, '2024-11-10', 240.00, 'credit card'),
(2, '2024-11-12', 360.00, 'cash'),
(3, '2024-11-14', 500.00, 'credit card'),
(4, '2024-11-16', 300.00, 'cash'),
(5, '2024-11-18', 600.00, 'credit card');

INSERT INTO Staff (first_name, last_name, role, hire_date)
VALUES
('Arun', 'das', 'receptionist', '2023-02-10'),
('leo', 'Wilson', 'manager', '2022-06-15'),
('Sophia', 'M', 'housekeeper', '2023-03-05'),
('James', 'A', 'housekeeper', '2023-08-20'),
('Linda', 'Thomas', 'manager', '2021-11-22');

INSERT INTO RoomAssignments (staff_id, room_id, assignment_date, task_description)
VALUES
(3, 1, '2024-11-19', 'Cleaning'),
(4, 2, '2024-11-20', 'Maintenance'),
(5, 3, '2024-11-21', 'Cleaning'),
(3, 4, '2024-11-22', 'Maintenance'),
(4, 5, '2024-11-23', 'Cleaning');

----- SQL Operations -----
-- 1 Retrieve available rooms on the first floor
SELECT *
FROM Rooms
WHERE status = 'available' AND floor_number = 1;

-- 2 Get customer details for all reservations sorted by check-in date
SELECT r.reservation_id, r.check_in_date, r.check_out_date, r.status,c.first_name, c.last_name, c.email
FROM Reservations AS r JOIN Customers AS c 
ON r.customer_id = c.customer_id
ORDER BY r.check_in_date;

-- 3 Find customers with reservations lasting 5 or more nights
SELECT C.customer_id, C.first_name, C.last_name, C.email,R.check_in_date, R.check_out_date,
DATEDIFF(R.check_out_date, R.check_in_date) AS nights_stayed
FROM Reservations R JOIN Customers C 
ON R.customer_id = C.customer_id
WHERE DATEDIFF(R.check_out_date, R.check_in_date) >= 5;

-- 4 Total amount paid per reservation
SELECT reservation_id, SUM(amount_paid) AS total_amount_paid
FROM Payments
GROUP BY reservation_id;

-- 5 Average price per room type
SELECT room_type, AVG(price_per_night) AS average_price
FROM Rooms
GROUP BY room_type;

-- 6 Total revenue in the last 30 days
SELECT SUM(amount_paid) AS total_revenue_last_month
FROM Payments
WHERE payment_date >= CURDATE() - 30;

-- 7 Count of room assignments per staff in the last 30 days
SELECT s.staff_id, s.first_name, s.last_name, COUNT(ra.assignment_id) AS room_assignments
FROM Staff s JOIN roomassignments ra 
ON s.staff_id = ra.staff_id
WHERE ra.assignment_date >= CURDATE() - 30
GROUP BY s.staff_id
ORDER BY room_assignments DESC;

-- 8 Most recent reservation per customer
SELECT r.customer_id, MAX(r.reservation_id) , MAX(r.check_in_date) AS check_in_date, 
MAX(r.check_out_date) AS check_out_date, MAX(r.status) AS status, c.first_name, c.last_name, c.email
FROM Reservations AS r JOIN Customers AS c 
ON r.customer_id = c.customer_id	
GROUP BY r.customer_id
ORDER BY MAX(r.check_in_date) DESC;

-- 9 Delete a reservation and its associated payments

-- 1st delete payment records related to the reservation
DELETE FROM Payments WHERE reservation_id = 10;
-- now Delete the reservation 
DELETE FROM Reservations WHERE reservation_id = 10;


-- 10 Room availability check for a specific date range
SELECT r.room_id, r.room_type, r.price_per_night, r.status, r.floor_number
FROM Rooms AS r LEFT JOIN Reservations AS res 
ON r.room_id = res.room_id 
    AND res.check_in_date < '2024-12-01'
    AND res.check_out_date > '2024-11-20'
WHERE res.reservation_id IS NULL
  AND r.status = 'available';




















