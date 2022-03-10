package com.movie.ride.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowDTO extends BaseDTO {

    private Integer id;
    private Integer theatreId;
    private Integer regionId;
    private Integer screenId;
    private Integer movieId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date effectiveFromDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date effectiveToDate;
    @JsonFormat(pattern = "HH:mm")
    private Date startTime;
    @JsonFormat(pattern = "HH:mm")
    private Date endTime;

}