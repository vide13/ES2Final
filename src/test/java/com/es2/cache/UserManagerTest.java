package com.es2.cache;

import com.es2.data.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;


class UserManagerTest {
    //TODO - Check this
    @Test
    void newUser() {
        UserManagerCache userManagerCache = UserManagerCache.getInstance();
        UserJob actual = userManagerCache.createUserJob("49",  "2020-06-01T21:00:08.929Z", "André", "Student");

        Assertions.assertEquals("49", actual.getId());
        Assertions.assertEquals("2020-06-01T21:00:08.929Z", actual.getCreatedAt());
    }

    @Test
    void getUserById() {
        UserManagerCache userManagerCache = UserManagerCache.getInstance();
        //teste sem nenhum utilizador
        Assertions.assertNull(userManagerCache.singleUser(2));

        userManagerCache.createUser(
                2,
                "janet.weaver@reqres.in",
                "Janet",
                "Weaver",
                "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");
        //teste após criação de um utilizador
        Assertions.assertEquals(2, userManagerCache.singleUser(2).getId());
        Assertions.assertEquals("janet.weaver@reqres.in", userManagerCache.singleUser(2).getEmail());
        Assertions.assertEquals("Janet", userManagerCache.singleUser(2).getFirst_name());
        Assertions.assertEquals("Weaver", userManagerCache.singleUser(2).getLast_name());
        Assertions.assertEquals("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", userManagerCache.singleUser(2).getAvatar());
    }

    //TODO - Test prints
    @Test
    void listUsers() {
        UserManagerCache userManagerCache = UserManagerCache.getInstance();
        ArrayList<User> data_user = new ArrayList<>();
        data_user.add(new User(
                7,
                "michael.lawson@reqres.in",
                "Michael",
                "Lawson",
                "https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg"));
        UserPage expected = new UserPage(2, 6, 12, 2, data_user);

        userManagerCache.createUser(
                7,
                "michael.lawson@reqres.in",
                "Michael",
                "Lawson",
                "https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg");
        UserPage actual = userManagerCache.listUsers();

        Assertions.assertEquals(expected.getPage(), actual.getPage());
        Assertions.assertEquals(expected.getPer_page(), actual.getPer_page());
        Assertions.assertEquals(expected.getTotal(), actual.getTotal());
        Assertions.assertEquals(expected.getTotal_pages(), actual.getTotal_pages());
        Assertions.assertEquals(expected.getData().get(0).getId(), actual.getData().get(0).getId());
    }

    //TODO - Test resources
    @Test
    void listResources() {
        UserManagerCache userManagerCache = UserManagerCache.getInstance();
        userManagerCache.createResource(2, "fuchsia rose", 2001, "#C74375", "17-2031");

        Assertions.assertNotEquals(0, userManagerCache.listResources().getData().size());
    }

    @Test
    void registerUserSuccessful() {
        UserManagerCache userManagerCache = UserManagerCache.getInstance();
        HashMap<String, String> actual = userManagerCache.registerUser(4, "eve.holt@reqres.in", "pistol", "QpwL5tke4Pnpja7X4");
        Assertions.assertEquals(4, Integer.parseInt(actual.get("id")));
        Assertions.assertEquals("QpwL5tke4Pnpja7X4", actual.get("token"));
    }

    @Test
    void registerUserUnsuccessful() {
        UserManagerCache userManagerCache = UserManagerCache.getInstance();
        HashMap<String, String> actual_email = userManagerCache.registerUser(4, "", "", "QpwL5tke4Pnpja7X4");
        Assertions.assertEquals("Missing email or username", actual_email.get("error"));

        HashMap<String, String> actual_pass = userManagerCache.registerUser(4, "eve.holt@reqres.in", "", "QpwL5tke4Pnpja7X4");
        Assertions.assertEquals("Missing password", actual_pass.get("error"));
    }

    @Test
    void authUserSuccessful() {
        UserManagerCache userManagerCache = UserManagerCache.getInstance();
        userManagerCache.registerUser(4, "eve.holt@reqres.in", "pistol","QpwL5tke4Pnpja7X4");
        Assertions.assertEquals("QpwL5tke4Pnpja7X4", userManagerCache.loginUser("eve.holt@reqres.in", "pistol"));
    }

    @Test
    void authUserUnsuccessful() {
        UserManagerCache userManagerCache = UserManagerCache.getInstance();
        Assertions.assertNull(userManagerCache.loginUser("eve.holt@reqres.in", ""));
    }



    @Test
    void getResourceById() {
        UserManagerCache userManagerCache = UserManagerCache.getInstance();
        userManagerCache.createResource(2, "fuchsia rose", 2001, "#C74375", "17-2031");
        Resource actual = userManagerCache.singleResource(2);
        Assertions.assertEquals(2, actual.getId());
        Assertions.assertEquals("fuchsia rose", actual.getName());
        Assertions.assertEquals(2001, actual.getYear());
        Assertions.assertEquals("#C74375", actual.getColor());
        Assertions.assertEquals("17-2031", actual.getPantone_value());
    }

    @Test
    void getUserByIdUnsuccessful() {
        UserManagerCache userManagerCache = UserManagerCache.getInstance();

        Assertions.assertNull(userManagerCache.singleUser(null));
    }

    @Test
    void getResourceByIdUnsuccessful() {
        UserManagerCache userManagerCache = UserManagerCache.getInstance();

        Assertions.assertNull(userManagerCache.singleResource(null));
    }




}
