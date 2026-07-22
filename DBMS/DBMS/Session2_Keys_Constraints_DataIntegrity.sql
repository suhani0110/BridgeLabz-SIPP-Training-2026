CREATE DATABASE IF NOT EXISTS covid_db;
USE covid_db;

-- Create countries table

CREATE TABLE countries (
    Country VARCHAR(100) PRIMARY KEY,
    Continent VARCHAR(50),
    Population BIGINT
);

-- Create covid_cases table

CREATE TABLE covid_cases (
    Country VARCHAR(100) NOT NULL,
    Date DATE NOT NULL,
    Confirmed_Cases INT NOT NULL,
    Deaths INT,
    Recoveries INT DEFAULT 0,
    Last_Updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (Country, Date),

    FOREIGN KEY (Country)
    REFERENCES countries(Country),

    CHECK (Deaths <= Confirmed_Cases),

    UNIQUE (Country, Date)
);

-- Insert sample countries

INSERT INTO countries VALUES
('India','Asia',1400000000),
('USA','North America',331000000),
('Brazil','South America',213000000),
('Germany','Europe',83000000);

-- Insert sample covid records

INSERT INTO covid_cases (Country, Date, Confirmed_Cases, Deaths)
VALUES
('India','2024-01-01',12000,150),
('USA','2024-01-01',10000,120),
('Brazil','2024-01-01',9000,90),
('Germany','2024-01-01',5000,40);

-- View data

SELECT * FROM countries;

SELECT * FROM covid_cases;

-- Test duplicate record
-- INSERT INTO covid_cases VALUES ('India','2024-01-01',15000,200,1000,DEFAULT);

-- Test invalid country
-- INSERT INTO covid_cases (Country, Date, Confirmed_Cases, Deaths)
-- VALUES ('Japan','2024-01-01',3000,20);

-- Test invalid deaths
-- INSERT INTO covid_cases (Country, Date, Confirmed_Cases, Deaths)
-- VALUES ('India','2024-01-02',100,150);

-- Test NULL country
-- INSERT INTO covid_cases (Country, Date, Confirmed_Cases, Deaths)
-- VALUES (NULL,'2024-01-03',1000,10);