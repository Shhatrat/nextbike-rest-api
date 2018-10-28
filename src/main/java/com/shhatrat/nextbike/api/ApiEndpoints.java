package com.shhatrat.nextbike.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface ApiEndpoints{

    String URL = "https://api.nextbike.net/maps/";

    @GET("nextbike-offical.xml")
    Observable<ResponseBody> getAll();

    @GET("nextbike-offical.xml?city={city}")
    Observable<Response<Void>> getCity(
            @Path("city") String city);
}
