CREATE DATABASE db_projeto;
USE db_projeto;

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

INSERT INTO tb_usuarios (nome, idade, tipoUsuario, password, interesses) values ('admin', 0, 1, '$2a$10$syj4euCwTY.MyiSAQEINveL2CllKqTkI.N9Yxa/UZphE7kAEtnJki', null);
INSERT INTO tb_usuarios (nome, idade, tipoUsuario, password, interesses) values ('usuario', 0, 0, '$2a$10$ene.D7OqoAGT82x2slxw6O1EWnxLKlpcv5VAjf/7BVTUWRCpJ0Q8W', 'IA Responsável, Cibersegurança');

INSERT INTO tb_recursos (titulo, autor, categoria, url, anotacoes) values ('Auditoria Automática de Modelos de IA', 'MIT Media Lab', 'IA Responsável', 'https://responsible-ai.mit.edu/audit', 'Ferramenta e guia sobre como auditar modelos de IA para detectar vieses. Inclui métricas de fairness e exemplos práticos. Pode ser usada em projetos acadêmicos e aplicações reais.');
INSERT INTO tb_recursos (titulo, autor, categoria, url, anotacoes) values ('Fundamentos de Privacidade Digital para Usuários', 'EFF (Electronic Frontier Foundation)', 'Privacidade & Ética Digital', 'https://ssd.eff.org', 'Guia completo sobre proteção de dados pessoais. Ensina boas práticas para senhas, rastreamento e segurança de contas. Ótimo para estudos de LGPD e temas relacionados a ética digital.');

SELECT * FROM tb_usuarios;
SELECT * FROM tb_recursos;
