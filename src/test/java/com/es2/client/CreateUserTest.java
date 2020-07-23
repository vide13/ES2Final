package com.es2.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreateUserTest {

    private static Client client;
    String bigWord = "estastringtemmaisdecinquentacarcatereseserautilizadaparanomesejobs";
    String maximumWord = "esta_string_tem_exatamente_cinquenta_caracteres_ab";

    @BeforeAll
    static void setup() throws IOException {
        client = Client.getClient();
        client.login("eve.holt@reqres.in", "cityslicka");
    }

    /**
     * White-Box Tests
     */

    @Test
    void Successful() {
        assertDoesNotThrow(() -> client.createUser("morpheus", "leader"));
    }

    @Test
    void NullJob() {
        assertThrows(Error.class, () -> client.createUser("morpheus", null));
    }

    @Test
    void InvalidJob() {
        assertThrows(Error.class, () -> client.createUser("morpheus", ""));
    }

    @Test
    void NullName() {
        assertThrows(Error.class, () -> client.createUser(null, "leader"));
    }

    @Test
    void InvalidName() {
        assertThrows(Error.class, () -> client.createUser("", "leader"));
    }

    @Test
    void createUserBlankNameGoodJob() {
        assertThrows(Error.class, () -> client.createUser("  ", "leader"));
    }

    @Test
    void createUserGoodNameBigJob() {
        assertThrows(Error.class, () -> client.createUser("morpheus", bigWord));
    }

    @Test
    void createUserGoodNameBlankJob() {
        assertThrows(Error.class, () -> client.createUser("morpheus", "  "));
    }

    @Test
    void createUserMaximumNameGoodJob() {
        assertDoesNotThrow(() -> client.createUser(maximumWord, "leader"));
    }

    @Test
    void createUserMinimumNameGoodJob() {
        assertDoesNotThrow(() -> client.createUser("a", "leader"));
    }

    @Test
    void createUserNullNameGoodJob() {
        assertThrows(Error.class, () -> client.createUser(null, "leader"));
    }
}