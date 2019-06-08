insert into user(id, city, email, lastname, firstname, password, country, role, username) values ('1','Novi Sad','stefan@gmail.com','Milanovic','Stefan','$2a$10$2HnklNkNwAtdVNZKs8.Hx.fH3.eGbiXSFkTjz736OCTrmjxgFhy/S','Srbija','author','stefan');
insert into user(id, city, email, lastname, firstname, password, country, role, username) values ('2','Novi Sad','a','a','a','$10$v9hM/bSo3FrE6Q2sOri6uOHEbmsHpwzXffuKRF22uTMG1UCBGJRD.','Srbija','author','a');

#--SCIENTIFIC FIELDS
insert into scientific_field(id, name) values ('1', 'Informacione Tehnologije');
insert into scientific_field(id, name) values ('2', 'Elektrotehnika');
insert into scientific_field(id, name) values ('3', 'Greadjevinarstvo');
insert into scientific_field(id, name) values ('4', 'Masinstvo');
insert into scientific_field(id, name) values ('5', 'Fizika');
insert into scientific_field(id, name) values ('6', 'Matematika');
insert into scientific_field(id, name) values ('7', 'Hemija');
insert into scientific_field(id, name) values ('8', 'Biologija');
insert into scientific_field(id, name) values ('9', 'Geografija');
insert into scientific_field(id, name) values ('10', 'Medicina');

#--MAGAZINES
insert into magazine(id, issn, name, scientific_fields_id, price) values ('1','1234-4321','Nauka', '1', '0.00');
insert into magazine(id, issn, name, scientific_fields_id, price) values ('2','4321-1234','Planeta', '2', '0.00');
insert into magazine(id, issn, name, scientific_fields_id, price) values ('3','3334-4321','Svet oko nas', '9', '0.00');
insert into magazine(id, issn, name, scientific_fields_id, price) values ('4','7334-4321','Beskonacnost', '6', '0.00');
#--MAGAZINE_FIELDS
# insert into magazine_fields(mag_id, field_id) values ('1','2');
# insert into magazine_fields(mag_id, field_id) values ('1','3');
# insert into magazine_fields(mag_id, field_id) values ('1','4');
#
# insert into magazine_fields(mag_id, field_id) values ('2','5');
#insert into magazine_fields(mag_id, field_id) values ('2','6');

#--SCIENCE PAPERS
--insert into science_paper(id, name, keywords, abbstract, scientific_field_id, science_magazine_id) values ('1','Polinomi i grupe i prstenoci','polinomi, grupe ','Uvod u grupe i prstenove, opis i funkcije polinoma','2','1');
--insert into science_paper(id, name, keywords, abbstract, scientific_field_id, science_magazine_id) values ('2','Teorija fizike','termodinamika, prelamanje, svetlost','Prelamanje svetlosti, teorija, fizika i uvod u termodinamiku','2','1');
--insert into science_paper(id, name, keywords, abbstract, scientific_field_id, science_magazine_id) values ('3','Ekonimija','ekonomija, marketing, poslovanje','Upravljanje marketinogm, uvod u ekonomiju, elektronsko poslovanje','2','1');
--insert into science_paper(id, name, keywords, abbstract, scientific_field_id, science_magazine_id) values ('4','Geografija i istorija','Prostor, geo, istorija, nauka','Gografija, istorija upoznavanje i osnovne analize','5','2');



