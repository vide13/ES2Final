package com.es2.network;

import com.es2.network.apiResponse.*;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface APIManager {

    /**
     * - List Users
     *
     * @return list of users
     */
    @GET("/api/users")
    Call<UsersApiResponse> listUsers();

    /**
     * - Get user data by id
     *
     * @param id - User id
     * @return User info
     */
    @GET("/api/users/{id}")
    Call<UserApiResponse> getUser(@Path("id") long id);

    /**
     * - List Resources
     *
     * @return list of resources
     */
    @GET("/api/unknown")
    Call<ResourcesApiResponse> listResources();

    /**
     * - Get resource by id
     *
     * @param id - Resource id
     * @return Resource if successful
     */
    @GET("/api/unknown/{id}")
    Call<ResourceApiResponse> getResource(@Path("id") long id);

    /**
     * - Create user
     *
     * @param user Json Object generated by the UserJob parser
     * @return CreateUserAPIResponse
     */
    @POST("/api/users")
    Call<CreateUserAPIResponse> createUser(@Body JsonObject user);

    /**
     * - Register User
     *
     * @param user - Json Object generated by the UserCredentials parser
     * @return - RegisterUserAPIResponse
     */
    @POST("/api/register")
    Call<RegisterUserAPIResponse> registerUser(@Body JsonObject user);

    /**
     * Authenticate User
     *
     * @param user - name and password
     * @return token if success
     */
    @POST("/api/login")
    Call<LoginUserAPIResponse> loginUser(@Body JsonObject user);
}