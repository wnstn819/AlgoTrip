-- 코드를 작성해주세요

# SELECT i.item_id, i.item_name from item_info I join item_tree T on i.item_id = t.item_id where parent_item_id is null







# ROOT 아이템을 찾아 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME)을 출력하는 SQL문을 작성해 주세요. 이때, 결과는 아이템 ID를 기준으로 오름차순 정렬해 주세요.

WITH ROOT AS(
SELECT ITEM_ID
FROM ITEM_TREE
WHERE PARENT_ITEM_ID IS NULL
)

SELECT ITEM_ID,ITEM_NAME
FROM ITEM_INFO
WHERE ITEM_ID IN(SELECT ITEM_ID FROM ROOT)






