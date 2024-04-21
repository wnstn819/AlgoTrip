-- 코드를 입력하세요
-- SELECT * from first_HALF

SELECT INGREDIENT_TYPE, SUM(TOTAL_ORDER) as TOTAL_ORDER from FiRST_HALF as F join ICECREAM_INFO as I ON F.flavor = I.flavor group by INGREDIENT_TYPE order by total_order asc