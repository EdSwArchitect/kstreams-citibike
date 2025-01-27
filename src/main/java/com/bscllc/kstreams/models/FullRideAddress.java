package com.bscllc.kstreams.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class FullRideAddress extends Ride {
    @Getter
    @Setter
    private String startAddress;
    @Getter
    @Setter
    private String endAddress;

    public FullRideAddress(Ride ride, String startAddress, String endAddress) {
        this.rideId = ride.rideId;
        this.endLat = ride.endLat;
        this.startLat = ride.startLat;
        this.endedAt = ride.endedAt;
        this.endedAtEventTime = ride.endedAtEventTime;
        this.endLon = ride.endLon;
        this.startLon = ride.startLon;
        this.endStationId = ride.endStationId;
        this.startStationId = ride.startStationId;
        this.endStationName = ride.endStationName;
        this.startStationName = ride.startStationName;
        this.memberCasual = ride.memberCasual;
        this.rideableType = ride.rideableType;
        this.startedAt = ride.startedAt;
        this.startedAtEventTime = ride.startedAtEventTime;
        this.startAddress = startAddress;
        this.endAddress = endAddress;
    }

}
