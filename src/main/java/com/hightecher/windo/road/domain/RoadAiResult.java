package com.hightecher.windo.road.domain;

import com.hightecher.windo.road.dto.Grade;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "RoadAiResult")
@Table(name = "road_ai_result")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoadAiResult {

    @Id
    @Column(name = "link_id", length = 20)
    private String linkId;

    @Column(name = "start_name", length = 100)
    private String startName;

    @Column(name = "end_name", length = 100)
    private String endName;

    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "ai_score")
    private Double aiScore;

    @Column(name = "avg_power")
    private Double avgPower;

    @Column(name = "ai_explanation", columnDefinition = "TEXT")
    private String aiExplanation;

    @Enumerated(EnumType.STRING)
    @Column(name = "grade", length = 1)
    private Grade grade;

}
