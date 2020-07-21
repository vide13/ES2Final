package com.es2.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SingleUserTest {

    private static Client client;

    @BeforeAll
    static void setup() throws IOException {
        client = Client.getClient();
        client.login("eve.holt@reqres.in", "cityslicka");
    }

    @Test
    void singleUserBigId() {
        assertThrows(Error.class, () -> client.singleUser(10000));
    }

    @Test
    void singleUserIdNull() {
        assertThrows(Error.class, () -> client.singleUser(null));
    }

    @Test
    void singleUserIdZero() {
        assertThrows(Error.class, () -> client.singleUser(0));
    }

    @Test
    void singleUserSuccessful() {
        assertDoesNotThrow(() -> client.singleUser(2));
    }

    @Test
    void singleUserSuccessfulMaximumId() {
        assertDoesNotThrow(() -> client.singleUser(9999));
    }

    @Test
    void singleUserSuccessfulMaximumIdMinus1() {
        assertDoesNotThrow(() -> client.singleUser(9998));
    }

    @Test
    void singleUserSuccessfulMinimumId() {
        assertDoesNotThrow(() -> client.singleUser(1));
    }
}