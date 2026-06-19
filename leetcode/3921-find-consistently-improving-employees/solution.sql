WITH ranked AS (SELECT employee_id, rating, ROW_NUMBER() OVER (PARTITION BY employee_id ORDER BY review_date DESC) AS rnk, COUNT(*) OVER (PARTITION BY employee_id) AS total_review
FROM performance_reviews),

last_3 AS (SELECT p.employee_id, MAX(CASE WHEN r.rnk=1 THEN r.rating END) AS latest, MAX(CASE WHEN r.rnk=2 THEN r.rating END) AS middle, MAX(CASE WHEN r.rnk= 3 THEN r.rating END) AS earliest 
FROM performance_reviews p
JOIN ranked r ON r.employee_id = p.employee_id
WHERE r.total_review >= 3
GROUP BY p.employee_id)

SELECT e.employee_id AS employee_id, e.name AS name, (l.latest-l.earliest) AS improvement_score
FROM last_3 l
JOIN employees e ON e.employee_id = l.employee_id
WHERE l.earliest < l.middle AND l.middle < l.latest
ORDER BY improvement_score DESC, name ASC;
