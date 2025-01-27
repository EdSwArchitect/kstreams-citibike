package com.bscllc.kstreams.serdes;

import com.bscllc.kstreams.models.CitiLatLon;
import com.bscllc.kstreams.models.FullRideAddress;
import com.bscllc.kstreams.models.Ride;
import com.bscllc.kstreams.models.RideLatLon;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

public class RiderSerdes {
    private RiderSerdes() {}

    public static Serde<Ride> Ride() {
        RideSerializer serializer = new RideSerializer();
        RideDeserializer deserializer = new RideDeserializer();

        return Serdes.serdeFrom(serializer, deserializer);
    }

    public static Serde<FullRideAddress> RideAddress() {
        RideAddressSerializer serializer = new RideAddressSerializer();
        RideAddressDeserializer deserializer = new RideAddressDeserializer();

        return Serdes.serdeFrom(serializer, deserializer);
    }

    public static Serde<RideLatLon> RideLatLon() {
        RideLatLonSerializer serializer = new RideLatLonSerializer();
        RideLatLonDeserializer deserializer = new RideLatLonDeserializer();

        return Serdes.serdeFrom(serializer, deserializer);
    }

    public static Serde<CitiLatLon> CitiLatLon() {
        CitiLatLonSerializer serializer = new CitiLatLonSerializer();
        CitiLatLonDeserializer deserializer = new CitiLatLonDeserializer();

        return Serdes.serdeFrom(serializer, deserializer);
    }
}
