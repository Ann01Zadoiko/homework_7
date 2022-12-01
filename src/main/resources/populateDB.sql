insert into companies (id,name_company,country) values (1,'Cisco','Australia');
insert into companies (id,name_company,country) values (2,'Sherlock','Japan');

insert into customers(id,name_customer,country) values (1,'Mr. Park','South Korea');
insert into customers(id,name_customer,country) values (2,'Mr. Backer','New Zealand');

insert into projects(id,name_project,"cost", date_of_creation) values (1,'Robot Sofia',500000,'2013-03-08');
insert into projects(id,name_project,"cost", date_of_creation) values (2,'SpaceOf',450000, '2009-07-01');
insert into projects(id,name_project,"cost", date_of_creation) values (3,'Cyberpunk',94250, '2022-01-09');
insert into projects(id,name_project, "cost", date_of_creation) values (4,'Universe of Luidgy', 67800,'2019-10-10');

insert into developers(id,name_developer,age, salary) values (1,'Ms. Garcia',25,5000);
insert into developers(id,name_developer,age, salary) values (2,'Mr. Williams',36,6150);
insert into developers(id,name_developer,age, salary) values (3,'Mr. Walker',27,1593);
insert into developers(id,name_developer,age, salary) values (4,'Ms. Brown',38,7541);
insert into developers(id,name_developer,age, salary) values (5,'Ms. Harris',41,9541);
insert into developers(id,name_developer,age, salary) values (6,'Mr. Gomez',43,6512);

insert into skills(id,programming_language,skill_level) values (1,'Java','Senior');
insert into skills(id,programming_language,skill_level) values (2,'Java','Middle');
insert into skills(id,programming_language,skill_level) values (3,'C++','Junior');
insert into skills(id,programming_language,skill_level) values (4,'C++','Senior');
insert into skills(id,programming_language,skill_level) values (5,'JS','Middle');
insert into skills(id,programming_language,skill_level) values (6,'JS','Junior');

insert into developer_projects(id_developer,id_project) values (1,1);
insert into developer_projects(id_developer,id_project) values (1,3);
insert into developer_projects(id_developer,id_project) values (2,2);
insert into developer_projects(id_developer,id_project) values (2,4);
insert into developer_projects(id_developer,id_project) values (3,2);
insert into developer_projects(id_developer,id_project) values (3,3);
insert into developer_projects(id_developer,id_project) values (4,1);
insert into developer_projects(id_developer,id_project) values (4,4);
insert into developer_projects(id_developer,id_project) values (5,4);
insert into developer_projects(id_developer,id_project) values (5,3);
insert into developer_projects(id_developer,id_project) values (6,2);
insert into developer_projects(id_developer,id_project) values (6,1);

insert into developer_skills(id_developer,id_skill) values (1,1);
insert into developer_skills(id_developer,id_skill) values (1,3);
insert into developer_skills(id_developer,id_skill) values (2,2);
insert into developer_skills(id_developer,id_skill) values (2,6);
insert into developer_skills(id_developer,id_skill) values (3,5);
insert into developer_skills(id_developer,id_skill) values (3,4);
insert into developer_skills(id_developer,id_skill) values (4,1);
insert into developer_skills(id_developer,id_skill) values (4,6);
insert into developer_skills(id_developer,id_skill) values (5,2);
insert into developer_skills(id_developer,id_skill) values (5,3);
insert into developer_skills(id_developer,id_skill) values (6,2);
insert into developer_skills(id_developer,id_skill) values (6,5);

insert into companies_projects(id_company,id_project) VALUES (1,1);
insert into companies_projects(id_company,id_project) VALUES (1,2);
insert into companies_projects(id_company,id_project) VALUES (2,3);
insert into companies_projects(id_company,id_project) VALUES (2,4);

insert into customers_projects(id_customer,id_project) VALUES (1,1);
insert into customers_projects(id_customer,id_project) VALUES (1,2);
insert into customers_projects(id_customer,id_project) VALUES (2,3);
insert into customers_projects(id_customer,id_project) VALUES (2,4);