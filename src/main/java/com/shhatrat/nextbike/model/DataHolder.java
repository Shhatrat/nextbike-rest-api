package com.shhatrat.nextbike.model;

import com.shhatrat.nextbike.P;
import com.shhatrat.nextbike.api.ApiProvider;
import com.shhatrat.nextbike.model.original.City;
import com.shhatrat.nextbike.model.original.Marker;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import org.joda.time.DateTime;
import org.simpleframework.xml.core.Persister;

import java.util.HashMap;
import java.util.Optional;

public class DataHolder {

    private static Optional<P<DateTime, Marker>> wholeMarker = Optional.empty();
    private static HashMap<Integer, P<DateTime, City>> countrySet = new HashMap();


    public static Single<Marker> getAllData(){
        try {
            if(wholeMarker.isPresent() && wholeMarker.get().getFirst().isAfter(DateTime.now().minusHours(6))){
                return Single.just(wholeMarker.get().getSecond());
            }else{
                return ApiProvider.getApi().getAll().map(DataHolder::convert).singleOrError();
            }
        }catch (Exception e){
            return Single.just(new Marker());
        }
    }

    static Marker convert(ResponseBody data) throws  Exception{
        Marker m = new Persister().read(Marker.class, data.string());
        wholeMarker = Optional.of(new P(DateTime.now(), m));
        return m;
    }

    static City convertCity(ResponseBody oo) {
        try {
            Marker m = new Persister().read(Marker.class, oo.string());
            City c = m.getCountry().getCity();
            countrySet.put(c.getUid(), new P(DateTime.now(), c));
            return c;
        }catch (Throwable e){
            return new City();
        }
    }

    public static Single<City> getCity(Integer cityUidName){
        try {
            if(countrySet.containsKey(cityUidName) && countrySet.get(cityUidName).getFirst().isAfter(DateTime.now().minusMinutes(5))){
                return Single.just(countrySet.get(cityUidName).getSecond());
            }else{
                return ApiProvider.getApi().getCity(cityUidName.toString()).map(DataHolder::convertCity).singleOrError();
            }
        }catch (Exception e){
            return Single.just(new City());
        }
    }
}
