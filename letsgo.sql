CREATE DATABASE lestgo;

USE letsgo;

CREATE TABLE tbl_dadosFuncionario	     -- Dados do Funcionário
(
Func_CPF BIGINT(12) NOT NULL UNIQUE,
Senha VARCHAR(21) NOT NULL,
Foto VARCHAR(150), 
Nome VARCHAR(70) NOT NULL,
RG BIGINT(15),
Sexo VARCHAR(9) NOT NULL,
Data_Nascimento VARCHAR(10),
Telefone VARCHAR(15),
Celular VARCHAR(15) NOT NULL,
Email VARCHAR(50),
Cep VARCHAR(9) NOT NULL,
UF VARCHAR(2) NOT NULL,
Endereco VARCHAR(70) NOT NULL,
Bairro VARCHAR(30) NOT NULL,
Complemento VARCHAR(50),
Nivel TINYINT NOT NULL, -- Como se fosse campo Boolean 0 false, 1 true.			
Status TINYINT NOT NULL, -- Como se fosse campo Boolean 0 false, 1 true.
PRIMARY KEY (Func_CPF)
)
ENGINE = INNODB DEFAULT CHARSET = UTF8;

CREATE TABLE tbl_cliente	                      -- Dados Clientes
(
Cliente_CPF BIGINT(12) NOT NULL UNIQUE,
Nome VARCHAR(70) NOT NULL,
RG BIGINT(15),
Sexo VARCHAR(9) NOT NULL,
Data_Nascimento VARCHAR(10),
Telefone VARCHAR(15),
Celular VARCHAR(15) NOT NULL,
Email VARCHAR(50),
Cep VARCHAR(9) NOT NULL,
UF VARCHAR(2) NOT NULL,
Endereco VARCHAR(70) NOT NULL,
Bairro VARCHAR(30) NOT NULL,
Complemento VARCHAR(50),
Status TINYINT NOT NULL, -- Como se fosse campo Boolean 0 false, 1 true.
PRIMARY KEY (Cliente_CPF)
)
ENGINE = INNODB DEFAULT CHARSET = UTF8;

CREATE TABLE tbl_administrativoFuncionario         -- Dados Financeiro
(
Cod_adm INT(6) NOT NULL UNIQUE AUTO_INCREMENT,
Cargo_Funcionario VARCHAR(50) NOT NULL,
Salario_Funcionario VARCHAR(20) NOT NULL,
Admissao_Data VARCHAR(10) NOT NULL,
Demissao_Data VARCHAR(10),
Func_CPF BIGINT(12) NOT NULL,
PRIMARY KEY (Cod_adm), 
CONSTRAINT fkfuncionario_administrativo FOREIGN KEY (Func_CPF) 
REFERENCES tbl_dadosFuncionario (Func_CPF)
)
ENGINE = INNODB DEFAULT CHARSET = UTF8;

CREATE TABLE tbl_vestido                           -- Dados dos Vestidos
(
Cod_vest INT(4) NOT NULL UNIQUE AUTO_INCREMENT,
Vestido VARCHAR(150), 
Cor VARCHAR(15) NOT NULL,
Tamanho VARCHAR(2) NOT NULL,
Modelo VARCHAR(30),
Quantidade INT(4) NOT NULL,
Valor DOUBLE(8,2) NOT NULL,
PRIMARY KEY (Cod_vest)
)
ENGINE = INNODB DEFAULT CHARSET = UTF8;

CREATE TABLE tbl_locacao (
Cod_locacao INT(4) NOT NULL UNIQUE AUTO_INCREMENT,
Cliente_CPF BIGINT(12) NOT NULL,
Func_CPF BIGINT(12) NOT NULL,
Cod_vest INT(4) NOT NULL,
Locacao_Data VARCHAR(10) NOT NULL,
Devolucao_Data VARCHAR(10),
Valor_Total DOUBLE(8,2),

FOREIGN KEY(Cliente_CPF) REFERENCES tbl_cliente(Cliente_CPF) ON DELETE NO ACTION ON UPDATE NO ACTION,  
FOREIGN KEY(Func_CPF) REFERENCES tbl_dadosFuncionario(Func_CPF) ON DELETE NO ACTION ON UPDATE NO ACTION,
FOREIGN KEY(Cod_vest) REFERENCES tbl_vestido(Cod_vest) ON DELETE NO ACTION ON UPDATE NO ACTION 
)
ENGINE = INNODB DEFAULT CHARSET = UTF8;


INSERT INTO `letsgo`.`tbl_dadosFuncionario` (`Func_CPF`, `Senha`, `Foto`, `Nome`, `RG`, `Sexo`, `Data_Nascimento`, `Telefone`, `Celular`, `Email`, `Cep`, `UF`, `Endereco`, `Bairro`, `Complemento`, `Nivel`, `Status`) VALUES ('051', '123', NULL, 'fernando', '89', 'Masculino', NULL, NULL, '85496889', NULL, '72318031', 'DF', 'Qr', 'samambaia', NULL, '1', '1');
