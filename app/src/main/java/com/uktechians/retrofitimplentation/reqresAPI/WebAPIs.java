package com.uktechians.retrofitimplentation.reqresAPI;

import com.uktechians.retrofitimplentation.reqresData.ReqresModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebAPIs {


    @GET("/api/users?")
    Call<ReqresModel> call(@Query("page") String page);



}
