-- 코드를 입력하세요
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, CASE STATUS WHEN "DONE" THEN "거래완료" WHEN "RESERVED" THEN "예약중" ELSE "판매중" END as STATUS from USED_GOODS_BOARD U where YEAR(U.CREATED_DATE) = "2022" AND MONTH(U.CREATED_DATE) = "10" AND DAY(U.CREATED_DATE) = "5" order by board_id desc