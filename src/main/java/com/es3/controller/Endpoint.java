package com.es3.controller;

import com.es3.objects.*;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Endpoint {
    @POST("api/users")
    Call<UserJob> createUser(@Body JsonObject jsonObject);

    @GET("/api/users/{id}")
    Call<SingleUser> singleUser(@Path("id") Integer id);

    @GET("/api/users")
    Call<ListUsers> listUsers();

    @POST("/api/register")
    Call<Register> register(@Body JsonObject jsonObject);

    @POST("/api/login")
    Call<Login> login(@Body JsonObject jsonObject);

    @GET("/api/unknown")
    Call<ListResources> listResources();

    @GET("/api/unknown/{id}")
    Call<SingleResource> singleResource(@Path("id") long id);

    @GET("/api/random")
    Call<ListUsers> randomRequest();
}
