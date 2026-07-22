USE covid_db;

-- Create indexes

CREATE INDEX idx_country_date
ON covid_cases (Country, Date);

CREATE INDEX idx_date
ON covid_cases (Date);

-- Covering index for infection rate queries

CREATE INDEX idx_infection_rate
ON covid_cases (infection_rate);

-- View top 10 countries by infection rate

SELECT Country, infection_rate
FROM covid_cases
ORDER BY infection_rate DESC
LIMIT 10;

-- Analyze query execution plan

EXPLAIN
SELECT c.Country,
       c.Confirmed_Cases,
       co.Continent
FROM covid_cases c
JOIN countries co
ON c.Country = co.Country
WHERE c.Date = '2024-01-01';

-- Create vaccine table

CREATE TABLE vaccine_distribution (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Country VARCHAR(100),
    Distribution_Date DATE,
    Doses_Administered INT
);

-- Transaction example

START TRANSACTION;

INSERT INTO vaccine_distribution
(Country, Distribution_Date, Doses_Administered)
VALUES
('India','2024-01-01',100000);

INSERT INTO vaccine_distribution
(Country, Distribution_Date, Doses_Administered)
VALUES
('USA','2024-01-01',80000);

COMMIT;

-- Rollback example

START TRANSACTION;

INSERT INTO vaccine_distribution
(Country, Distribution_Date, Doses_Administered)
VALUES
('Brazil','2024-01-02',60000);

ROLLBACK;

-- Isolation level examples

SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
START TRANSACTION;
SELECT * FROM covid_cases;
COMMIT;

SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
START TRANSACTION;
SELECT * FROM covid_cases;
COMMIT;

SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;
START TRANSACTION;
SELECT * FROM covid_cases;
COMMIT;

SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;
START TRANSACTION;
SELECT * FROM covid_cases;
COMMIT;