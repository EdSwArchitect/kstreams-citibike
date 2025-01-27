package com.bscllc.kstreams.serdes;

import com.bscllc.kstreams.models.CitiLatLon;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class CitiLatLonDeserializer implements Deserializer<CitiLatLon> {
    private final ObjectMapper mapper = new ObjectMapper();
    /**
     * @param topic  the topic
     * @param bytes object bytes
     * @return Rider object
     */
    @Override
    public CitiLatLon deserialize(String topic, byte[] bytes) {
        try {
            return mapper.readValue(bytes, CitiLatLon.class);

        } catch (IOException e) {
            return new CitiLatLon();
        }
    }
}
