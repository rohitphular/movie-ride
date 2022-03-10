--liquibase formatted sql

--changeset rohit:1
DROP TABLE IF EXISTS seat;

CREATE TABLE seat (
  id INTEGER NOT NULL AUTO_INCREMENT,
  screen_id INTEGER NOT NULL,
  tier_name VARCHAR(50) NOT NULL,
  row_no INTEGER NOT NULL,
  seat_no INTEGER NOT NULL,
  base_price DOUBLE NOT NULL,
  PRIMARY KEY (id));

--rollback drop table seat;