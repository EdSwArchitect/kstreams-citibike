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
public class Address {
    @Getter
    @Setter
    @JsonProperty("house_number")
    private String houseNumber;
    @Getter
    @Setter
    @JsonProperty("building")
    private String building;
    @Getter
    @Setter
    @JsonProperty("tourism")
    private String tourism;
    @Getter
    @Setter
    @JsonProperty("man_made")
    private String manMade;
    @Getter
    @Setter
    @JsonProperty("quarter")
    private String quarter;
    @Getter
    @Setter
    @JsonProperty("shop")
    private String shop;
    @Getter
    @Setter
    @JsonProperty("railway")
    private String railway;
    @Getter
    @Setter
    @JsonProperty("office")
    private String office;
    @Getter
    @Setter
    @JsonProperty("leisure")
    private String leisure;
    @Getter
    @Setter
    @JsonProperty("historic")
    private String historic;
    @Getter
    @Setter
    @JsonProperty("residential")
    private String residential;
    @Getter
    @Setter
    @JsonProperty("place")
    private String place;
    @Getter
    @Setter
    @JsonProperty("commercial")
    private String commercial;
    @Getter
    @Setter
    @JsonProperty("craft")
    private String craft;
    @Getter
    @Setter
    @JsonProperty("highway")
    private String highway;
    @Getter
    @Setter
    @JsonProperty("amenity")
    private String amenity;
    @Getter
    @Setter
    @JsonProperty("road")
    private String road;
    @Getter
    @Setter
    @JsonProperty("neighbourhood")
    private String neighborhood;
    @Getter
    @Setter
    @JsonProperty("suburb")
    private String suburb;
    @Getter
    @Setter
    @JsonProperty("county")
    private String county;
    @Getter
    @Setter
    @JsonProperty("city")
    private String city;
    @Getter
    @Setter
    @JsonProperty("state")
    private String state;
    @Getter
    @Setter
    @JsonProperty("ISO3166-2-lvl4")
    private String iso3166_2_lvl4;
    @Getter
    @Setter
    @JsonProperty("postcode")
    private String postCode;
    @Getter
    @Setter
    @JsonProperty("country")
    private String country;
    @Getter
    @Setter
    @JsonProperty("country_code")
    private String countryCode;

}
