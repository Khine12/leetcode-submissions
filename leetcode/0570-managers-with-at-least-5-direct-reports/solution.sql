-- Write your PostgreSQL query statement below
SELECT name
FROM Employee
WHERE id IN (SELECT k.managerId
            FROM Employee k
            GROUP BY k.managerId
            HAVING COUNT(*) >= 5);
