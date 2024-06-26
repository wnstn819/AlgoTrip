WITH RECURSIVE Ancestors AS (
    -- 1세대를 선택합니다 (최초의 조상)
    SELECT 
        ID, 
        PARENT_ID, 
        1 AS generation
    FROM 
        ECOLI_DATA
    WHERE 
        PARENT_ID IS NULL
    
    UNION ALL
    
    -- 재귀적으로 조상을 찾습니다
    SELECT 
        E.ID, 
        E.PARENT_ID, 
        A.generation + 1
    FROM 
        ECOLI_DATA E
    JOIN 
        Ancestors A ON E.PARENT_ID = A.ID
    WHERE 
        A.generation < 100  -- 100세대까지 제한
)

SELECT 
    ID
FROM 
    Ancestors
WHERE 
    generation = 3
ORDER BY 
    generation, ID;
