package com.es2.cache;

import com.es2.data.*;
import com.google.gson.JsonObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class UserManagerNotStatic {
    private static volatile UserManagerNotStatic userManager;
    private final ArrayList<UserJob> arrayListUsersJob = new ArrayList<>();
    private final ArrayList<User> arrayListUsers = new ArrayList<>();
    private final ArrayList<Resource> arrayListResources = new ArrayList<>();
    private final ArrayList<UserCredentials> arrayListUsersCredentials = new ArrayList<>();

    UserManagerNotStatic() {
        if (userManager != null) {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class.");
        }
    }

    public static UserManagerNotStatic getInstance() {
        if (userManager == null) {
            synchronized (UserManagerNotStatic.class) {
                if (userManager == null)
                    userManager = new UserManagerNotStatic();
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


    void listUsers() {
        UserPage userPage = new UserPage(2, 6, 12, 2, arrayListUsers);
        System.out.println("\tPage: " + userPage.getPage());
        System.out.println("\tPer_page: " + userPage.getPer_page());
        System.out.println("\tTotal: " + userPage.getTotal());
        System.out.println("\tTotal_pages: " + userPage.getTotal_pages());
        for (User arrayListUser : arrayListUsers) {
            System.out.println("\tId: " + arrayListUser.getId());
            System.out.println("\t\tEmail: " + arrayListUser.getEmail());
            System.out.println("\t\tFirst_name: " + arrayListUser.getFirst_name());
            System.out.println("\t\tLast_name: " + arrayListUser.getLast_name());
            System.out.println("\t\tAvatar: " + arrayListUser.getAvatar());
        }
    }

    public User singleUser(Integer id) {
        for (User arrayListUser : arrayListUsers) {
            if (arrayListUser.getId().equals(id)) {
                return arrayListUser;
            }
        }
        return null;
    }

    JsonObject listResources() {
        ResourcePage resourcePage = new ResourcePage(1, 6, 12, 2, arrayListResources);
        return resourcePage.toJsonObject();
        /*System.out.println("\tPage: " + resourcePage.getPage());
        System.out.println("\tPer_page: " + resourcePage.getPer_page());
        System.out.println("\tTotal: " + resourcePage.getTotal());
        System.out.println("\tTotal_pages: " + resourcePage.getTotal_pages());
        for (com.es2.data.Resource arrayListResource : arrayListResources) {
            System.out.println("\tId: " + arrayListResource.getId());
            System.out.println("\t\tName: " + arrayListResource.getName());
            System.out.println("\t\tYear: " + arrayListResource.getYear());
            System.out.println("\t\tColor: " + arrayListResource.getColor());
            System.out.println("\t\tPantoneValue: " + arrayListResource.getPantone_value());
        }*/
    }

    public Resource singleResource(Integer id) {
        for (Resource arrayListResource : arrayListResources) {
            if (arrayListResource.getId().equals(id)) {
                return arrayListResource;
            }
        }
        return null;
    }


    public UserJob createUserJob(String name, String job, String id, String createdAt) {
        UserJob userJob = new UserJob(name, job, id, createdAt);
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

    public UserCredentials registerUser(String email, String password) {
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
    }

    public UserCredentials registerUser(Integer id, String email, String password, String token) {
        UserCredentials userCredentials = new UserCredentials(id, email, password, token);
        arrayListUsersCredentials.add(userCredentials);
        return userCredentials;
    }


    public String loginUser(String email, String password) {
        for (UserCredentials arrayListUsersCredential : arrayListUsersCredentials) {
            if (arrayListUsersCredential.getEmail().equals(email)) {
                if (arrayListUsersCredential.getPassword().equals(password)) {
                    return arrayListUsersCredential.getToken();
                }
            }
        }
        return null;
    }

}
