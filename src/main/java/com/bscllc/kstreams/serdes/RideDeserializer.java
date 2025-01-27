package com.bscllc.kstreams.serdes;

import com.bscllc.kstreams.models.Ride;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class RideDeserializer implements Deserializer<Ride> {
    private ObjectMapper mapper = new ObjectMapper();
    /**
     * @param topic  the topic
     * @param bytes object bytes
     * @return Rider object
     */
    @Override
    public Ride deserialize(String topic, byte[] bytes) {
        try {
            return mapper.readValue(bytes, Ride.class);

        } catch (IOException e) {
            return new Ride();
        }
    }
}
