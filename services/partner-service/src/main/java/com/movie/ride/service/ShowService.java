package com.movie.ride.service;

import com.movie.ride.dto.ShowDTO;
import com.movie.ride.enums.Status;
import com.movie.ride.model.Show;
import com.movie.ride.repository.ShowRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;

@Data
@Service
public class ShowService {

    private final ShowRepository showRepository;

    public Show create(final ShowDTO showDTO) {
        final Date now = new Date();
        final Show show = Show.builder()
                .theatreId(showDTO.getTheatreId())
                .regionId(showDTO.getRegionId())
                .screenId(showDTO.getScreenId())
                .movieId(showDTO.getMovieId())
                .effectiveFromDate(showDTO.getEffectiveFromDate())
                .effectiveToDate(showDTO.getEffectiveToDate())
                .startTime(showDTO.getStartTime())
                .endTime(showDTO.getEndTime())
                .status(Status.ACTIVE)
                .createdBy(100)
                .createdOn(now)
                .updatedBy(100)
                .updatedOn(now)
                .build();

        return showRepository.save(show);
    }

    public Show update(final ShowDTO showDTO) {
        final Date now = new Date();
        final Show existingShow = showRepository.findById(showDTO.getId())
                .orElseThrow(() -> new RuntimeException("Record not found"));

        existingShow.setTheatreId(showDTO.getTheatreId());
        existingShow.setRegionId(showDTO.getRegionId());
        existingShow.setScreenId(showDTO.getScreenId());
        existingShow.setMovieId(showDTO.getMovieId());
        existingShow.setEffectiveFromDate(showDTO.getEffectiveFromDate());
        existingShow.setEffectiveToDate(showDTO.getEffectiveToDate());
        existingShow.setStartTime(showDTO.getStartTime());
        existingShow.setEndTime(showDTO.getEndTime());
        existingShow.setStatus(Status.ACTIVE);
        existingShow.setUpdatedBy(100);
        existingShow.setUpdatedOn(now);

        return showRepository.save(existingShow);
    }

    public void delete(final Integer id) {
        showRepository.deleteById(id);
    }

}