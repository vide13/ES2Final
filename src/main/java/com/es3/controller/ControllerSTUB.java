package com.es3.controller;

import com.es3.objects.UserJob;
import retrofit2.Response;


public class ControllerSTUB implements ControllerInterface {
    @Override
    public Response createUser(UserJob user) {
        return Response.success(201, new UserJob("49", "morpheus", "leader", "2020-06-01T21:00:08.929Z"));
    }
}
