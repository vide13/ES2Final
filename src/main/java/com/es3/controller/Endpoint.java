package com.es3.controller;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Endpoint {
    @POST("api/users")
    Call<JsonObject> create(@Body JsonObject user);
}
