-- Write your PostgreSQL query statement below
SELECT ROUND(COUNT(a.player_id)::numeric/COUNT(*),2) AS fraction
FROM (SELECT player_id, MIN(event_date) AS first_date
      FROM Activity
      GROUP BY player_id
)f
LEFT JOIN Activity a ON a.player_id = f.player_id AND a.event_date = f.first_date + INTERVAL '1 day';
