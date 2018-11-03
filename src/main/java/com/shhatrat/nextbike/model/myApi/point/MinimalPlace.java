package com.shhatrat.nextbike.model.myApi.point;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shhatrat.nextbike.model.original.Place;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MinimalPlace {

    String uid;
    Double lat;
    Double lng;
    String name;
    Integer bikes;
    Integer bikeRacks;

    public MinimalPlace(Place p){
        this.uid = p.getUid();
        this.name = p.getName();
        this.lat = p.getLat();
        this.lng = p.getLng();
        this.bikeRacks = p.getBikeRacks();
        this.bikes = p.getBikes();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBikes() {
        return bikes;
    }

    public void setBikes(Integer bikes) {
        this.bikes = bikes;
    }

    public Integer getBikeRacks() {
        return bikeRacks;
    }

    public void setBikeRacks(Integer bikeRacks) {
        this.bikeRacks = bikeRacks;
    }
}
