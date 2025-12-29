package com.hightecher.windo.road.repository;

import com.hightecher.windo.road.dto.Grade;
import com.hightecher.windo.road.dto.RoadDetailDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class RoadDetailQueryRepository {

    @PersistenceContext
    private EntityManager em;

    public RoadDetailDto findRoadDetail(String linkId) {
        return em.createQuery("""
            select new com.hightecher.windo.road.dto.RoadDetailDto(
                a.linkId,
                a.startName,
                a.endName,
                a.region,
                a.aiScore,
                a.aiExplanation,
                a.grade,
                a.avgPower,
                l.roadType,
                l.distanceM,
                l.lanes
            )
            from RoadAiResult a
            join RoadLocation l
                on a.linkId = l.linkId
            where a.linkId = :linkId
        """, RoadDetailDto.class)
                .setParameter("linkId", linkId)
                .getSingleResult();
    }




}
