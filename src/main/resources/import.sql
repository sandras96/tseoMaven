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




--insert into exam_taking(mark, points, exam_id, professor_id, student_id)values(6, 55, 1, 1,1);
--insert into exam_taking(mark, points, exam_id, professor_id, student_id)values(10, 98, 3, 3,3);
--insert into exam_taking(mark, points, exam_id, professor_id, student_id)values(5, 48, 4, 1,2);





---Good----

---user---
insert into user (username, password, deleted) values ( "sake", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK",  0);
insert into user (username, password, deleted) values ( "neks", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "sanja", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "s", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "megs", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "uki", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "vule", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "liki", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "boskic", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "zvija", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "jeso", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "mici", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);
insert into user (username, password, deleted) values ( "darko", "$2a$04$bAsNVI05EjajIzH4AHFdu.RimWMl2K5hmnzeBrcqRX7Cm8BtMgIFK", 0);

---authority---
INSERT INTO authority VALUES (1,'ADMIN');
INSERT INTO authority VALUES (2,'STUDENT');
INSERT INTO authority VALUES (3,'PROFESSOR');

---user_authority---
INSERT INTO user_authority VALUES (1,1);
INSERT INTO user_authority VALUES (2,2);
INSERT INTO user_authority VALUES (3,2);
INSERT INTO user_authority VALUES (4,2);
INSERT INTO user_authority VALUES (5,2);
INSERT INTO user_authority VALUES (6,2);
INSERT INTO user_authority VALUES (7,2);
INSERT INTO user_authority VALUES (8,3);
INSERT INTO user_authority VALUES (9,3);
INSERT INTO user_authority VALUES (10,3);
INSERT INTO user_authority VALUES (11,3);
INSERT INTO user_authority VALUES (12,3);
INSERT INTO user_authority VALUES (13,3);

---student---
insert into student(firstname, lastname,address,birthdate, city, country,email, index_number, zip, user_rel, phone)values("Nela", "Milojevic","Adresa1", '1996-03-23', "Uzice", "Srbija", "nelamilojevic@gmail.com","sf10/2016", 31000, 2, '065/1234567');
insert into student(firstname, lastname,address,birthdate, city, country,email, index_number, zip, user_rel, phone)values("Sanja", "Milojevic","Adresa2", '1992-11-12', "Uzice", "Srbija", "sanjamilojevic@gmail.com", "sf8/2015", 31000, 3, '064/1234567');
insert into student(firstname, lastname,address,birthdate, city, country,email, index_number, zip, user_rel, phone)values("Student", "Student","Adresa3", '1995-09-12', "Novi Sad", "Srbija", "student@gmail.com", "sf56/2016", 21000, 4, '061/7894569');
insert into student(firstname, lastname,address,birthdate, city, country,email, index_number, zip, user_rel, phone)values("Magdalena", "Salipur","Adresa4", '1997-01-27', "Priboj", "Srbija", "megs@gmail.com", "sf11/2016", 31330, 5, '062/0096569');
insert into student(firstname, lastname,address,birthdate, city, country,email, index_number, zip, user_rel, phone)values("Uros", "Cvijovic","Adresa5", '1996-03-02', "Sevojno", "Srbija", "uroscvija@gmail.com", "sf15/2015", 31100, 6, '069/1494569');
insert into student(firstname, lastname,address,birthdate, city, country,email, index_number, zip, user_rel, phone)values("Vuk", "Jovanovic","Adresa6", '1996-07-18', "Sevojno", "Srbija", "vulejovana@gmail.com", "sf45/2016", 31100, 7, '066/1245673');

---professor---
insert into professor(firstname, lastname,address,birthdate, city, country,email, zip, phone, role, user_rel)values("Lidija", "Salipur","Adresa7", '1994-04-12', "Priboj", "Srbija", "liki@gmail.com", 31330, '065/789654','PROFESSOR', 8);
insert into professor(firstname, lastname,address,birthdate, city, country,email, zip, phone, role, user_rel)values("Nikola", "Spasojevic","Adresa8", '1996-12-19', "Brcko", "BiH", "sakeboskic@mejl.com", 76100, '064/7596235','PROFESSOR', 9);
insert into professor(firstname, lastname,address,birthdate, city, country,email, zip, phone, role, user_rel)values("Marko", "Cvijovic","Adresa9", '1996-04-05', "Sevojno", "Srbija", "marezvija@mejl.com", 31100, '063/1236546','ASSOCIATE', 10);
insert into professor(firstname, lastname,address,birthdate, city, country,email, zip, phone, role, user_rel)values("Nikola", "Jelisavcic","Adresa10", '1996-10-06', "Sevojno", "Srbija", "jesakesa@mejl.com", 31100, '063/12396846','DEMONSTRATOR', 11);
insert into professor(firstname, lastname,address,birthdate, city, country,email, zip, phone, role, user_rel)values("Milica", "Babic","Adresa11", '1998-12-31', "Sremski Karlovci", "Srbija", "mici98@mejl.com", 21100, '063/1278546','ASSOCIATE', 12);
insert into professor(firstname, lastname,address,birthdate, city, country,email, zip, phone, role, user_rel)values("Darko", "Leric","Adresa12", '1996-09-05', "Backi Breg", "Srbija", "darkoleric@mejl.com", 25275, '063/1278946','DEMONSTRATOR', 13);

---course---
insert into course(name, espb, semester, deleted) values ('Osnove programiranja', 6, 'WINTER',0);
insert into course(name, espb, semester, deleted) values ('Osnove softverskih arhitektura', 4, 'WINTER',0);
insert into course(name, espb, semester, deleted) values ('Razvoj softvera', 5, 'WINTER',0);
insert into course(name, espb, semester, deleted) values ('Informaciona bezbednost', 6, 'SUMMER',0);
insert into course(name, espb, semester, deleted) values ('Sistemi e-obrazovanja', 6, 'SUMMER',0);
insert into course(name, espb, semester, deleted) values ('Poslovna informatika', 5, 'SUMMER',0);

---course_professor---
insert into course_professor(course_id,professor_id)values(1,1);
insert into course_professor(course_id,professor_id)values(1,4);
insert into course_professor(course_id,professor_id)values(2,2);
insert into course_professor(course_id,professor_id)values(2,3);
insert into course_professor(course_id,professor_id)values(3,1);
insert into course_professor(course_id,professor_id)values(3,6);
insert into course_professor(course_id,professor_id)values(4,2);
insert into course_professor(course_id,professor_id)values(4,5);
insert into course_professor(course_id,professor_id)values(5,2);
insert into course_professor(course_id,professor_id)values(5,5);
insert into course_professor(course_id,professor_id)values(5,6);
insert into course_professor(course_id,professor_id)values(6,2);
insert into course_professor(course_id,professor_id)values(6,4);

---course_attendance---
insert into course_attendance (course_id,student_id)values(1,1);
insert into course_attendance (course_id,student_id)values(1,4);
insert into course_attendance (course_id,student_id)values(1,6);
insert into course_attendance (course_id,student_id)values(2,3);
insert into course_attendance (course_id,student_id)values(2,2);
insert into course_attendance (course_id,student_id)values(3,6);
insert into course_attendance (course_id,student_id)values(3,5);
insert into course_attendance (course_id,student_id)values(3,4);
insert into course_attendance (course_id,student_id)values(3,1);
insert into course_attendance (course_id,student_id)values(4,1);
insert into course_attendance (course_id,student_id)values(4,3);
insert into course_attendance (course_id,student_id)values(4,2);
insert into course_attendance (course_id,student_id)values(5,2);
insert into course_attendance (course_id,student_id)values(5,3);
insert into course_attendance (course_id,student_id)values(5,1);
insert into course_attendance (course_id,student_id)values(6,4);
insert into course_attendance (course_id,student_id)values(6,6);

---exam---
--insert into exam (date, points, assignment, course_id, exam_period_id) values ('2018-12-12', 65, 'assignment1', 1, 1);
--insert into exam (date, points, assignment, course_id, exam_period_id) values ('2018-12-12', 35, 'assignment2', 1, 2);
--insert into exam (date, points, assignment, course_id, exam_period_id) values ('2018-12-12', 100, 'assignment3', 2, 2);
--insert into exam (date, points, assignment, course_id, exam_period_id) values ('2018-12-12', 85, 'assignment4', 6, 3);
insert into exam(assignment,date,points,course_id,exam_period_id)values('assignment1','2021-02-02',65,1,1);
insert into exam(assignment,date,points,course_id,exam_period_id)values('assignment2','2021-02-18',35,1,2);
insert into exam(assignment,date,points,course_id,exam_period_id)values('assignment3','2021-02-16',100,2,2);
insert into exam(assignment,date,points,course_id,exam_period_id)values('assignment4','2021-04-19',85,6,3);
insert into exam(assignment,date,points,course_id,exam_period_id)values('exam assignment osa','2021-04-21',100,2,3);
insert into exam(assignment,date,points,course_id,exam_period_id)values('exam 2','2021-07-09',35,3,5);
insert into exam(assignment,date,points,course_id,exam_period_id)values('exam 1','2021-06-25',65,3,4);
insert into exam(assignment,date,points,course_id,exam_period_id)values('assignm ','2021-04-16',100,4,3);
insert into exam(assignment,date,points,course_id,exam_period_id)values('sistems','2021-02-13',80,5,2);
insert into exam(assignment,date,points,course_id,exam_period_id)values('sistems2','2021-04-15',20,5,3);
insert into exam(assignment,date,points,course_id,exam_period_id)values('assignment5','2021-06-28',15,6,4);

---exam_taking---
insert into exam_taking(mark,points,exam_id,professor_id,student_id)values(7,66,1,1,1);
insert into exam_taking(mark,points,exam_id,professor_id,student_id)values(8,73,1,4,4);
insert into exam_taking(mark,points,exam_id,professor_id,student_id)values(8,88,2,4,6);
insert into exam_taking(mark,points,exam_id,professor_id,student_id)values(4,45,3,3,3);
insert into exam_taking(mark,points,exam_id,professor_id,student_id)values(8,75,3,2,2);
insert into exam_taking(mark,points,exam_id,professor_id,student_id)values(6,51,9,6,2);
insert into exam_taking(mark,points,exam_id,professor_id,student_id)values(9,88,9,5,1);
insert into exam_taking(mark,points,exam_id,professor_id,student_id)values(6,55,9,6,3);
insert into exam_taking(mark,points,exam_id,professor_id,student_id)values(8,75,10,2,2);
insert into exam_taking(mark,points,exam_id,professor_id,student_id)values(7,66,10,2,3);

---exam_period---
insert into exam_period(name, start_date, end_date)values('januarski rok', '2021-01-22', '2021-02-02');
insert into exam_period(name, start_date, end_date)values('februarski rok', '2021-02-10', '2021-02-22');
insert into exam_period(name, start_date, end_date)values('aprilski rok', '2021-04-15', '2021-04-25');
insert into exam_period(name, start_date, end_date)values('junski rok', '2021-06-22', '2021-07-05');
insert into exam_period(name, start_date, end_date)values('julski rok', '2021-07-07', '2021-07-18');
insert into exam_period(name, start_date, end_date)values('septembarski rok', '2021-08-22', '2021-09-10');

---payment---
insert into payment(account_number,address,amount,city,date,deleted,model,name,payment_code,purpose,reference,student_id) values (1567456, 'adress1', 520, 'Ue', '2018-12-12', false, 15, 'name', 5, 'purpose', 556, 1);
insert into payment(account_number, address, amount, city, date, deleted, model, name, payment_code, purpose, reference, student_id) values (123456, 'address', 560, 'UE', '2018-12-12', false, 5, 'name1', 456, 'uplata', 36, 1);

---file---
