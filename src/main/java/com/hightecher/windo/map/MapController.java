package com.hightecher.windo.map;

import com.hightecher.windo.road.dto.Grade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MapController {

    private final MapQueryService mapQueryService;

    @GetMapping("/map/points")
    public List<MapPointDto> getMapPoints(
            @RequestParam(required = false) List<Grade> grades,
            @RequestParam(required = false) Grade minGrade
    ) {
        if (grades != null && !grades.isEmpty()) {
            return mapQueryService.getMapPointsByGrades(grades);
        }
        if (minGrade != null) {
            return mapQueryService.getMapPointsByMinGrade(minGrade);
        }
        return mapQueryService.getMapPoints();
    }

}
