package com.movie.ride.service;

import com.movie.ride.enums.Status;
import com.movie.ride.model.Language;
import com.movie.ride.model.Region;
import com.movie.ride.repository.LanguageRepository;
import com.movie.ride.repository.RegionRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;

@Data
@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    public Language save(final Language language) {
        final Date now = new Date();
        final Language newLanguage = language.toBuilder()
                .status(Status.ACTIVE)
                .createdBy(100)
                .createdOn(now)
                .updatedBy(100)
                .updatedOn(now)
                .build();
        return languageRepository.save(newLanguage);
    }

}