WITH A AS (
    SELECT FISH_TYPE
    FROM FISH_INFO
    GROUP BY FISH_TYPE
    HAVING AVG(IFNULL(LENGTH,10)) >= 33
)

SELECT COUNT(*) AS FISH_COUNT, MAX(LENGTH) AS MAX_LENGTH, FISH_TYPE
FROM FISH_INFO
WHERE FISH_TYPE IN (SELECT FISH_TYPE FROM A)
GROUP BY FISH_TYPE
ORDER BY FISH_TYPE;