package com.shhatrat.nextbike.model.original;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.Root;

import java.util.List;


@Root(strict = false)
public class Marker {

    @ElementListUnion({
            @ElementList(entry = "country", type = Country.class, inline = true)
    })
    List<Country> countryList;


    public List<Country> getCountryList() {
        return countryList;
    }

    public Country getCountry(){
        return countryList.get(0);
    }
}