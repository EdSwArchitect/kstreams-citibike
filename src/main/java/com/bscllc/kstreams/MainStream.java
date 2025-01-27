package com.bscllc.kstreams;

import com.bscllc.kstreams.models.CitiLatLon;
import com.bscllc.kstreams.serdes.RiderSerdes;
import com.bscllc.kstreams.streams.CitiLatLonStream;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class MainStream {
    final private static Logger logger = LoggerFactory.getLogger(MainStream.class);

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "citibike");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");

        final StreamsBuilder builder = new StreamsBuilder();

        KStream<String, CitiLatLon> latLonStream = CitiLatLonStream.createStream(props, builder);

        KTable<String, CitiLatLon> citiLatLonKTable =
                latLonStream.toTable(Materialized.with(Serdes.String(), RiderSerdes.CitiLatLon()));

        logger.info("Queryable store name: {}", citiLatLonKTable.queryableStoreName());

        Topology topology = builder.build();

        final KafkaStreams streams = new KafkaStreams(topology, props);
        final CountDownLatch latch = new CountDownLatch(1);

        Runtime.getRuntime().addShutdownHook(new Thread("citibike-shutdown-hook") {
            @Override
            public void run() {
                streams.close();
                latch.countDown();
            }
        });

        try {
            streams.start();
            latch.await();
        } catch (Throwable e) {
            System.exit(1);
        }
        System.exit(0);

    }
}
