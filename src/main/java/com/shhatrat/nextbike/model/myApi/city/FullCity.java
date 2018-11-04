package com.shhatrat.nextbike.model.myApi.city;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shhatrat.nextbike.model.original.City;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FullCity {

    String name;
    Integer uid;
    Double lat;
    Double lng;
    Integer availableBikes;
    Integer numPlaces;

    public FullCity(String name, Integer uid, Double lat, Double lng, Integer availableBikes, Integer numPlaces) {
        this.name = name;
        this.uid = uid;
        this.lat = lat;
        this.lng = lng;
        this.availableBikes = availableBikes;
        this.numPlaces = numPlaces;
    }

    public FullCity(City c) {
        this.name = c.getName();
        this.uid = c.getUid();
        this.lat = c.getLat();
        this.lng = c.getLng();
        this.availableBikes = c.getAvailableBikes();
        this.numPlaces = c.getNumPlaces();
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public void setAvailableBikes(Integer availableBikes) {
        this.availableBikes = availableBikes;
    }

    public void setNumPlaces(Integer numPlaces) {
        this.numPlaces = numPlaces;
    }

    public String getName() {
        return name;
    }

    public Integer getUid() {
        return uid;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public Integer getAvailableBikes() {
        return availableBikes;
    }

    public Integer getNumPlaces() {
        return numPlaces;
    }
}
