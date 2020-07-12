package com.es3.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SingleResourceTest {

    private static Client client;

    @BeforeAll
    static void setup() throws IOException {
        client = Client.getClient();
        client.login("eve.holt@reqres.in", "cityslicka");
    }

    @Test
    void singleResourceIdNull() {
        assertThrows(Error.class, () -> client.singleResource(null));
    }

    @Test
    void singleResourceBigId() {
        assertThrows(Error.class, () -> client.singleResource(1000000));
    }

    @Test
    void singleResourceIdLesserThanZero() {
        assertThrows(Error.class, () -> client.singleResource(-5));
    }

    @Test
    void singleResourceSuccessful() {
        assertDoesNotThrow(() -> client.singleResource(2));
    }

    @Test
    void singleResourceSuccessfulMinimumId() {
        assertDoesNotThrow(() -> client.singleResource(1));
    }

    @Test
    void singleResourceSuccessfulMaximumId() {
        assertDoesNotThrow(() -> client.singleResource(9999));
    }


}