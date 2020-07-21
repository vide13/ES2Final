package com.es3.service;

import com.es3.HTTPClient.Retrofit;
import com.es3.controller.Endpoint;
import com.es3.objects.Credentials;
import com.es3.objects.SingleResource;
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
    void singleResourceBigId() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleResource> request = endpoint.singleResource(token, 1000000);
        Response<SingleResource> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void singleResourceIdLesserThanZero() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleResource> request = endpoint.singleResource(token, -5);
        Response<SingleResource> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void singleResourceNotFound() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleResource> request = endpoint.singleResource(token, 23);
        Response<SingleResource> response = request.execute();
        Assertions.assertEquals(404, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void singleResourceSuccessful() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleResource> request = endpoint.singleResource(token, 2);
        Response<SingleResource> response = request.execute();
        Assertions.assertEquals(200, response.code());
        assert response.body() != null;
        Assertions.assertEquals(2, response.body().getData().getId());
        Assertions.assertEquals("fuchsia rose", response.body().getData().getName());
        Assertions.assertEquals(2001, response.body().getData().getYear());
        Assertions.assertEquals("#C74375", response.body().getData().getColor());
        Assertions.assertEquals("17-2031", response.body().getData().getPantone_value());
    }
}
