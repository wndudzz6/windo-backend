package com.hightecher.windo.energy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "road_energy_forecast")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoadEnergyForecast {

    @EmbeddedId
    private RoadEnergyForecastId id;

    @Column(name = "e_kwh")
    private Double eKwh;
}
