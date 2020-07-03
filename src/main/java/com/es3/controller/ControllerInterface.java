package com.es3.controller;

import com.es3.objects.ListUsers;
import com.es3.objects.SingleUser;
import com.es3.objects.UserJob;

import java.io.IOException;

public interface ControllerInterface {
    UserJob createUser(UserJob user) throws IOException;

    SingleUser singleUser(Integer id) throws IOException;

    ListUsers listUsers() throws IOException;
}
