package com.es3.service;

import com.es3.HTTPClient.Retrofit;
import com.es3.controller.Endpoint;
import com.es3.objects.SingleResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class SingleResourceTest {

    @Test
    void singleResourceBigId() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleResource> request = endpoint.singleResource(1000000);
        Response<SingleResource> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void singleResourceIdLesserThanZero() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleResource> request = endpoint.singleResource(-5);
        Response<SingleResource> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void singleResourceSuccessful() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleResource> request = endpoint.singleResource(2);
        Response<SingleResource> response = request.execute();
        Assertions.assertEquals(200, response.code());
        assert response.body() != null;
        Assertions.assertEquals(2, response.body().getData().getId());
        Assertions.assertEquals("fuchsia rose", response.body().getData().getName());
        Assertions.assertEquals(2001, response.body().getData().getYear());
        Assertions.assertEquals("#C74375", response.body().getData().getColor());
        Assertions.assertEquals("17-2031", response.body().getData().getPantone_value());
    }

    @Test
    void singleResourceNotFound() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleResource> request = endpoint.singleResource(23);
        Response<SingleResource> response = request.execute();
        Assertions.assertEquals(404, response.code());
        Assertions.assertNull(response.body());
    }
}
