package com.movie.ride.service;

import com.movie.ride.dto.SearchCriteria;
import com.movie.ride.model.Show;
import com.movie.ride.repository.ShowDao;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ShowService {

    private final ShowDao showDao;

    public List<Show> search(final SearchCriteria searchCriteria) {
        return showDao.search(searchCriteria);
    }

}