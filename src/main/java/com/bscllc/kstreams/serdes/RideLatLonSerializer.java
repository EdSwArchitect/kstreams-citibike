package com.bscllc.kstreams.serdes;

import com.bscllc.kstreams.models.RideLatLon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class RideLatLonSerializer implements Serializer<RideLatLon> {
    private ObjectMapper mapper = new ObjectMapper();
    /**
     * @param configs 
     * @param isKey
     */
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    /**
     * @param topic Topic name
     * @param ride The ride
     * @return serialization bytes
     */
    @Override
    public byte[] serialize(String topic, RideLatLon ride) {
        try {
            return mapper.writeValueAsBytes(ride);
        } catch (JsonProcessingException e) {
            return new byte[0];
        }
    }

    /**
     * @param topic 
     * @param headers
     * @param data
     * @return
     */
    @Override
    public byte[] serialize(String topic, Headers headers, RideLatLon data) {
        return serialize(topic, data);
    }

    /**
     * 
     */
    @Override
    public void close() {
        Serializer.super.close();
    }
}
