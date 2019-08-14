package com.example.drivercab.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseClient {


    private final static String BaseUrl = "http://lotuscabs.com/api/";
    private static Retrofit retrofitEndPoint;

    public static Retrofit getBaseClient(){
        if(retrofitEndPoint == null){
            retrofitEndPoint = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitEndPoint;
    }

}
