package com.es3.controller;

import com.es3.objects.User;
import com.es3.objects.UserJob;
import com.es3.objects.UserPage;
import retrofit2.Response;

import java.util.ArrayList;


public class ControllerSTUB implements ControllerInterface {
    @Override
    public UserJob createUser(UserJob user) {
        return Response.success(201, new UserJob("49",
                "morpheus",
                "leader",
                "2020-06-01T21:00:08.929Z")
        ).body();
    }

    @Override
    public UserPage listUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(7,
                "michael.lawson@reqres.in",
                "Michael", "Lawson",
                "https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg")
        );
        return Response.success(200, new UserPage(2, 6, 12, 2, users)).body();
    }
}
