package com.movie.ride.service;

import com.movie.ride.enums.Status;
import com.movie.ride.model.Genre;
import com.movie.ride.model.Movie;
import com.movie.ride.repository.GenreRepository;
import com.movie.ride.repository.MovieRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;

@Data
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public Movie save(final Movie movie) {
        final Date now = new Date();
        final Movie newMovie = movie.toBuilder()
                .status(Status.ACTIVE)
                .createdBy(100)
                .createdOn(now)
                .updatedBy(100)
                .updatedOn(now)
                .build();
        return movieRepository.save(newMovie);
    }

}