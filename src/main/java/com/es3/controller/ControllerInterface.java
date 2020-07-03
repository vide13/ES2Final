package com.es3.controller;

import com.es3.objects.UserJob;
import retrofit2.Response;

import java.io.IOException;

public interface ControllerInterface {
    Response createUser(UserJob user) throws IOException;

    Response listUsers() throws IOException;
}
