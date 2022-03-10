package com.movie.ride.dummy;

import com.movie.ride.dto.SearchCriteria;
import com.movie.ride.dto.common.ApiResponse;
import com.movie.ride.model.Show;
import com.movie.ride.resource.SearchResource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Slf4j
@Data
@Component
@Profile("local")
public class DummySearchValidator implements CommandLineRunner {

    private final SearchResource searchResource;

    @Override
    public void run(String... args) throws Exception {
        SearchCriteria searchCriteria = SearchCriteria.builder()
                .movieId(3)
                .queryDate(getDate(15, 3, 2022))
                .regionId(1)
                .build();
        final ApiResponse<List<Show>> shows = searchResource.searchShow(searchCriteria);
        shows.getPayload().forEach(show -> log.info(show.toString()));
    }

    public Date getDate(final int day, final int month, final int year) {
        return Date.from(LocalDate.of(year, month, day).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

}