package com.shhatrat.nextbike.model.nextbike;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class City {

    @Attribute
    Integer uid;

    @Attribute
    Double lat;

    @Attribute
    Double lng;

    @Attribute
    Integer zoom;

    @Attribute(name = "maps_icon")
    String mapsIcon;

    @Attribute
    String name;

    @Attribute
    String alias;

    @ElementListUnion({
            @ElementList(entry = "place", type = Place.class, inline = true, required = false)
    })
    List<Place> placeList;

    @Attribute(name = "break", required = false)
    Integer breakNumber;


    @Attribute(name = "num_places", required = false)
    Integer numPlaces;

    @Attribute(name = "refresh_rate", required = false)
    Integer refreshRate;

    @Attribute(name = "booked_bikes", required = false)
    Integer bookedBikes;

    @Attribute(name = "bike_types", required = false)
    String bikeTypes;

    @Attribute(name = "return_to_official_only", required = false)
    Integer returnToOfficialOnly;


    public Integer getUid() {
        return uid;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public Integer getZoom() {
        return zoom;
    }

    public String getMapsIcon() {
        return mapsIcon;
    }

    public String getName() {
        return name;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public String getAlias() {
        return alias;
    }

    public Integer getBreakNumber() {
        return breakNumber;
    }

    public Integer getNumPlaces() {
        return numPlaces;
    }

    public Integer getRefreshRate() {
        return refreshRate;
    }

    public Integer getBookedBikes() {
        return bookedBikes;
    }

    public String getBikeTypes() {
        return bikeTypes;
    }

    public Integer getReturnToOfficialOnly() {
        return returnToOfficialOnly;
    }
}