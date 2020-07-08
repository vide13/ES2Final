package com.es3.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SingleUserTest {

    @Test
    void singleUserIdNull() {
        assertThrows(Error.class, () -> Client.singleUser(null));
    }

    @Test
    void singleUserBigId() {
        assertThrows(Error.class, () -> Client.singleUser(1000000));
    }

    @Test
    void singleUserIdLesserThanZero() {
        assertThrows(Error.class, () -> Client.singleUser(-5));
    }

    @Test
    void singleUserSuccessful() {
        assertDoesNotThrow(() -> Client.singleUser(2));
    }

    @Test
    void singleUserSuccessfulMinimumId() {
        assertDoesNotThrow(() -> Client.singleUser(1));
    }

    @Test
    void singleUserSuccessfulMaximumId() {
        assertDoesNotThrow(() -> Client.singleUser(9999));
    }


}