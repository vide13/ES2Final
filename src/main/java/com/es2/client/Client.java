package com.es2.client;

import com.es2.controller.ControllerAPI;
import com.es2.controller.ControllerInterface;
import com.es2.controller.ControllerSTUB;
import com.es2.exceptions.*;
import com.es2.objects.*;

import java.io.IOException;

import static com.es2.client.Validation.*;

public class Client {
    public static final ControllerInterface controller = new ControllerSTUB();
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

    public void createUser(String name, String job) throws IOException, InvalidJobException, InvalidNameException, InvalidTokenException {
        isValidNameArgument(name);
        isValidJobArgument(job);
        isValidToken(token);
        UserJob userJob = controller.createUser(token, new UserJob(name, job));
    }

    public void listResources() throws IOException, InvalidTokenException {
        isValidToken(token);
        ListResources listResources = controller.listResources(token);
    }

    public void listUsers() throws IOException, InvalidTokenException {
        isValidToken(token);
        ListUsers listUsers = controller.listUsers(token);
    }

    public void login(String email, String password) throws IOException, InvalidPasswordException, InvalidEmailException {
        isValidPasswordArgument(password);
        isValidEmailArgument(email);
        token = controller.login(new Credentials(email, password)).getToken();
    }

    public void register(String email, String password) throws IOException, InvalidPasswordException, InvalidEmailException {
        isValidPasswordArgument(password);
        isValidEmailArgument(email);
        Register register = controller.register(new Credentials(email, password));
    }

    public void singleResource(Integer id) throws IOException, InvalidIdException, InvalidTokenException {
        isValidIntegerArgument(id);
        isValidToken(token);
        SingleResource singleResource = controller.singleResource(token, id);
    }

    public void singleUser(Integer id) throws IOException, InvalidIdException, InvalidTokenException {
        isValidIntegerArgument(id);
        isValidToken(token);
        SingleUser singleUser = controller.singleUser(token, id);
    }

    public SingleUser pairOrNotTest(Integer a, Integer b) throws Exception {
        if (a + b == 0) {
            throw new Exception("Can't be 0");
        } else if ((a + b) % 2 == 0) {
            return controller.singleUser(token, 2);
        } else {
            return controller.singleUser(token, 1);
        }
    }
}