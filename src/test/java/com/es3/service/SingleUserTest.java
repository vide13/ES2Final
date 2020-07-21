package com.es3.service;

import com.es3.HTTPClient.Retrofit;
import com.es3.controller.Endpoint;
import com.es3.objects.Credentials;
import com.es3.objects.SingleUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class SingleUserTest {

    private static Endpoint endpoint;
    private static String token;

    @BeforeAll
    static void setup() throws IOException {
        endpoint = Retrofit.getClient().create(Endpoint.class);
        token = endpoint.login(new Credentials("eve.holt@reqres.in", "cityslicka").toJsonObject()).execute().body().getToken();
    }

    @Test
    void singleUserBigId() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleUser> request = endpoint.singleUser(token, 1000000);
        Response<SingleUser> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void singleUserIdLesserThanZero() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleUser> request = endpoint.singleUser(token, -5);
        Response<SingleUser> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void singleUserNotFound() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleUser> request = endpoint.singleUser(token, 23);
        Response<SingleUser> response = request.execute();
        Assertions.assertEquals(404, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void singleUserSuccessful() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<SingleUser> request = endpoint.singleUser(token, 2);
        Response<SingleUser> response = request.execute();
        Assertions.assertEquals(200, response.code());
        assert response.body() != null;
        Assertions.assertEquals(2, response.body().getData().getId());
        Assertions.assertEquals("janet.weaver@reqres.in", response.body().getData().getEmail());
        Assertions.assertEquals("Janet", response.body().getData().getFirst_name());
        Assertions.assertEquals("Weaver", response.body().getData().getLast_name());
        Assertions.assertEquals("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", response.body().getData().getAvatar());
    }

}
