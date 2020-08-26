package com.es2.client;

import com.es2.exceptions.InvalidIdException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SingleUserTest {

    private static Client client;
    private final Integer UPPER_LIMIT = 10000;
    private final Integer LOWER_LIMIT = 1;

    @BeforeAll
    static void setup() {
        client = Client.getClient();
        //Need token?
        //client.login("eve.holt@reqres.in", "cityslicka");
    }

    @Test
    void LowerInvalidBoundaryName() {
        assertThrows(InvalidIdException.class, () -> client.singleUser(LOWER_LIMIT - 1));
    }

    @Test
    void LowerValidBoundaryName() {
        assertDoesNotThrow(() -> client.singleUser(LOWER_LIMIT));
    }

    @Test
    void UpperValidBoundaryName() {
        assertDoesNotThrow(() -> client.singleUser(UPPER_LIMIT));
    }

    @Test
    void UpperInvalidBoundaryName() {
        assertThrows(InvalidIdException.class, () -> client.singleUser(UPPER_LIMIT + 1));
    }

}