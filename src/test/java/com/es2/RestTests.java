package com.es2;

import com.es2.network.apiResponse.UserApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static com.es2.data.HttpCodes.*;


public class RestTests {
    @Test
    void newUser() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertEquals(CREATED, topTierAPI.newUser("teste", "agricultor").code());
    }

    @Test
    void newUserNullName() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertEquals(SEMANTIC_ERROR, topTierAPI.newUser(null, "agricultor").code());
    }

    @Test
    void newUserBlankJob() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertEquals(SEMANTIC_ERROR, topTierAPI.newUser("teste", " ").code());
    }

    @Test
    void getUserById() throws IOException {
        //Cache doesnt have user whit id 1 -> request made do reqres and user added to cache
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Response<UserApiResponse> userCall1 = topTierAPI.getUserById(1);
        Assertions.assertEquals(OK, userCall1.code());
        Assertions.assertEquals("https://reqres.in/api/users/1", userCall1.raw().request().url().toString());

        //Cache has user whit id 1 -> request made to cache
        Response<UserApiResponse> userCall2 = topTierAPI.getUserById(1);
        Assertions.assertEquals(OK, userCall2.code());
        Assertions.assertEquals("http://localhost/", userCall2.raw().request().url().toString());
    }

    @Test
    void getUserByIdNullName() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertEquals(SEMANTIC_ERROR, topTierAPI.getUserById(null).code());
    }


    @Test
    void listUsers() throws IOException {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertEquals(OK, topTierAPI.listUsers().code());
    }
}
