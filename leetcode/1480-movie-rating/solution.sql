-- Write your PostgreSQL query statement below
(SELECT u.name AS results
FROM Users u
JOIN MovieRating m ON m.user_id = u.user_id
GROUP BY u.name
ORDER BY COUNT(*) DESC, u.name ASC
LIMIT 1)

UNION ALL 

(SELECT mm.title AS results
FROM Movies mm
JOIN MovieRating m ON m.movie_id = mm.movie_id
WHERE m.created_at >= '2020-02-01' AND m.created_at <= '2020-02-29'
GROUP BY mm.title
ORDER BY AVG(m.rating) DESC, mm.title ASC
LIMIT 1)
