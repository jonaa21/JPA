DROP SCHEMA IF EXISTS jpa;
create schema IF NOT EXISTS jpa;

use jpa;

CREATE TABLE IF NOT EXISTS city (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  description VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
  );

CREATE TABLE IF NOT EXISTS employee (
  id INT NOT NULL AUTO_INCREMENT,
  firstname VARCHAR(45) NULL,
  lastname VARCHAR(45) NULL,
  PRIMARY KEY (id)
  );

CREATE TABLE IF NOT EXISTS adres (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
  );

  CREATE TABLE IF NOT EXISTS mc_donalds (
  id INT NOT NULL AUTO_INCREMENT,
  adres_fk INT NOT NULL,
  phone VARCHAR(45) NOT NULL,
  code VARCHAR(45) NOT NULL,
  city_fk INT NOT NULL,
  PRIMARY KEY (id)
  );

  CREATE TABLE IF NOT EXISTS emp_filiaal(
  id INT NOT NULL AUTO_INCREMENT,
  mc_donalds_id INT NOT NULL,
  employee_id INT NOT NULL,
  PRIMARY KEY (id)
  );

  ALTER TABLE mc_donalds
  ADD CONSTRAINT adres_fk FOREIGN KEY (adres_fk)
  REFERENCES adres(id),
  ADD CONSTRAINT city_fk
  FOREIGN KEY (city_fk)
  REFERENCES city(id);

  ALTER TABLE emp_filiaal
  ADD CONSTRAINT employee_fk FOREIGN KEY (employee_id)
  REFERENCES employee(id),
  ADD CONSTRAINT mcdonalds_fk FOREIGN KEY (mc_donalds_id)
  REFERENCES mc_donalds(id);

INSERT INTO `jpa`.`adres` (`name`) VALUES ('LallaRookhweg');
INSERT INTO `jpa`.`adres` (`name`) VALUES ('Keizerstraat');
INSERT INTO `jpa`.`adres` (`name`) VALUES ('Wayamboweg');
INSERT INTO `jpa`.`adres` (`name`) VALUES ('Noord');

INSERT INTO `jpa`.`city` (`name`, `description`) VALUES ('Paramaribo', 'Capital');
INSERT INTO `jpa`.`city` (`name`, `description`) VALUES ('Nickerie', 'North-West');
INSERT INTO `jpa`.`city` (`name`, `description`) VALUES ('Marowijne', 'North-East');
INSERT INTO `jpa`.`city` (`name`, `description`) VALUES ('Sipaliwini', 'South');

INSERT INTO `jpa`.`employee` (`firstname`, `lastname`) VALUES ('Jonathan', 'Oldnestam');
INSERT INTO `jpa`.`employee` (`firstname`, `lastname`) VALUES ('Mitchel', 'Pawirodinomo');
INSERT INTO `jpa`.`employee` (`firstname`, `lastname`) VALUES ('Romario', 'Dipopawiro');
INSERT INTO `jpa`.`employee` (`firstname`, `lastname`) VALUES ('John', 'Doe');

INSERT INTO `jpa`.`mc_donalds` (`adres_fk`, `phone`, `code`, `city_fk`) VALUES ('1', '12345678', '123', '1');
INSERT INTO `jpa`.`mc_donalds` (`adres_fk`, `phone`, `code`, `city_fk`) VALUES ('2', '45678912', '456', '3');
INSERT INTO `jpa`.`mc_donalds` (`adres_fk`, `phone`, `code`, `city_fk`) VALUES ('4', '78912345', '789', '2');
INSERT INTO `jpa`.`mc_donalds` (`adres_fk`, `phone`, `code`, `city_fk`) VALUES ('3', '32165498', '321', '4');

INSERT INTO `jpa`.`emp_filiaal` (`mc_donalds_id`, `employee_id`) VALUES ('1', '1');
INSERT INTO `jpa`.`emp_filiaal` (`mc_donalds_id`, `employee_id`) VALUES ('2', '3');
INSERT INTO `jpa`.`emp_filiaal` (`mc_donalds_id`, `employee_id`) VALUES ('3', '4');
INSERT INTO `jpa`.`emp_filiaal` (`mc_donalds_id`, `employee_id`) VALUES ('4', '2');
