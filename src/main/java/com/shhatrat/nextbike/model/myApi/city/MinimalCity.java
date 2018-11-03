package com.shhatrat.nextbike.model.myApi.city;

import com.shhatrat.nextbike.model.original.City;

/**
 * Minimal data about city
 */
public class MinimalCity {

    String name;
    Integer uid;

    public MinimalCity(String name, Integer id) {
        this.name = name;
        this.uid = id;
    }

    public MinimalCity(City ci) {
        this.name = ci.getName();
        this.uid = ci.getUid();
    }

    public String getName() {
        if(name!=null)
            return name;
        else return "";
    }

    public Integer getUid() {
        return uid;
    }
}
