package com.bscllc.kstreams.serdes;

import com.bscllc.kstreams.models.RideLatLon;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class RideLatLonDeserializer implements Deserializer<RideLatLon> {
    private ObjectMapper mapper = new ObjectMapper();
    /**
     * @param topic  the topic
     * @param bytes object bytes
     * @return Rider object
     */
    @Override
    public RideLatLon deserialize(String topic, byte[] bytes) {
        try {
            return mapper.readValue(bytes, RideLatLon.class);

        } catch (IOException e) {
            return new RideLatLon();
        }
    }
}
