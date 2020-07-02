package com.es3.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreateUserTest {
    Client client = new Client();


    @Test
    void createUserNull() {
        assertThrows(Error.class, () -> client.createUser(null, null));
    }

    @Test
    void createUserSuccessful() {
        assertDoesNotThrow(() -> client.createUser("morpheus", "leader"));
    }
}