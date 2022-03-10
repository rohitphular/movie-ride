package com.movie.ride.resource;

import com.movie.ride.dto.SearchCriteria;
import com.movie.ride.dto.common.ApiResponse;
import com.movie.ride.model.Show;
import com.movie.ride.service.ShowService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Data
@RestController
public class SearchResource {

    private final ShowService showService;

    @PostMapping("/shows")
    public ApiResponse<List<Show>> searchShow(@RequestBody SearchCriteria searchCriteria) {
        ApiResponse.ApiResponseBuilder<List<Show>> apiResponseBuilder = ApiResponse.builder();
        try {
            final List<Show> shows = showService.search(searchCriteria);
            apiResponseBuilder.status(HttpStatus.OK.value());
            apiResponseBuilder.message(HttpStatus.OK.series().name());
            apiResponseBuilder.payload(shows);
        } catch (RuntimeException e) {
            log.error("Exception while searching shows", e);
            apiResponseBuilder.status(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponseBuilder.message("Error while searching shows");
        }

        return apiResponseBuilder.build();
    }

}