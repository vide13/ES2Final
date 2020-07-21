package com.es2.controller;

import com.es2.objects.*;

import java.io.IOException;

public interface ControllerInterface {
    UserJob createUser(String token, UserJob user) throws IOException;

    ListResources listResources(String token) throws IOException;

    ListUsers listUsers(String token) throws IOException;

    Login login(Credentials credentials) throws IOException;

    Register register(Credentials credentials) throws IOException;

    SingleResource singleResource(String token, Integer id) throws IOException;

    SingleUser singleUser(String token, Integer id) throws IOException;
}
