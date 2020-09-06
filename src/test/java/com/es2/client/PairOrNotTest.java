package com.es2.client;

import com.es2.objects.SingleUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PairOrNotTest {
    private static Client client;

    @BeforeAll
    static void setup() {
        client = Client.getClient();
    }

    @Test
    void pair() throws Exception {
        SingleUser user = client.pairOrNotTest(1, 1);
        Assertions.assertEquals(2, user.getData().getId());
    }

    @Test
    void odd() throws Exception {
        SingleUser user = client.pairOrNotTest(1, 2);
        Assertions.assertEquals(1, user.getData().getId());
    }

    @Test
    void zero() {
        assertThrows(Exception.class, () -> client.pairOrNotTest(1, -1));
    }
}
