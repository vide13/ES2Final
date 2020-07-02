package com.es3.client;

import com.es3.controller.ControllerAPI;
import com.es3.controller.ControllerInterface;
import com.es3.objects.UserJob;

import java.io.IOException;

import static com.es3.client.Validation.isValidStringArgument;

public class Client {
    public ControllerInterface controller = new ControllerAPI();

    void createUser(String name, String job) throws IOException {
        if (!isValidStringArgument(name) || !isValidStringArgument(job)) {
            throw new Error("Invalid name or job.");
        }
        controller.createUser(new UserJob(name, job));
    }

    void listUsers() {
    }

    void register() {
    }

    void login() {
    }

    void listResources() {
    }

    void singleResource() {
    }
}
