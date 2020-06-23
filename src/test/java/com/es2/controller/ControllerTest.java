package com.es2.controller;

import com.es2.cache.UserManager;
import com.es2.controller.Controller;
import com.es2.network.apiResponse.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

class ControllerTest {


    @Test
    void newUserNull() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals("Invalid Arguments", controller.newUser(null, null).errorBody().string());
    }

    @Test
    void newUserBlank() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals("Empty Arguments", controller.newUser("", "").errorBody().string());
    }

    @Test
    void newUserSuccessful() throws IOException {
        Controller controller = Controller.getInstance();
        Response<CreateUserAPIResponse> response = controller.newUser("Jane", "Scientist");
        Assertions.assertEquals(CreateUserAPIResponse.class, response.body().getClass());
        Assertions.assertEquals("Jane", response.body().getName());
    }

    @Test
    void getUserByIdNull() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals("Invalid Argument", controller.getUserById(null).errorBody().string());
    }

    @Test
    void getUserByIdSuccessful() throws IOException {
        Controller controller = Controller.getInstance();
        UserManager.getInstance().deleteUser(1);

        //Cache doesnt have user with id 1 -> request made do reqres and user added to cache
        Response<UserApiResponse> firstCall = controller.getUserById(1);
        Assertions.assertEquals(1, firstCall.body().getUser().getId());
        Assertions.assertEquals("https://reqres.in/api/users/1", firstCall.raw().request().url().toString());
        Assertions.assertEquals(UserApiResponse.class, firstCall.body().getClass());

        //Cache has user with id 1, request is made to cache
        Response<UserApiResponse> secondCall = controller.getUserById(1);
        Assertions.assertEquals(1, secondCall.body().getUser().getId());
        Assertions.assertEquals("http://localhost/", secondCall.raw().request().url().toString());
        Assertions.assertEquals(UserApiResponse.class, secondCall.body().getClass());
    }

    @Test
    void getUserByIdNotInRange() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals("Invalid Argument", controller.getUserById(Integer.MAX_VALUE + 1).errorBody().string());
    }

    @Test
    void getUserByIdUnsuccessful() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertNotNull(controller.getUserById(-1).errorBody());
    }

    @Test
    void listUsers() throws IOException {
        Controller controller = Controller.getInstance();
        Response<UsersApiResponse> response = controller.listUsers();
        Assertions.assertNotNull(response.body());
        Assertions.assertEquals(UsersApiResponse.class, response.body().getClass());
    }

    @Test
    void registerUserNull() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals("Invalid Argument", controller.registerUser(null, null).errorBody().string());
    }

    @Test
    void registerUserEmpty() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals("Invalid Argument", controller.registerUser("", "").errorBody().string());
    }

    @Test
    void registerUserSuccessful() throws IOException {
        Controller controller = Controller.getInstance();
        Response<RegisterUserAPIResponse> response = controller.registerUser("eve.holt@reqres.in", "passTeste");
        Assertions.assertNotNull(response.body());
        Assertions.assertEquals(RegisterUserAPIResponse.class, response.body().getClass());
    }

    @Test
    void registerUserUnsuccessful() throws IOException {
        Controller controller = Controller.getInstance();
        Response<RegisterUserAPIResponse> response = controller.registerUser("invalidemail", "passTeste");
        Assertions.assertNotNull(response.errorBody());
    }

    @Test
    void authUserNull() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals("Invalid Argument", controller.authUser(null, null).errorBody().string());
    }

    @Test
    void authUserEmpty() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals("Invalid Argument", controller.authUser("", "").errorBody().string());
    }

    @Test
    void authUserSuccessful() throws IOException {
        Controller controller = Controller.getInstance();
        Response<LoginUserAPIResponse> response = controller.authUser("eve.holt@reqres.in", "passTeste");
        Assertions.assertEquals(LoginUserAPIResponse.class, response.body().getClass());
    }

    @Test
    void authUserUnsuccessful() throws IOException {
        Controller controller = Controller.getInstance();
        Response<LoginUserAPIResponse> response = controller.authUser("invalidEmail", "passTeste");
        Assertions.assertNull(response.body());
    }

    @Test
    void listResources() throws IOException {
        Controller controller = Controller.getInstance();
        Response<ResourcesApiResponse> response = controller.listResources();
        Assertions.assertNotNull(response.body());
        Assertions.assertEquals(ResourcesApiResponse.class, response.body().getClass());
    }

    @Test
    void getResourceByIdNull() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals("Invalid Argument", controller.getResourceById(null).errorBody().string());
    }

    @Test
    void getResourceByIdSuccessful() throws IOException {
        Controller controller = Controller.getInstance();
        Response<ResourceApiResponse> firstCall = controller.getResourceById(1);
        //Get from reqres
        Assertions.assertEquals(1, firstCall.body().getData().getId());
        Assertions.assertEquals(ResourceApiResponse.class, firstCall.body().getClass());
        //Get from cache
        Response<ResourceApiResponse> secondCall = controller.getResourceById(1);
        Assertions.assertEquals(1, secondCall.body().getData().getId());
        Assertions.assertEquals(ResourceApiResponse.class, secondCall.body().getClass());
    }

    @Test
    void getResourceByIdNotInRange() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertEquals("Invalid Argument", controller.getResourceById(Integer.MAX_VALUE + 1).errorBody().string());
    }

    @Test
    void getResourceByIdUnsuccessful() throws IOException {
        Controller controller = Controller.getInstance();
        Assertions.assertNull(controller.getResourceById(-1).body());
    }
}