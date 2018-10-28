package com.shhatrat.nextbike.model.myApi;

import com.shhatrat.nextbike.model.original.Country;

import java.util.List;
import java.util.stream.Collectors;

public class MCountry {

    String name;
    List<MCity> mCities;

    public MCountry(Country c) {
       this.name = c.name;
       this. mCities = c.getCityList().stream().map(ci -> new MCity(ci)).collect(Collectors.toList());
    }

    public String getName() {
        if(name!=null)
            return name;
        else
            return "";
    }

    public List<MCity> getmCities() {
        return mCities;
    }
}
