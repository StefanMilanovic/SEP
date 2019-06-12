#editori #password e
insert into user(id, city, email, lastname, firstname, password, country, role, username) values ('1','Sid','a','admin','admin','$2a$10$BQRyiN/k2eUCQWxPL3htkesrDAVw/11wuxFG4zv5Evp/0l9jMU2ay','Srbija','EDITOR','admin');
insert into user(id, city, email, lastname, firstname, password, country, role, username) values ('2','Sid','a1','admin1','admin1','$2a$10$BQRyiN/k2eUCQWxPL3htkesrDAVw/11wuxFG4zv5Evp/0l9jMU2ay','Srbija','EDITOR','admin1');
insert into user(id, city, email, lastname, firstname, password, country, role, username) values ('10','Sid','a2','admin2','admin2','$2a$10$BQRyiN/k2eUCQWxPL3htkesrDAVw/11wuxFG4zv5Evp/0l9jMU2ay','Srbija','EDITOR','admin2');

#autori
insert into user(id, city, email, lastname, firstname, password, country, role, username) values ('3','Sid','k','korisnik','korisnik','$2a$10$BQRyiN/k2eUCQWxPL3htkesrDAVw/11wuxFG4zv5Evp/0l9jMU2ay','Srbija','USER','korisnik');
insert into user(id, city, email, lastname, firstname, password, country, role, username) values ('11','Sid','k1','korisnik1','korisnik1','$2a$10$BQRyiN/k2eUCQWxPL3htkesrDAVw/11wuxFG4zv5Evp/0l9jMU2ay','Srbija','USER','korisnik1');

#sekundarni editori
insert into user(id, city, email, lastname, firstname, password, country, role, username) values ('12','Sid','e','editor','editor','$2a$10$BQRyiN/k2eUCQWxPL3htkesrDAVw/11wuxFG4zv5Evp/0l9jMU2ay','Srbija','SECEDITOR','editor');
insert into user(id, city, email, lastname, firstname, password, country, role, username) values ('13','Sid','e1','editor1','editor1','$2a$10$BQRyiN/k2eUCQWxPL3htkesrDAVw/11wuxFG4zv5Evp/0l9jMU2ay','Srbija','SECEDITOR','editor1');



#recenzenti
insert into user(id, city, email, lastname, firstname, password, country, role, username, reviewer_magazine_id) values ('4','Sid','r','recenzent','recenzent','$2a$10$BQRyiN/k2eUCQWxPL3htkesrDAVw/11wuxFG4zv5Evp/0l9jMU2ay','Srbija','REVIEWER','recenzent', '1');
insert into user(id, city, email, lastname, firstname, password, country, role, username, reviewer_magazine_id) values ('5','Sid','r1','recenzent1','recenzent1','$2a$10$BQRyiN/k2eUCQWxPL3htkesrDAVw/11wuxFG4zv5Evp/0l9jMU2ay','Srbija','REVIEWER','recenzent1', '1');
insert into user(id, city, email, lastname, firstname, password, country, role, username, reviewer_magazine_id) values ('6','Sid','r2','recenzent2','recenzent2','$2a$10$BQRyiN/k2eUCQWxPL3htkesrDAVw/11wuxFG4zv5Evp/0l9jMU2ay','Srbija','REVIEWER','recenzent2','2');
insert into user(id, city, email, lastname, firstname, password, country, role, username, reviewer_magazine_id) values ('7','Sid','r3','recenzent3','recenzent3','$2a$10$BQRyiN/k2eUCQWxPL3htkesrDAVw/11wuxFG4zv5Evp/0l9jMU2ay','Srbija','REVIEWER','recenzent3', '2');

# $2y$12$QiNu1WMxQxzn.xzce8FKCOu8LXaaQB.wZVNW/uxrrs1tg9QpJ9Oaa
# $2a$10$BQRyiN/k2eUCQWxPL3htkesrDAVw/11wuxFG4zv5Evp/0l9jMU2ay
#--SCIENTIFIC FIELDS
insert into scientific_field(id, name) values ('1', 'IT');
insert into scientific_field(id, name) values ('2', 'Elektrotehnika');
insert into scientific_field(id, name) values ('3', 'Gradjevina');
insert into scientific_field(id, name) values ('4', 'Masinstvo');
insert into scientific_field(id, name) values ('5', 'Fizika');
insert into scientific_field(id, name) values ('6', 'Matematika');
insert into scientific_field(id, name) values ('7', 'Hemija');
insert into scientific_field(id, name) values ('8', 'Biologija');
insert into scientific_field(id, name) values ('9', 'Geografija');
insert into scientific_field(id, name) values ('10', 'Medicina');

#--USER SCIENTIFIC FIELD
insert into user_scientific_field(user_id, scientific_field_id) values (12, 1);
insert into user_scientific_field(user_id, scientific_field_id) values (13, 2);

#--MAGAZINES
insert into magazine(id, issn, name, scientific_fields_id, price, editor_id) values ('1','1234-4321','Casopis1', '1', '0.00','1');
insert into magazine(id, issn, name, scientific_fields_id, price, editor_id) values ('2','4321-1234','Casopis2', '2', '0.00','2');

#--MAGAZINE_FIELDS
# insert into magazine_fields(mag_id, field_id) values ('1','2');
# insert into magazine_fields(mag_id, field_id) values ('1','3');
# insert into magazine_fields(mag_id, field_id) values ('1','4');
#
# insert into magazine_fields(mag_id, field_id) values ('2','5');
#insert into magazine_fields(mag_id, field_id) values ('2','6');

#--SCIENCE PAPERS
# --insert into science_paper(id, name, keywords, abbstract, scientific_field_id, science_magazine_id) values ('1','A thermodynamic framework for the modeling of crystallizable triple shape memory polymers','thermodynamic,modeling,polymers','Triple shape memory polymers (TSMPs) can be programed to remember and switch be- tween three distinct shapes with the use of external stimuli','2','1');
# --insert into science_paper(id, name, keywords, abbstract, scientific_field_id, science_magazine_id) values ('2','Theoretical framework for percolation threshold, tortuosity and transport properties of porous materials containing 3D non-spherical pores','percolation,tortuosity,transport,3D,pores','Understanding the effects of porous network characteristics including the percolation and tortuosity on transport properties of porous materials is of great importance for the design and optimization of such materials','2','1');
# --insert into science_paper(id, name, keywords, abbstract, scientific_field_id, science_magazine_id) values ('3','Finalised Marketing','engineering,merketing,instructions','The information in this publication may be reproduced to support SQA qualifications only on a non-commercial basis. If it is reproduced, SQA should be clearly acknowledged as the source.','2','1');
# --insert into science_paper(id, name, keywords, abbstract, scientific_field_id, science_magazine_id) values ('4','Physical pendulum experiment re-investigated with an accelerometer','pendulum,accelerometer,sensor','The physical pendulum experiment is the typicalone to introduce the physics of oscillating systems.','5','2');
#
#

