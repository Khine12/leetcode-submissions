-- Write your PostgreSQL query statement below
SELECT a.product_id AS product1_id, b.product_id AS product2_id, pa.category AS product1_category, pb.category AS product2_category, COUNT(DISTINCT a.user_id) AS customer_count
FROM ProductPurchases a
JOIN ProductPurchases b ON a.product_id < b.product_id AND a.user_id = b.user_id
JOIN ProductInfo pa ON a.product_id = pa.product_id
JOIN ProductInfo pb ON b.product_id = pb.product_id
GROUP BY a.product_id, b.product_id, pa.category, pb.category
HAVING COUNT(DISTINCT a.user_id) >= 3
ORDER BY customer_count DESC, product1_id ASC, product2_id ASC;
