package com.hightecher.windo.road.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "RoadLocation")
@Table(name = "road_location")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoadLocation {

    @Id
    @Column(name = "link_id", length = 20)
    private String linkId;

    @Column(name = "road_type", length = 50)
    private String roadType;

    @Column(name = "distance_m")
    private Integer distanceM;

    @Column(name = "lon")
    private Double lon;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lanes")
    private Integer lanes;

    @Column(name = "data_source", length = 50)
    private String dataSource;
}
