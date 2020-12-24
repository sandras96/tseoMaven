insert into user (username, password, deleted) values ( "sake", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK",  0);
insert into user (username, password, deleted) values ( "n", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "m", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "d", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "h", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "j", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "l", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);

INSERT INTO authority VALUES (1,'ADMIN');
INSERT INTO authority VALUES (2,'STUDENT');
INSERT INTO authority VALUES (3,'PROFESSOR');

INSERT INTO user_authority VALUES (1,1);
INSERT INTO user_authority VALUES (2,2);
INSERT INTO user_authority VALUES (3,3);
INSERT INTO user_authority VALUES (4,3);
INSERT INTO user_authority VALUES (5,2);

insert into student(firstname, lastname,address,birthdate, city, country,email, index_number, zip, user_rel, phone) values("nela", "milojevic","ss", '2018-12-12', "Uzice", "Srb", "sake@gmail.com","sf10/2016", 31000, 1, '123');
insert into student(firstname, lastname,address,birthdate, city, country,email, index_number, zip, user_rel, phone) values("sanja", "milojevic","ss", '2018-12-12', "Uzice", "Srb", "n", "sf10/2015", 31000, 2, '456');
insert into student(firstname, lastname,address,birthdate, city, country,email, index_number, zip, user_rel, phone) values("student", "student","ss", '2018-12-12', "Uzice", "Srb", "n", "sf10/2012", 31000, 6, '4569');

insert into professor(firstname, lastname,address,birthdate, city, country,email, zip, phone, role, user_rel) values("prof1", "prof1","ss", '2018-12-12', "Uzice", "Srb", "mejl.com", 31000, '6556','PROFESSOR', 3);
insert into professor(firstname, lastname,address,birthdate, city, country,email, zip, phone, role, user_rel) values("prof2", "prof2","ss", '2018-12-12', "Uzice", "Srb", "mejl.com", 31000, '655635','PROFESSOR', 4);
insert into professor(firstname, lastname,address,birthdate, city, country,email, zip, phone, role, user_rel) values("prof3", "prof3","ss", '2018-12-12', "Uzice", "Srb", "mejl.com", 31000, '65546','PROFESSOR', 5);

insert into course(name, espb, semester, deleted) values ('Osnove programiranja', 6, 'WINTER',0);
insert into course(name, espb, semester, deleted) values ('Osnove softverskih arhitektura', 6, 'WINTER',0);
insert into course(name, espb, semester, deleted) values ('Razvoj softvera', 5, 'WINTER',0);
insert into course(name, espb, semester, deleted) values ('Informaciona bezbednost', 6, 'SUMMER',0);
insert into course(name, espb, semester, deleted) values ('Sistemi e-obrazovanja', 6, 'SUMMER',0);
insert into course(name, espb, semester, deleted) values ('Poslovna informatika', 5, 'SUMMER',0);

insert into course_attendance(course_id, student_id) values (1,1);
insert into course_attendance(course_id, student_id) values (1,2);
insert into course_attendance(course_id, student_id) values (2,2);
insert into course_attendance(course_id, student_id) values (4,1);
insert into course_attendance(course_id, student_id) values (4,3);
insert into course_attendance(course_id, student_id) values (5,2);
insert into course_attendance(course_id, student_id) values (5,3);
insert into course_attendance(course_id, student_id) values (3,3);
insert into course_attendance(course_id, student_id) values (6,3);

insert into course_professor(course_id, professor_id) values (1,1);
insert into course_professor(course_id, professor_id) values (1,2);
insert into course_professor(course_id, professor_id) values (2,2);
insert into course_professor(course_id, professor_id) values (4,1);
insert into course_professor(course_id, professor_id) values (4,3);
insert into course_professor(course_id, professor_id) values (5,2);
insert into course_professor(course_id, professor_id) values (5,3);
insert into course_professor(course_id, professor_id) values (3,3);
insert into course_professor(course_id, professor_id) values (6,3);

insert into document (date, name, student_id, deleted) values ('2018-12-12', 'doc1', 1, 0);
insert into document (date, name, student_id, deleted) values ('2018-12-12', 'doc2', 1, 0);
insert into document (date, name, student_id, deleted) values ('2018-12-12', 'doc3', 1, 0);
insert into document (date, name, student_id, deleted) values ('2018-12-12', 'doc4', 2, 0);
insert into document (date, name, student_id, deleted) values ('2018-12-12', 'doc5', 3, 0);

insert into exam (date, points, assignment, course_id, exam_period_id) values ('2018-12-12', 65, 'asss5', 1, 1);
insert into exam (date, points, assignment, course_id, exam_period_id) values ('2018-12-12', 35, 'asss55', 1, 2);
insert into exam (date, points, assignment, course_id, exam_period_id) values ('2018-12-12', 100, 'asss5', 2, 2);
insert into exam (date, points, assignment, course_id, exam_period_id) values ('2018-12-12', 65, 'asss5', 6, 3);

insert into exam_period(name, start_date, end_date)values('januarski rok', '2018-12-12', '2018-12-12');
insert into exam_period(name, start_date, end_date)values('februarski rok', '2018-12-12', '2018-12-12');
insert into exam_period(name, start_date, end_date)values('aprilski rok', '2018-12-12', '2018-12-12');

insert into exam_taking(mark, pass, points, exam_id, professor_id, student_id)values(6, true, 55, 1, 1,1);
insert into exam_taking(mark, pass, points, exam_id, professor_id, student_id)values(10, true, 98, 3, 3,3);
insert into exam_taking(mark, pass, points, exam_id, professor_id, student_id)values(5, false, 48, 4, 1,2);

--PAYMENT
insert into payment(account_number,address,amount,city,date,deleted,model,name,payment_code,purpose,reference,student_id) values
					(1567456, 'adress1', 520, 'Ue', '2018-12-12', false, 15, 'name', 5, 'purpose', 556, 1);



--INSERT INTO authority VALUES (1,'ADMIN');
--INSERT INTO authority VALUES (2,'USER');

--insert into user_authority values(1, 1);
--insert into user_authority values(2, 2);
--insert into user_authority values(3, 2);
