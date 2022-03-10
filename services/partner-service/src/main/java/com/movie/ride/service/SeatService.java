package com.movie.ride.service;

import com.movie.ride.model.Seat;
import com.movie.ride.repository.SeatRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public Seat save(final Seat seat) {
        return seatRepository.save(seat);
    }

}