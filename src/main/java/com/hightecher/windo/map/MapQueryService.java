package com.hightecher.windo.map;

import com.hightecher.windo.road.dto.Grade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MapQueryService {

    private final RoadMapQueryRepository roadMapQueryRepository;

    public List<MapPointDto> getMapPoints() {
        return roadMapQueryRepository.findMapPoints();
    }

    public List<MapPointDto> getMapPointsByMinGrade(Grade minGrade) {
        List<Grade> grades = Arrays.stream(Grade.values())
                .filter(g -> g.getPriority() >= minGrade.getPriority())
                .toList();

        return roadMapQueryRepository.findMapPointsByGrades(grades);
    }
    public List<MapPointDto> getMapPointsByGrades(List<Grade> grades) {
        return roadMapQueryRepository.findMapPointsByGrades(grades);
    }


}
