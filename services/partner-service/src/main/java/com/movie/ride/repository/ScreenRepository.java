package com.movie.ride.repository;

import com.movie.ride.model.Screen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends CrudRepository<Screen, Integer> {

}