package com.es3.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ListUsersTest {

    @Test
    void listUsersSuccessful() {
        assertDoesNotThrow(() -> Client.listUsers());
    }


}