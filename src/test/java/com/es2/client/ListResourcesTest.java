package com.es2.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ListResourcesTest {

    private static Client client;

    @BeforeAll
    static void setup() throws IOException {
        client = Client.getClient();
        client.login("eve.holt@reqres.in", "cityslicka");
    }

    @Test
    void listResourcesSuccessful() {
        assertDoesNotThrow(() -> client.listResources());
    }
}