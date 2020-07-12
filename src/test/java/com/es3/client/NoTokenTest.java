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
    void createUserUnsuccessful() {
        assertThrows(Error.class, () -> client.createUser("morpheus", "leader"));
    }

    @Test
    void listResourcesUnsuccessful() {
        assertThrows(Error.class, () -> client.listResources());
    }

    @Test
    void listUsersUnsuccessful() {
        assertThrows(Error.class, () -> client.listUsers());
    }

    @Test
    void singleResourceUnsuccessful() {
        assertThrows(Error.class, () -> client.singleResource(2));
    }

    @Test
    void singleUserUnsuccessful() {
        assertThrows(Error.class, () -> client.singleUser(2));
    }

}
