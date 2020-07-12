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
    void singleResourceBigId() {
        assertThrows(Error.class, () -> client.singleResource(10000));
    }

    @Test
    void singleResourceIdNull() {
        assertThrows(Error.class, () -> client.singleResource(null));
    }

    @Test
    void singleResourceIdZero() {
        assertThrows(Error.class, () -> client.singleResource(0));
    }

    
    @Test
    void singleResourceSuccessful() {
        assertDoesNotThrow(() -> client.singleResource(2));
    }

    @Test
    void singleResourceSuccessfulMaximumId() {
        assertDoesNotThrow(() -> client.singleResource(9999));
    }

    @Test
    void singleResourceSuccessfulMaximumIdMinus1() {
        assertDoesNotThrow(() -> client.singleResource(9998));
    }

    @Test
    void singleResourceSuccessfulMinimumId() {
        assertDoesNotThrow(() -> client.singleResource(1));
    }
}