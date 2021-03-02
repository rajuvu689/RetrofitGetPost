package com.rtsoftworld.retrofitgetpost.network;

import com.rtsoftworld.retrofitgetpost.Model.MyDataModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/json")  // /json is a path parameter. it detects endpoint of the api
    Call<MyDataModel> getMyIp();
}
