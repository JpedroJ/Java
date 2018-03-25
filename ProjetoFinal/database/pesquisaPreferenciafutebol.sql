
CREATE DATABASE PesquisaPreferenciaFutebol;

USE PesquisaPreferenciaFutebol;

CREATE TABLE pesquisas
(
  codigo INTEGER NOT NULL AUTO_INCREMENT,
  data_pesquisa TIMESTAMP NOT NULL,
  PRIMARY KEY (codigo)
);

CREATE TABLE entrevistados(
 codigo INTEGER NOT NULL AUTO_INCREMENT,
 idade INTEGER NOT NULL,
 genero VARCHAR(20) NOT NULL,
 time_coracao VARCHAR (20)NOT NULL,
 codigo_pesquisa INTEGER NOT NULL,
 PRIMARY KEY (codigo),
 FOREIGN KEY (codigo_pesquisa) REFERENCES pesquisas(codigo) ON DELETE CASCADE
);
