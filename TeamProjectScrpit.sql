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
INSERT INTO exercise_routine VALUES (1, "routine 1-1", "routine 2", "routine 3");
INSERT INTO exercise_routine VALUES (2, "routine 2-1", "routine 2", "routine 3");
INSERT INTO exercise_routine VALUES (3, "routine 3-1", "routine 2", "routine 3");







# MANAGER




# BODYINFO



# MENU

INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("A", "아침", "M-menu", "T-menu", "W-menu", "T-menu", "F-menu", "S-menu", "S-menu");
INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("A", "점심", "M-menu", "T-menu", "W-menu", "T-menu", "F-menu", "S-menu", "S-menu");
INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("A", "저녁", "M-menu", "T-menu", "W-menu", "T-menu", "F-menu", "S-menu", "S-menu");

INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("B", "아침", "M-menu", "T-menu", "W-menu", "T-menu", "F-menu", "S-menu", "S-menu");
INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("B", "점심", "M-menu", "T-menu", "W-menu", "T-menu", "F-menu", "S-menu", "S-menu");
INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("B", "저녁", "M-menu", "T-menu", "W-menu", "T-menu", "F-menu", "S-menu", "S-menu");

INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("C", "아침", "M-menu", "T-menu", "W-menu", "T-menu", "F-menu", "S-menu", "S-menu");
INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("C", "점심", "M-menu", "T-menu", "W-menu", "T-menu", "F-menu", "S-menu", "S-menu");
INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("C", "저녁", "M-menu", "T-menu", "W-menu", "T-menu", "F-menu", "S-menu", "S-menu");





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




# MILEAGE
