--liquibase formatted sql

--changeset rohit:1
DROP TABLE IF EXISTS region;

CREATE TABLE region (
  id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  town VARCHAR(20) NOT NULL,
  city VARCHAR(20) NOT NULL,
  state VARCHAR(20) NOT NULL,
  country VARCHAR(50) NOT NULL,
  status VARCHAR(10),
  created_by INTEGER NOT NULL,
  created_on DATETIME NOT NULL,
  updated_by INTEGER NOT NULL,
  updated_on DATETIME NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX region_id_uq (id ASC));

--rollback drop table region;