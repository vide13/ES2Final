package com.es2.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LoginUserTest {

    private static Client client;

    @BeforeAll
    static void setup() {
        client = Client.getClient();
    }

    @Test
    void successful() {
        assertDoesNotThrow(() -> client.login("eve.holt@reqres.in", "TestPassword"));
    }

}