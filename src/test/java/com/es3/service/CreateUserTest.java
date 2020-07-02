package com.es3.service;

import com.es3.HTTPClient.Retrofit;
import com.es3.controller.Endpoint;
import com.es3.objects.UserJob;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class CreateUserTest {

    @Test
    void createUser() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob("morpheus", "leader");
        Call<JsonObject> request = endpoint.create(user.toJsonObject());
        Response<JsonObject> response = request.execute();
        Assertions.assertEquals(201, response.code());
        assert response.body() != null;
        Assertions.assertEquals("morpheus", response.body().get("name").getAsString());
        Assertions.assertEquals("leader", response.body().get("job").getAsString());
        Assertions.assertNotNull(response.body().get("id"));
        Assertions.assertNotNull(response.body().get("createdAt"));
    }
}
