package com.shhatrat.nextbike.model;

import com.shhatrat.nextbike.Util;
import com.shhatrat.nextbike.model.original.Country;
import com.shhatrat.nextbike.model.original.Marker;
import io.reactivex.Single;
import org.simpleframework.xml.core.Persister;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Optional;

public class DataHolder {

    public static Single<Marker> getAllData(){
        try {
            Persister serializer = new Persister();
            File xml = new ClassPathResource("nextbike-offical.xml").getFile();
            Util.readFile(xml.getPath(), Charset.defaultCharset());
            Marker marker = serializer.read(Marker.class, xml);
            return Single.just(marker);
        }catch (Exception e){
            return Single.just(new Marker());
        }
    }

    public static Single<Country> getCountry(String countryName){
        try {
            Persister serializer = new Persister();
            File xml = new ClassPathResource("nextbike-offical.xml").getFile();
            Util.readFile(xml.getPath(), Charset.defaultCharset());
            Marker marker = serializer.read(Marker.class, xml);
            return Single.just(marker.getCountryList().stream().filter(c -> c.name.equals(countryName)).findFirst().get());
        }catch (Exception e){
            return Single.just(new Country());
        }
    }

}
