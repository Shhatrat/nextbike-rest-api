package com.shhatrat.nextbike.api;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class ApiProvider{

    private static ApiEndpoints api;

    public static ApiEndpoints getApi(){
        if(api == null){
           api = createWebService(createOkHttpClient(), ApiEndpoints.URL);
        }
        return api;
    }

    private static OkHttpClient createOkHttpClient(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .connectTimeout(60L, TimeUnit.SECONDS)
                .readTimeout(60L, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor).build();
    }

    private static ApiEndpoints createWebService(OkHttpClient okHttpClient,  String url){
        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        return retrofit.create(ApiEndpoints.class);
    }
}
