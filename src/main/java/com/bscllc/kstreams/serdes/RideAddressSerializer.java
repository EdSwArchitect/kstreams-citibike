package com.bscllc.kstreams.serdes;

import com.bscllc.kstreams.models.FullRideAddress;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class RideAddressSerializer implements Serializer<FullRideAddress> {
    private final ObjectMapper mapper = new ObjectMapper();
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
    public byte[] serialize(String topic, FullRideAddress ride) {
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
    public byte[] serialize(String topic, Headers headers, FullRideAddress data) {
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
