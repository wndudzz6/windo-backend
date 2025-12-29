package com.hightecher.windo.map;

import com.hightecher.windo.road.dto.Grade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class RoadMapQueryRepository {

    @PersistenceContext
    private EntityManager em;

    public List<MapPointDto> findMapPoints() {
        return em.createQuery("""
            select new com.hightecher.windo.map.MapPointDto(
                l.linkId,
                l.lat,
                l.lon,
                a.grade
            )
            from RoadLocation l
            join RoadAiResult a
                on l.linkId = a.linkId
        """, MapPointDto.class)
                .getResultList();
    }

    public List<MapPointDto> findMapPointsByGrades(List<Grade> grades) {
        return em.createQuery("""
        select new com.hightecher.windo.map.MapPointDto(
            l.linkId,
            l.lat,
            l.lon,
            a.grade
        )
        from RoadLocation l
        join RoadAiResult a
            on l.linkId = a.linkId
        where a.grade in :grades
    """, MapPointDto.class)
                .setParameter("grades", grades)
                .getResultList();
    }


}
