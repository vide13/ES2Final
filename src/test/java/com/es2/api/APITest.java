package com.es2.api;

import com.es2.data.UserCredentials;
import com.es2.data.UserJob;
import com.es2.network.APIManager;
import com.es2.network.apiResponse.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static com.es2.api.APIClient.getClient;
import static com.es2.data.HttpCodes.*;

class APITest {

    @Test
    void newUser() throws IOException {
        APIManager service = getClient().create(APIManager.class);

        UserJob userJob = new UserJob("TestName", "tester");
        Call<CreateUserAPIResponse> callUser = service.createUser(userJob.toJsonObject());
        Response<CreateUserAPIResponse> response = callUser.execute();
        Assertions.assertEquals(CREATED, response.code());
    }

    @Test
    void getUserByIdSuccessful() throws IOException {
        APIManager service = getClient().create(APIManager.class);

        Call<UserApiResponse> callUser = service.getUser(1);
        Response<UserApiResponse> response = callUser.execute();
        Assertions.assertEquals(OK, response.code());
    }

    @Test
    void getUserByIdUnsuccessful() throws IOException {
        APIManager service = getClient().create(APIManager.class);

        Call<UserApiResponse> callUser = service.getUser(-7);
        Response<UserApiResponse> response = callUser.execute();
        Assertions.assertEquals(NOT_FOUND, response.code());
    }

    @Test
    void listUsers() throws IOException {
        APIManager service = getClient().create(APIManager.class);

        Call<UsersApiResponse> callUser = service.listUsers();
        Response<UsersApiResponse> response = callUser.execute();
        Assertions.assertEquals(OK, response.code());
    }

    @Test
    void registerUserSuccessful() throws IOException {
        APIManager service = getClient().create(APIManager.class);

        UserCredentials userCredentials = new UserCredentials("eve.holt@reqres.in", "qwerty");
        Call<RegisterAndLoginUserAPIResponse> callUser = service.registerUser(userCredentials.toJsonObject());
        Response<RegisterAndLoginUserAPIResponse> response = callUser.execute();
        Assertions.assertEquals(OK, response.code());
    }

    @Test
    void registerUserUnsuccessful() throws IOException {
        APIManager service = getClient().create(APIManager.class);

        UserCredentials userCredentials = new UserCredentials("invalid credentials", "qwerty");
        Call<RegisterAndLoginUserAPIResponse> callUser = service.registerUser(userCredentials.toJsonObject());
        Response<RegisterAndLoginUserAPIResponse> response = callUser.execute();
        Assertions.assertEquals(BAD_REQUEST, response.code());
    }

    @Test
    void authUserSuccessful() throws IOException {
        APIManager service = getClient().create(APIManager.class);

        UserCredentials userCredentials = new UserCredentials("eve.holt@reqres.in", "cityslicka");
        Call<RegisterAndLoginUserAPIResponse> callUser = service.loginUser(userCredentials.toJsonObject());
        Response<RegisterAndLoginUserAPIResponse> response = callUser.execute();
        Assertions.assertEquals(OK, response.code());
    }

    @Test
    void authUserUnsuccessful() throws IOException {
        APIManager service = getClient().create(APIManager.class);

        UserCredentials userCredentials = new UserCredentials("wrong_mail@reqres.in", "cityslicka");
        Call<RegisterAndLoginUserAPIResponse> callUser = service.loginUser(userCredentials.toJsonObject());
        Response<RegisterAndLoginUserAPIResponse> response = callUser.execute();
        Assertions.assertEquals(BAD_REQUEST, response.code());
    }

    @Test
    void listResources() throws IOException {
        APIManager service = getClient().create(APIManager.class);

        Call<ResourcesApiResponse> callUser = service.listResources();
        Response<ResourcesApiResponse> response = callUser.execute();
        Assertions.assertEquals(OK, response.code());
    }

    @Test
    void getResourceById() throws IOException {
        APIManager service = getClient().create(APIManager.class);

        Call<ResourceApiResponse> callUser = service.getResource(2);
        Response<ResourceApiResponse> response = callUser.execute();
        Assertions.assertEquals(OK, response.code());
    }
}