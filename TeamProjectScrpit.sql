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

INSERT INTO exercise_routine VALUES (1, "https://ibb.co/xzFj274", "https://ibb.co/xzFj274", "https://ibb.co/xzFj274");
INSERT INTO exercise_routine VALUES (2, "https://ibb.co/y4c1w05", "https://ibb.co/y4c1w05", "https://ibb.co/y4c1w05");
truncate table exercise_routine;

# MANAGER
CREATE TABLE IF NOT EXISTS `bodymanager`.`Manager` (
  `manager_code` INT NOT NULL AUTO_INCREMENT,
  `manager_email` VARCHAR(45) NOT NULL,
  `manager_nickname` VARCHAR(6) NOT NULL,
  `manager_gender` VARCHAR(4) NULL,
  `manager_age` INT NULL,
  `manager_phone_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`manager_code`, `manager_email`),
  UNIQUE INDEX `manager_phone_number_UNIQUE` (`manager_phone_number` ASC) VISIBLE,
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

#Equipment
CREATE TABLE IF NOT EXISTS `bodymanager`.`Equipment` (
  `equipment_number` INT NOT NULL AUTO_INCREMENT COMMENT '운동기구 번호',
  `equipment_name` VARCHAR(45) NOT NULL COMMENT '운동기구 이름',
  `equipment_usage` TEXT NOT NULL COMMENT '운동기구 사용법',
  `equipment_image_url` VARCHAR(511) NOT NULL COMMENT '운동기구 이미지',
  PRIMARY KEY (`equipment_number`))
ENGINE = InnoDB
COMMENT = '운동기구 관련 테이블';

Insert into equipment(equipment_name, equipment_usage, equipment_image_url) 
values ("랫 풀다운",
"앉아서 랫 풀다운 기계에 앉고 발을 고정합니다.  
손잡이를 어깨 너비로 잡고, 팔을 늘어뜨리며 손잡이를 가슴 쪽으로 당깁니다. 
등과 상체 근육을 사용하여 손잡이를 천천히 내려놓습니다. 
허리를 고정한 상태로 반복합니다.",
"랫풀다운 기구 이미지"
);
Insert into equipment(equipment_name, equipment_usage, equipment_image_url) 
values ("레그 프레스",
"레그 프레스 기계에 앉고 발판에 발을 놓습니다. 
무릎을 구부리고 발판을 밀며 다리를 펴는 동작을 반복합니다. 
허벅지 근육을 강화하고 하체를 운동합니다. ", 
"레그 프레스 기구 이미지"
);
Insert into equipment(equipment_name, equipment_usage, equipment_image_url) 
values ("힙 레이즈 ",
"힙 레이즈 기기에 앉고 패드에 엉덩이를 대고 손잡이를 잡습니다.
상체를 고정하고 복근을 사용하여 다리를 들어올립니다.
다리를 천천히 내리면서 복근을 계속해서 수축시킵니다. 
다리를 들어올리고 내리는 동작을 반복하여 복근을 강화합니다.",
"힙 레기즈 기구 이미지"
);

commit ;
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

#----------------23/05/24 10:44 CASECADE로 추가
ALTER TABLE `bodymanager`.`user_menu_select` 
DROP FOREIGN KEY `fk_table1_User1`;
ALTER TABLE `bodymanager`.`user_menu_select` 
ADD CONSTRAINT `fk_table1_User1`
  FOREIGN KEY (`user_code`)
  REFERENCES `bodymanager`.`user` (`user_code`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  ALTER TABLE `bodymanager`.`mileage` 
DROP FOREIGN KEY `fk_milege_user1`;
ALTER TABLE `bodymanager`.`mileage` 
ADD CONSTRAINT `fk_milege_user1`
  FOREIGN KEY (`user_code`)
  REFERENCES `bodymanager`.`user` (`user_code`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `bodymanager`.`body_info` 
DROP FOREIGN KEY `fk_body_info_user`;
ALTER TABLE `bodymanager`.`body_info` 
ADD CONSTRAINT `fk_body_info_user`
  FOREIGN KEY (`user_code`)
  REFERENCES `bodymanager`.`user` (`user_code`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

  


