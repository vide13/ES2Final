package com.es2.client;

import com.es2.exceptions.InvalidTokenException;
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
        assertThrows(InvalidTokenException.class, () -> client.createUser("morpheus", "leader"));
    }

    @Test
    void listResourcesUnsuccessful() {
        assertThrows(InvalidTokenException.class, () -> client.listResources());
    }

    @Test
    void listUsersUnsuccessful() {
        assertThrows(InvalidTokenException.class, () -> client.listUsers());
    }

    @Test
    void singleResourceUnsuccessful() {
        assertThrows(InvalidTokenException.class, () -> client.singleResource(2));
    }

    @Test
    void singleUserUnsuccessful() {
        assertThrows(InvalidTokenException.class, () -> client.singleUser(2));
    }

}
