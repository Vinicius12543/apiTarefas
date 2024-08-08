CREATE DATABASE bd_apiTarefas;
USE bd_apiTarefas;
CREATE TABLE categoria(
	id 		INTEGER			AUTO_INCREMENT,
    nome	VARCHAR(50)		NOT NULL,
    PRIMARY KEY(id)
);

CREATE table tarefa(
	id					INTEGER			AUTO_INCREMENT,
	nome				VARCHAR(50)		NOT NULL,
    data				DATE			NOT NULL,
    descricao			VARCHAR(150)	NOT NULL,
    id_categoria		INTEGER			NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_categoria) REFERENCES categoria(id)
);