package com.movie.ride.service;

import com.movie.ride.enums.Status;
import com.movie.ride.model.Theater;
import com.movie.ride.repository.TheaterRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;

@Data
@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;

    public Theater save(final Theater theater) {
        final Date now = new Date();
        final Theater newTheatre = theater.toBuilder()
                .status(Status.ACTIVE)
                .createdBy(100)
                .createdOn(now)
                .updatedBy(100)
                .updatedOn(now)
                .build();
        return theaterRepository.save(newTheatre);
    }

}