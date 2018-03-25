
CREATE DATABASE Bebidas;

USE Bebidas;

CREATE TABLE tipo_bebidas
(
  codigo INTEGER NOT NULL AUTO_INCREMENT,
  bebida VARCHAR(40) NOT NULL,
  materiaPrima VARCHAR(100) NOT NULL,
  tradicionalidade VARCHAR(30) NOT NULL,
  teorAlcoolico VARCHAR(30) NOT NULL,
  PRIMARY KEY (codigo)
);
