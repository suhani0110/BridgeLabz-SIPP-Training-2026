
-- Session 4: Sub-queries & Advanced Queries


-- Use Case 16
-- Find Countries with Above-Average Death Counts

SELECT country,
       SUM(death_count) AS total_deaths
FROM covid_deaths
GROUP BY country
HAVING SUM(death_count) >
(
    SELECT AVG(total_deaths)
    FROM
    (
        SELECT SUM(death_count) AS total_deaths
        FROM covid_deaths
        GROUP BY country
    ) AS avg_table
);

-- Use Case 17
-- Identify Countries Exceeding Case Threshold

SELECT DISTINCT country
FROM covid_cases
WHERE country IN
(
    SELECT country
    FROM covid_cases
    GROUP BY country
    HAVING MAX(confirmed_cases) > 1000000
);

-- ==========================================================
-- Use Case 18
-- Track COVID Waves - State-wise Analysis (Mumbai)
-- ==========================================================

SELECT
    c1.report_date,
    c1.state,
    c1.confirmed_cases,
    CASE
        WHEN c1.confirmed_cases =
        (
            SELECT MAX(c2.confirmed_cases)
            FROM covid_cases c2
            WHERE c2.state = c1.state
        )
        THEN 'Peak Wave'
        ELSE 'Normal Day'
    END AS wave_status
FROM covid_cases c1
WHERE c1.state = 'Mumbai'
ORDER BY c1.report_date;

-- ==========================================================
-- Use Case 19
-- Compare Vaccination Coverage using UNION
-- ==========================================================

SELECT
    country,
    'Vaccinated' AS population_type,
    vaccinated_population AS population_count
FROM covid_vaccination

UNION

SELECT
    country,
    'Unvaccinated' AS population_type,
    (total_population - vaccinated_population) AS population_count
FROM covid_vaccination
ORDER BY country;


-- Use Case 20
-- Find Countries Present in Deaths but Not Cases


SELECT DISTINCT country
FROM covid_deaths
WHERE country NOT IN
(
    SELECT DISTINCT country
    FROM covid_cases
);


