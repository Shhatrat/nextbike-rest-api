package com.shhatrat.nextbike.model;

import com.shhatrat.nextbike.P;
import com.shhatrat.nextbike.Util;
import com.shhatrat.nextbike.api.ApiProvider;
import com.shhatrat.nextbike.model.original.Country;
import com.shhatrat.nextbike.model.original.Marker;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import org.simpleframework.xml.core.Persister;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

public class DataHolder {

    private static Optional<P<Date, Marker>> wholeMarker = Optional.empty();
    private static HashMap<String, P<Date, Marker>> countrySet = new HashMap();


    public static Single<Marker> getAllData(){
        try {
            if(wholeMarker.isPresent()){
                return Single.just(wholeMarker.get().getSecond());
            }else{
                return ApiProvider.getApi().getAll().map(DataHolder::convert).singleOrError();
            }
        }catch (Exception e){
            return Single.just(new Marker());
        }
    }

    static Marker convert(ResponseBody oo) throws  Exception{
        Marker m = new Persister().read(Marker.class, oo.string());
        wholeMarker = Optional.of(new P(new Date(), m));
        return m;
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
