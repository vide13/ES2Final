package com.es2.service;

import com.es2.HTTPClient.Retrofit;
import com.es2.controller.Endpoint;
import com.es2.objects.Credentials;
import com.es2.objects.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class LoginUserTest {
    private static Endpoint endpoint;
    private final String WORD_WHIT_128_CHARACTER = "esta_string_tem_exatamente_128_caracteres_zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
    private final String EIGHT_CHARACTER_WORD = "TestPass";
    private final String SEVEN_CHARACTER_WORD = "TestPas";

    /**
     * Setup token required to call certain functionalities
     */
    @BeforeAll
    static void setup() {
        endpoint = Retrofit.getClient().create(Endpoint.class);

    }

    @Test
    void successful() throws IOException {
        Credentials user = new Credentials("eve.holt@reqres.in", "TestPassword");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(200, response.code());
    }

    /**
     * Black-Box Tests
     */
    @Test
    void nullPassword() throws IOException {
        Credentials user = new Credentials("eve.holt@reqres.in", null);
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }

    @Test
    void blankPassword() throws IOException {
        Credentials user = new Credentials("eve.holt@reqres.in", " ");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }

    @Test
    void nullEmail() throws IOException {
        Credentials user = new Credentials(null, "TestPassword");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }

    @Test
    void blankEmail() throws IOException {
        Credentials user = new Credentials(" ", "TestPassword");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }

    /**
     * Boundary-value analysis
     * <p>
     * Password Always Valid
     */

    @Test
    void lowerInvalidBoundaryEmail() throws IOException {
        Credentials user = new Credentials("aa", "TestPassword");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }

    @Test
    void lowerValidBoundaryEmail() throws IOException {
        Credentials user = new Credentials("b@b", "TestPassword");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(200, response.code());
    }

    @Test
    void upperValidBoundaryEmail() throws IOException {
        Credentials user = new Credentials(WORD_WHIT_128_CHARACTER, "TestPassword");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(200, response.code());
    }

    @Test
    void upperInvalidBoundaryEmail() throws IOException {
        Credentials user = new Credentials(WORD_WHIT_128_CHARACTER + 1, "TestPassword");
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }

    /**
     * Email Always Valid
     */

    @Test
    void lowerInvalidBoundaryPassword() throws IOException {
        Credentials user = new Credentials("eve.holt@reqres.in", SEVEN_CHARACTER_WORD);
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }

    @Test
    void lowerValidBoundaryPassword() throws IOException {
        Credentials user = new Credentials("eve.holt@reqres.in", EIGHT_CHARACTER_WORD);
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(200, response.code());
    }

    @Test
    void upperValidBoundaryPassword() throws IOException {
        Credentials user = new Credentials("eve.holt@reqres.in", WORD_WHIT_128_CHARACTER);
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertEquals(200, response.code());
    }

    @Test
    void upperInvalidBoundaryPassword() throws IOException {
        Credentials user = new Credentials("eve.holt@reqres.in", WORD_WHIT_128_CHARACTER + 1);
        Call<Login> request = endpoint.login(user.toJsonObject());
        Response<Login> response = request.execute();
        Assertions.assertTrue(response.code() > 399);
    }
}
