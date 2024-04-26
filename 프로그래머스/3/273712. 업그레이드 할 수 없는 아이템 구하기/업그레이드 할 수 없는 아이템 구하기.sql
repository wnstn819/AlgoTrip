-- 코드를 작성해주세요
-- 더 이상 업그레이드할 수 없는 아이템의 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME), 아이템의 희귀도(RARITY)를 출력하는 SQL 문을 작성해 주세요. 이때 결과는 아이템 ID를 기준으로 내림차순 정렬해 주세요.

-- 1. 업그레이드 할 수 없는 아이템
-- 2. 내림차순 정렬

WITH NONE AS(
    SELECT I.ITEM_ID
    FROM ITEM_TREE T
    RIGHT JOIN ITEM_INFO I
    ON I.ITEM_ID = T.PARENT_ITEM_ID
    WHERE T.PARENT_ITEM_ID IS NOT NULL
)

SELECT ITEM_ID,ITEM_NAME, RARITY
FROM ITEM_INFO
WHERE ITEM_ID NOT IN (SELECT ITEM_ID FROM NONE)
ORDER BY ITEM_ID DESC
