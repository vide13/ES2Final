package com.es3.service;

import com.es3.HTTPClient.Retrofit;
import com.es3.controller.Endpoint;
import com.es3.objects.Credentials;
import com.es3.objects.ListUsers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class ListUsersTest {

    private static Endpoint endpoint;
    private static String token;

    @BeforeAll
    static void setup() throws IOException {
        endpoint = Retrofit.getClient().create(Endpoint.class);
        token = endpoint.login(new Credentials("eve.holt@reqres.in", "cityslicka").toJsonObject()).execute().body().getToken();
    }

    @Test
    void listUsers() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<ListUsers> request = endpoint.listUsers(token);
        Response<ListUsers> response = request.execute();
        Assertions.assertEquals(200, response.code());
        Assertions.assertNotNull(response.body());
    }
}
