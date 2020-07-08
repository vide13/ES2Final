package com.es3.service;

import com.es3.HTTPClient.Retrofit;
import com.es3.controller.Endpoint;
import com.es3.objects.ListUsers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class ListUsersTest {
    @Test
    void listUsers() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<ListUsers> request = endpoint.listUsers();
        Response<ListUsers> response = request.execute();
        Assertions.assertEquals(200, response.code());
        Assertions.assertNotNull(response.body());
    }
}
