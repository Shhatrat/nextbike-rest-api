package com.shhatrat.nextbike.model.original;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Bike {

    @Attribute
    Integer number;

    @Attribute(name = "bike_type")
    Integer bikeType;

    @Attribute(name = "lock_types")
    String lockTypes;

    @Attribute()
    Integer active;

    @Attribute
    String state;

    @Attribute(name = "electric_lock", required = false)
    Integer electricLock;

    @Attribute(name = "boardcomputer", required = false)
    String boardComputer;


    public Integer getNumber() {
        return number;
    }

    public Integer getBikeType() {
        return bikeType;
    }

    public String getLockTypes() {
        return lockTypes;
    }

    public Integer getActive() {
        return active;
    }

    public String getState() {
        return state;
    }

    public Integer getElectricLock() {
        return electricLock;
    }

    public String getBoardComputer() {
        return boardComputer;
    }
}
