-- 코드를 작성해주세요
# SELECT ID, LENGTH
# FROM FISH_INFO
# ORDER BY LENGTH DESC, ID
# LIMIT 10


SELECT ID, LENGTH
FROM (SELECT ID, LENGTH,ROW_NUMBER() OVER(ORDER BY LENGTH DESC) AS NUMBER FROM FISH_INFO) FISH_INFO
WHERE NUMBER <= 10
ORDER BY LENGTH DESC, ID
