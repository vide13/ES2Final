package com.es3.controller;

import com.es3.objects.User;
import com.es3.objects.UserJob;
import com.es3.objects.UserPage;

import java.io.IOException;

public interface ControllerInterface {
    UserJob createUser(UserJob user) throws IOException;

    User singleUser(Integer id) throws IOException;

    UserPage listUsers() throws IOException;
}
