-- Creating tables
CREATE TABLE Authors (
    author_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50)
);
CREATE TABLE Books (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    author_id INT,
    publication_year int,
    price DECIMAL(10, 2),
    FOREIGN KEY (author_id) REFERENCES Authors(author_id)
);

CREATE TABLE Borrowers (
    borrower_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    dob DATE
);
CREATE TABLE Loans (
    loan_id INT PRIMARY KEY AUTO_INCREMENT,
    borrower_id INT,
    book_id INT,
    loan_date DATE,
    return_date DATE,
    FOREIGN KEY (borrower_id) REFERENCES Borrowers(borrower_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id)
);
-- Inserting Values INto the tables.
INSERT INTO Authors (first_name, last_name)
VALUES 
    ('George', 'Orwell'),
    ('Jane', 'Austen'),
    ('Charles', 'Dicken'),
    ('Leo', 'Tolstoy'),
    ('J.K', 'Rowling');
    
    
INSERT INTO Books (title, author_id, publication_year, price) 
VALUES ('Animal Farm', 1, 1949, 20.00), 
    ('Pride and Prejudice', 2, 1813, 15.00), 
    ('A Tale of Two Cities', 3, 1859, 18.00), 
    ('War and Peace', 4, 1869, 25.00), 
    ('Harry Potter', 5, 1997, 30.00);
    
    INSERT INTO Borrowers (first_name, last_name, email, dob)
VALUES ('Adithya', 'K', 'adithya@gmail.com', '2002-02-11'),
    ('Rahul', 'S', 'rahuloo1@gmail.com', '1990-11-30'),
    ('Smitha', 'D', 'smitha@gmail.com', '2000-08-22'),
    ('Micky', 'M', 'micky2002@gmail.com', '2006-02-14'),
    ('Veena', 'C', 'veena245@gmail.com', '1999-09-09');
    
    INSERT INTO Loans (borrower_id, book_id, loan_date, return_date)
VALUES (1, 21, '2024-01-10', '2024-01-20'),
    (2, 23, '2024-02-15', '2024-02-25'),
    (3, 22, '2024-01-12', '2024-01-22'),
    (4, 24, '2024-03-01', '2024-03-11'),
    (5, 25, '2024-03-05', '2024-03-15');


select * from authors;
select * from loans;
SELECT * FROM Borrowers;
SELECT * FROM Books;

-- SQL operations
-- 1) select
select * from books;

select title,price,publication_year 
from Books where price > 20;

select first_name,last_name,email
from Borrowers
where borrower_id IN (select borrower_id
                       from Loans
                        where loan_date > '2024-01-01');
          
          
-- 2) update
    update Books
    set price = 35.00
	where title = 'Harry Potter';
    
-- 3)delete
-- 1st delete the foreign key relation from loan table.
delete from Loans
where book_id = (select book_id from Books where title = 'War and Peace');

-- now delete the book from books
delete from Books
where title = 'War and Peace';


-- 4)ALTER the table

alter table Books
add column genre VARCHAR(50);


-- Aggregate Function
-- 1)
      select count(*)
      from Borrowers;
      
-- 2) 
     select sum(price)
     from Books;
     
-- 3) 
      Select avg(price)
      from Books;
      
      
-- SUB QUERY ----

select title from Books
where book_id IN (
    select book_id
    from Loans
    where borrower_id IN (
                          select borrower_id
                           FROM Borrowers
                            WHERE YEAR(CURDATE()) - YEAR(dob) > 30));
-- CURDATE() will return current date - YEAR() will return the date of birth of borrower. Doing this will get the age.





    


















