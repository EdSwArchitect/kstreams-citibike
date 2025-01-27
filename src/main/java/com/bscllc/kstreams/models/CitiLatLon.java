package com.bscllc.kstreams.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitiLatLon {
    @Getter
    @Setter
    @JsonProperty("place_id")
    private String placeId;
    @Getter
    @Setter
    @JsonProperty("licence")
    private String licence;
    @Getter
    @JsonProperty("osm_type")
    private String osmType;
    @Getter
    @JsonProperty("osm_id")
    private long osmId;
    @Getter
    @Setter
    @JsonProperty("lat")
    private double lat;
    @Getter
    @Setter
    @JsonProperty("lon")
    private double lon;
    @Getter
    @Setter
    @JsonProperty("display_name")
    private String displayName;
    @Getter
    @Setter
    @JsonProperty("address")
    private Address address;
    @Getter
    @Setter
    @JsonProperty("boundingbox")
    private double[] boundingBox;
}
