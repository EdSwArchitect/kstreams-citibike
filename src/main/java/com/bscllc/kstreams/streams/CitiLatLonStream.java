package com.bscllc.kstreams.streams;

import com.bscllc.kstreams.models.CitiLatLon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class CitiLatLonStream {
    final private static Logger logger = LoggerFactory.getLogger(CitiLatLonStream.class);

    public static KStream<String, CitiLatLon> createStream(Properties props, StreamsBuilder builder ) {
        final ObjectMapper mapper = new ObjectMapper();

        KStream<String, String> geoLatLonStream = builder.<String, String>stream("geo-lat-lon", Consumed.with(Serdes.String(), Serdes.String()))
                .filter((key, value) -> !value.isEmpty());

        return geoLatLonStream
                .map((key, value) -> {
                    CitiLatLon citiLatLon = null;
                    try {
                        citiLatLon = mapper.readValue(value, CitiLatLon.class);
                    } catch (JsonProcessingException e) {
                        citiLatLon = new CitiLatLon();
                    }

                    KeyValue<String, CitiLatLon> kvp = KeyValue.pair(citiLatLon.getLat() + "_" + citiLatLon.getLon(), citiLatLon);

//                    logger.info("geoLatLon : {}", kvp);

                    return kvp;
                });

    }
}
