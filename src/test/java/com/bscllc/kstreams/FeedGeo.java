package com.bscllc.kstreams;

import com.bscllc.kstreams.models.CitiLatLon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

public class FeedGeo {
    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("src/test/resources/geocode.json");

        Properties props = new Properties();
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.ACKS_CONFIG, "all");

        try (
                Reader reader = Files.newBufferedReader(path);
                BufferedReader bufferedReader = new BufferedReader(reader);

                Producer<String, String> producer = new KafkaProducer<>(props);
        ) {

            AtomicInteger counter = new AtomicInteger(0);

            final ObjectMapper objectMapper = new ObjectMapper();

            bufferedReader.lines().forEach(line -> {
                System.out.println(line);
                counter.incrementAndGet();

                try {
                    CitiLatLon citiLatLon = objectMapper.readValue(line, CitiLatLon.class);

                    ProducerRecord<String, String> producerRecord = new ProducerRecord<>("geo-lat-lon",
                            citiLatLon.getPlaceId(), line);
                    producer.send(producerRecord);

                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }


            });

            System.out.format("%d lines of data sent%n", counter.get());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
