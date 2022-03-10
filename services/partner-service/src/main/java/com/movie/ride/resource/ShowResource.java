package com.movie.ride.resource;

import com.movie.ride.dto.ShowDTO;
import com.movie.ride.model.common.ApiResponse;
import com.movie.ride.service.ShowService;
import com.movie.ride.validator.ShowValidator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Data
@RestController
@RequestMapping("/show")
public class ShowResource {

    private final ShowService showService;
    private final ShowValidator showValidator;

    @PostMapping
    public ApiResponse<?> create(@RequestBody final ShowDTO showDTO) {
        ApiResponse.ApiResponseBuilder<?> apiResponseBuilder = ApiResponse.builder();
        try {
            if(showValidator.isValid(showDTO)) {
                apiResponseBuilder.status(HttpStatus.BAD_REQUEST.value());
                apiResponseBuilder.message(HttpStatus.BAD_REQUEST.series().name());
            } else {
                showService.create(showDTO);
                apiResponseBuilder.status(HttpStatus.OK.value());
                apiResponseBuilder.message(HttpStatus.OK.series().name());
            }
        } catch (RuntimeException e) {
            log.error("Exception while creating show record", e);
            apiResponseBuilder.status(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponseBuilder.message("Error while creating show");
        }

        return apiResponseBuilder.build();
    }

    @PutMapping
    public ApiResponse<?> update(@RequestBody final ShowDTO showDTO) {
        ApiResponse.ApiResponseBuilder<?> apiResponseBuilder = ApiResponse.builder();
        try {
            if(showValidator.isValid(showDTO)) {
                apiResponseBuilder.status(HttpStatus.BAD_REQUEST.value());
                apiResponseBuilder.message(HttpStatus.BAD_REQUEST.series().name());
            } else {
                showService.update(showDTO);
                apiResponseBuilder.status(HttpStatus.OK.value());
                apiResponseBuilder.message(HttpStatus.OK.series().name());
            }
        } catch (RuntimeException e) {
            log.error("Exception while updating show record", e);
            apiResponseBuilder.status(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponseBuilder.message("Error while updating show");
        }

        return apiResponseBuilder.build();
    }

    @DeleteMapping("/id/{id}")
    public ApiResponse<?> delete(@PathVariable final int showId) {
        ApiResponse.ApiResponseBuilder<?> apiResponseBuilder = ApiResponse.builder();
        try {
            showService.delete(showId);
            apiResponseBuilder.status(HttpStatus.OK.value());
            apiResponseBuilder.message(HttpStatus.OK.series().name());
        } catch (RuntimeException e) {
            log.error("Exception while deleting show record", e);
            apiResponseBuilder.status(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponseBuilder.message("Error while deleting show");
        }

        return apiResponseBuilder.build();
    }

}