package com.shhatrat.nextbike.model.myApi;

import com.shhatrat.nextbike.model.myApi.city.MinimalCity;
import com.shhatrat.nextbike.model.original.Country;

import java.util.List;
import java.util.stream.Collectors;

public class MCountry {

    String name;
    List<MinimalCity> mCities;

    public MCountry(Country c) {
       this.name = c.name;
       this. mCities = c.getCityList().stream().map(ci -> new MinimalCity(ci)).collect(Collectors.toList());
    }

    public String getName() {
        if(name!=null)
            return name;
        else
            return "";
    }

    public List<MinimalCity> getmCities() {
        return mCities;
    }
}
