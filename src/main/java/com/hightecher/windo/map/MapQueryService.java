package com.hightecher.windo.map;

import com.hightecher.windo.road.repository.RoadMapQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MapQueryService {

    private final RoadMapQueryRepository roadMapQueryRepository;

    public List<MapPointDto> getMapPoints() {
        return roadMapQueryRepository.findMapPoints();
    }
}
