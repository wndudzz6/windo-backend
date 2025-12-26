package com.hightecher.windo.road.dto;

public record RoadDetailDto(
        String linkId,
        String startName,
        String endName,
        String region,
        Double aiScore,
        String aiExplanation,
        Grade grade,
        Double avgPower,
        String roadType,
        Integer distanceM,
        Integer lanes
) {}
