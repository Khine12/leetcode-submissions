WITH seasonal AS (SELECT CASE WHEN EXTRACT(MONTH FROM sale_date) IN (12,1,2) THEN 'Winter' WHEN EXTRACT(MONTH FROM sale_date) IN (3,4,5) THEN 'Spring' WHEN EXTRACT(MONTH FROM sale_date) IN (6,7,8) THEN 'Summer' ELSE 'Fall' END AS season, p.category, s.quantity, s.price
FROM sales s
JOIN products p ON s.product_id = p.product_id),

khine AS (SELECT season, category, SUM(quantity) AS total_quantity, SUM(quantity*price) AS total_revenue
FROM seasonal
GROUP BY season, category),

ranking AS (SELECT *, RANK() OVER (PARTITION BY season ORDER BY total_quantity DESC, total_revenue DESC, category ASC) AS rnk FROM khine)

SELECT season, category, total_quantity, total_revenue
FROM ranking
WHERE rnk = 1
ORDER BY season ASC;
