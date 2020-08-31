package com.es2.client;

import com.es2.exceptions.InvalidEmailException;
import com.es2.exceptions.InvalidPasswordException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ListResourcesTest {

    private static Client client;

    @BeforeAll
    static void setup() throws IOException, InvalidEmailException, InvalidPasswordException {
        client = Client.getClient();
        client.login("eve.holt@reqres.in", "cityslicka");
    }

    @Test
    void listResourcesSuccessful() {
        assertDoesNotThrow(() -> client.listResources());
    }
}