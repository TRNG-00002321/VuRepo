-- SELECT
SELECT lastname, firstname, jobtitle FROM employees WHERE jobtitle = 'Sales Rep';

SELECT lastname, firstname, jobtitle, officeCode FROM employees WHERE jobtitle = 'Sales Rep' AND officeCode = 1;

SELECT lastname, firstname, jobTitle, officeCode FROM employees WHERE jobtitle = 'Sale Rep' OR officeCode = 1;

SELECT firstName, lastName, officeCode FROM employees WHERE officeCode BETWEEN 1 AND 3;

-- DISTINCT
SELECT DISTINCT lastname from employees ORDER BY `lastName`;

-- IN operator allows to determine if a value matches any value in a list of values


-- BETWEEN operator is a logical operator that specifies whether a value is in a range or not
SELECT productCode, productName, buyPrice FROM products WHERE `buyPrice` BETWEEN 90 and 100;

-- LIKE operator is a logical operator that tests wheather a string contains a specified pattern or not
SELECT employeeNumber lastName, firstName FROM employees WHERE firstName LIKE 'a%';

SELECT employeeNumber lastName, firstName FROM employees WHERE firstname LIKE 'T_m';

-- LIMIT clause is used to limit the number of rows to return
SELECT select_list FROM table_name LIMIT ADD

-- IS NULL to test whether a value is NULL or not,
SELECT customerName, country, saleemployeenumber FROM customers 

-- Aliases to assign temp names to columns or tables in a query using AS 
SELECT e.firstName, e.lastName FROM employees e ORDER BY e.`firstName`; 

-- JOIN
-- self join (a table joining to itself)
-- inner join
-- outer join

SELECT m.member_id, m.name AS member, c.committee_id, c.name AS committee FROM members m INNER JOIN committees c ON c.name = m.name;

SELECT m.member_id, m.name AS member, c.committee_id, c.name AS committee FROM members m LEFT JOIN committees c USING(name);

SELECT m.member_id, m.name AS member, c.committee_id, c.name AS committee FROM members m RIGHT JOIN committees c ON c.name = m.name;

-- CROSS JOIN 

-- SELF JOIN allows you to join a table to itself 

-- GROUP BY clause, what is aggregate function and scalar function?

SELECT status FROM orders GROUP BY status;

SELECT status, SUM(quantityOrdered * priceEach) As amount FROM orders 
INNER JOIN orderdetails USING (`orderNumber`) GROUP BY status;

SELECT YEAR(orderDate) AS year, SUM(quantityOrdered*priceEach) AS total FROM orders
INNER JOIN orderdetails USING (`orderNumber`) WHERE status = 'Shipped' 
GROUP BY year HAVING year > 2003;

CREATE View emp_view AS
SELECT employeeNumber, firstName, officeCode FROM employees;

SELECT * FROM emp_view WHERE `employeeNumber`>1200;


-- Show all invoices together with the name of the sales agent for each one
SELECT * from orderdetails;


-- Which sales agent made the most sales in 2009?
SELECT * FROM employees;

-- How many customers are assigned to each sales agent?


-- Which track was purchased the most in 2010?


-- Show the top three best selling artists.


-- Which customers have the same initials as at least one other customer?


-- Which countries have the most invoices?


-- Which city has the customer with the highest sales total?


-- Who is the highest spending customer?


-- Return the email and full name of of all customers who listen to Rock.


-- Which artist has written the most Rock songs?


-- Which artist has generated the most revenue?




-- ADVANCED CHALLENGES
-- solve these with a mixture of joins, subqueries, CTE, and set operators.
-- solve at least one of them in two different ways, and see if the execution
-- plan for them is the same, or different.

-- 1. which artists did not make any albums at all?


-- 2. which artists did not record any tracks of the Latin genre?


-- 3. which video track has the longest length? (use media type table)




-- 4. boss employee (the one who reports to nobody)


-- 5. how many audio tracks were bought by German customers, and what was
--    the total price paid for them?



-- 6. list the names and countries of the customers supported by an employee
--    who was hired younger than 35.




-- DML exercises

-- 1. insert two new records into the employee table.

-- 2. insert two new records into the tracks table.

-- 3. update customer Aaron Mitchell's name to Robert Walter

-- 4. delete one of the employees you inserted.

-- 5. delete customer Robert Walter.