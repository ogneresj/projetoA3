CREATE DATABASE db_projeto;
USE db_projeto;

ALTER TABLE tb_usuarios ADD COLUMN interesses VARCHAR(255);

CREATE TABLE tb_usuarios (
	id int primary key auto_increment,
    nome VARCHAR(50) NOT NULL,
    idade int,
    tipoUsuario boolean NOT NULL,
    password VARCHAR(60) NOT NULL,
    interesses VARCHAR(255)
);

CREATE TABLE tb_recursos (
	id int primary key auto_increment,
    titulo varchar(50) NOT NULL,
    autor varchar(50) NOT NULL,
    categoria varchar(50) NOT NULL,
    url varchar(100),
    anotacoes varchar(500)
);

SELECT * FROM tb_usuarios;
SELECT * FROM tb_recursos;

DROP TABLE tb_usuarios;
DROP TABLE tb_recursos;