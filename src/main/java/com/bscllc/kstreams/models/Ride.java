package com.bscllc.kstreams.models;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ride {
    // 2021-10-06 19:47:05
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * ride_id,rideable_type,started_at,ended_at,start_station_name,start_station_id,end_station_name,
     * end_station_id,start_lat,start_lng,end_lat,end_lng,member_casual
     *
     */
    @Getter
    @Setter
    @CsvBindByPosition(position=0)
    protected String rideId;
    @Getter
    @Setter
    @CsvBindByPosition(position=1)
    protected String rideableType;
    @Getter
    @CsvBindByPosition(position=2)
    protected String startedAt;
    @Getter
    @CsvBindByPosition(position=3)
    protected String endedAt;
    @Getter
    @Setter
    @CsvBindByPosition(position=4)
    protected String startStationName;
    @Getter
    @Setter
    @CsvBindByPosition(position=5)
    protected String startStationId;
    @Getter
    @Setter
    @CsvBindByPosition(position=6)
    protected String endStationName;
    @Getter
    @Setter
    @CsvBindByPosition(position=7)
    protected String endStationId;
    @Getter
    @Setter
    @CsvBindByPosition(position=8)
    protected double startLat;
    @Getter
    @Setter
    @CsvBindByPosition(position=9)
    protected double startLon;
    @Getter
    @Setter
    @CsvBindByPosition(position=10)
    protected double endLat;
    @Getter
    @Setter
    @CsvBindByPosition(position=11)
    protected double endLon;
    @Getter
    @Setter
    @CsvBindByPosition(position=12)
    protected String memberCasual;
    @Getter
    protected long startedAtEventTime;
    @Getter
    protected long endedAtEventTime;

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
        try {
            this.startedAtEventTime = sdf.parse(startedAt).getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void setEndedAt(String endedAt) {
        this.endedAt = endedAt;
        try {
            this.endedAtEventTime = sdf.parse(endedAt).getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Ride csvToRide(String csv) {
        List<Ride> list = new CsvToBeanBuilder<Ride>(new StringReader(csv))
                .withType(Ride.class).build().parse();

        if (list.size() > 0) {
            System.out.println(list.get(0));
            return list.get(0);
        } else {
            return new Ride();
        }
    }
}
