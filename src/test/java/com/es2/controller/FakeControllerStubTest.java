package com.es2.controller;

import com.es2.controller.FakeControllerStub;
import com.es2.data.Resource;
import com.es2.data.User;
import com.es2.data.UserJob;
import com.es2.data.UserPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;


class FakeControllerStubTest {
    //TODO - Check this
    @Test
    void newUser() {
        FakeControllerStub fakeControllerStub = FakeControllerStub.getInstance();
        UserJob actual = fakeControllerStub.newUser();

        Assertions.assertEquals("49", actual.getId());
        Assertions.assertEquals("2020-06-01T21:00:08.929Z", actual.getCreatedAt());
    }

    @Test
    void getUserById() {
        FakeControllerStub fakeControllerStub = FakeControllerStub.getInstance();
        User actual = fakeControllerStub.getUserById(1);

        Assertions.assertEquals(1, actual.getId());
        Assertions.assertEquals("janet.weaver@reqres.in", actual.getEmail());
        Assertions.assertEquals("Janet", actual.getFirst_name());
        Assertions.assertEquals("Weaver", actual.getLast_name());
        Assertions.assertEquals("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", actual.getAvatar());
    }

    @Test
    void getUserByIdUnsuccessful() {
        FakeControllerStub fakeControllerStub = FakeControllerStub.getInstance();
        User actual = fakeControllerStub.getUserById(123);

        Assertions.assertNull(actual);
    }

    //TODO - Test prints
    @Test
    void listUsers() {
        FakeControllerStub fakeControllerStub = FakeControllerStub.getInstance();

        ArrayList<User> data_user = new ArrayList<>();
        data_user.add(new User(
                7,
                "michael.lawson@reqres.in",
                "Michael",
                "Lawson",
                "https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg"));
        data_user.add(new User(
                8,
                "lindsay.ferguson@reqres.in",
                "Lindsay",
                "Ferguson",
                "https://s3.amazonaws.com/uifaces/faces/twitter/araa3185/128.jpg"));
        UserPage expected = new UserPage(2, 6, 12, 2, data_user);
        UserPage actual = fakeControllerStub.listUsers();
        Assertions.assertEquals(expected.getPage(), actual.getPage());
        Assertions.assertEquals(expected.getPer_page(), actual.getPer_page());
        Assertions.assertEquals(expected.getTotal(), actual.getTotal());
        Assertions.assertEquals(expected.getTotal_pages(), actual.getTotal_pages());
        Assertions.assertEquals(expected.getData().get(0).getId(), actual.getData().get(0).getId());
    }

    @Test
    void registerUserSuccessful() {
        FakeControllerStub fakeControllerStub = FakeControllerStub.getInstance();

        HashMap<String, String> actual = fakeControllerStub.registerUser("eve.holt@reqres.in", "pistol");
        Assertions.assertEquals("4", actual.get("id"));
        Assertions.assertEquals("QpwL5tke4Pnpja7X4", actual.get("token"));
    }

    @Test
    void registerUserUnsuccessful() {
        FakeControllerStub fakeControllerStub = FakeControllerStub.getInstance();

        HashMap<String, String> actual_email = fakeControllerStub.registerUser("", "pistol");
        Assertions.assertEquals("Missing email or username", actual_email.get("error"));

        HashMap<String, String> actual_password = fakeControllerStub.registerUser("eve.holt@reqres.in", "");
        Assertions.assertEquals("Missing password", actual_password.get("error"));
    }

    @Test
    void authUserSuccessful() {
        FakeControllerStub fakeControllerStub = FakeControllerStub.getInstance();

        String actual = fakeControllerStub.authUser("eve.holt@reqres.in", "pistol").get("token");
        Assertions.assertEquals("QpwL5tke4Pnpja7X4", actual);
    }

    @Test
    void authUserUnsuccessful() {
        FakeControllerStub fakeControllerStub = FakeControllerStub.getInstance();

        String actual_email = fakeControllerStub.authUser("eve.holt@reqres.in", "").get("error");
        Assertions.assertEquals("Missing password", actual_email);

        String actual_password = fakeControllerStub.authUser("", "pistol").get("error");
        Assertions.assertEquals("Missing email or username", actual_password);
    }

    @Test
    void updateUser() {
        FakeControllerStub fakeControllerStub = FakeControllerStub.getInstance();

        Assertions.assertEquals("morpheus", fakeControllerStub.updateUser().get("name"));
        Assertions.assertEquals("zion resident", fakeControllerStub.updateUser().get("job"));
        Assertions.assertEquals("2020-06-01T21:29:54.801Z", fakeControllerStub.updateUser().get("updatedAt"));
    }

    @Test
    void deleteUser() {
        FakeControllerStub fakeControllerStub = FakeControllerStub.getInstance();

        Assertions.assertEquals("User deleted!", fakeControllerStub.deleteUser("4"));
    }


    //TODO - Test resources
    @Test
    void listResources() {
        FakeControllerStub fakeControllerStub = FakeControllerStub.getInstance();

        Resource actual = fakeControllerStub.listResources().getData().get(0);
        Assertions.assertEquals(1, actual.getId());
        Assertions.assertEquals("cerulean", actual.getName());
        Assertions.assertEquals(2000, actual.getYear());
        Assertions.assertEquals("#98B2D1", actual.getColor());
        Assertions.assertEquals("17-2031", fakeControllerStub.listResources().getData().get(1).getPantone_value());
    }

    @Test
    void getResourceById() {
        FakeControllerStub fakeControllerStub = FakeControllerStub.getInstance();
        Resource actual = fakeControllerStub.getResourceById();

        Assertions.assertEquals(2, actual.getId());
        Assertions.assertEquals("fuchsia rose", actual.getName());
        Assertions.assertEquals(2001, actual.getYear());
        Assertions.assertEquals("#C74375", actual.getColor());
        Assertions.assertEquals("17-2031", actual.getPantone_value());
    }


}
