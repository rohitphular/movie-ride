package com.movie.ride.service;

import com.movie.ride.enums.Status;
import com.movie.ride.model.Region;
import com.movie.ride.repository.RegionRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;

@Data
@Service
public class RegionService {

    private final RegionRepository regionRepository;

    public Region save(final Region region) {
        final Date now = new Date();
        final Region newRegion = region.toBuilder()
                .status(Status.ACTIVE)
                .createdBy(100)
                .createdOn(now)
                .updatedBy(100)
                .updatedOn(now)
                .build();
        return regionRepository.save(newRegion);
    }

}