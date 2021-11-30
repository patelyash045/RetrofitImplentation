package com.uktechians.retrofitimplentation.reqresAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static RetrofitClient instance = null;
    private Retrofit retrofit;


    public RetrofitClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitClient getInstance(){

        if (instance==null){
            instance = new RetrofitClient();
        }
        return instance;
    }

    public Retrofit getClient(){
        return retrofit;
    }

}
