-- Write your PostgreSQL query statement below
SELECT Department, Employee, Salary
FROM(
    SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary,RANK() OVER (PARTITION BY e.departmentId ORDER BY e.salary DESC) AS rnk
    FROM Employee e
    JOIN Department d on d.id = e.departmentId
)t
WHERE rnk = 1;
