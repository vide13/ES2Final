package com.es2.controller;

import com.es2.cache.UserManager;
import com.es2.controller.Controller;
import com.es2.network.apiResponse.UserApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static com.es2.data.HttpCodes.*;


public class RestTests {
    @Test
    void newUser() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals(CREATED, controller.newUser("teste", "agricultor").code());
    }

    @Test
    void newUserNullName() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals(SEMANTIC_ERROR, controller.newUser(null, "agricultor").code());
    }

    @Test
    void newUserBlankJob() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals(SEMANTIC_ERROR, controller.newUser("teste", " ").code());
    }

    @Test
    void getUserById() throws IOException {
        UserManager.getInstance().deleteUser(1);

        //Cache doesnt have user whit id 1 -> request made do reqres and user added to cache
        Controller controller = Controller.getInstance();
        Response<UserApiResponse> userCall1 = controller.getUserById(1);
        Assertions.assertEquals(OK, userCall1.code());
        Assertions.assertEquals("https://reqres.in/api/users/1", userCall1.raw().request().url().toString());

        //Cache has user whit id 1 -> request made to cache
        Response<UserApiResponse> userCall2 = controller.getUserById(1);
        Assertions.assertEquals(OK, userCall2.code());
        Assertions.assertEquals("http://localhost/", userCall2.raw().request().url().toString());
    }

    @Test
    void getUserByIdNullName() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals(SEMANTIC_ERROR, controller.getUserById(null).code());
    }


    @Test
    void listUsers() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals(OK, controller.listUsers().code());
    }

    @Test
    void registerUserSuccessful() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals(OK, controller.registerUser("eve.holt@reqres.in", "passTeste").code());
    }

    @Test
    void registerUserUnsuccessful() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals(BAD_REQUEST, controller.registerUser("invalidEmail", "passTeste").code());
    }

    @Test
    void registerUserNullEmail() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals(SEMANTIC_ERROR, controller.registerUser(null, "passTeste").code());
    }

    @Test
    void registerUserEmptyPassword() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals(SEMANTIC_ERROR, controller.registerUser("invalidEmail", "").code());
    }

    @Test
    void authUserSuccessful() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals(OK, controller.authUser("eve.holt@reqres.in", "passTeste").code());
    }

    @Test
    void authUserSuccessfulFromCache() throws IOException {
        Controller controller = Controller.getInstance();
        UserManager.getInstance().registerUser(12312312, "test@test.com", "pass", "!!@@123");
        Assertions.assertEquals(OK, controller.authUser("test@test.com", "pass").code());
    }

    @Test
    void authUserUnsuccessful() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals(BAD_REQUEST, controller.authUser("invalid@email.add", "passTeste").code());
    }

    @Test
    void authUserNullEmail() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals(SEMANTIC_ERROR, controller.authUser(null, "passTeste").code());
    }

    @Test
    void authUserEmptyPassword() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals(SEMANTIC_ERROR, controller.authUser("invalidEmail", "").code());
    }

    @Test
    void listResources() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals(OK, controller.listResources().code());
    }

    @Test
    void getResourceByIdSuccessful() throws IOException {
        Controller controller = Controller.getInstance();
        //Get from reqres
        Assertions.assertEquals(OK, controller.getResourceById(1).code());
        //Get from cache
        Assertions.assertEquals(OK, controller.getResourceById(1).code());
    }

    @Test
    void getResourceByIdUnsuccessful() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals(SEMANTIC_ERROR, controller.getResourceById(-7).code());
    }

    @Test
    void getResourceByIdNull() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals(SEMANTIC_ERROR, controller.getResourceById(null).code());
    }
}
