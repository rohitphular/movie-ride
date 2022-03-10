--liquibase formatted sql

--changeset rohit:1
DROP TABLE IF EXISTS movie_genre;

CREATE TABLE movie_genre (
  id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  status VARCHAR(10) NOT NULL,
  created_by INTEGER NOT NULL,
  created_on DATETIME NOT NULL,
  updated_by INTEGER NOT NULL,
  updated_on DATETIME NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX movie_genre_id_uq (id ASC));

--rollback drop table movie_genre;