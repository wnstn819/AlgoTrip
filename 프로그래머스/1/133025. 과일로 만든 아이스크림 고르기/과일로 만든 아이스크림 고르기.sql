-- 코드를 입력하세요
SELECT F.FLAVOR from FIRST_HALF F JOIN ICECREAM_INFO I ON F.FLAVOR = I.FLAVOR where F.TOTAL_ORDER > 3000 AND I.INGREDIENT_TYPE = "fruit_based" order by TOTAL_ORDER DESC