package com.hightecher.windo.road.controller;

import com.hightecher.windo.road.dto.RoadDetailDto;
import com.hightecher.windo.road.service.RoadQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roads")
public class RoadController {

    private final RoadQueryService roadQueryService;

    @GetMapping("/{linkId}")
    public RoadDetailDto getRoadDetail(@PathVariable String linkId) {
        return roadQueryService.getRoadDetail(linkId);
    }
}
