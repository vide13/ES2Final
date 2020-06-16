package com.es2.cache;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Thread.sleep;

public class UserManager {
    private static volatile UserManager userManager;
    ArrayList<User> myUsers = new ArrayList<>();
    HashMap<String, String> registeredUsers = new HashMap<>();
    ArrayList<Resource> myResources = new ArrayList<>();

    private UserManager() {
        if (userManager != null) {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class.");
        }
    }

    public static UserManager getInstance() {
        if (userManager == null) {
            synchronized (UserManager.class) {
                if (userManager == null)
                    userManager = new UserManager();
            }
        }
        return userManager;
    }


    public UserJob newUser() {
        return new UserJob("morpheus", "leader");
    }


    public User getUserById(Integer id) {
        if (id == null)
            return null;
        return new User(
                2,
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

    public String deleteUser() {
        return null;
    }

    public HashMap<String, String> updateUser() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", "morpheus");
        hashMap.put("job", "zion resident");
        hashMap.put("updatedAt", "2020-06-01T21:29:54.801Z");
        return hashMap;
    }

    public ResourcePage delayedResponse() throws InterruptedException {
        sleep(3000);
        return listResources();
    }


    //Make singleton from serialize and deserialize operation.
    protected UserManager readResolve() {
        return getInstance();
    }
}
