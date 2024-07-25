# Banco sangue backend


This project was generated with SDK verion 11
using intelij to work with java

If you want to use Visual Studio Code to run the project, you need to install this extentions:
![image](https://github.com/ViitorSG/citel-spring/assets/89858196/93d5bfdd-ffe4-4874-84ec-29820c5b84fd)
![image](https://github.com/ViitorSG/citel-spring/assets/89858196/72997ebe-0eae-4b5e-bdb4-c84163aad128)
![image](https://github.com/ViitorSG/citel-spring/assets/89858196/fc82324d-3161-4f8c-87bd-83b118013da5)
![image](https://github.com/ViitorSG/citel-spring/assets/89858196/7ea7b750-65f4-4dda-994b-ad39b260e774)


# Create the DB

run create database citel_software_db;

run use citel_software_db;

run CREATE TABLE candidate (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf CHAR(14) NOT NULL UNIQUE,
    rg CHAR(12) NOT NULL UNIQUE,
    data_nasc DATE NOT NULL,
    sexo CHAR(9) NOT NULL,
    mae VARCHAR(100),
    pai VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    cep CHAR(9) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    numero INT NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado CHAR(2) NOT NULL,
    telefone_fixo CHAR(14),
    celular CHAR(15),
    altura DECIMAL(3, 2) NOT NULL,
    peso DECIMAL(5, 2) NOT NULL,
    tipo_sanguineo CHAR(3) NOT NULL
);
