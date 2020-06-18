package com.es2.cache;

import com.es2.data.Resource;
import com.es2.data.User;
import com.es2.data.UserCredentials;
import com.es2.data.UserJob;

public class MainTestes {

    public static void main(String[] args) {

        UserManagerNotStatic userManager = new UserManagerNotStatic();

        createStaticUsers(userManager);
        createStaticPages(userManager);

        //criar user job
        System.out.println("Create com.es2.data.User Job!");
//        UserJob userJob = userManager.createUserJob("morpheus", "leader");
//        System.out.println("\tName: " + userJob.getName());
//        System.out.println("\tJob: " + userJob.getJob());
//        System.out.println("\tId: " + userJob.getId());
//        System.out.println("\tCreatedAt: " + userJob.getCreatedAt());


        //listar users
        System.out.println("\nList Users!");
        userManager.listUsers();


        //single user
        System.out.println("\nSingle com.es2.data.User(2)!");
        User user_single = userManager.singleUser(2);
        if(user_single != null){
            System.out.println("\tId: " + user_single.getId());
            System.out.println("\tEmail: " + user_single.getEmail());
            System.out.println("\tFirstName: " + user_single.getFirst_name());
            System.out.println("\tLastName: " + user_single.getLast_name());
            System.out.println("\tAvatar: " + user_single.getAvatar());
        }


        //listar resources
        System.out.println("\nList Resources!");
        userManager.listResources();


        //single resource
        System.out.println("\nSingle com.es2.data.Resource(2)!");
        Resource resource_single = userManager.singleResource(2);
        if(user_single != null){
            System.out.println("\tId: " + resource_single.getId());
            System.out.println("\tName: " + resource_single.getName());
            System.out.println("\tYear: " + resource_single.getYear());
            System.out.println("\tColor: " + resource_single.getColor());
            System.out.println("\tPantoneValue: " + resource_single.getPantone_value());
        }

        //update user job
        System.out.println("\nUpdate com.es2.data.User Job!");
        UserJob update_userJob = userManager.updateUserJob("2", "morpheus", "zion resident");
        System.out.println("\tName: " + update_userJob.getName());
        System.out.println("\tJob: " + update_userJob.getJob());
        System.out.println("\tUpdatedAt: " + update_userJob.getUpdatedAt());


        //delete user Job
        System.out.println("\nDelete com.es2.data.User Job!");
        userManager.deleteUserJob("2");


        //register user credentials
        System.out.println("\nCreate com.es2.data.User Credentials!");
        UserCredentials register_userCredentials = userManager.registerUser("eve.holt@reqres.in", "pistol");
        System.out.println("\tId: " + register_userCredentials.getId());
        System.out.println("\tToken: " + register_userCredentials.getToken());


        //login user credentials
        System.out.println("\nLogin com.es2.data.User Credentials!");
        UserCredentials login_userCredentials = userManager.loginUser("eve.holt@reqres.in", "pistol");
        System.out.println("\tToken: " + login_userCredentials.getToken());

    }


    public static void createStaticUsers(UserManagerNotStatic userManager){
        userManager.createUser(
                2,
                "janet.weaver@reqres.in",
                "Janet",
                "Weaver",
                "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");
        userManager.createUser(
                7,
                "michael.lawson@reqres.in",
                "Michael",
                "Lawson",
                "https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg");
        userManager.createUser(
                8,
                "lindsay.ferguson@reqres.in",
                "Lindsay",
                "Ferguson",
                "https://s3.amazonaws.com/uifaces/faces/twitter/araa3185/128.jpg");
        userManager.createUser(
                9,
                "tobias.funke@reqres.in",
                "Tobias",
                "Funke",
                "https://s3.amazonaws.com/uifaces/faces/twitter/vivekprvr/128.jpg");
    }

    public static void createStaticPages(UserManagerNotStatic userManager){
        userManager.createPage(
                1,
                "cerulean",
                2000,
                "#98B2D1",
                "15-4020");
        userManager.createPage(
                2,
                "fuchsia rose",
                2001,
                "#C74375",
                "17-2031");
        userManager.createPage(
                3,
                "true red",
                2002,
                "#BF1932",
                "19-1664");
        userManager.createPage(
                4,
                "aqua sky",
                2003,
                "#7BC4C4",
                "14-4811");
    }


}