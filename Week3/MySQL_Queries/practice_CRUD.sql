use practice_CRUD;

CREATE Table employees(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    salary DECIMAL(10,2),
    department VARCHAR(50)
);

INSERT INTO employees (name, salary, department) VALUES ('Vu', 60000, 'IT'), ('Alex', 65000, 'Engineering');

SELECT * FROM employees;

SELECT * FROM employees WHERE salary <62000;

SELECT * FROM employees ORDER BY salary DESC;

UPDATE employees SET salary = 80000 WHERE name = "Vu";

DELETE FROM employees WHERE id = 2;

-- TRUNCADE TABLE employees;

-- DROP TABLE employees;