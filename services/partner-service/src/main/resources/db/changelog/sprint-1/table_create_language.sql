--liquibase formatted sql

--changeset rohit:1
DROP TABLE IF EXISTS movie_language;

CREATE TABLE movie_language (
  id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  status VARCHAR(10) NOT NULL,
  created_by INTEGER NOT NULL,
  created_on DATETIME NOT NULL,
  updated_by INTEGER NOT NULL,
  updated_on DATETIME NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX movie_lang_id_uq (id ASC));

--rollback drop table movie_language;