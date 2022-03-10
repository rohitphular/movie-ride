package com.movie.ride.validator;

import com.movie.ride.dto.ShowDTO;
import org.springframework.stereotype.Component;

@Component
public class ShowValidator implements Validator<ShowDTO> {

    @Override
    public boolean isValid(ShowDTO showDTO) {
        /* If id provided, then check if record exists */
        /* Verify if theater-id is valid */
        /* Verify if region-id is part of theater */
        /* Verify if screen-id is part of theater */
        /* Verify if movie-id is valid record */
        /* Validate if effective-from-date & effective-to-date are correct */
        /* Validate if start-time & end-time are correct */
        return false;
    }
}