USE BODYMANAGER;

# USER 
CREATE VIEW manager_info AS(
SELECT U.user_code, U.user_email,
U.user_nickname, U.user_age, U.user_phone_number
FROM user U, manager M 
WHERE U.user_email = M.manager_email
ORDER BY user_code ASC
);




# BOARD
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





#EXCERCISE_ROUTINE
INSERT INTO exercise_routine VALUES (1, "routine 1", "routine 2", "routine 3");
INSERT INTO exercise_routine VALUES (2, "routine 1", "routine 2", "routine 3");
INSERT INTO exercise_routine VALUES (3, "routine 1", "routine 2", "routine 3");







# MANAGER




# BODYINFO



# MENU
SELECT * FROM bodymanager.menu_detail;
select U.user_code, M.menu_code, M.time,M.monday,M.tuesday,M.wednesday, M.thursday, M.friday,M.saturday,M.sunday
From user U, menu_detail M, user_menu_select US
where U.user_code = US.user_code
AND US.menu_code = M.menu_code
order by menu_index asc;

CREATE VIEW user_Select_menu AS
(
select U.user_code, M.menu_code, M.time,M.monday,M.tuesday,M.wednesday, M.thursday, M.friday,M.saturday,M.sunday
From user U, menu_detail M, user_menu_select US
where U.user_code = US.user_code
AND US.menu_code = M.menu_code
order by menu_index asc
);

INSERT INTO menu VALUES ("A");
INSERT INTO menu VALUES ("B");
INSERT INTO menu VALUES ("C");


INSERT INTO menu_detail VAlUES (1,"A","아침","갑1","을1","병","정","무","기","경");
INSERT INTO menu_detail VAlUES (2,"A","점심","갑2","을2","병","정","무","기","경");
INSERT INTO menu_detail VAlUES (3,"A","저녁","갑3","을3","병","정","무","기","경");
INSERT INTO menu_detail VAlUES (4,"B","아침","갑4","을4","병","정","무","기","경");
INSERT INTO menu_detail VAlUES (5,"B","점심","갑5","을5","병","정","무","기","경");
INSERT INTO menu_detail VAlUES (6,"B","저녁","갑6","을6","병","정","무","기","경");
INSERT INTO menu_detail VAlUES (7,"C","아침","갑7","을7","병","정","무","기","경");
INSERT INTO menu_detail VAlUES (8,"C","점심","갑8","을8","병","정","무","기","경");
INSERT INTO menu_detail VAlUES (9,"C","저녁","갑9","을9","병","정","무","기","경");



# MILEAGE
