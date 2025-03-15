package org.example.mybatis.entity;


public class City {

    private int cityId;
    private String city;
    private int countryId;

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", city='" + city + '\'' +
                ", countryId=" + countryId +
                '}';
    }
}
