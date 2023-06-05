use bodymanager;
select * from manager;
select * from user;

select * from user_menu_select;
select * from body_info;

DELETE FROM body_info WHERE user_code = 2;

UPDATE body_info set record_date = "2023-05-23" where user_code = 1;
commit;

CREATE VIEW trainner_profile AS(
SELECT U.user_email, U.user_nickname, U.user_phone_number,
U.user_gender, U.user_age 
FROM user U, manager M
WHERE M.manager_email = U.user_email
ORDER BY user_code
);