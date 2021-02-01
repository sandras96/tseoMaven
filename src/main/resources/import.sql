--insert into user(address, birthdate, city, country, email, firstname, lastname, phone, zip, deleted, password, username) values ('address1','2018-12-12', 'Uzice', 'Srbija', 'user1@gmail.com', 'firstname1', 'lastname1', '123456', 152369, false, "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 'usr1'); 
--insert into user(address, birthdate, city, country, email, firstname, lastname, phone, zip, deleted, password, username) values ('address2','2018-12-12', 'Uzice', 'Srbija', 'user2@gmail.com', 'firstname2', 'lastname2', '1235456', 1523629, false, "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 'usr2'); 
--insert into user(address, birthdate, city, country, email, firstname, lastname, phone, zip, deleted, password, username) values ('address3','2018-12-12', 'Uzice', 'Srbija', 'user3@gmail.com', 'firstname3', 'lastname3', '123456', 152369, false, "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 'usr3'); 
--insert into user(address, birthdate, city, country, email, firstname, lastname, phone, zip, deleted, password, username) values ('address4','2018-12-12', 'Uzice', 'Srbija', 'user4@gmail.com', 'firstname4', 'lastname4', '123456', 152369, false, "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 'usr4'); 
--insert into user(address, birthdate, city, country, email, firstname, lastname, phone, zip, deleted, password, username) values ('address5','2018-12-12', 'Uzice', 'Srbija', 'user5@gmail.com', 'firstname5', 'lastname5', '123456', 152369, false, "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 'usr5'); 
--insert into user(address, birthdate, city, country, email, firstname, lastname, phone, zip, deleted, password, username) values ('address6','2018-12-12', 'Uzice', 'Srbija', 'user6@gmail.com', 'firstname6', 'lastname6', '123456', 152369, false, "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 'admin');  

				
--insert into student(index_number, user_rel) values ('sf10/2016', 1);
--insert into student(index_number, user_rel) values ('sf9/2016', 2);
--insert into student(index_number, user_rel) values ('sf8/2016', 3);  


--insert into professor(role, user_rel) values ('PROFESSOR', 4);
--insert into professor(role, user_rel) values ('ASSOCIATE', 5);


--insert into user_authority(user_id, authority_id) values (1,2);
--insert into user_authority(user_id, authority_id) values (2,2);
--insert into user_authority(user_id, authority_id) values (3,2);

--insert into user_authority(user_id, authority_id) values (4,3);
--insert into user_authority(user_id, authority_id) values (5,3);


--insert into user_authority(user_id, authority_id) values (6,1);



insert into file(name,type,data)values("file1", "doc", 0);

insert into user (username, password, deleted) values ( "sake", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK",  0);
insert into user (username, password, deleted) values ( "neks", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "sanjica", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "s", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "p1", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "p2", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "p3", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);

INSERT INTO authority VALUES (1,'ADMIN');
INSERT INTO authority VALUES (2,'STUDENT');
INSERT INTO authority VALUES (3,'PROFESSOR');

INSERT INTO user_authority VALUES (1,1);
INSERT INTO user_authority VALUES (2,2);
INSERT INTO user_authority VALUES (3,2);
INSERT INTO user_authority VALUES (4,2);
INSERT INTO user_authority VALUES (5,3);
INSERT INTO user_authority VALUES (6,3);
INSERT INTO user_authority VALUES (7,3);

insert into student(firstname, lastname,address,birthdate, city, country,email, index_number, zip, user_rel, phone) values("nela", "milojevic","ss", '2018-12-12', "Uzice", "Srb", "sake@gmail.com","sf10/2016", 31000, 2, '123');
insert into student(firstname, lastname,address,birthdate, city, country,email, index_number, zip, user_rel, phone) values("sanja", "milojevic","ss", '2018-12-12', "Uzice", "Srb", "n", "sf10/2015", 31000, 3, '456');
insert into student(firstname, lastname,address,birthdate, city, country,email, index_number, zip, user_rel, phone) values("student", "student","ss", '2018-12-12', "Uzice", "Srb", "n", "sf10/2012", 31000, 4, '4569');

insert into professor(firstname, lastname,address,birthdate, city, country,email, zip, phone, role, user_rel) values("prof1", "prof1","ss", '2018-12-12', "Uzice", "Srb", "mejl.com", 31000, '6556','PROFESSOR', 5);
insert into professor(firstname, lastname,address,birthdate, city, country,email, zip, phone, role, user_rel) values("prof2", "prof2","ss", '2018-12-12', "Uzice", "Srb", "mejl.com", 31000, '655635','PROFESSOR', 6);
insert into professor(firstname, lastname,address,birthdate, city, country,email, zip, phone, role, user_rel) values("prof3", "prof3","ss", '2018-12-12', "Uzice", "Srb", "mejl.com", 31000, '65546','PROFESSOR', 7);

insert into course(name, espb, semester, deleted) values ('Osnove programiranja', 6, 'WINTER',0);
insert into course(name, espb, semester, deleted) values ('Osnove softverskih arhitektura', 6, 'WINTER',0);
insert into course(name, espb, semester, deleted) values ('Razvoj softvera', 5, 'WINTER',0);
insert into course(name, espb, semester, deleted) values ('Informaciona bezbednost', 6, 'SUMMER',0);
insert into course(name, espb, semester, deleted) values ('Sistemi e-obrazovanja', 6, 'SUMMER',0);
insert into course(name, espb, semester, deleted) values ('Poslovna informatika', 5, 'SUMMER',0);

--insert into course_attendance(course_id, student_id) values (1,2);
--insert into course_attendance(course_id, student_id) values (1,1);
--insert into course_attendance(course_id, student_id) values (2,2);
--insert into course_attendance(course_id, student_id) values (2,1);
--insert into course_attendance(course_id, student_id) values (4,2);
--insert into course_attendance(course_id, student_id) values (4,3);
--insert into course_attendance(course_id, student_id) values (5,2);
--insert into course_attendance(course_id, student_id) values (5,3);
--insert into course_attendance(course_id, student_id) values (5,1);
--insert into course_attendance(course_id, student_id) values (3,2);
--insert into course_attendance(course_id, student_id) values (3,3);
--insert into course_attendance(course_id, student_id) values (3,1);



--insert into course_professor(course_id, professor_id) values (1,1);
--insert into course_professor(course_id, professor_id) values (1,2);
--insert into course_professor(course_id, professor_id) values (2,2);
--insert into course_professor(course_id, professor_id) values (4,1);
--insert into course_professor(course_id, professor_id) values (4,3);
--insert into course_professor(course_id, professor_id) values (5,2);
--insert into course_professor(course_id, professor_id) values (5,3);
--insert into course_professor(course_id, professor_id) values (3,3);
--insert into course_professor(course_id, professor_id) values (6,3);

--insert into document (date, name, student_id, deleted) values ('2018-12-12', 'doc1', 1, 0);
--insert into document (date, name, student_id, deleted) values ('2018-12-12', 'doc2', 1, 0);
--insert into document (date, name, student_id, deleted) values ('2018-12-12', 'doc3', 1, 0);
--insert into document (date, name, student_id, deleted) values ('2018-12-12', 'doc4', 2, 0);
--insert into document (date, name, student_id, deleted) values ('2018-12-12', 'doc5', 3, 0);

insert into exam (date, points, assignment, course_id, exam_period_id) values ('2018-12-12', 65, 'asss5', 1, 1);
insert into exam (date, points, assignment, course_id, exam_period_id) values ('2018-12-12', 35, 'asss55', 1, 2);
insert into exam (date, points, assignment, course_id, exam_period_id) values ('2018-12-12', 100, 'asss5', 2, 2);
insert into exam (date, points, assignment, course_id, exam_period_id) values ('2018-12-12', 65, 'asss5', 6, 3);

insert into exam_period(name, start_date, end_date)values('januarski rok', '2018-12-12', '2018-12-12');
insert into exam_period(name, start_date, end_date)values('februarski rok', '2018-12-12', '2018-12-12');
insert into exam_period(name, start_date, end_date)values('aprilski rok', '2018-12-12', '2018-12-12');

--insert into exam_taking(mark, points, exam_id, professor_id, student_id)values(6, 55, 1, 1,1);
--insert into exam_taking(mark, points, exam_id, professor_id, student_id)values(10, 98, 3, 3,3);
--insert into exam_taking(mark, points, exam_id, professor_id, student_id)values(5, 48, 4, 1,2);

--PAYMENT
insert into payment(account_number,address,amount,city,date,deleted,model,name,payment_code,purpose,reference,student_id) values (1567456, 'adress1', 520, 'Ue', '2018-12-12', false, 15, 'name', 5, 'purpose', 556, 1);

insert into payment(account_number, address, amount, city, date, deleted, model, name, payment_code, purpose, reference, student_id) values (123456, 'address', 560, 'UE', '2018-12-12', false, 5, 'name1', 456, 'uplata', 36, 1);


--INSERT INTO authority VALUES (1,'ADMIN');
--INSERT INTO authority VALUES (2,'USER');

--insert into user_authority values(1, 1);
--insert into user_authority values(2, 2);
--insert into user_authority values(3, 2);
