package com.shhatrat.nextbike.model.original;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class Place {

    @Attribute
    String uid;

    @Attribute
    Double lat;

    @Attribute
    Double lng;

    @Attribute
    String name;

    @Attribute(required = false)
    Integer spot;

    @Attribute(required = false)
    Double number;

    @Attribute(required = false)
    Integer bikes;

    @Attribute(name = "bike_racks", required = false)
    Integer bikeRacks;

    @Attribute(name = "rack_locks", required = false)
    Integer rackLocks;


    @Attribute(name = "free_racks", required = false)
    String freeRacks;

    @Attribute(name = "terminal_type", required = false)
    String terminalType;

    @Attribute(name = "bike_numbers", required = false)
    String bikeNumbers;

    @Attribute(name = "bike_types", required = false)
    String bikeTypes;

    @Attribute(name = "place_type", required = false)
    Integer placeType;

    @ElementListUnion({
            @ElementList(entry = "bike", type = Bike.class, inline = true, required = false)
    })
    List<Object> list;


    public String getUid() {
        return uid;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public String getName() {
        return name;
    }

    public Integer getSpot() {
        return spot;
    }

    public Double getNumber() {
        return number;
    }

    public Integer getBikes() {
        return bikes;
    }

    public String getFreeRacks() {
        return freeRacks;
    }

    public String getTerminalType() {
        return terminalType;
    }

    public String getBikeNumbers() {
        return bikeNumbers;
    }

    public String getBikeTypes() {
        return bikeTypes;
    }

    public Integer getPlaceType() {
        return placeType;
    }

    public Integer getBikeRacks() {
        return bikeRacks;
    }

    public Integer getRackLocks() {
        return rackLocks;
    }

    public List<Object> getList() {
        return list;
    }

    public static int compareDistance(Place c1, Place c2, Double lat, Double lng){  //todo
        Place virtualCityOfUserCoordinates = new Place();
        virtualCityOfUserCoordinates.lat = lat;
        virtualCityOfUserCoordinates.lng = lng;
        Double result = (haversineDistance(c1, virtualCityOfUserCoordinates) - haversineDistance(c2, virtualCityOfUserCoordinates));
        return  result.intValue();
    }

    public static double haversineDistance(Place pointA, Place pointB) {
        double deltaLat = Math.toRadians(pointB.lat - pointA.lat);
        double deltaLong = Math.toRadians(pointB.lng - pointA.lng);
        double a = Math.pow(Math.sin(deltaLat / 2), 2) + Math.cos(Math.toRadians(pointA.lat)) *
                Math.cos(Math.toRadians(pointB.lat)) * Math.pow(Math.sin(deltaLong / 2), 2);
        double greatCircleDistance = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return 3958.761 * greatCircleDistance;
    }


}
