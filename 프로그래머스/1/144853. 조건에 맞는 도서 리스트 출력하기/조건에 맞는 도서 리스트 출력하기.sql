-- 코드를 입력하세요
SELECT BOOK_ID as ID , DATE_FORMAT(PUBLISHED_DATE, "%Y-%m-%d") as 출판일 from BOOK where YEAR(PUBLISHED_DATE) = "2021" AND CATEGORY = "인문" ORDER BY published_date desc