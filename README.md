# CitelSpring

This project was generated with SDK verion 11
using intelij to work with java

# Downloading the mvn
To install Maven, follow these steps:

Check System Requirements: Before installing Maven, ensure that your system meets the minimum requirements. Maven requires the Java Development Kit (JDK) to be installed. Make sure you have JDK installed on your machine.

Download Maven: Visit the official Apache Maven website at https://maven.apache.org/download.cgi and download the latest version of Maven. Choose the binary file, typically available in zip or tar.gz format.

Extract the File: After downloading, extract the file to a location of your choice on your file system.

Configure Environment Variables: Add the Maven bin directory to your system's PATH. This allows you to run Maven from any directory in the terminal or command prompt.

On Windows:
Open Control Panel.
Click on "System and Security" and then "System."
Click on "Advanced system settings" on the left panel.
In the System Properties window, click on "Environment Variables."
In the "System Variables" section, find the PATH variable and click "Edit."
Add the path to the Maven bin directory (for example, C:\path\to\apache-maven-3.8.5\bin) to the end of the PATH variable's value, separated by a semicolon.
Click "OK" in all windows to save the changes.

Verify the Installation: After installation, open a new terminal or command prompt and run the following commands to verify that Maven is installed correctly: mvn -version

# Downloading the libs

Run mvn clean install to dowload the libs that i used for codding

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
