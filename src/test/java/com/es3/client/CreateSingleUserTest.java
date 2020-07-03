package com.es3.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreateSingleUserTest {
    @Test
    void createUserNull() {
        assertThrows(Error.class, () -> Client.createUser(null, null));
    }

    @Test
    void createUserSuccessful() {
        assertDoesNotThrow(() -> Client.createUser("morpheus", "leader"));
    }
}