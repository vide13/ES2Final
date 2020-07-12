package com.es3.service;

import com.es3.HTTPClient.Retrofit;
import com.es3.controller.Endpoint;
import com.es3.objects.Credentials;
import com.es3.objects.ListUsers;
import com.es3.objects.UserJob;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class EndpointNotFound {
    private static Endpoint endpoint;

    @BeforeAll
    static void setup() throws IOException {
        endpoint = Retrofit.getClient().create(Endpoint.class);
    }

    @Test
    void endpointNotFound() throws IOException {
        Call<ListUsers> request = endpoint.randomRequest();
        Response<ListUsers> response = request.execute();
        Assertions.assertEquals(404, response.code());
    }

}