package com.movie.ride.repository;

import com.movie.ride.dto.SearchCriteria;
import com.movie.ride.model.Show;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Component
public class ShowDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Show> search(final SearchCriteria searchCriteria) {
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Show> cq = cb.createQuery(Show.class);

        Root<Show> showQ = cq.from(Show.class);
        List<Predicate> predicates = new ArrayList<>();

        if(Objects.nonNull(searchCriteria.getTheaterId())) {
            predicates.add(cb.equal(showQ.get("theaterId"), searchCriteria.getTheaterId()));
        }

        if(Objects.nonNull(searchCriteria.getRegionId())) {
            predicates.add(cb.equal(showQ.get("regionId"), searchCriteria.getRegionId()));
        }

        if(Objects.nonNull(searchCriteria.getMovieId())) {
            predicates.add(cb.equal(showQ.get("movieId"), searchCriteria.getMovieId()));
        }

        Predicate onStart = cb.lessThanOrEqualTo(showQ.get("effectiveFromDate"), searchCriteria.getQueryDate());
        predicates.add(onStart);
        Predicate onEnd = cb.greaterThanOrEqualTo(showQ.get("effectiveToDate"), searchCriteria.getQueryDate());
        predicates.add(onEnd);

        cq.where(predicates.toArray(new Predicate[]{}));
        return entityManager.createQuery(cq).getResultList();
    }

}
