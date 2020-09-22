CREATE TABLE imobiliario.usuarios (
	id serial NOT NULL,
	email varchar(500) NOT NULL,
	nome varchar(1000) NOT NULL,
	senha varchar NOT NULL,
	CONSTRAINT usuarios_pk PRIMARY KEY (id)
);

CREATE TABLE imobiliario.cadastro_imobiliario (
	id serial NOT NULL,
	cep varchar(8) NOT NULL,
	endereco varchar(1000) NULL,
	complemento varchar(1000) NULL,
	id_tipo_logradouro int4 NULL,
	numero varchar(100) NULL,
	bairro varchar(500) NULL,
	cidade varchar NULL,
	id_unidade_federativa int4 NULL,
	id_usuario int4 NULL,
	CONSTRAINT cadastro_imobiliario_pk PRIMARY KEY (id)
);

ALTER TABLE imobiliario.cadastro_imobiliario ADD CONSTRAINT cadastro_imobiliario_tipo_logradouro_fk FOREIGN KEY (id_tipo_logradouro) REFERENCES imobiliario.tipo_logradouro(id);
ALTER TABLE imobiliario.cadastro_imobiliario ADD CONSTRAINT unidade_federativa_fk FOREIGN KEY (id_unidade_federativa) REFERENCES imobiliario.unidade_federativa(id);
ALTER TABLE imobiliario.cadastro_imobiliario ADD CONSTRAINT usuario_fk FOREIGN KEY (id_usuario) REFERENCES imobiliario.usuarios(id);

CREATE TABLE imobiliario.tipo_logradouro (
	id serial NOT NULL,
	descricao varchar(200) NOT NULL,
	CONSTRAINT tipo_logradouro_pk PRIMARY KEY (id)
);

CREATE TABLE unidade_federativa (
	id serial NOT NULL,
	nome varchar(100) NOT null,
	sigla char(2),
	CONSTRAINT unidade_federativa_pk PRIMARY KEY (id)
);

CREATE TABLE imobiliario.documentos_cadastro_imobiliario (
	id serial NOT NULL,
	documento bytea NULL,
	nome varchar(500) NULL,
	content_type varchar(100) NULL,
	extensao varchar(50) null,
	id_cadastro_imobiliario int4 NULL,
	CONSTRAINT documentos_cadastro_imobiliario_pk PRIMARY KEY (id)
);

INSERT INTO unidade_federativa VALUES (1, 'Acre', 'AC');
INSERT INTO unidade_federativa VALUES (2, 'Alagoas', 'AL');
INSERT INTO unidade_federativa VALUES (3, 'Amazonas', 'AM');
INSERT INTO unidade_federativa VALUES (4, 'Amapá', 'AP');
INSERT INTO unidade_federativa VALUES (5, 'Bahia', 'BA');
INSERT INTO unidade_federativa VALUES (6, 'Ceará', 'CE');
INSERT INTO unidade_federativa VALUES (7, 'Distrito Federal', 'DF');
INSERT INTO unidade_federativa VALUES (8, 'Espirito Santo', 'ES');
INSERT INTO unidade_federativa VALUES (9, 'Goiás', 'GO');
INSERT INTO unidade_federativa VALUES (10, 'Maranhão', 'MA');
INSERT INTO unidade_federativa VALUES (11, 'Minas Gerais', 'MG');
INSERT INTO unidade_federativa VALUES (12, 'Mato Grosso do Sul', 'MS');
INSERT INTO unidade_federativa VALUES (13, 'Mato Grosso', 'MT');
INSERT INTO unidade_federativa VALUES (14, 'Pará', 'PA');
INSERT INTO unidade_federativa VALUES (15, 'Paraíba', 'PB');
INSERT INTO unidade_federativa VALUES (16, 'Pernambuco', 'PE');
INSERT INTO unidade_federativa VALUES (17, 'Piauí', 'PI');
INSERT INTO unidade_federativa VALUES (18, 'Paraná', 'PR');
INSERT INTO unidade_federativa VALUES (19, 'Rio de Janeiro', 'RJ');
INSERT INTO unidade_federativa VALUES (20, 'Rio Grande do Norte', 'RN');
INSERT INTO unidade_federativa VALUES (21, 'Rondônia', 'RO');
INSERT INTO unidade_federativa VALUES (22, 'Roraima', 'RR');
INSERT INTO unidade_federativa VALUES (23, 'Rio Grande do Sul', 'RS');
INSERT INTO unidade_federativa VALUES (24, 'Santa Catarina', 'SC');
INSERT INTO unidade_federativa VALUES (25, 'Sergipe', 'SE');
INSERT INTO unidade_federativa VALUES (26, 'São Paulo', 'SP');
INSERT INTO unidade_federativa VALUES (27, 'Tocantins', 'TO');

INSERT INTO imobiliario.tipo_logradouro (descricao) VALUES('Avenida');
INSERT INTO imobiliario.tipo_logradouro (descricao) VALUES('Beco');
INSERT INTO imobiliario.tipo_logradouro (descricao) VALUES('Comunidade');
INSERT INTO imobiliario.tipo_logradouro (descricao) VALUES('Condomínio');
INSERT INTO imobiliario.tipo_logradouro (descricao) VALUES('Lote');
INSERT INTO imobiliario.tipo_logradouro (descricao) VALUES('Morro');
INSERT INTO imobiliario.tipo_logradouro (descricao) VALUES('Praça');
INSERT INTO imobiliario.tipo_logradouro (descricao) VALUES('Ponte');
INSERT INTO imobiliario.tipo_logradouro (descricao) VALUES('Rua');
INSERT INTO imobiliario.tipo_logradouro (descricao) VALUES('Rodovia');
INSERT INTO imobiliario.tipo_logradouro (descricao) VALUES('Sitio');
INSERT INTO imobiliario.tipo_logradouro (descricao) VALUES('Via Litorânea');
INSERT INTO imobiliario.tipo_logradouro (descricao) VALUES('Via de Pedestre');


INSERT INTO imobiliario.usuarios (email,nome,senha) VALUES
('teste@teste.com','teste','$2a$10$WnI.b3wMWnVtuQlwgG95S.bSm.ZK3mHxTZDNkLYbIql5wujEuCe66');
INSERT INTO imobiliario.cadastro_imobiliario (endereco,cep,complemento,id_tipo_logradouro,numero,bairro,cidade,id_unidade_federativa,id_usuario) VALUES ('179-7205 Ante Rd.','2028055','Kay Meyer',1,54,'neque sed dictum','Cusco',26,1)