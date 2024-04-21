-- 코드를 입력하세요
SELECT ANIMAL_TYPE ,  CASE 
           WHEN NAME IS NULL THEN 'No name' 
           ELSE NAME 
       END AS NAME,SEX_UPON_INTAKE from animal_ins order by animal_id asc