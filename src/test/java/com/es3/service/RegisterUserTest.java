package com.es3.service;

import com.es3.HTTPClient.Retrofit;
import com.es3.controller.Endpoint;
import com.es3.objects.Credentials;
import com.es3.objects.Register;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class RegisterUserTest {
    private final String BIG_STRING = "estaStringTemMaisDeCinquentaCaracteresAoTodoSaoMais";

    @Test
    void registerUserBigNameBigJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(BIG_STRING, BIG_STRING);
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserBigNameBlankJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(BIG_STRING, " ");
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserBigNameEmptyJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(BIG_STRING, "");
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserBigNameGoodJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(BIG_STRING, "leader");
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserBigNameNullJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(BIG_STRING, null);
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserBlankNameBlankJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(" ", " ");
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserBlankNameEmptyJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(" ", "");
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserBlankNameGoodJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(" ", "leader");
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserBlankNameNullJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(" ", null);
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserEmptyNameBigJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("", BIG_STRING);
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserEmptyNameBlankJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("", " ");
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserEmptyNameEmptyJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("", "");
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserEmptyNameGoodJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("", "leader");
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserEmptyNameNullJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("", null);
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserGoodNameBigJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("morpheus", BIG_STRING);
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserGoodNameBlankJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("morpheus", " ");
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserGoodNameEmptyJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("morpheus", "");
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserGoodNameNullJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("morpheus", null);
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserNullNameBigJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(null, BIG_STRING);
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserNullNameBlankJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(null, " ");
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserNullNameEmptyJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(" ", " ");
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserNullNameGoodJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(null, "leader");
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserNullNameNullJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(null, null);
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void registerUserSuccessful() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("eve.holt@reqres.in", "pistol");
        Call<Register> request = endpoint.register(user.toJsonObject());
        Response<Register> response = request.execute();
        Assertions.assertEquals(200, response.code());
        assert response.body() != null;
        Assertions.assertNotNull(response.body().getId());
        Assertions.assertNotNull(response.body().getToken());
    }

}
