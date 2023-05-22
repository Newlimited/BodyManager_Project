use bodymanager;

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

INSERT INTO exercise_routine VALUES (1, "routine 1", "routine 2", "routine 3");
INSERT INTO exercise_routine VALUES (2, "routine 1", "routine 2", "routine 3");
INSERT INTO exercise_routine VALUES (3, "routine 1", "routine 2", "routine 3");








