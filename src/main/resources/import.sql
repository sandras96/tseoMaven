insert into user (firstname, lastname, username, password, email, deleted) values ("sandra", "stojanovic", "sake", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", "sake@gmail.com", 0);
insert into user (firstname, lastname, username, password, email, deleted) values ("nela", "milojevic", "n", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", "n", 0);
insert into user (firstname, lastname, username, password, email, deleted) values ("sanja", "milojevic", "m", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", "m", 0);

insert into student(address,birthdate, city, country, index_number, zip, user_rel) values("ss", '2018-12-12', "Uzice", "Srb", "sf10/2016", 31000, 1);
insert into student(address,birthdate, city, country, index_number, zip, user_rel) values("ss", '2018-12-12', "Uzice", "Srb", "sf10/2015", 31000, 2);


insert into professor(role, user_rel) values('PROFESSOR', 3);

INSERT INTO authority VALUES (1,'ADMIN');
INSERT INTO authority VALUES (2,'USER');

insert into user_authority values(1, 1);
insert into user_authority values(2, 2);
insert into user_authority values(3, 2);
