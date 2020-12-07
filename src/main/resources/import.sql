insert into user ( username, password,deleted) values ( "sake", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK",  0);
insert into user  (username, password,  deleted) values ( "n", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "m", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);

insert into student(firstname, lastname,address,birthdate, city, country,email, index_number, zip, user_rel, phone) values("nela", "milojevic","ss", '2018-12-12', "Uzice", "Srb", "sake@gmail.com","sf10/2016", 31000, 1, '123');
insert into student(firstname, lastname,address,birthdate, city, country,email, index_number, zip, user_rel, phone) values("sanja", "milojevic","ss", '2018-12-12', "Uzice", "Srb", "n", "sf10/2015", 31000, 2, '456');


insert into professor(role, user_rel) values('PROFESSOR', 3);

INSERT INTO authority VALUES (1,'ADMIN');
INSERT INTO authority VALUES (2,'USER');

insert into user_authority values(1, 1);
insert into user_authority values(2, 2);
insert into user_authority values(3, 2);
