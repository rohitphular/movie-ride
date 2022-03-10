package com.movie.ride.repository;

import com.movie.ride.model.Show;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends CrudRepository<Show, Integer> {

}