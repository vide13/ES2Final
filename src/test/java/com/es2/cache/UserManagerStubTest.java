package com.es2.cache;

import com.es2.data.Resource;
import com.es2.data.User;
import com.es2.data.UserJob;
import com.es2.data.UserPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class UserManagerStubTest {
    //TODO - Check this
    @Test
    void newUser() {
        UserManager userManager = UserManager.getInstance();
        UserJob actual = userManager.newUser();

        Assertions.assertEquals("49", actual.getId());
        Assertions.assertEquals("2020-06-01T21:00:08.929Z", actual.getCreatedAt());
    }

    @Test
    void getUserById() {
        UserManager userManager = UserManager.getInstance();
        User actual = userManager.getUserById(2);

        Assertions.assertEquals(2, actual.getId());
        Assertions.assertEquals("janet.weaver@reqres.in", actual.getEmail());
        Assertions.assertEquals("Janet", actual.getFirst_name());
        Assertions.assertEquals("Weaver", actual.getLast_name());
        Assertions.assertEquals("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", actual.getAvatar());
    }

    //TODO - Test prints
    @Test
    void listUsers() {
        UserManager userManager = UserManager.getInstance();
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
        UserPage actual = userManager.listUsers();
        Assertions.assertEquals(expected.getPage(), actual.getPage());
        Assertions.assertEquals(expected.getPer_page(), actual.getPer_page());
        Assertions.assertEquals(expected.getTotal(), actual.getTotal());
        Assertions.assertEquals(expected.getTotal_pages(), actual.getTotal_pages());
        Assertions.assertEquals(expected.getData().get(0).getId(), actual.getData().get(0).getId());
    }

    @Test
    void registerUserSuccessful() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertEquals("4", userManager.registerUser("eve.holt@reqres.in", "pistol").get("id"));
        Assertions.assertEquals("QpwL5tke4Pnpja7X4", userManager.registerUser("eve.holt@reqres.in", "pistol").get("token"));
    }

    @Test
    void registerUserUnsuccessful() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertEquals("Missing email or username", userManager.registerUser("", "pistol").get("error"));
        Assertions.assertEquals("Missing password", userManager.registerUser("eve.holt@reqres.in", "").get("error"));
    }

    @Test
    void authUserSuccessful() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertEquals("QpwL5tke4Pnpja7X4", userManager.authUser("eve.holt@reqres.in", "pistol").get("token"));
    }

    @Test
    void authUserUnsuccessful() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertEquals("Missing password", userManager.authUser("eve.holt@reqres.in", "").get("error"));
    }

    //TODO - Test resources
    @Test
    void listResources() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertEquals(1, userManager.listResources().getData().get(0).getId());
        Assertions.assertEquals("cerulean", userManager.listResources().getData().get(0).getName());
        Assertions.assertEquals(2000, userManager.listResources().getData().get(0).getYear());
        Assertions.assertEquals("#98B2D1", userManager.listResources().getData().get(0).getColor());
        Assertions.assertEquals("17-2031", userManager.listResources().getData().get(1).getPantone_value());
    }

    @Test
    void getResourceById() {
        UserManager userManager = UserManager.getInstance();
        Resource actual = userManager.getResourceById();

        Assertions.assertEquals(2, actual.getId());
        Assertions.assertEquals("fuchsia rose", actual.getName());
        Assertions.assertEquals(2001, actual.getYear());
        Assertions.assertEquals("#C74375", actual.getColor());
        Assertions.assertEquals("17-2031", actual.getPantone_value());
    }

    @Test
    void updateUser() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertEquals("morpheus", userManager.updateUser().get("name"));
        Assertions.assertEquals("zion resident", userManager.updateUser().get("job"));
        Assertions.assertEquals("2020-06-01T21:29:54.801Z", userManager.updateUser().get("updatedAt"));
    }

    @Test
    void getUserByIdUnseccessfull() {
        UserManager userManager = UserManager.getInstance();

        Assertions.assertNull(userManager.getUserById(null));
    }

    @Test
    void deleteUser() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertNull(userManager.deleteUser());
    }

    /*@Test
    void delayedResponse() throws InterruptedException {
        com.es2.cache.UserManager userManager = com.es2.cache.UserManager.getInstance();

        Assertions.assertEquals(1, userManager.delayedResponse().data.get(0).id);
        Assertions.assertEquals("cerulean", userManager.delayedResponse().data.get(0).name);
        Assertions.assertEquals(2000, userManager.delayedResponse().data.get(0).year);
        Assertions.assertEquals("#98B2D1", userManager.delayedResponse().data.get(0).color);
        Assertions.assertEquals("17-2031", userManager.delayedResponse().data.get(1).pantone_value);
    }*/


}
