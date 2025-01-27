package com.bscllc.kstreams;

import com.bscllc.kstreams.models.CitiLatLon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CountGeo {
    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("src/test/resources/geocode.json");
        HashMap<String, String>geos = new HashMap<>();

        try (
                Reader reader = Files.newBufferedReader(path);
                BufferedReader bufferedReader = new BufferedReader(reader);
        ) {

            final ObjectMapper objectMapper = new ObjectMapper();
            final AtomicInteger lineCount = new AtomicInteger(0);

            bufferedReader.lines().forEach(line -> {
                try {
                    CitiLatLon citiLatLon = objectMapper.readValue(line, CitiLatLon.class);

                    geos.put(citiLatLon.getLat() + "_" + citiLatLon.getLon(), line);
                    lineCount.incrementAndGet();

                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }


            });

            System.out.format("Keys: %s%n", geos.keySet());
            System.out.format("%d lines of data read. %d lines of data stored.%n", lineCount.get(), geos.size());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
