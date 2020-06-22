package com.es2;

import com.es2.cache.UserManager;
import com.es2.network.apiResponse.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

class TopTierAPITest {


    @Test
    void newUserNull() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertEquals("Invalid Arguments", topTierAPI.newUser(null, null).errorBody().string());
    }

    @Test
    void newUserBlank() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertEquals("Empty Arguments", topTierAPI.newUser("", "").errorBody().string());
    }

    @Test
    void newUserSuccessful() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Response<CreateUserAPIResponse> response = topTierAPI.newUser("Jane", "Scientist");
        Assertions.assertEquals(CreateUserAPIResponse.class, response.body().getClass());
        Assertions.assertEquals("Jane", response.body().getName());
    }

    @Test
    void getUserByIdNull() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertEquals("Invalid Argument", topTierAPI.getUserById(null).errorBody().string());
    }

    @Test
    void getUserByIdSuccessful() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        UserManager.getInstance().deleteUser(1);

        //Cache doesnt have user with id 1 -> request made do reqres and user added to cache
        Response<UserApiResponse> firstCall = topTierAPI.getUserById(1);
        Assertions.assertEquals(1, firstCall.body().getUser().getId());
        Assertions.assertEquals("https://reqres.in/api/users/1", firstCall.raw().request().url().toString());
        Assertions.assertEquals(UserApiResponse.class, firstCall.body().getClass());

        //Cache has user with id 1, request is made to cache
        Response<UserApiResponse> secondCall = topTierAPI.getUserById(1);
        Assertions.assertEquals(1, secondCall.body().getUser().getId());
        Assertions.assertEquals("http://localhost/", secondCall.raw().request().url().toString());
        Assertions.assertEquals(UserApiResponse.class, secondCall.body().getClass());
    }

    @Test
    void getUserByIdNotInRange() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertEquals("Invalid Argument", topTierAPI.getUserById(Integer.MAX_VALUE + 1).errorBody().string());
    }

    @Test
    void getUserByIdUnsuccessful() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertNotNull(topTierAPI.getUserById(-1).errorBody());
    }

    @Test
    void listUsers() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Response<UsersApiResponse> response = topTierAPI.listUsers();
        Assertions.assertNotNull(response.body());
        Assertions.assertEquals(UsersApiResponse.class, response.body().getClass());
    }

    @Test
    void registerUserNull() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertEquals("Invalid Argument", topTierAPI.registerUser(null, null).errorBody().string());
    }

    @Test
    void registerUserEmpty() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertEquals("Invalid Argument", topTierAPI.registerUser("", "").errorBody().string());
    }

    @Test
    void registerUserSuccessful() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Response<RegisterUserAPIResponse> response = topTierAPI.registerUser("eve.holt@reqres.in", "passTeste");
        Assertions.assertNotNull(response.body());
        Assertions.assertEquals(RegisterUserAPIResponse.class, response.body().getClass());
    }

    @Test
    void registerUserUnsuccessful() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Response<RegisterUserAPIResponse> response = topTierAPI.registerUser("invalidemail", "passTeste");
        Assertions.assertNotNull(response.errorBody());
    }

    @Test
    void authUserNull() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertEquals("Invalid Argument", topTierAPI.authUser(null, null).errorBody().string());
    }

    @Test
    void authUserEmpty() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertEquals("Invalid Argument", topTierAPI.authUser("", "").errorBody().string());
    }

    @Test
    void authUserSuccessful() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Response<LoginUserAPIResponse> response = topTierAPI.authUser("eve.holt@reqres.in", "passTeste");
        Assertions.assertEquals(LoginUserAPIResponse.class, response.body().getClass());
    }

    @Test
    void authUserUnsuccessful() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Response<LoginUserAPIResponse> response = topTierAPI.authUser("invalidEmail", "passTeste");
        Assertions.assertNull(response.body());
    }

    @Test
    void listResources() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Response<ResourcesApiResponse> response = topTierAPI.listResources();
        Assertions.assertNotNull(response.body());
        Assertions.assertEquals(ResourcesApiResponse.class, response.body().getClass());
    }

    @Test
    void getResourceByIdNull() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertEquals("Invalid Argument", topTierAPI.getResourceById(null).errorBody().string());
    }

    @Test
    void getResourceByIdSuccessful() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Response<ResourceApiResponse> firstCall = topTierAPI.getResourceById(1);
        //Get from reqres
        Assertions.assertEquals(1, firstCall.body().getData().getId());
        Assertions.assertEquals(ResourceApiResponse.class, firstCall.body().getClass());
        //Get from cache
        Response<ResourceApiResponse> secondCall = topTierAPI.getResourceById(1);
        Assertions.assertEquals(1, secondCall.body().getData().getId());
        Assertions.assertEquals(ResourceApiResponse.class, secondCall.body().getClass());
    }

    @Test
    void getResourceByIdNotInRange() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertEquals("Invalid Argument", topTierAPI.getResourceById(Integer.MAX_VALUE + 1).errorBody().string());
    }

    @Test
    void getResourceByIdUnsuccessful() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertNull(topTierAPI.getResourceById(-1).body());
    }
}