package com.es3.client;

import com.es3.controller.ControllerInterface;
import com.es3.controller.ControllerSTUB;
import com.es3.objects.*;

import java.io.IOException;

import static com.es3.client.Validation.isValidIntegerArgument;
import static com.es3.client.Validation.isValidStringArgument;

public class Client {
    public static final ControllerInterface controller = new ControllerSTUB();

    public static void main(String[] args) throws IOException {
        try {
            createUser("Jorge", "Engenheiro");
        } catch (Error error) {
            System.out.println("\nCreate User failed: " + error.getMessage());
        }

        try {
            singleUser(2);
        } catch (Error error) {
            System.out.println("\nSingle User failed: " + error.getMessage());
        }

        try {
            listUsers();
        } catch (Error error) {
            System.out.println("\nList Users failed: " + error.getMessage());
        }

        try {
            register("eve.holt@reqres.in", "pistol");
        } catch (Error error) {
            System.out.println("\nRegister failed: " + error.getMessage());
        }

        try {
            login("eve.holt@reqres.in", "cityslicka");
        } catch (Error error) {
            System.out.println("\nLogin failed: " + error.getMessage());
        }

        try {
            listResources();
        } catch (Error error) {
            System.out.println("\nList Resources failed: " + error.getMessage());
        }

        try {
            singleResource(2);
        } catch (Error error) {
            System.out.println("\nList Resources failed: " + error.getMessage());
        }
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
        SingleUser singleUser = controller.singleUser(id);
        System.out.println("\nBody: " + singleUser.toJsonObject());
    }

    static void listUsers() throws IOException {
        ListUsers listUsers = controller.listUsers();
        System.out.println("\nBody: " + listUsers.toJsonObject());
    }

    static void register(String email, String password) throws IOException {
        if (!isValidStringArgument(email) || !isValidStringArgument(password)) {
            throw new Error("Invalid email or password");
        }
        Register register = controller.register(new Credentials(email, password));
        System.out.println("\nBody: " + register.toJsonObject());
    }

    static void login(String email, String password) throws IOException {
        if (!isValidStringArgument(email) || !isValidStringArgument(password)) {
            throw new Error("Invalid email or password");
        }
        Login login = controller.login(new Credentials(email, password));
        System.out.println("\nBody: " + login.toJsonObject());
    }

    static void listResources() throws IOException {
        ListResources listResources = controller.listResources();
        System.out.println("\nBody: " + listResources.toJsonObject());
    }

    static void singleResource(Integer id) throws IOException {
        if (!isValidIntegerArgument(id)) {
            throw new Error();
        }
        SingleResource singleResource = controller.singleResource(id);
        System.out.println("\nBody: " + singleResource.toJsonObject());
    }
}
