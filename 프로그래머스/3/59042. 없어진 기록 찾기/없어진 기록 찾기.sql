-- 코드를 입력하세요
-- SELECT * from animal_outs
SELECT ANIMAL_ID, o.name as NAME from animal_ins i right join animal_outs o using(animal_id) where i.name is null and o.name is not null order by ANIMAL_ID