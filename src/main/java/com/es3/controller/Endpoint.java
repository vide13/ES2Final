package com.es3.controller;

import com.es3.objects.*;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.*;

public interface Endpoint {
    @POST("api/users")
    Call<UserJob> createUser(@Header("Token") String token, @Body JsonObject jsonObject);

    @GET("/api/users/{id}")
    Call<SingleUser> singleUser(@Header("Token") String token, @Path("id") Integer id);

    @GET("/api/users")
    Call<ListUsers> listUsers(@Header("Token") String token);

    @POST("/api/register")
    Call<Register> register(@Body JsonObject jsonObject);

    @POST("/api/login")
    Call<Login> login(@Body JsonObject jsonObject);

    @GET("/api/unknown")
    Call<ListResources> listResources(@Header("Token") String token);

    @GET("/api/unknown/{id}")
    Call<SingleResource> singleResource(@Header("Token") String token, @Path("id") long id);

    @GET("/api/random")
    Call<ListUsers> randomRequest();
}
