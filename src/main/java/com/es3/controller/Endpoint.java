package com.es3.controller;

import com.es3.objects.UserJob;
import com.es3.objects.UserPage;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Endpoint {
    @POST("api/users")
    Call<UserJob> createUser(@Body JsonObject user);

    @GET("/api/users")
    Call<UserPage> listUsers();
}
