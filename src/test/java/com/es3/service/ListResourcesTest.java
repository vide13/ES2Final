package com.es3.service;

import com.es3.HTTPClient.Retrofit;
import com.es3.controller.Endpoint;
import com.es3.objects.Credentials;
import com.es3.objects.ListResources;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class ListResourcesTest {

    private static Endpoint endpoint;
    private static String token;

    @BeforeAll
    static void setup() throws IOException {
        endpoint = Retrofit.getClient().create(Endpoint.class);
        token = endpoint.login(new Credentials("eve.holt@reqres.in", "cityslicka").toJsonObject()).execute().body().getToken();
    }

    @Test
    void listResources() throws IOException {
        Call<ListResources> request = endpoint.listResources(token);
        Response<ListResources> response = request.execute();
        Assertions.assertEquals(200, response.code());
        Assertions.assertNotNull(response.body());
    }
}
