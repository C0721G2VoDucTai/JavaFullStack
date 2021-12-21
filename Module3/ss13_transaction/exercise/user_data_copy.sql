drop database if exists user_data_copy;
create database user_data_copy;
use user_data_copy;
create table user_infomation (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);
insert into user_infomation(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into user_infomation(name, email, country) values('Kante','kante@che.uk','Kenia');
DELIMITER $$

CREATE PROCEDURE show_all_user()

BEGIN

    SELECT*

    FROM user_infomation;

    END$$

DELIMITER ;

  

DELIMITER $$

CREATE PROCEDURE edit_user(

IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50),
IN user_id int

)
BEGIN

    update user_infomation 
    set name = user_name, email=user_email, country =user_country
    where id = user_id;
    END$$

DELIMITER ;
DELIMITER $$

CREATE PROCEDURE delete_user(
IN user_id int
)
BEGIN
    delete from user_infomation 
    where id = user_id;
    END$$

DELIMITER ;

call show_all_user()