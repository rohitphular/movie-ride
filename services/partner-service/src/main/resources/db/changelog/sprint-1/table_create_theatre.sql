--liquibase formatted sql

--changeset rohit:1
DROP TABLE IF EXISTS theater;

CREATE TABLE theater (
  id INTEGER NOT NULL AUTO_INCREMENT,
  theater_code VARCHAR(10) NOT NULL,
  name VARCHAR(50) NOT NULL,
  address VARCHAR(255) NOT NULL,
  region_id INTEGER NOT NULL,
  status VARCHAR(10),
  created_by INTEGER NOT NULL,
  created_on DATETIME NOT NULL,
  updated_by INTEGER NOT NULL,
  updated_on DATETIME NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX theater_id_uq (id ASC),
  CONSTRAINT uniqueCode UNIQUE (theater_code));

--rollback drop table theater;