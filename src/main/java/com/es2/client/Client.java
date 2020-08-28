package com.es2.client;

import com.es2.controller.ControllerAPI;
import com.es2.controller.ControllerInterface;
import com.es2.exceptions.InvalidEmailException;
import com.es2.exceptions.InvalidIdException;
import com.es2.exceptions.InvalidPasswordException;
import com.es2.objects.*;

import java.io.IOException;

import static com.es2.client.Validation.*;

public class Client {
    public static final ControllerInterface controller = new ControllerAPI();
    private static String token;

    private static Client client;

    public static Client getClient() {
        if (client == null) {
            synchronized (Client.class) {
                if (client == null) {
                    client = new Client();
                }
            }
        }
        return client;
    }

    public void createUser(String name, String job) throws IOException {
        if (!isValidStringArgument(name) || !isValidStringArgument(job)) {
            throw new Error("Invalid name or job");
        }
        if (!isValidToken(token)) throw new Error("Invalid Token");
        UserJob userJob = controller.createUser(token, new UserJob(name, job));
    }

    public void listResources() throws IOException {
        if (!isValidToken(token)) throw new Error("Invalid Token");
        ListResources listResources = controller.listResources(token);
    }

    public void listUsers() throws IOException {
        if (!isValidToken(token)) throw new Error("Invalid Token");
        ListUsers listUsers = controller.listUsers(token);
    }

    public void login(String email, String password) throws IOException {
        if (!isValidStringArgument(email) || !isValidStringArgument(password)) {
            throw new Error("Invalid email or password");
        }
        token = controller.login(new Credentials(email, password)).getToken();
    }

    public void register(String email, String password) throws IOException, InvalidPasswordException, InvalidEmailException {
        isValidPasswordArgument(password);
        isValidEmailArgument(email);
        Register register = controller.register(new Credentials(email, password));
    }

    public void singleResource(Integer id) throws IOException {
        if (!isValidIntegerArgument(id)) {
            throw new Error("Invalid Id");
        }
        if (!isValidToken(token)) throw new Error("Invalid Token");
        SingleResource singleResource = controller.singleResource(token, id);
    }

    public void singleUser(Integer id) throws IOException, InvalidIdException {
        if (!isValidIntegerArgument(id)) {
            throw new InvalidIdException("Invalid Id");
        }
        if (!isValidToken(token)) throw new Error("Invalid Token");
        SingleUser singleUser = controller.singleUser(token, id);
    }
}