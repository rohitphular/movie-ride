package com.movie.ride.service;

import com.movie.ride.enums.Status;
import com.movie.ride.model.Theatre;
import com.movie.ride.repository.TheatreRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;

@Data
@Service
public class TheatreService {

    private final TheatreRepository theatreRepository;

    public Theatre save(final Theatre theatre) {
        final Date now = new Date();
        final Theatre newTheatre = theatre.toBuilder()
                .status(Status.ACTIVE)
                .createdBy(100)
                .createdOn(now)
                .updatedBy(100)
                .updatedOn(now)
                .build();
        return theatreRepository.save(newTheatre);
    }

}