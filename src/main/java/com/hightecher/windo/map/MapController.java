package com.hightecher.windo.map;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MapController {

    private final MapQueryService mapQueryService;

    @GetMapping("/map/points")
    public List<MapPointDto> getMapPoints() {
        return mapQueryService.getMapPoints();
    }
}
