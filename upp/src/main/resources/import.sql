insert into user(id, city, email, lastname, firstname, password, country, role, username) values ('1','Novi Sad','marica50@ptt.yu','Zoric','Marica','$2a$10$2HnklNkNwAtdVNZKs8.Hx.fH3.eGbiXSFkTjz736OCTrmjxgFhy/S','Srbija','author','maricaZoric');
insert into user(id, city, email, lastname, firstname, password, country, role, username) values ('2','Novi Sad','a','a','a','$10$v9hM/bSo3FrE6Q2sOri6uOHEbmsHpwzXffuKRF22uTMG1UCBGJRD.','Srbija','author','a');

#--SCIENTIFIC FIELDS
insert into scientific_field(id, name) values ('1', 'Information Technology');
insert into scientific_field(id, name) values ('2', 'Electrical Engineering');
insert into scientific_field(id, name) values ('3', 'Civil Engineering');
insert into scientific_field(id, name) values ('4', 'Mechanical Engineering');
insert into scientific_field(id, name) values ('5', 'Physics');
insert into scientific_field(id, name) values ('6', 'Mathemathics');
insert into scientific_field(id, name) values ('7', 'Chemistry');
insert into scientific_field(id, name) values ('8', 'Biology');
insert into scientific_field(id, name) values ('9', 'Geography');
insert into scientific_field(id, name) values ('10', 'Medicine');

#--MAGAZINES
insert into magazine(id, issn, name, scientific_fields_id, price) values ('1','1234-4321','Engineering Monthly', '1', '0.00');
insert into magazine(id, issn, name, scientific_fields_id, price) values ('2','4321-1234','This Month in Physics and Maths', '2', '0.00');

#--MAGAZINE_FIELDS
# insert into magazine_fields(mag_id, field_id) values ('1','2');
# insert into magazine_fields(mag_id, field_id) values ('1','3');
# insert into magazine_fields(mag_id, field_id) values ('1','4');
#
# insert into magazine_fields(mag_id, field_id) values ('2','5');
#insert into magazine_fields(mag_id, field_id) values ('2','6');

#--SCIENCE PAPERS
insert into science_paper(id, name, keywords, abbstract, scientific_field_id, science_magazine_id) values ('1','A thermodynamic framework for the modeling of crystallizable triple shape memory polymers','thermodynamic,modeling,polymers','Triple shape memory polymers (TSMPs) can be programed to remember and switch be- tween three distinct shapes with the use of external stimuli','2','1');
insert into science_paper(id, name, keywords, abbstract, scientific_field_id, science_magazine_id) values ('2','Theoretical framework for percolation threshold, tortuosity and transport properties of porous materials containing 3D non-spherical pores','percolation,tortuosity,transport,3D,pores','Understanding the effects of porous network characteristics including the percolation and tortuosity on transport properties of porous materials is of great importance for the design and optimization of such materials','2','1');
insert into science_paper(id, name, keywords, abbstract, scientific_field_id, science_magazine_id) values ('3','Finalised Marketing','engineering,merketing,instructions','The information in this publication may be reproduced to support SQA qualifications only on a non-commercial basis. If it is reproduced, SQA should be clearly acknowledged as the source.','2','1');
insert into science_paper(id, name, keywords, abbstract, scientific_field_id, science_magazine_id) values ('4','Physical pendulum experiment re-investigated with an accelerometer','pendulum,accelerometer,sensor','The physical pendulum experiment is the typicalone to introduce the physics of oscillating systems.','5','2');



