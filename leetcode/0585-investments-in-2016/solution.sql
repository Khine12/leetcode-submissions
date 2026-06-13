-- Write your PostgreSQL query statement below
SELECT ROUND(SUM(tiv_2016)::numeric,2) AS tiv_2016
FROM (SELECT tiv_2016, 
      COUNT(*) OVER (PARTITION BY tiv_2015) AS cnt_2015 , 
      COUNT(*) OVER (PARTITION BY lat,lon) AS cnt_LanLon
      FROM Insurance)
WHERE cnt_2015 > 1 AND cnt_LanLon = 1;
