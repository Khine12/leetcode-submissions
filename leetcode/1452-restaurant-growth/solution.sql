WITH daily AS (SELECT visited_on, SUM(amount) AS daily_amount
               FROM Customer
               GROUP BY visited_on)
SELECT visited_on, SUM(daily_amount) OVER w AS amount, ROUND(AVG(daily_amount) OVER w,2) AS average_amount
FROM daily
WINDOW w AS (ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW)
ORDER BY visited_on
OFFSET 6;
