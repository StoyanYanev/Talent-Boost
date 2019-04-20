/*3*/
SELECT *
FROM countries;

/*4*/
SELECT (first_name || ' ' || last_name) AS full_name, salary
FROM employees;

/*5*/
SELECT salary, (first_name || ' ' || last_name) AS full_name
FROM employees;

/*6*/
SELECT (first_name || ' ' || last_name) AS full_name
FROM employees
WHERE salary >= 1500;

/*7*/
SELECT *
FROM jobs;

/*8*/
SELECT (first_name || ' ' || last_name) AS full_name
FROM employees
WHERE job_id = 'AD_PRES';

/*or*/

SELECT (first_name || ' ' || last_name) AS full_name
FROM employees
WHERE job_id = (SELECT job_id
				FROM jobs
				WHERE job_id = 'AD_PRES');
				
/*9*/
SELECT *
FROM employees
WHERE hire_date >= '01-jan-1999';

/*10*/
SELECT *
FROM employees
WHERE commission_pct IS NULL;

/*11*/
SELECT last_name, salary
FROM employees
WHERE first_name LIKE 'Peter';

/*12*/
SELECT salary * 12, (first_name || ' ' || last_name) AS full_name
FROM employees
WHERE job_id IN (SELECT job_id 
			   	FROM jobs
				WHERE job_title LIKE 'Programmer');
				
/*13*/
SELECT *
FROM countries
WHERE region_id BETWEEN 1 AND 3;

/*14*/
SELECT job_title
FROM jobs
WHERE min_salary BETWEEN 1000 AND 3000;

/*15*/
SELECT *
FROM employees
WHERE commission_pct IS NULL AND salary BETWEEN 3000 AND 10000 AND department_id = '30';

/*16*/
SELECT *
FROM employees
WHERE first_name LIKE 'S%' OR last_name LIKE 'S%';

/*17*/
SELECT first_name, job_id
FROM employees
WHERE salary >= 5000 AND department_id = '50' AND first_name LIKE 'A%';

/*18*/
SELECT *
FROM employees
WHERE salary >= 2000 AND first_name LIKE '%z%' OR last_name LIKE '%z%';

/*19*/
SELECT (first_name || ' ' || last_name) AS full_name
FROM employees
WHERE job_id IN ('AD_PRES', 'IT_PROG', 'ST_CLERK');

/*20*/
SELECT job_id
FROM employees
WHERE commission_pct IS NOT NULL;

/*21*/
SELECT *
FROM jobs
ORDER BY job_title

/*22*/
SELECT *
FROM jobs
ORDER BY max_salary DESC;

/*23*/
SELECT (first_name || ' ' || last_name) AS full_name, salary
FROM employees
ORDER BY hire_date;

/*24*/
SELECT country_name
FROM countries
WHERE country_name LIKE '%u%'
ORDER BY country_name DESC;

/*25*/
SELECT (first_name || ' ' || last_name) AS full_name
FROM employees
WHERE commission_pct IS NULL AND salary BETWEEN 2500 AND 9000 AND job_id IN ('ST_MAN', 'IT_PROG');

/*26*/
SELECT (first_name || ' ' || last_name) AS full_name, salary
FROM employees
WHERE first_name = 'David'
ORDER BY last_name, salary;

/*27*/
SELECT *
FROM employees
WHERE employee_id BETWEEN 100 AND 130 AND manager_id BETWEEN 100 AND 120 AND hire_date >= '01/01/1999'
ORDER BY salary;