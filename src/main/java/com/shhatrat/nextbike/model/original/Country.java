package com.shhatrat.nextbike.model.original;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.Root;

import java.util.List;

import static com.shhatrat.nextbike.Util.calculateDistanceBetweenPoints;

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
        return (int) (calculateDistanceBetweenPoints(c1.lat, virtualCityOfUserCoordinates.lat, c1.lng, virtualCityOfUserCoordinates.lng) - calculateDistanceBetweenPoints(c2.lat, virtualCityOfUserCoordinates.lat, c2.lng, virtualCityOfUserCoordinates.lng));
        }
}