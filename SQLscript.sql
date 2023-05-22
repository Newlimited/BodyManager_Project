use bodymanager;
select * from user;
select * from mileage;
select * from manager;
select * from board;
select * from excersice_routine;
INSERT INTO excersice_routine values(1, "image1", "image2", "image3");

select U.user_code, M.manager_email from user U, manager M
where U.user_email = M.manager_email;

CREATE VIEW manager_info AS(
SELECT U.user_code, U.user_email,
U.user_nickname, U.user_age, U.user_phone_number
FROM user U, manager M 
WHERE U.user_email = M.manager_email
ORDER BY user_code ASC
);

UPDATE mileage 
SET 
    attendance_date = '2023-05-21'
    where user_code = 4;
    
    commit ;

select * from manager_info;

CREATE VIEW board_view AS (
SELECT
B.board_number AS boardNumber,
M.manager_email AS boardWriterEmail,
B.board_writer_nickname AS boardWriterNickname,
B.board_title AS title,
B.board_content AS boardContent,
B.board_image_url AS boardImageUrl,
B.view_count AS viewCount,
B.board_write_datetime AS boardWriteDatetime
From board B, manager M, user U
WHERE B.board_writer_email = M.manager_email
AND M.manager_email = U.user_email
ORDER BY B.board_number DESC
);
SELECT * from board_view ;


SELECT
B.board_number AS boardNumber,
M.manager_email AS boardWriterEmail,
B.board_writer_nickname AS boardWriterNickname,
B.board_title AS title,
B.board_content AS boardContent,
B.board_image_url AS boardImageUrl,
B.view_count AS viewCount,
B.board_write_datetime AS boardWriteDatetime
From board B, manager M, user U
WHERE B.board_writer_email = M.manager_email
AND M.manager_email = U.user_email
ORDER BY B.board_number DESC;
select * from manager;


CREATE VIEW diet_menu AS (
SELECT
D.user_code AS userCode,
D.time AS Time,
D.item AS Food,
D.diet_number AS Day,
D.menu_code AS counter
FROM diet_detail D, user U, diet DI, menu ME
WHERE D.user_code = DI.user_code
AND DI.user_code = ME.user_code
AND ME.user_code = U.user_code
AND D.diet_number = DI.diet_number
AND D.menu_code = DI.menu_code
AND DI.menu_code = ME.menu_code
ORDER BY D.diet_number DESC,
D.user_code DESC
);

SELECT * FROM diet_menu;






-- SELECT 
-- B.board_number As 게시물번호,
-- B.title AS boardTitle,
-- B.content As boardContent,
-- B.board_image_url AS boardImageUrl,
-- B.write_datetime As boardWriteDatetime,
-- B.view_count As viewCount,
-- U.email As boardWriterEmail,
-- U.nickname AS boardWriterNickname,
-- U.profile_image_url AS boardWriterProfileImageUrl,
-- count(DISTINCT C.comment_number) As commentCount,
-- count(DISTINCT L.user_email) AS likeCount

-- from Board B, Comment C, Liky L, User U
-- where B.board_number = C.board_number
-- AND B.writer_email = U.email 
-- GROUP BY B.board_number 
-- ORDER BY B.write_datetime DESC;



CREATE VIEW diet_menu AS (
SELECT
M.menu_code AS MenuCode,
D.time AS Time,
D.monday AS Monday,
D.tuesday AS Tuesday,
D.wednesday AS Wednesday,
D.thursday AS Thursday,
D.friday AS Friday,
D.saturday AS Saturday,
D.sunday AS Sunday
FROM diet_detail D, menu M, user U
ORDER BY M.menu_code DESC
);

INSERT INTO menu values ('A');
INSERT INTO menu values ('B');
INSERT INTO menu values ('C');

INSERt INTO menu_detail(menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday) values ('A','아침', '가', '나', '다', '라','마','바','사'); 
INSERt INTO menu_detail(menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday) values ('A','점심', '가', '나', '다', '라','마','바','사'); 
INSERt INTO menu_detail(menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday) values ('A','저녁', '가', '나', '다', '라','마','바','사'); 
INSERt INTO menu_detail(menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday) values ('B','아침', '가1', '나1', '다1', '라1','마1','바1','사1'); 
INSERt INTO menu_detail(menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday) values ('B','점심', '가1', '나1', '다1', '라1','마1','바1','사1'); 
INSERt INTO menu_detail(menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday) values ('B','저녁', '가1', '나1', '다1', '라1','마1','바1','사1'); 
INSERt INTO menu_detail(menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday) values ('C','아침', '가2', '나2', '다2', '라2','마2','바2','사2'); 
INSERt INTO menu_detail(menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday) values ('C','점심', '가2', '나2', '다2', '라2','마2','바2','사2'); 
INSERt INTO menu_detail(menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday) values ('C','저녁', '가2', '나2', '다2', '라2','마2','바2','사2'); 

INSERT INTO exercise_routine VALUES (1, "routine 1", "routine 2", "routine 3");
INSERT INTO exercise_routine VALUES (2, "routine 1", "routine 2", "routine 3");
INSERT INTO exercise_routine VALUES (3, "routine 1", "routine 2", "routine 3");

select * from excersice_routine;

select * from menu_detail;
select * from menu_detail
where menu_code = 'A';

ALTER TABLE mileage ALTER attendance_today SET DEFAULT false;
select * from mileage;

select manager_code from manager
where manager_code = 2;