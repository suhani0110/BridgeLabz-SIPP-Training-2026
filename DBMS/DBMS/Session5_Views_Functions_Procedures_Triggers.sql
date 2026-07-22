USE covid_db;

-- Create view for latest COVID data

CREATE VIEW LatestCovidData AS
SELECT Country, Date, Confirmed_Cases, Deaths, Recoveries
FROM covid_cases
WHERE Date = (SELECT MAX(Date) FROM covid_cases);

-- Function to calculate mortality rate

DELIMITER $$

CREATE FUNCTION CalculateMortalityRate(
    p_country VARCHAR(100),
    p_date DATE
)
RETURNS DECIMAL(5,2)
DETERMINISTIC
BEGIN
    DECLARE rate DECIMAL(5,2);

    SELECT (Deaths * 100.0 / Confirmed_Cases)
    INTO rate
    FROM covid_cases
    WHERE Country = p_country
    AND Date = p_date;

    RETURN rate;
END$$

DELIMITER ;

-- Stored procedure to update COVID statistics

DELIMITER $$

CREATE PROCEDURE UpdateCovidStats(
    IN p_country VARCHAR(100),
    IN p_date DATE,
    IN p_confirmed INT,
    IN p_deaths INT,
    IN p_recoveries INT
)
BEGIN
    UPDATE covid_cases
    SET Confirmed_Cases = p_confirmed,
        Deaths = p_deaths,
        Recoveries = p_recoveries
    WHERE Country = p_country
    AND Date = p_date;
END$$

DELIMITER ;

-- Function to calculate recovery rate

DELIMITER $$

CREATE FUNCTION CalculateRecoveryRate(
    p_country VARCHAR(100)
)
RETURNS DECIMAL(5,2)
DETERMINISTIC
BEGIN
    DECLARE rate DECIMAL(5,2);

    SELECT (Recoveries * 100.0 / Confirmed_Cases)
    INTO rate
    FROM covid_cases
    WHERE Country = p_country
    ORDER BY Date DESC
    LIMIT 1;

    RETURN rate;
END$$

DELIMITER ;

-- Create audit table

CREATE TABLE covid_audit (
    Audit_ID INT AUTO_INCREMENT PRIMARY KEY,
    Country VARCHAR(100),
    Report_Date DATE,
    Old_Confirmed INT,
    New_Confirmed INT,
    Old_Deaths INT,
    New_Deaths INT,
    Old_Recoveries INT,
    New_Recoveries INT,
    Updated_At TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Trigger to log updates

DELIMITER $$

CREATE TRIGGER CovidAuditTrigger
BEFORE UPDATE
ON covid_cases
FOR EACH ROW
BEGIN
    INSERT INTO covid_audit(
        Country,
        Report_Date,
        Old_Confirmed,
        New_Confirmed,
        Old_Deaths,
        New_Deaths,
        Old_Recoveries,
        New_Recoveries
    )
    VALUES(
        OLD.Country,
        OLD.Date,
        OLD.Confirmed_Cases,
        NEW.Confirmed_Cases,
        OLD.Deaths,
        NEW.Deaths,
        OLD.Recoveries,
        NEW.Recoveries
    );
END$$

DELIMITER ;

-- View latest data

SELECT * FROM LatestCovidData;

-- Test mortality rate

SELECT CalculateMortalityRate('India','2024-01-01');

-- Test recovery rate

SELECT CalculateRecoveryRate('India');

-- Test stored procedure

CALL UpdateCovidStats('India','2024-01-01',15000,180,14500);

-- View audit records

SELECT * FROM covid_audit;