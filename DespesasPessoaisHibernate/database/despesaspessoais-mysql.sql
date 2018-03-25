
CREATE DATABASE DespesasPessoais;

USE DespesasPessoais;

CREATE TABLE despesas
(
  codigo INTEGER NOT NULL AUTO_INCREMENT,
  categoria VARCHAR(40) NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  valor DECIMAL(10,2) NOT NULL,
  data_pagamento DATE NOT NULL,
  PRIMARY KEY (codigo)
);
