-- 코드를 입력하세요
SELECT PRODUCT_CODE,SUM(SALES_AMOUNT*PRICE) as SALES from product p , offline_sale o where p.product_id = o.product_id group by product_code order by SALES desc, PRODUCT_Code