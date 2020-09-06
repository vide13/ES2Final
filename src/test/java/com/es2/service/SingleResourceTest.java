package com.es2.service;

import com.es2.HTTPClient.Retrofit;
import com.es2.controller.Endpoint;
import com.es2.objects.Credentials;
import com.es2.objects.SingleResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class SingleResourceTest {

    private static Endpoint endpoint;
    private static String token;

    @BeforeAll
    static void setup() throws IOException {
        endpoint = Retrofit.getClient().create(Endpoint.class);
        token = endpoint.login(new Credentials("eve.holt@reqres.in", "cityslicka").toJsonObject()).execute().body().getToken();
    }

    @Test
    void lowerInvalidBoundaryId() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleResource> request = endpoint.singleResource(token, 0);
        Response<SingleResource> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }

    @Test
    void lowerValidBoundaryId() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleResource> request = endpoint.singleResource(token, 1);
        Response<SingleResource> response = request.execute();
        Assertions.assertEquals(200, response.code());
    }

    @Test
    void upperValidBoundaryId() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleResource> request = endpoint.singleResource(token, 10000);
        Response<SingleResource> response = request.execute();
        Assertions.assertEquals(200, response.code());
    }

    @Test
    void upperInvalidBoundaryId() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleResource> request = endpoint.singleResource(token, 10001);
        Response<SingleResource> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }
}
