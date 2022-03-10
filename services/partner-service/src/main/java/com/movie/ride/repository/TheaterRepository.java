package com.movie.ride.repository;

import com.movie.ride.model.Theater;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends CrudRepository<Theater, Integer> {

}