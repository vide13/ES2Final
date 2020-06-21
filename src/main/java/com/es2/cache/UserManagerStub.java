package com.es2.cache;

import com.es2.data.*;

import java.util.ArrayList;
import java.util.HashMap;

public class UserManagerStub {
    private static volatile UserManagerStub userManagerStub;

    private UserManagerStub() {
        if (userManagerStub != null) {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class.");
        }
    }

    public static UserManagerStub getInstance() {
        if (userManagerStub == null) {
            synchronized (UserManagerStub.class) {
                if (userManagerStub == null)
                    userManagerStub = new UserManagerStub();
            }
        }
        return userManagerStub;
    }

    public UserJob newUser() {
        return new UserJob("49", "2020-06-01T21:00:08.929Z", "morpheus", "leader");
    }

    public User getUserById(Integer id) {
        if (id != 1)
            return null;
        return new User(
                1,
                "janet.weaver@reqres.in",
                "Janet",
                "Weaver",
                "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"
        );
    }

    public UserPage listUsers() {
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
        return new UserPage(2, 6, 12, 2, data_user);
    }

    public HashMap<String, String> registerUser(String email, String password) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (email.isEmpty()) {
            hashMap.put("error", "Missing email or username");
            return hashMap;
        }
        if (password.isEmpty()) {
            hashMap.put("error", "Missing password");
            return hashMap;
        }
        hashMap.put("id", "4");
        hashMap.put("token", "QpwL5tke4Pnpja7X4");
        return hashMap;
    }

    public HashMap<String, String> authUser(String email, String password) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (email.isEmpty()) {
            hashMap.put("error", "Missing email or username");
            return hashMap;
        }
        if (password.isEmpty()) {
            hashMap.put("error", "Missing password");
            return hashMap;
        }

        hashMap.put("token", "QpwL5tke4Pnpja7X4");
        return hashMap;
    }

    public HashMap<String, String> updateUser() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", "morpheus");
        hashMap.put("job", "zion resident");
        hashMap.put("updatedAt", "2020-06-01T21:29:54.801Z");
        return hashMap;
    }

    String deleteUser(String id) {
        return "User deleted!";
    }


    public ResourcePage listResources() {
        ArrayList<Resource> data_page = new ArrayList<>();
        data_page.add(new Resource(
                1,
                "cerulean",
                2000,
                "#98B2D1",
                "15-4020"
        ));
        data_page.add(new Resource(
                2,
                "fuchsia rose",
                2001,
                "#C74375",
                "17-2031"
        ));

        return new ResourcePage(2, 6, 12, 2, data_page);
    }

    public Resource getResourceById() {
        return new Resource(
                2,
                "fuchsia rose",
                2001,
                "#C74375",
                "17-2031"
        );
    }

}
