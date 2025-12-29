package com.hightecher.windo.energy.repository;

import com.hightecher.windo.energy.domain.RoadEnergyForecast;
import com.hightecher.windo.energy.domain.Season;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class RoadEnergyForecastRepository {

    @PersistenceContext
    private EntityManager em;

    public List<RoadEnergyForecast> findByLinkId(String linkId) {
        return em.createQuery("""
            select e
            from RoadEnergyForecast e
            where e.id.linkId = :linkId
        """, RoadEnergyForecast.class)
                .setParameter("linkId", linkId)
                .getResultList();
    }

    public List<RoadEnergyForecast> findByLinkIdAndSeason(
            String linkId,
            Season season
    ) {
        return em.createQuery("""
            select e
            from RoadEnergyForecast e
            where e.id.linkId = :linkId
              and e.id.season = :season
        """, RoadEnergyForecast.class)
                .setParameter("linkId", linkId)
                .setParameter("season", season)
                .getResultList();
    }

    public List<RoadEnergyForecast> findTop10BySeason(String season) {
        return em.createQuery("""
            select e
            from RoadEnergyForecast e
            where e.id.season = :season
            order by e.eKwh desc
        """, RoadEnergyForecast.class)
                .setParameter("season", season)
                .setMaxResults(10)
                .getResultList();
    }
}

