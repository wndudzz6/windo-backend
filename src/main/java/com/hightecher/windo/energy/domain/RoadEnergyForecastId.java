package com.hightecher.windo.energy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoadEnergyForecastId implements Serializable {

    @Column(name = "link_id")
    private String linkId;

    @Column(name = "season")
    private Season season;

    @Column(name = "time")
    private Integer time;
}
