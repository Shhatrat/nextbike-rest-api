package com.shhatrat.nextbike.model.nextbike;

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


    public List<City> getCityList() {
        return cityList;
    }

    public City getCity(){
        return cityList.get(0);
    }
}
