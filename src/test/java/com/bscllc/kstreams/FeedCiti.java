package com.bscllc.kstreams;

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
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class FeedCiti {
    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath(args[0]);
        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
//        mapper.enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);

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

            bufferedReader.lines().forEach(line -> {
                System.out.println(line);
                counter.incrementAndGet();
                ProducerRecord<String, String> producerRecord = new ProducerRecord<>("citibike",
                        UUID.randomUUID().toString(), line);
                producer.send(producerRecord);
            });

            System.out.format("%d lines of data sent%n", counter.get());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
