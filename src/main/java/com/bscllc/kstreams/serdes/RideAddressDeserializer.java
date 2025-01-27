package com.bscllc.kstreams.serdes;

import com.bscllc.kstreams.models.FullRideAddress;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class RideAddressDeserializer implements Deserializer<FullRideAddress> {
    private final ObjectMapper mapper = new ObjectMapper();
    /**
     * @param topic  the topic
     * @param bytes object bytes
     * @return Rider object
     */
    @Override
    public FullRideAddress deserialize(String topic, byte[] bytes) {
        try {
            return mapper.readValue(bytes, FullRideAddress.class);

        } catch (IOException e) {
            return new FullRideAddress();
        }
    }
}
