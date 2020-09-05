package com.es2.service;

import com.es2.HTTPClient.Retrofit;
import com.es2.controller.Endpoint;
import com.es2.objects.Credentials;
import com.es2.objects.UserJob;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class CreateUserTest {
    private static Endpoint endpoint;
    private static String token;
    private final String FIFTY_ONE_CHARACTER_WORD = "esta_string_tem_exatamente_cinquenta_e_um_caractere";
    private final String FIFTY_CHARACTER_WORD = "esta_string_tem_exatamente_cinquenta_caracteres_ab";

    /**
     * Setup token required to call certain functionalities
     */
    @BeforeAll
    static void setup() throws IOException {
        endpoint = Retrofit.getClient().create(Endpoint.class);

        token = endpoint.login(new Credentials(
                "eve.holt@reqres.in",
                "cityslicka"
        ).toJsonObject()).execute().body().getToken();
    }


    @Test
    void successful() throws IOException {
        UserJob user = new UserJob("morpheus", "leader");
        Call<UserJob> request = endpoint.createUser(token, user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertEquals(201, response.code());
    }

    /**
     * Black-Box Tests
     */

    @Test
    void nullJob() throws IOException {
        UserJob user = new UserJob("morpheus", null);
        Call<UserJob> request = endpoint.createUser(token, user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }

    @Test
    void blankJob() throws IOException {
        UserJob user = new UserJob("morpheus", " ");
        Call<UserJob> request = endpoint.createUser(token, user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }

    @Test
    void nullName() throws IOException {
        UserJob user = new UserJob(null, "leader");
        Call<UserJob> request = endpoint.createUser(token, user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }

    @Test
    void blankName() throws IOException {
        UserJob user = new UserJob(" ", "leader");
        Call<UserJob> request = endpoint.createUser(token, user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }

    /**
     * Boundary-value analysis
     * <p>
     * Job Always Valid
     */

    @Test
    void lowerInvalidBoundaryName() throws IOException {
        UserJob user = new UserJob("m", "leader");
        Call<UserJob> request = endpoint.createUser(token, user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }

    @Test
    void lowerValidBoundaryName() throws IOException {
        UserJob user = new UserJob("mo", "leader");
        Call<UserJob> request = endpoint.createUser(token, user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertEquals(201, response.code());
    }

    @Test
    void upperValidBoundaryName() throws IOException {
        UserJob user = new UserJob(FIFTY_CHARACTER_WORD, "leader");
        Call<UserJob> request = endpoint.createUser(token, user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertEquals(201, response.code());
    }

    @Test
    void upperInvalidBoundaryName() throws IOException {
        UserJob user = new UserJob(FIFTY_ONE_CHARACTER_WORD, "leader");
        Call<UserJob> request = endpoint.createUser(token, user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }

    /**
     * Name Always Valid
     */

    @Test
    void lowerInvalidBoundaryJob() throws IOException {
        UserJob user = new UserJob("morpheus", "l");
        Call<UserJob> request = endpoint.createUser(token, user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }

    @Test
    void lowerValidBoundaryJob() throws IOException {
        UserJob user = new UserJob("morpheus", "le");
        Call<UserJob> request = endpoint.createUser(token, user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertEquals(201, response.code());
    }

    @Test
    void upperValidBoundaryJob() throws IOException {
        UserJob user = new UserJob("morpheus", FIFTY_CHARACTER_WORD);
        Call<UserJob> request = endpoint.createUser(token, user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertEquals(201, response.code());
    }

    @Test
    void upperInvalidBoundaryJob() throws IOException {
        UserJob user = new UserJob("morpheus", FIFTY_ONE_CHARACTER_WORD);
        Call<UserJob> request = endpoint.createUser(token, user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }

    @Test
    void invalidToken() throws IOException {
        UserJob user = new UserJob("morpheus", "leader");
        Call<UserJob> request = endpoint.createUser("token_invalido", user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertEquals(400, response.code());
    }

    @Test
    void nullToken() throws IOException {
        UserJob user = new UserJob("morpheus", "leader");
        Call<UserJob> request = endpoint.createUser(null, user.toJsonObject());
        Response<UserJob> response = request.execute();
        Assertions.assertEquals(400, response.code());
    }
}