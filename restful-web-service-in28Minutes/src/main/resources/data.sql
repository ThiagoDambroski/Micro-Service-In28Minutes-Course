insert into user_details(id,birth_date,name)
values(1001, current_date() ,'Leticia');

insert into user_details(id,birth_date,name)
values(1002, current_date() ,'Thiago');

insert into post(id,description,user_id)
values(2001,'I want to learn AWS',1002)