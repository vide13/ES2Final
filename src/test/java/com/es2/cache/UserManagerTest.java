package com.es2.cache;

import com.es2.data.Resource;
import com.es2.data.User;
import com.es2.data.UserJob;
import com.es2.data.UserPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;


class UserManagerTest {
    @Test
    void newUser() {
        UserManager userManager = UserManager.getInstance();
        UserJob actual = userManager.newUser("49", "2020-06-01T21:00:08.929Z", "André", "Student");

        Assertions.assertEquals("49", actual.getId());
        Assertions.assertEquals("2020-06-01T21:00:08.929Z", actual.getCreatedAt());
    }

    @Test
    void getUserById() {
        UserManager userManager = UserManager.getInstance();
        //teste sem nenhum utilizador
        Assertions.assertNull(userManager.getUserById(1));

        userManager.createUserArray(
                1,
                "janet.weaver@reqres.in",
                "Janet",
                "Weaver",
                "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");
        //teste após criação de um utilizador
        User actual = userManager.getUserById(1);
        Assertions.assertEquals(1, actual.getId());
        Assertions.assertEquals("janet.weaver@reqres.in", actual.getEmail());
        Assertions.assertEquals("Janet", actual.getFirst_name());
        Assertions.assertEquals("Weaver", actual.getLast_name());
        Assertions.assertEquals("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", actual.getAvatar());
    }

    @Test
    void getUserByIdUnsuccessful() {
        UserManager userManager = UserManager.getInstance();

        Assertions.assertNull(userManager.getUserById(123));
    }

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
        UserPage expected = new UserPage(2, 6, 12, 2, data_user);

        userManager.createUserArray(
                7,
                "michael.lawson@reqres.in",
                "Michael",
                "Lawson",
                "https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg");
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

        HashMap<String, String> actual = userManager.registerUser(4, "eve.holt@reqres.in", "pistol", "QpwL5tke4Pnpja7X4");
        Assertions.assertEquals(4, Integer.parseInt(actual.get("id")));
        Assertions.assertEquals("QpwL5tke4Pnpja7X4", actual.get("token"));
    }

    @Test
    void registerUserUnsuccessful() {
        UserManager userManager = UserManager.getInstance();

        HashMap<String, String> actual_email = userManager.registerUser(4, "", "", "QpwL5tke4Pnpja7X4");
        Assertions.assertEquals("Missing email or username", actual_email.get("error"));

        HashMap<String, String> actual_pass = userManager.registerUser(4, "eve.holt@reqres.in", "", "QpwL5tke4Pnpja7X4");
        Assertions.assertEquals("Missing password", actual_pass.get("error"));
    }

    @Test
    void authUserSuccessful() {
        UserManager userManager = UserManager.getInstance();

        userManager.registerUser(4, "eve.holt@reqres.in", "pistol", "QpwL5tke4Pnpja7X4");
        Assertions.assertEquals("QpwL5tke4Pnpja7X4", userManager.authUser("eve.holt@reqres.in", "pistol"));
    }

    @Test
    void authUserUnsuccessful() {
        UserManager userManager = UserManager.getInstance();

        Assertions.assertNull(userManager.authUser("eve.holt@reqres.in", ""));
    }

    @Test
    void listResources() {
        UserManager userManager = UserManager.getInstance();

        userManager.createResourceArray(2, "fuchsia rose", 2001, "#C74375", "17-2031");
        Assertions.assertNotEquals(0, userManager.listResources().getData().size());
    }

    @Test
    void getResourceById() {
        UserManager userManager = UserManager.getInstance();

        userManager.createResourceArray(2, "fuchsia rose", 2001, "#C74375", "17-2031");
        Resource actual = userManager.getResourceById(2);
        Assertions.assertEquals(2, actual.getId());
        Assertions.assertEquals("fuchsia rose", actual.getName());
        Assertions.assertEquals(2001, actual.getYear());
        Assertions.assertEquals("#C74375", actual.getColor());
        Assertions.assertEquals("17-2031", actual.getPantone_value());
    }

    @Test
    void getResourceByIdUnsuccessful() {
        UserManager userManager = UserManager.getInstance();

        Assertions.assertNull(userManager.getResourceById(null));
    }


}
