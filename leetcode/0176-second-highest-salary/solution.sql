-- Write your PostgreSQL query statement below
SELECT MAX(salary) AS SecondHighestSalary
FROM(
    SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) as rnk
    FROM Employee
)ranked
WHERE rnk = 2;
