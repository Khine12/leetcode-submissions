-- Write your PostgreSQL query statement below
SELECT S.score, DENSE_RANK() OVER (ORDER BY score DESC) AS rank
FROM Scores S
ORDER BY rank;
