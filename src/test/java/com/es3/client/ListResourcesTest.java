package com.es3.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ListResourcesTest {

    @Test
    void listResourcesSuccessful() {
        assertDoesNotThrow(() -> Client.listResources());
    }


}