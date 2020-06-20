package com.es2.cache;

import com.es2.data.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class UserManagerCache {
    private static volatile UserManagerCache userManager;
    private final ArrayList<UserJob> arrayListUsersJob = new ArrayList<>();
    private final ArrayList<User> arrayListUsers = new ArrayList<>();
    private final ArrayList<Resource> arrayListResources = new ArrayList<>();
    private final ArrayList<UserCredentials> arrayListUsersCredentials = new ArrayList<>();

    UserManagerCache() {
        if (userManager != null) {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class.");
        }
    }

    public static UserManagerCache getInstance() {
        if (userManager == null) {
            synchronized (UserManagerCache.class) {
                if (userManager == null)
                    userManager = new UserManagerCache();
            }
        }
        return userManager;
    }

    public void createUser(Integer id, String email, String first_name, String last_name, String avatar) {
        User user = new User(id, email, first_name, last_name, avatar);
        arrayListUsers.add(user);
    }

    public void createResource(Integer id, String name, Integer year, String color, String pantone_value) {
        Resource resource = new Resource(id, name, year, color, pantone_value);
        arrayListResources.add(resource);
    }


    UserPage listUsers() {
        UserPage userPage = new UserPage(2, 6, 12, 2, arrayListUsers);
        return userPage;
    }

    public User singleUser(Integer id) {
        for (User arrayListUser : arrayListUsers) {
            if (arrayListUser.getId().equals(id)) {
                return arrayListUser;
            }
        }
        return null;
    }

    ResourcePage listResources() {
        ResourcePage resourcePage = new ResourcePage(1, 6, 12, 2, arrayListResources);
        return resourcePage;
    }

    public Resource singleResource(Integer id) {
        for (Resource arrayListResource : arrayListResources) {
            if (arrayListResource.getId().equals(id)) {
                return arrayListResource;
            }
        }
        return null;
    }


    public UserJob createUserJob(String id, String createdAt, String name, String job) {
        UserJob userJob = new UserJob(id, createdAt, name, job);
        arrayListUsersJob.add(userJob);
        return userJob;
    }

    UserJob updateUserJob(String id, String name, String job) {
        for (UserJob userJob : arrayListUsersJob) {
            if (userJob.getId().equals(id)) {
                userJob.setName(name);
                userJob.setJob(job);
                userJob.setUpdatedAt(LocalDateTime.now().toString());
                return userJob;
            }
        }
        throw new NullPointerException("com.es2.data.User not found!");
    }

    void deleteUserJob(String id) {
        for (int i = 0; i < arrayListUsersJob.size(); i++) {
            if (arrayListUsersJob.get(i).getId().equals(id)) {
                arrayListUsersJob.remove(i);
            }
        }
    }

    /*public UserCredentials registerUser(String email, String password) {
        //generate random id
        Random r = new Random();
        Integer id = r.nextInt(10);

        //generate random token
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * abc.length());
            salt.append(abc.charAt(index));
        }
        String token = salt.toString();

        UserCredentials userCredentials = new UserCredentials(id, email, password, token);
        arrayListUsersCredentials.add(userCredentials);
        return userCredentials;
    }*/

    public HashMap<String, String> registerUser(Integer id, String email, String password, String token) {
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

        UserCredentials userCredentials = new UserCredentials(id, email, password, token);

        arrayListUsersCredentials.add(userCredentials);
        return hashMap;
     }


    public String loginUser(String email, String password) {
        for (UserCredentials arrayListUsersCredential : arrayListUsersCredentials) {
            if (arrayListUsersCredential.getEmail().equals(email)) {
                if (arrayListUsersCredential.getPassword().equals(password)) {
                    return arrayListUsersCredential.getToken();
                }
            }
        }
        return "User not found";
    }

}
