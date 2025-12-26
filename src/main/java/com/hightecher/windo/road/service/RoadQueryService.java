package com.hightecher.windo.road.service;

import com.hightecher.windo.road.dto.RoadDetailDto;
import com.hightecher.windo.road.repository.RoadDetailQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoadQueryService {

    private final RoadDetailQueryRepository roadDetailQueryRepository;

    public RoadDetailDto getRoadDetail(String linkId) {
        return roadDetailQueryRepository.findRoadDetail(linkId);
    }
}
