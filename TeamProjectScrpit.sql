CREATE DATABASE IF NOT EXISTS bodymanager;
USE BODYMANAGER;

# USER 
CREATE TABLE IF NOT EXISTS `bodymanager`.`User` (
  `user_code` INT NOT NULL AUTO_INCREMENT COMMENT '회원번호',
  `user_email` VARCHAR(45) NOT NULL,
  `user_password` VARCHAR(255) NOT NULL COMMENT '회원비밀번호',
  `user_nickname` VARCHAR(6) NOT NULL COMMENT '회원닉네임',
  `user_phone_number` VARCHAR(45) NOT NULL COMMENT '회원전화번호',
  `user_address` VARCHAR(45) NULL COMMENT '회원주소',
  `user_gender` VARCHAR(4) NULL COMMENT '회원성별',
  `user_age` INT NULL COMMENT '회원나이',
  PRIMARY KEY (`user_code`, `user_email`),
  UNIQUE INDEX `user_nickname_UNIQUE` (`user_nickname` ASC) VISIBLE,
  UNIQUE INDEX `user_phone_number_UNIQUE` (`user_phone_number` ASC) VISIBLE,
  UNIQUE INDEX `user_email_UNIQUE` (`user_email` ASC) VISIBLE,
  UNIQUE INDEX `user_code_UNIQUE` (`user_code` ASC) VISIBLE)
ENGINE = InnoDB
COMMENT = '회원정보';

# BOARD
CREATE TABLE IF NOT EXISTS `bodymanager`.`Board` (
  `board_number` INT NOT NULL AUTO_INCREMENT COMMENT '게시글 번호',
  `board_writer_email` VARCHAR(45) NOT NULL,
  `board_writer_nickname` VARCHAR(6) NOT NULL COMMENT '작성자닉네임',
  `board_title` VARCHAR(45) NOT NULL COMMENT '게시글제목',
  `board_content` TEXT NOT NULL COMMENT '제시글내용',
  `board_image_url` VARCHAR(511) NULL COMMENT '게시글 이미지',
  `board_write_datetime` DATE NOT NULL,
  `view_count` INT NOT NULL,
  PRIMARY KEY (`board_number`))
ENGINE = InnoDB
COMMENT = '공지사항게시판';


#EXCERCISE_ROUTINE
CREATE TABLE IF NOT EXISTS `bodymanager`.`Exercise_routine` (
  `routine_number` INT NOT NULL COMMENT '운동루틴 번호',
  `routine_image_url1` VARCHAR(511) NOT NULL,
  `routine_image_url2` VARCHAR(511) NOT NULL,
  `routine_image_url3` VARCHAR(511) NOT NULL,
  PRIMARY KEY (`routine_number`),
  UNIQUE INDEX `routine_number_UNIQUE` (`routine_number` ASC) VISIBLE)
ENGINE = InnoDB
COMMENT = '운동루틴';

INSERT INTO exercise_routine VALUES (1, "routine 1-1", "routine 2", "routine 3");
INSERT INTO exercise_routine VALUES (2, "routine 2-1", "routine 2", "routine 3");
INSERT INTO exercise_routine VALUES (3, "routine 3-1", "routine 2", "routine 3");

# MANAGER
CREATE TABLE IF NOT EXISTS `bodymanager`.`Manager` (
  `manager_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`manager_email`),
  CONSTRAINT `fk_Manager_User1`
    FOREIGN KEY (`manager_email`)
    REFERENCES `bodymanager`.`User` (`user_email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '관리자 ';

# BODYINFO
CREATE TABLE IF NOT EXISTS `bodymanager`.`Body_info` (
  `user_code` INT NOT NULL AUTO_INCREMENT COMMENT '회원번호',
  `record_date` DATE NOT NULL,
  `height` DOUBLE NOT NULL COMMENT '키',
  `weight` DOUBLE NOT NULL COMMENT '체중',
  `muscle_mass` DOUBLE NOT NULL COMMENT '골격량',
  `fat_rate` DOUBLE NOT NULL COMMENT '체지방률',
  `bmi_index` DOUBLE NOT NULL COMMENT 'bmi 지수 ',
  `bmi_result` VARCHAR(45) NOT NULL COMMENT 'bmi 지수 결과',
  PRIMARY KEY (`user_code`, `record_date`),
  CONSTRAINT `fk_body_info_user`
    FOREIGN KEY (`user_code`)
    REFERENCES `bodymanager`.`User` (`user_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '신체정보';



# MENU & MENU Detail
CREATE TABLE IF NOT EXISTS `bodymanager`.`Menu` (
  `menu_code` VARCHAR(5) NOT NULL COMMENT '세트메뉴 코드',
  PRIMARY KEY (`menu_code`))
ENGINE = InnoDB
COMMENT = '식단';

CREATE TABLE IF NOT EXISTS `bodymanager`.`Menu_detail` (
  `menu_index` INT NOT NULL AUTO_INCREMENT COMMENT '메뉴순번',
  `menu_code` VARCHAR(5) NOT NULL COMMENT '메뉴 코드',
  `time` VARCHAR(45) NOT NULL COMMENT '아침점심저녁',
  `monday` VARCHAR(45) COLLATE 'utf8mb3_bin' NOT NULL,
  `tuesday` VARCHAR(45) COLLATE 'utf8mb3_bin' NOT NULL,
  `wednesday` VARCHAR(45) COLLATE 'utf8mb3_bin' NOT NULL,
  `thursday` VARCHAR(45) COLLATE 'utf8mb3_bin' NOT NULL,
  `friday` VARCHAR(45) COLLATE 'utf8mb3_bin' NOT NULL,
  `saturday` VARCHAR(45) COLLATE 'utf8mb3_bin' NOT NULL,
  `sunday` VARCHAR(45) COLLATE 'utf8mb3_bin' NOT NULL,
  PRIMARY KEY (`menu_index`),
  CONSTRAINT `fk_Diet_detail_Menu1`
    FOREIGN KEY (`menu_code`)
    REFERENCES `bodymanager`.`Menu` (`menu_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '식단내용물';


INSERT INTO menu value ("A");
INSERT INTO menu value ("B");
INSERT INTO menu value ("C");
-- 데이터를 먼저 제거하세요
truncate table menu_detail;

INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("A", "아침", "현미밥 1공기 닭가슴살 120g 배추김치 사과","베이글 1개 닭가슴살 100 야채 샐러드  우유 1컵","현미밥 1공기 닭가슴살 120 배추김치 사과","고구마 1.5 두유 1컵 달걀 2개 방울토마토 5개","보리식빵 2개 달갈 2개 아몬드 5알 사과","단호박 120 달걀 2개 야채 샐러드","베이글 1개 닭가슴살 100 야채 샐러드  우유 1컵");
INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("A", "점심", "고구마 1.5 두무 1모 방울토마토 5개 아몬드 5알","단호박 200 연어 150 야채샐러드 호두 2알","현미밥 1공기, 닭가슴살 120 , 두유 1컵, 아보카도 1개","고구마 1.5 두무 1모 방울토마토 5개 아몬드 5알","단호박 200 연어 150 야채샐러드 호두 2알","현미밥 1공기, 소고기 부채살 150g, 김치","현미밥 1공기, 소고기 부채살 150g, 김치");
INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("A", "저녁", "단호박 200 닭가슴살 120 야채샐러드 자몽 1개","현미밥 1공기, 닭가슴살 120 , 두유 1컵, 아보카도 1개","현미밥 1공기, 닭가슴살 120 , 두유 1컵, 아보카도 1개","단호박 200 닭가슴살 120 야채샐러드 자몽 1개","현미밥 1공기, 닭가슴살 120 , 두유 1컵, 아보카도 1개","고구마 200g 계란 4개 방울토마토 5개","현미밥 1공기 소고기 부채살 150g 야채샐러드 토마토");

INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("B", "아침", "고구마 1.5 두무 1모 방울토마토 5개 아몬드 5알","단호박 200 연어 150 야채샐러드 호두 2알","현미밥 1공기, 닭가슴살 120 , 두유 1컵, 아보카도 1개","고구마 1.5 두무 1모 방울토마토 5개 아몬드 5알","단호박 200 연어 150 야채샐러드 호두 2알","현미밥 1공기, 소고기 부채살 150g, 김치","현미밥 1공기, 소고기 부채살 150g, 김치");
INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("B", "점심", "현미밥 1공기 닭가슴살 120g 배추김치 사과","베이글 1개 닭가슴살 100 야채 샐러드  우유 1컵","현미밥 1공기 닭가슴살 120 배추김치 사과","고구마 1.5 두유 1컵 달걀 2개 방울토마토 5개","보리식빵 2개 달갈 2개 아몬드 5알 사과","단호박 120 달걀 2개 야채 샐러드","베이글 1개 닭가슴살 100 야채 샐러드  우유 1컵");
INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("B", "저녁", "단호박 200 닭가슴살 120 야채샐러드 자몽 1개","현미밥 1공기, 닭가슴살 120 , 두유 1컵, 아보카도 1개","현미밥 1공기, 닭가슴살 120 , 두유 1컵, 아보카도 1개","단호박 200 닭가슴살 120 야채샐러드 자몽 1개","현미밥 1공기, 닭가슴살 120 , 두유 1컵, 아보카도 1개","고구마 200g 계란 4개 방울토마토 5개","현미밥 1공기 소고기 부채살 150g 야채샐러드 토마토");

INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("C", "아침", "단호박 200 닭가슴살 120 야채샐러드 자몽 1개","현미밥 1공기, 닭가슴살 120 , 두유 1컵, 아보카도 1개","현미밥 1공기, 닭가슴살 120 , 두유 1컵, 아보카도 1개","단호박 200 닭가슴살 120 야채샐러드 자몽 1개","현미밥 1공기, 닭가슴살 120 , 두유 1컵, 아보카도 1개","고구마 200g 계란 4개 방울토마토 5개","현미밥 1공기 소고기 부채살 150g 야채샐러드 토마토");
INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("C", "점심", "현미밥 1공기 닭가슴살 120g 배추김치 사과","베이글 1개 닭가슴살 100 야채 샐러드  우유 1컵","현미밥 1공기 닭가슴살 120 배추김치 사과","고구마 1.5 두유 1컵 달걀 2개 방울토마토 5개","보리식빵 2개 달갈 2개 아몬드 5알 사과","단호박 120 달걀 2개 야채 샐러드","베이글 1개 닭가슴살 100 야채 샐러드  우유 1컵");
INSERT INTO menu_detail (menu_code, time, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES ("C", "저녁", "고구마 1.5 두무 1모 방울토마토 5개 아몬드 5알","단호박 200 연어 150 야채샐러드 호두 2알","현미밥 1공기, 닭가슴살 120 , 두유 1컵, 아보카도 1개","고구마 1.5 두무 1모 방울토마토 5개 아몬드 5알","단호박 200 연어 150 야채샐러드 호두 2알","현미밥 1공기, 소고기 부채살 150g, 김치","현미밥 1공기, 소고기 부채살 150g, 김치");



# UserMenuSelect
CREATE TABLE IF NOT EXISTS `bodymanager`.`User_menu_select` (
  `user_code` INT NOT NULL COMMENT '회원번호',
  `menu_code` VARCHAR(5) NOT NULL COMMENT '메뉴코드',
  PRIMARY KEY (`user_code`, `menu_code`),
  INDEX `fk_table1_Menu1_idx` (`menu_code` ASC) VISIBLE,
  CONSTRAINT `fk_table1_User1`
    FOREIGN KEY (`user_code`)
    REFERENCES `bodymanager`.`User` (`user_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_Menu1`
    FOREIGN KEY (`menu_code`)
    REFERENCES `bodymanager`.`Menu` (`menu_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '회원메뉴 선택';


# MILEAGE
CREATE TABLE IF NOT EXISTS `bodymanager`.`Mileage` (
  `user_code` INT NOT NULL AUTO_INCREMENT COMMENT '회원번호',
  `attendance_today` TINYINT NOT NULL COMMENT '출석체크',
  `attendance_mileage` INT NOT NULL COMMENT '출석체크 마일리지',
  `attendance_date` DATE NULL COMMENT '출석날짜',
  PRIMARY KEY (`user_code`),
  CONSTRAINT `fk_milege_user1`
    FOREIGN KEY (`user_code`)
    REFERENCES `bodymanager`.`User` (`user_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '마일리지';

#VIEW
CREATE VIEW user_Select_menu AS
(
select U.user_code, M.menu_code, M.time,M.monday,M.tuesday,M.wednesday, M.thursday, M.friday,M.saturday,M.sunday
From user U, menu_detail M, user_menu_select US
where U.user_code = US.user_code
AND US.menu_code = M.menu_code
order by menu_index asc
);

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

CREATE VIEW manager_info AS(
SELECT U.user_code, U.user_email,
U.user_nickname, U.user_age, U.user_phone_number
FROM user U, manager M 
WHERE U.user_email = M.manager_email
ORDER BY user_code ASC
);

