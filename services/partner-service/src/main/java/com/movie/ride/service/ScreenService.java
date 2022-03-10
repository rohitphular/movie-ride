package com.movie.ride.service;

import com.movie.ride.model.Screen;
import com.movie.ride.repository.ScreenRepository;
import com.movie.ride.repository.SeatRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;

@Data
@Service
public class ScreenService {

    private final ScreenRepository screenRepository;

    public Screen save(final Screen screen) {
        final Date now = new Date();
        final Screen newScreen = screen.toBuilder()
                .createdBy(100)
                .createdOn(now)
                .updatedBy(100)
                .updatedOn(now)
                .build();

        return screenRepository.save(newScreen);
    }

}