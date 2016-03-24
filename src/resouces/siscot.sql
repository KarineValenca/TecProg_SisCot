drop table Products;
drop table Providers;
drop table Managers;
drop table Quotation_Product_Provider;
drop table Quotation; 

create table Products(

	id INT UNSIGNED PRIMARY KEY  AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	price double,
	provider VARCHAR(100)
);

create table Providers( 

	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, 
	cnpj VARCHAR(14) NOT NULL, 
	nome VARCHAR(100) NOT NULL, 
	email VARCHAR(100), 
	senha VARCHAR(100) NOT NULL, 
	ddd INT UNSIGNED, 
	telefone INT UNSIGNED, 
	endereco VARCHAR(100), 
	cidade VARCHAR(100), 
	estado VARCHAR(100), 
	cep INT UNSIGNED,
	authorized boolean not null
);

create table Managers(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(15) NOT NULL,
	password VARCHAR(8) NOT NULL
);

create table Quotation(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	managerName VARCHAR(30) NOT NULL,
	quotationDate DATE NOT NULL,
	quotationIsOn boolean NOT NULL
);

create table Quotation_Product_Provider(
	quotationID INT UNSIGNED NOT NULL,
	productName VARCHAR(100) NOT NULL,
    providerName VARCHAR(100),
    priceProduct DOUBLE 
);

ALTER TABLE Quotation_Product_Provider ADD FOREIGN KEY(quotationID) REFERENCES Quotation (id);

insert into Products (nome) values ("Arroz");
insert into Providers (cnpj, nome, email,  senha, ddd, telefone, endereco, cidade, estado, cep, authorized) values ("12343456", "Atacadao", "email@hotmail.com", "password", 61, 3045, "Asa Sul", "Brasilia", "DF", 76420, true);
insert into Managers (username, password) values ("gerente", "password");