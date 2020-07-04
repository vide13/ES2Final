package com.es3.controller;

import com.es3.objects.*;
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
    public SingleUser singleUser(Integer id) {
        return Response.success(200,
                new SingleUser(new UserData(2,
                        "janet.weaver@reqres.in",
                        "Janet",
                        "Weaver",
                        "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"))
        ).body();
    }

    @Override
    public ListUsers listUsers() {
        ArrayList<UserData> data = new ArrayList<>();
        data.add(new UserData(7,
                "michael.lawson@reqres.in",
                "Michael", "Lawson",
                "https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg")
        );
        return Response.success(200, new ListUsers(2, 6, 12, 2, data)).body();
    }

    @Override
    public Register register(Credentials credentials) {
        return Response.success(200, new Register(4, "QpwL5tke4Pnpja7X4")).body();
    }

    @Override
    public Login login(Credentials credentials) {
        return Response.success(200, new Login("QpwL5tke4Pnpja7X4")).body();
    }

    @Override
    public ListResources listResources() {
        ArrayList<ResourceData> data = new ArrayList<>();
        data.add(new ResourceData(1, "cerulean", 2000, "#98B2D1", "15-4020"));
        return Response.success(200, new ListResources(1, 6, 12, 2, data)).body();
    }

    @Override
    public SingleResource singleResource(Integer id) {
        return Response.success(200, new SingleResource(new ResourceData(2, "fuchsia rose", 2001, "#C74375", "17-2031"))).body();
    }
}
