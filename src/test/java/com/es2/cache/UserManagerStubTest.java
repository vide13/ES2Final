package com.es2.cache;

import com.es2.data.Resource;
import com.es2.data.User;
import com.es2.data.UserJob;
import com.es2.data.UserPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;


class UserManagerStubTest {
    //TODO - Check this
    @Test
    void newUser() {
        UserManagerStub userManagerStub = UserManagerStub.getInstance();
        UserJob actual = userManagerStub.newUser();

        Assertions.assertEquals("49", actual.getId());
        Assertions.assertEquals("2020-06-01T21:00:08.929Z", actual.getCreatedAt());
    }

    @Test
    void getUserById() {
        UserManagerStub userManagerStub = UserManagerStub.getInstance();
        User actual = userManagerStub.getUserById(1);

        Assertions.assertEquals(1, actual.getId());
        Assertions.assertEquals("janet.weaver@reqres.in", actual.getEmail());
        Assertions.assertEquals("Janet", actual.getFirst_name());
        Assertions.assertEquals("Weaver", actual.getLast_name());
        Assertions.assertEquals("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", actual.getAvatar());
    }

    @Test
    void getUserByIdUnsuccessful() {
        UserManagerStub userManagerStub = UserManagerStub.getInstance();
        User actual = userManagerStub.getUserById(123);

        Assertions.assertNull(actual);
    }

    //TODO - Test prints
    @Test
    void listUsers() {
        UserManagerStub userManagerStub = UserManagerStub.getInstance();

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
        UserPage actual = userManagerStub.listUsers();
        Assertions.assertEquals(expected.getPage(), actual.getPage());
        Assertions.assertEquals(expected.getPer_page(), actual.getPer_page());
        Assertions.assertEquals(expected.getTotal(), actual.getTotal());
        Assertions.assertEquals(expected.getTotal_pages(), actual.getTotal_pages());
        Assertions.assertEquals(expected.getData().get(0).getId(), actual.getData().get(0).getId());
    }

    @Test
    void registerUserSuccessful() {
        UserManagerStub userManagerStub = UserManagerStub.getInstance();

        HashMap<String, String> actual = userManagerStub.registerUser("eve.holt@reqres.in", "pistol");
        Assertions.assertEquals("4", actual.get("id"));
        Assertions.assertEquals("QpwL5tke4Pnpja7X4", actual.get("token"));
    }

    @Test
    void registerUserUnsuccessful() {
        UserManagerStub userManagerStub = UserManagerStub.getInstance();

        HashMap<String, String> actual_email = userManagerStub.registerUser("", "pistol");
        Assertions.assertEquals("Missing email or username", actual_email.get("error"));

        HashMap<String, String> actual_password = userManagerStub.registerUser("eve.holt@reqres.in", "");
        Assertions.assertEquals("Missing password", actual_password.get("error"));
    }

    @Test
    void authUserSuccessful() {
        UserManagerStub userManagerStub = UserManagerStub.getInstance();

        String actual = userManagerStub.authUser("eve.holt@reqres.in", "pistol").get("token");
        Assertions.assertEquals("QpwL5tke4Pnpja7X4", actual);
    }

    @Test
    void authUserUnsuccessful() {
        UserManagerStub userManagerStub = UserManagerStub.getInstance();

        String actual_email = userManagerStub.authUser("eve.holt@reqres.in", "").get("error");
        Assertions.assertEquals("Missing password", actual_email);

        String actual_password = userManagerStub.authUser("", "pistol").get("error");
        Assertions.assertEquals("Missing email or username", actual_password);
    }

    @Test
    void updateUser() {
        UserManagerStub userManagerStub = UserManagerStub.getInstance();

        Assertions.assertEquals("morpheus", userManagerStub.updateUser().get("name"));
        Assertions.assertEquals("zion resident", userManagerStub.updateUser().get("job"));
        Assertions.assertEquals("2020-06-01T21:29:54.801Z", userManagerStub.updateUser().get("updatedAt"));
    }

    @Test
    void deleteUser() {
        UserManagerStub userManagerStub = UserManagerStub.getInstance();

        Assertions.assertEquals("User deleted!", userManagerStub.deleteUser("4"));
    }


    //TODO - Test resources
    @Test
    void listResources() {
        UserManagerStub userManagerStub = UserManagerStub.getInstance();

        Resource actual = userManagerStub.listResources().getData().get(0);
        Assertions.assertEquals(1, actual.getId());
        Assertions.assertEquals("cerulean", actual.getName());
        Assertions.assertEquals(2000, actual.getYear());
        Assertions.assertEquals("#98B2D1", actual.getColor());
        Assertions.assertEquals("17-2031", userManagerStub.listResources().getData().get(1).getPantone_value());
    }

    @Test
    void getResourceById() {
        UserManagerStub userManagerStub = UserManagerStub.getInstance();
        Resource actual = userManagerStub.getResourceById();

        Assertions.assertEquals(2, actual.getId());
        Assertions.assertEquals("fuchsia rose", actual.getName());
        Assertions.assertEquals(2001, actual.getYear());
        Assertions.assertEquals("#C74375", actual.getColor());
        Assertions.assertEquals("17-2031", actual.getPantone_value());
    }


}
