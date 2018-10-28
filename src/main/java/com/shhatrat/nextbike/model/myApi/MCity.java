package com.shhatrat.nextbike.model.myApi;

import com.shhatrat.nextbike.model.original.City;

public class MCity {

    String name;
    Integer uid;

    public MCity(String name, Integer id) {
        this.name = name;
        this.uid = id;
    }

    public MCity(City ci) {
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
