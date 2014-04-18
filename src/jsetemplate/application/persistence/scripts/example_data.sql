select * from users ;
select * from user_roles  ;

insert into user_roles (id , name) values (1 , 'administrator');
insert into user_roles (id , name) values (2 , 'backend');
insert into user_roles (id , name) values (3 , 'client');

insert into users (user_id, email, name, password, surname, role_id)
values('112233','jhon@gmail.com','jhon','XXXXXX','doe', 1);
insert into users (user_id, email, name, password, surname, role_id)
values('332211','jj@gmail.com','jack','XXXXXX','jhonson', 2);
insert into users (user_id, email, name, password, surname, role_id)
values('665544','mthomas@gmail.com','Michael','XXXXXX','Thomas', 3);