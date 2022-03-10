--liquibase formatted sql

--changeset rohit:1
DROP TABLE IF EXISTS show_details;

CREATE TABLE show_details (
  id INTEGER NOT NULL AUTO_INCREMENT,
  theatre_id INTEGER NOT NULL,
  region_id INTEGER NOT NULL,
  screen_id INTEGER NOT NULL,
  movie_id INTEGER NOT NULL,
  effective_from_date DATE NOT NULL,
  effective_to_date DATE NOT NULL,
  start_time TIME NOT NULL,
  end_time TIME NOT NULL,
  status VARCHAR(10) NOT NULL,
  created_by INTEGER NOT NULL,
  created_on DATETIME NOT NULL,
  updated_by INTEGER NOT NULL,
  updated_on DATETIME NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX show_id_uq (id ASC));

--rollback drop table show_details;