CREATE DATABASE lestgo;

USE letsgo;

CREATE TABLE tbl_dadosFuncionario	     -- Dados do Funcionário
(
CPF INT(11) NOT NULL UNIQUE,
Foto BLOB, -- Salva em byte qualquer arquivo.
Nome VARCHAR(70) NOT NULL,
RG INT(15),
Sexo VARCHAR(9) NOT NULL,
Data_Nascimento VARCHAR(10) NOT NULL,
Telefone VARCHAR(15),
Celular VARCHAR(15) NOT NULL,
Email VARCHAR(50) UNIQUE,
Cep VARCHAR(9) NOT NULL,
UF VARCHAR(2) NOT NULL,
Endereco VARCHAR(70) NOT NULL,
Bairro VARCHAR(30) NOT NULL,
Complemento VARCHAR(50),
Nivel TINYINT NOT NULL, -- Como se fosse campo Boolean 0 false, 1 true.			
Status TINYINT NOT NULL, -- Como se fosse campo Boolean 0 false, 1 true.
PRIMARY KEY (CPF)
)
ENGINE = INNODB DEFAULT CHARSET = UTF8;

CREATE TABLE tbl_cliente	                      -- Dados Clientes
(
CPF INT(11) NOT NULL UNIQUE,
Nome VARCHAR(70) NOT NULL,
RG INT(15),
Sexo VARCHAR(9) NOT NULL,
Data_Nascimento VARCHAR(10) NOT NULL,
Telefone VARCHAR(15),
Celular VARCHAR(15) NOT NULL,
Email VARCHAR(50) UNIQUE,
Cep VARCHAR(9) NOT NULL,
UF VARCHAR(2) NOT NULL,
Endereco VARCHAR(70) NOT NULL,
Bairro VARCHAR(30) NOT NULL,
Complemento VARCHAR(50),
Status TINYINT NOT NULL, -- Como se fosse campo Boolean 0 false, 1 true.
PRIMARY KEY (CPF)
)
ENGINE = INNODB DEFAULT CHARSET = UTF8;

CREATE TABLE tbl_administrativoFuncionario         -- Dados Financeiro
(
Cod_adm INT(6) NOT NULL UNIQUE AUTO_INCREMENT,
Cargo_Funcionario VARCHAR(50) NOT NULL,
Salario_Funcionario DOUBLE(8,2) NOT NULL,
Admissao_Data VARCHAR(10) NOT NULL,
Demissao_Data VARCHAR(10),
CPF INT(11) NOT NULL,
PRIMARY KEY (Cod_adm), 
CONSTRAINT fkfuncionario_administrativo FOREIGN KEY (CPF) 
REFERENCES tbl_dadosFuncionario (CPF)
)
ENGINE = INNODB DEFAULT CHARSET = UTF8;

CREATE TABLE tbl_loginFuncionario                  -- Dados Login Funcionário
(
Cod_login INT NOT NULL AUTO_INCREMENT,
Senha VARCHAR(20) NOT NULL,
CPF INT(11) NOT NULL,
PRIMARY KEY (Cod_login),
CONSTRAINT fkadministrativo_login FOREIGN KEY (CPF) 
REFERENCES tbl_dadosFuncionario (CPF)
)
ENGINE = INNODB DEFAULT CHARSET = UTF8;

CREATE TABLE tbl_vestido                           -- Dados dos Vestidos
(
Cod_vest INT NOT NULL AUTO_INCREMENT,
Vestido BLOB, -- Salva em byte qualquer arquivo.
Cor VARCHAR(15) NOT NULL,
Tamanho VARCHAR(2) NOT NULL,
Modelo VARCHAR(30),
Quantidade INT(4) NOT NULL,
CPF INT(11),
PRIMARY KEY (Cod_vest),
CONSTRAINT fk_vestido_funcionario FOREIGN KEY (CPF) 
REFERENCES tbl_dadosFuncionario (CPF)
)
ENGINE = INNODB DEFAULT CHARSET = UTF8;

