package com.movie.ride.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.movie.ride.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "show_details")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer theaterId;
    private Integer regionId;
    private Integer screenId;
    private Integer movieId;
    @Temporal(TemporalType.DATE)
    private Date effectiveFromDate;
    @Temporal(TemporalType.DATE)
    private Date effectiveToDate;
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Temporal(TemporalType.TIME)
    private Date endTime;
    private Status status;
    private Integer createdBy;
    private Date createdOn;
    private Integer updatedBy;
    private Date updatedOn;

}