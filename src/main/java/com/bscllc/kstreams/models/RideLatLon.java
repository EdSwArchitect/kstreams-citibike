package com.bscllc.kstreams.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RideLatLon {
    @Getter
    @Setter
    private String rideId;
    @Getter
    @Setter
    private double startLat;
    @Getter
    @Setter
    private double startLon;
    @Getter
    @Setter
    private double endLat;
    @Getter
    @Setter
    private double endLon;
    @Getter
    @Setter
    private String address;
    @Getter
    @Setter
    private String rideableType;
    @Getter
    @Setter
    private String startedAt;
    @Getter
    @Setter
    private String endedAt;


    public RideLatLon(Ride ride) {
        this.startLat = ride.getStartLat();
        this.startLon = ride.getStartLon();
        this.endLat = ride.getEndLat();
        this.endLon = ride.getEndLon();
        this.rideId = ride.getRideId();
        this.rideableType = ride.getRideableType();
        this.startedAt = ride.getStartedAt();
        this.endedAt = ride.getEndedAt();
    }
}
