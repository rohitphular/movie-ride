package com.movie.ride.dummy;

import com.movie.ride.dto.ShowDTO;
import com.movie.ride.model.common.ApiResponse;
import com.movie.ride.resource.ShowResource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
@Data
@Component
@Profile("local")
public class DummyShowGenerator implements CommandLineRunner {

    private final ShowResource showResource;

    @Override
    public void run(String... args) throws Exception {
        final ShowDTO showDTO1 = ShowDTO.builder()
                .theatreId(1)
                .regionId(1)
                .screenId(1)
                .movieId(1)
                .effectiveFromDate(getDate(10, 3, 2022))
                .effectiveToDate(getDate(20, 3, 2022))
                .startTime(getDatetime(1, 1, 2000, 8, 0))
                .endTime(getDatetime(1, 1, 2000, 11, 0))
                .build();

        final ApiResponse<?> apiResponse1 = showResource.create(showDTO1);
        log.info("Show API Response Status - " + apiResponse1.getStatus());

        final ShowDTO showDTO2 = ShowDTO.builder()
                .theatreId(1)
                .regionId(1)
                .screenId(2)
                .movieId(2)
                .effectiveFromDate(getDate(12, 3, 2022))
                .effectiveToDate(getDate(20, 3, 2022))
                .startTime(getDatetime(1, 1, 2000, 11, 0))
                .endTime(getDatetime(1, 1, 2000, 13, 0))
                .build();

        final ApiResponse<?> apiResponse2 = showResource.create(showDTO2);
        log.info("Show API Response Status - " + apiResponse2.getStatus());

        final ShowDTO showDTO3 = ShowDTO.builder()
                .theatreId(1)
                .regionId(1)
                .screenId(2)
                .movieId(3)
                .effectiveFromDate(getDate(12, 3, 2022))
                .effectiveToDate(getDate(20, 3, 2022))
                .startTime(getDatetime(1, 1, 2000, 14, 0))
                .endTime(getDatetime(1, 1, 2000, 17, 0))
                .build();

        final ApiResponse<?> apiResponse3 = showResource.create(showDTO3);
        log.info("Show API Response Status - " + apiResponse3.getStatus());

        final ShowDTO showDTO4 = ShowDTO.builder()
                .theatreId(1)
                .regionId(1)
                .screenId(2)
                .movieId(3)
                .effectiveFromDate(getDate(12, 3, 2022))
                .effectiveToDate(getDate(20, 3, 2022))
                .startTime(getDatetime(1, 1, 2000, 18, 0))
                .endTime(getDatetime(1, 1, 2000, 21, 0))
                .build();

        final ApiResponse<?> apiResponse4 = showResource.create(showDTO4);
        log.info("Show API Response Status - " + apiResponse4.getStatus());
    }

    public Date getDate(final int day, final int month, final int year) {
        return Date.from(LocalDate.of(year, month, day).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public Date getDatetime(final int day, final int month, final int year, final int hour, final int min) {
        return Date.from(LocalDateTime.of(year, month, day, hour, min).atZone(ZoneId.systemDefault()).toInstant());
    }

}