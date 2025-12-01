DELIMITER $$
CREATE PROCEDURE GetCustomers()
BEGIN
        SELECT 
                `FirstName`,
                `City`,
                `State`,
                `PostalCode`,
                `Country`
        FROM
                `Customer`
        ORDER BY `FirstName`;
END$$
DELIMITER ;

CALL `GetCustomers`


-- IN parameter in store procedure
DELIMITER //
CREATE PROCEDURE GetCustomerByCountry(
    IN countryName VARCHAR(255)
)
BEGIN
        SELECT * 
        FROM `Customer`
        WHERE `Country` = countryName;
END //
DELIMITER ;

CALL `GetCustomerByCountry`('USA')


-- INOUT Parameter in store Prodecure
DELIMITER //
CREATE PROCEDURE GetCustomerCountByCountry(
    IN countryName VARCHAR(255),
    OUT total INT
)
BEGIN 
        SELECT COUNT(CustomerId)
        INTO total
        FROM `Customer`
        WHERE Country = countryName;
END//

DELIMITER ;

CALL `GetCustomerCountByCountry`('USA',@total);
SELECT @total;


-- OUT parameter in store procedure
DELIMITER //
Create PROCEDURE GetCountryCount(
    OUT total INT
)
BEGIN
        SELECT COUNT(DISTINCT `Country`)
        INTO total
        FROM `Customer`;
END//
DELIMITER ;

CALL `GetCountryCount`(@total);
SELECT @total;


-- Create function in MySQL
DELIMITER //
CREATE FUNCTION Seniority(
        birthYear INT
)
RETURNS VARCHAR(30)
DETERMINISTIC
BEGIN
        DECLARE seniority VARCHAR(20);

        IF birthYear < 1970 THEN 
            SET seniority = 'old';
        ELSEIF birthYear < 1980 THEN
            SET seniority = 'pretty old';
        ELSEIF birthYear < 2000 THEN
            SET seniority = 'pretty young';
        ELSE
            SET seniority = 'young';
        END IF;

        RETURN seniority;
END//
DELIMITER ;

SELECT 
        FirstName, Seniority(YEAR(BirthDate)) AS Seniority
        FROM `Employee`
        ORDER BY `FirstName`;


-- Create Trigger in MySQL
CREATE TABLE employees_audit(
        id INT AUTO_INCREMENT PRIMARY KEY,
        employeeNumber INT NOT NULL,
        lastName VARCHAR(50) NOT NULL,
        changedat DATETIME DEFAULT NULL,
        action VARCHAR(50) DEFAULT NULL
);
        
CREATE TRIGGER before_employee_update
        BEFORE UPDATE ON `Employee`
        FOR EACH ROW 
INSERT INTO employees_audit
SET action = 'update',
        employeeNumber = OLD.employeeID,
        lastName = OLD.LastName,
        changedat = NOW();

UPDATE `Employee`
        SET `LastName`= 'Phan'
        WHERE `EmployeeId`= 6;

SELECT * FROM employees_audit
