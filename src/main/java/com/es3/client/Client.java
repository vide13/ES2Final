package com.es3.client;

import com.es3.controller.ControllerInterface;
import com.es3.controller.ControllerSTUB;
import com.es3.objects.User;
import com.es3.objects.UserJob;
import com.es3.objects.UserPage;

import java.io.IOException;

import static com.es3.client.Validation.isValidIntegerArgument;
import static com.es3.client.Validation.isValidStringArgument;

public class Client {
    public static ControllerInterface controller = new ControllerSTUB();

    public static void main(String[] args) throws IOException {
        createUser("Jorge", "Engenheiro");
        singleUser(2);
        listUsers();
        register();
        login();
        listResources();
        singleResource();
    }

    static void createUser(String name, String job) throws IOException {
        if (!isValidStringArgument(name) || !isValidStringArgument(job)) {
            throw new Error("Invalid name or job");
        }
        UserJob userJob = controller.createUser(new UserJob(name, job));
        System.out.println("\nBody: " + userJob.toJsonObject());
    }

    static void singleUser(Integer id) throws IOException {
        if (!isValidIntegerArgument(id)) {
            throw new Error("Invalid id");
        }
        User user = controller.singleUser(id);
        System.out.println("\nBody: " + user.toJsonObject());
    }

    static void listUsers() throws IOException {
        UserPage userPage = controller.listUsers();
        System.out.println("\nBody: " + userPage.toJsonObject());
    }

    static void register() {
    }

    static void login() {
    }

    static void listResources() {
    }

    static void singleResource() {
    }
}
