package com.es3.service;

import com.es3.HTTPClient.Retrofit;
import com.es3.controller.Endpoint;
import com.es3.objects.Credentials;
import com.es3.objects.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class LoginUserTest {
    private final String BIG_STRING = "estaStringTemMaisDeCinquentaCaracteresAoTodoSaoMais";

    @Test
    void loginUserBigNameBigJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(BIG_STRING, BIG_STRING);
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserBigNameBlankJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(BIG_STRING, " ");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserBigNameEmptyJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(BIG_STRING, "");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserBigNameGoodJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(BIG_STRING, "leader");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserBigNameNullJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(BIG_STRING, null);
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserBlankNameBlankJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(" ", " ");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserBlankNameEmptyJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(" ", "");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserBlankNameGoodJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(" ", "leader");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserBlankNameNullJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(" ", null);
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserEmptyNameBigJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("", BIG_STRING);
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserEmptyNameBlankJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("", " ");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserEmptyNameEmptyJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("", "");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserEmptyNameGoodJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("", "leader");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserEmptyNameNullJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("", null);
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserGoodNameBigJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("morpheus", BIG_STRING);
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserGoodNameBlankJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("morpheus", " ");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserGoodNameEmptyJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("morpheus", "");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserGoodNameNullJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("morpheus", null);
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserNullNameBigJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(null, BIG_STRING);
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserNullNameBlankJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(null, " ");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserNullNameEmptyJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(" ", " ");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserNullNameGoodJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(null, "leader");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserNullNameNullJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials(null, null);
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(400, response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void loginUserSuccessful() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Credentials user = new Credentials("eve.holt@reqres.in", "pistol");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(200, response.code());
        assert response.body() != null;
        Assertions.assertNotNull(response.body().getToken());
    }
}
