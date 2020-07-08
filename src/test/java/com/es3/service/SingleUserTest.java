package com.es3.service;

import com.es3.HTTPClient.Retrofit;
import com.es3.controller.Endpoint;
import com.es3.objects.SingleUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class SingleUserTest {
    @Test
    void singleUserBigId() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleUser> request = endpoint.singleUser(1000000);
        Response<SingleUser> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void singleUserIdLesserThanZero() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleUser> request = endpoint.singleUser(-5);
        Response<SingleUser> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void singleUserSuccessful() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleUser> request = endpoint.singleUser(2);
        Response<SingleUser> response = request.execute();
        Assertions.assertEquals(200, response.code());
        assert response.body() != null;
        Assertions.assertEquals(2, response.body().getData().getId());
        Assertions.assertEquals("janet.weaver@reqres.in", response.body().getData().getEmail());
        Assertions.assertEquals("Janet", response.body().getData().getFirst_name());
        Assertions.assertEquals("Weaver", response.body().getData().getLast_name());
        Assertions.assertEquals("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", response.body().getData().getAvatar());
    }

    @Test
    void singleUserNotFound() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleUser> request = endpoint.singleUser(23);
        Response<SingleUser> response = request.execute();
        Assertions.assertEquals(404, response.code());
        Assertions.assertNull(response.body());
    } 

}
