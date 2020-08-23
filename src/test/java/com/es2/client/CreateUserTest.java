package com.es2.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreateUserTest {

    private static Client client;
    String FIFTY_ONE_CHARACTER_WORD = "esta_string_tem_exatamente_cinquenta_e_um_caractere";
    String FIFTY_CHARACTER_WORD = "esta_string_tem_exatamente_cinquenta_caracteres_ab";

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
    void createUserGoodNameBlankJob() {
        assertThrows(Error.class, () -> client.createUser("morpheus", " "));
    }

    @Test
    void NullName() {
        assertThrows(Error.class, () -> client.createUser(null, "leader"));
    }

    @Test
    void createUserBlankNameGoodJob() {
        assertThrows(Error.class, () -> client.createUser(" ", "leader"));
    }

    /**
     * Boundary-value analysis
     *
     * Job Always Valid
     */

    @Test
    void ZeroCharactersName() {
        assertThrows(Error.class, () -> client.createUser("", "leader"));
    }

    @Test
    void OneCharacterName() {
        assertThrows(Error.class, () -> client.createUser("a", "leader"));
    }

    @Test
    void FiftyCharactersName() {
        assertThrows(Error.class, () -> client.createUser(FIFTY_CHARACTER_WORD, "leader"));
    }

    @Test
    void FiftyOneCharactersName() {
        assertThrows(Error.class, () -> client.createUser(FIFTY_ONE_CHARACTER_WORD, "leader"));
    }

    /**
     * Name Always Valid
     */

    @Test
    void InvalidJob() {
        assertThrows(Error.class, () -> client.createUser("morpheus", ""));
    }

    @Test
    void OneCharacterJob() {
        assertThrows(Error.class, () -> client.createUser("morpheus", "a"));
    }

    @Test
    void FiftyCharactersJob() {
        assertThrows(Error.class, () -> client.createUser("morpheus", FIFTY_CHARACTER_WORD));
    }

    @Test
    void FiftyOneCharactersJob() {
        assertThrows(Error.class, () -> client.createUser("morpheus", FIFTY_ONE_CHARACTER_WORD));
    }
    
}