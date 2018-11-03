package com.shhatrat.nextbike.model.original;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class Country {

    @ElementListUnion({
            @ElementList(entry = "city", type = City.class, inline = true)
    })
    List<City> cityList;

    @Attribute
    public String name;

    @Attribute
    Double lat;

    @Attribute
    Double lng;

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public String getName() {
        return name;
    }

    public List<City> getCityList() {
        return cityList;
    }


    public City getCity(){
        return cityList.get(0);
    }

    public static int compareDistance(Country c1, Country c2, Double lat, Double lng){
        Country virtualCityOfUserCoordinates = new Country();
        virtualCityOfUserCoordinates.lat = lat;
        virtualCityOfUserCoordinates.lng = lng;
        return (int) (haversineDistance(c1, virtualCityOfUserCoordinates) - haversineDistance(c2, virtualCityOfUserCoordinates));
        }

    public static double haversineDistance(Country pointA, Country pointB) {
        double deltaLat = Math.toRadians(pointB.lat - pointA.lat);
        double deltaLong = Math.toRadians(pointB.lng - pointA.lng);
        double a = Math.pow(Math.sin(deltaLat / 2), 2) + Math.cos(Math.toRadians(pointA.lat)) *
                Math.cos(Math.toRadians(pointB.lat)) * Math.pow(Math.sin(deltaLong / 2), 2);
        double greatCircleDistance = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return 3958.761 * greatCircleDistance;
    }
}