package com.es3.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SingleResourceTest {

    @Test
    void singleResourceIdNull() {
        assertThrows(Error.class, () -> Client.singleResource(null));
    }

    @Test
    void singleResourceBigId() {
        assertThrows(Error.class, () -> Client.singleResource(1000000));
    }

    @Test
    void singleResourceIdLesserThanZero() {
        assertThrows(Error.class, () -> Client.singleResource(-5));
    }

    @Test
    void singleResourceSuccessful() {
        assertDoesNotThrow(() -> Client.singleResource(2));
    }


}