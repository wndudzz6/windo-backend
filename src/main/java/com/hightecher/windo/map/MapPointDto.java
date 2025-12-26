package com.hightecher.windo.map;

import com.hightecher.windo.road.dto.Grade;

public record MapPointDto(
        String linkId,
        Double lat,
        Double lon,
        Grade grade
) {}
