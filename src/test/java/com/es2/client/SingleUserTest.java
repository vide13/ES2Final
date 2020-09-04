package com.es2.client;

import com.es2.exceptions.InvalidEmailException;
import com.es2.exceptions.InvalidIdException;
import com.es2.exceptions.InvalidPasswordException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SingleUserTest {

    private static Client client;
    private final Integer UPPER_LIMIT = 10000;
    private final Integer LOWER_LIMIT = 1;

    @BeforeAll
    static void setup() throws InvalidEmailException, IOException, InvalidPasswordException {
        client = Client.getClient();
        client.login("eve.holt@reqres.in", "cityslicka");
    }

    @Test
    void successful() {
        assertDoesNotThrow(() -> client.singleUser(10));
    }

    /**
     * Black-Box Tests
     */

    @Test
    void nullId() {
        assertThrows(InvalidIdException.class, () -> client.singleUser(null));
    }

    @Test
    void lowerInvalidBoundaryId() {
        assertThrows(InvalidIdException.class, () -> client.singleUser(LOWER_LIMIT - 1));
    }

    @Test
    void lowerValidBoundaryId() {
        assertDoesNotThrow(() -> client.singleUser(LOWER_LIMIT));
    }

    @Test
    void upperValidBoundaryId() {
        assertDoesNotThrow(() -> client.singleUser(UPPER_LIMIT));
    }

    @Test
    void upperInvalidBoundaryId() {
        assertThrows(InvalidIdException.class, () -> client.singleUser(UPPER_LIMIT + 1));
    }

}