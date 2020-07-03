package com.es3.service;

import com.es3.HTTPClient.Retrofit;
import com.es3.controller.Endpoint;
import com.es3.objects.UserJob;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class CreateSingleUserTest {

    @Test
    void createUser() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob("morpheus", "leader");
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertEquals(201, response.code());
        assert response.body() != null;
        Assertions.assertEquals("morpheus", response.body().getName());
        Assertions.assertEquals("leader", response.body().getJob());
        Assertions.assertNotNull(response.body().getId());
        Assertions.assertNotNull(response.body().getCreatedAt());
    }
}
