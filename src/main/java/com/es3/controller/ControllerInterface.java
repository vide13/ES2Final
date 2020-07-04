package com.es3.controller;

import com.es3.objects.*;

import java.io.IOException;

public interface ControllerInterface {
    UserJob createUser(UserJob user) throws IOException;

    SingleUser singleUser(Integer id) throws IOException;

    ListUsers listUsers() throws IOException;

    Register register(Credentials credentials) throws IOException;
}
