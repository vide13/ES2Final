package com.es2.service;

import com.es2.HTTPClient.Retrofit;
import com.es2.controller.Endpoint;
import com.es2.objects.Credentials;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class RandomUserTest {

    private static Endpoint endpoint;
    private static String token;

    @BeforeAll
    static void setup() throws IOException {
        endpoint = Retrofit.getClient().create(Endpoint.class);
        token = endpoint.login(new Credentials("eve.holt@reqres.in", "cityslicka").toJsonObject()).execute().body().getToken();
    }

    @Test
    void successful() throws IOException {
        Call<JsonObject> request = endpoint.randomUser(token);
        Response<JsonObject> response = request.execute();
        Assertions.assertEquals(200, response.code());
    }

    @Test
    void correctPayload() throws IOException {
        Call<JsonObject> request = endpoint.randomUser(token);
        Response<JsonObject> response = request.execute();
        System.out.println(response.body().get("data"));
        Assertions.assertEquals(1, response.body().get("data").getAsJsonArray().size());
    }
}
