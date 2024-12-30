-- 코드를 입력하세요
# 보호소에서 중성화 수술을 거친 동물 정보를 알아보려 합니다. 보호소에 들어올 당시에는 중성화1되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회하는 SQL 문을 작성해주세요.

WITH Dog AS (
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE SEX_UPON_INTAKE LIKE 'Intact%'
INTERSECT
SELECT ANIMAL_ID
FROM ANIMAL_OUTS
WHERE SEX_UPON_OUTCOME NOT LIKE 'Intact%'
)

SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
FROM ANIMAL_OUTS A
JOIN Dog B
USING(ANIMAL_ID)
ORDER BY ANIMAL_ID
