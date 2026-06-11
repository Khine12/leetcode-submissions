CREATE OR REPLACE FUNCTION NthHighestSalary(N INT) RETURNS TABLE (Salary INT) AS $$
BEGIN
  RETURN QUERY (
    -- Write your PostgreSQL query statement below.
    
      SELECT MAX(ranked.salary)
      FROM(
        SELECT E.salary, DENSE_RANK() OVER (ORDER BY E.salary DESC) as rnk
        FROM Employee E
      )ranked
      WHERE rnk=N
  );
END;
$$ LANGUAGE plpgsql;
