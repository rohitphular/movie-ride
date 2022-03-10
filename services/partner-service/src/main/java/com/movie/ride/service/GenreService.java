package com.movie.ride.service;

import com.movie.ride.enums.Status;
import com.movie.ride.model.Genre;
import com.movie.ride.model.Language;
import com.movie.ride.repository.GenreRepository;
import com.movie.ride.repository.LanguageRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;

@Data
@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public Genre save(final Genre genre) {
        final Date now = new Date();
        final Genre newGenre = genre.toBuilder()
                .status(Status.ACTIVE)
                .createdBy(100)
                .createdOn(now)
                .updatedBy(100)
                .updatedOn(now)
                .build();
        return genreRepository.save(newGenre);
    }

}