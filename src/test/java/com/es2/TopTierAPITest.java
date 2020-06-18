package com.es2;

import com.es2.Exceptions.InvalidArguments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class TopTierAPITest {

    @Test
    void newUser() throws IOException, InvalidArguments {
        TopTierAPI topTierAPI = TopTierAPI.getInstance();
        Assertions.assertEquals(201, topTierAPI.newUser("teste", "agricultor").code());
    }
}