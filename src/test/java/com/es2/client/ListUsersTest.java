package com.es2.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ListUsersTest {

    private static Client client;

    @BeforeAll
    static void setup() throws IOException {
        client = Client.getClient();
        /*
        Need token?
        client.login("eve.holt@reqres.in", "cityslicka");
        */
    }

    @Test
    void listUsersSuccessful() {
        assertDoesNotThrow(() -> client.listUsers());
    }
}