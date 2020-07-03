package com.es3.controller;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Endpoint {
    @POST("api/users")
    Call<JsonObject> createUser(@Body JsonObject user);

    @GET("/api/users")
    Call<JsonObject> listUsers();
}
