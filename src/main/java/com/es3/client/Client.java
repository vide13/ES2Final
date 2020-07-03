package com.es3.client;

import com.es3.controller.ControllerAPI;
import com.es3.controller.ControllerInterface;
import com.es3.objects.UserJob;
import retrofit2.Response;

import java.io.IOException;

import static com.es3.client.Validation.isValidStringArgument;

public class Client {
    public static ControllerInterface controller = new ControllerAPI();

    public static void main(String[] args) throws IOException {
        // Create User
        Response createUserResponse = createUser("Jorge", "Engenheiro");
        System.out.println("\nCreate User\nCode: " + createUserResponse.code() + "\nBody: " + createUserResponse.body().toString());

        // List Users
        Response listUsersResponse = listUsers();
        System.out.println("\nList Users\nCode: " + listUsersResponse.code() + "\nBody: " + listUsersResponse.body().toString());
    }

    static Response createUser(String name, String job) throws IOException {
        if (!isValidStringArgument(name) || !isValidStringArgument(job)) {
            throw new Error("Invalid name or job.");
        }
        return controller.createUser(new UserJob(name, job));
    }

    static Response listUsers() throws IOException {
        return controller.listUsers();
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
