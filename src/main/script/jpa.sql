DROP SCHEMA IF EXISTS jpa;
create schema IF NOT EXISTS jpa;

use jpa_new;

CREATE TABLE IF NOT EXISTS city (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  description VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
  );

  CREATE TABLE IF NOT EXISTS emp_filiaal (
  id INT NOT NULL,
  emp_filiaal_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
  );

CREATE TABLE IF NOT EXISTS employee (
  id INT NOT NULL AUTO_INCREMENT,
  firstname VARCHAR(45) NULL,
  lastname VARCHAR(45) NULL,
  emp_filiaal_fk INT NOT NULL,
  PRIMARY KEY (id)
  );

CREATE TABLE IF NOT EXISTS adres (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  mc_donalds_id INT NOT NULL,
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

  ALTER TABLE employee
  ADD CONSTRAINT emp_filiaal_fk FOREIGN KEY (emp_filiaal_fk)
  REFERENCES emp_filiaal(id);

  ALTER TABLE adres
  ADD CONSTRAINT mc_donalds_id FOREIGN KEY (mc_donalds_id)
  REFERENCES mc_donalds(id);

  ALTER TABLE mc_donalds
  ADD CONSTRAINT adres_fk FOREIGN KEY (adres_fk)
  REFERENCES adres(id),
  ADD CONSTRAINT city_fk
  FOREIGN KEY (city_fk)
  REFERENCES city(id);
