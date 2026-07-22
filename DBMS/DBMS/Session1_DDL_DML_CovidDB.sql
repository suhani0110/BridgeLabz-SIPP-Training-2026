CREATE DATABASE IF NOT EXISTS covid_db;
USE covid_db;

-- Create covid_cases table

CREATE TABLE covid_cases (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100),
    state VARCHAR(100),
    report_date DATE,
    report_time TIME,
    confirmed_cases INT,
    deaths INT,
    recoveries INT
);

-- Insert a record

INSERT INTO covid_cases
(country, state, report_date, report_time, confirmed_cases, deaths, recoveries)
VALUES
('India', 'India', '2020-03-15', '10:00:00', 100, 2, 50);

-- Update confirmed cases

UPDATE covid_cases
SET confirmed_cases = 120
WHERE country = 'India'
AND report_date = '2020-03-15';

-- Delete incorrect record

DELETE FROM covid_cases
WHERE state = 'IN';

-- Add vaccination rate column

ALTER TABLE covid_cases
ADD vaccination_rate FLOAT;

-- View data

SELECT * FROM covid_cases;