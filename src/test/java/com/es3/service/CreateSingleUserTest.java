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
    private final String BIG_STRING = "estaStringTemMaisDeCinquentaCaracteresAoTodoSaoMais";

    @Test
    void createUserSuccessful() throws IOException {
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

    @Test
    void createUserBigNameBigJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob(BIG_STRING, BIG_STRING);
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void crateUserBigNameBlankJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob(BIG_STRING, " ");
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserBigNameEmptyJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob(BIG_STRING, "");
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }


    @Test
    void createUserBigNameGoodJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob(BIG_STRING, "leader");
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserBigNameNullJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob(BIG_STRING, null);
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserBlankNameBlankJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob(" ", " ");
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserBlankNameEmptyJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob(" ", "");
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserBlankNameGoodJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob(" ", "leader");
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserBlankNameNullJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob(" ", null);
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserEmptyNameBigJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob("", BIG_STRING);
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserEmptyNameBlankJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob("", " ");
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserEmptyNameEmptyJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob("", "");
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserEmptyNameGoodJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob("", "leader");
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserEmptyNameNullJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob("", null);
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserGoodNameBigJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob("morpheus", BIG_STRING);
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserGoodNameBlankJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob("morpheus", " ");
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserGoodNameEmptyJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob("morpheus", "");
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserGoodNameNullJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob("morpheus", null);
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserNullNameBigJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob(null, BIG_STRING);
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserNullNameBlankJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob(null, " ");
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserNullNameEmptyJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob(" ", " ");
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserNullNameGoodJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob(null, "leader");
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

    @Test
    void createUserNullNameNullJob() throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        UserJob user = new UserJob(null, null);
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(299 < response.code());
        Assertions.assertNull(response.body());
    }

}
