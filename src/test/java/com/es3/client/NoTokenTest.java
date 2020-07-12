package com.es3.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NoTokenTest {

    private static Client client;

    @BeforeAll
    static void setup() {
        client = Client.getClient();
    }

    @Test
    void createUserNoTokenUnsuccessful() {
        assertThrows(Error.class, () -> client.createUser("morpheus", "leader"));
    }

    @Test
    void listResourcesNoTokenUnsuccessful() {
        assertThrows(Error.class, () -> client.listResources());
    }

    @Test
    void listUsersNoTokenUnsuccessful() {
        assertThrows(Error.class, () -> client.listUsers());
    }

    @Test
    void singleResourceNoTokenUnsuccessful() {
        assertThrows(Error.class, () -> client.singleResource(2));
    }

    @Test
    void singleUserNoTokenUnsuccessful() {
        assertThrows(Error.class, () -> client.singleUser(2));
    }

}
