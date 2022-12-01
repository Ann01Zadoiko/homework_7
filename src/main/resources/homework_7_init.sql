create table developers
(
	id serial PRIMARY key,
	name_developer VARCHAR(25) not NULL,
	age int not null,
	salary int not null
);

create table skills
(
	id serial primary key,
	programming_language VARCHAR(10) not null,
	skill_level VARCHAR(10) not null
);

create table companies(
	id serial primary key,
	name_company VARCHAR(25) not null,
	country VARCHAR(25) not null
);

create table customers
(
	id serial PRIMARY key,
	name_customer VARCHAR(25) not null,
	country VARCHAR(25) not null
);

create table projects
(
	id serial primary key,
	name_project VARCHAR(25) not null,
	cost int not null,
	date_of_creation date not null
);

create table developer_projects
(
	id_developer int NOT NULL,
    id_project int NOT NULL,
	foreign key (id_developer) references developers (id),
	FOREIGN key (id_project) REFERENCES projects (id)
);

create table developer_skills
(
	id_skill int NOT NULL,
	id_developer int NOT NULL,
	FOREIGN key (id_skill) REFERENCES skills (id),
	foreign key (id_developer) references developers (id)
);

CREATE TABLE companies_projects(
	id_company INT NOT NULL,
    id_project INT NOT NULL,
    FOREIGN KEY (id_company) REFERENCES companies (id),
    FOREIGN KEY (id_project) REFERENCES projects (id)
);

CREATE TABLE customers_projects(
	id_customer INT NOT NULL,
    id_project INT NOT NULL,
    FOREIGN KEY (id_customer) REFERENCES customers (id),
    FOREIGN KEY (id_project) REFERENCES projects (id)
);