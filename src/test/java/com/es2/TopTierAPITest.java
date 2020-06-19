package com.es2;

import com.es2.Exceptions.InvalidArguments;
import com.es2.Exceptions.UserNotFoundException;
import com.es2.network.apiResponse.UserApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

class TopTierAPITest {

    @Test
    void newUser() throws IOException, InvalidArguments {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertEquals(201, topTierAPI.newUser("teste", "agricultor").code());
    }

    @Test
    void getUserById() throws IOException, UserNotFoundException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        //Cache doesnt have user whit id 1 -> request made do reqres and user added to cache
        Response<UserApiResponse> firstCall = topTierAPI.getUserById(1);
        Assertions.assertEquals(1, firstCall.body().getUser().getId());
        Assertions.assertEquals("https://reqres.in/api/users/1", firstCall.raw().request().url().toString());

        //Cache has user whit id 1, request is made to cache
        Response<UserApiResponse> secondCall = topTierAPI.getUserById(1);
        Assertions.assertEquals(1, secondCall.body().getUser().getId());
        Assertions.assertEquals("http://localhost/", secondCall.raw().request().url().toString());
    }
}