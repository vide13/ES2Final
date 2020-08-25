package com.es2.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreateUserTest {

    private static Client client;
    private final String FIFTY_ONE_CHARACTER_WORD = "esta_string_tem_exatamente_cinquenta_e_um_caractere";
    private final String FIFTY_CHARACTER_WORD = "esta_string_tem_exatamente_cinquenta_caracteres_ab";

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
    void BlankJob() {
        assertThrows(Error.class, () -> client.createUser("morpheus", " "));
    }

    @Test
    void NullName() {
        assertThrows(Error.class, () -> client.createUser(null, "leader"));
    }

    @Test
    void BlankName() {
        assertThrows(Error.class, () -> client.createUser(" ", "leader"));
    }

    /**
     * Boundary-value analysis
     *
     * Name Always Valid
     */

    @Test
    void LowerInvalidBoundaryName() {
        assertThrows(Error.class, () -> client.createUser("a", "leader"));
    }

    @Test
    void LowerValidBoundaryName() {
        assertThrows(Error.class, () -> client.createUser("bb", "leader"));
    }

    @Test
    void UpperValidBoundaryName() {
        assertThrows(Error.class, () -> client.createUser(FIFTY_CHARACTER_WORD, "leader"));
    }

    @Test
    void UpperInvalidBoundaryName() {
        assertThrows(Error.class, () -> client.createUser(FIFTY_ONE_CHARACTER_WORD, "leader"));
    }

    /**
     * Job Always Valid
     */

    @Test
    void LowerInvalidBoundaryJob() {
        assertThrows(Error.class, () -> client.createUser("morpheus", "a"));
    }

    @Test
    void LowerValidBoundaryJob() {
        assertThrows(Error.class, () -> client.createUser("morpheus", "bb"));
    }

    @Test
    void UpperValidBoundaryJob() {
        assertThrows(Error.class, () -> client.createUser("morpheus", FIFTY_CHARACTER_WORD));
    }

    @Test
    void UpperInvalidBoundaryJob() {
        assertThrows(Error.class, () -> client.createUser("morpheus", FIFTY_ONE_CHARACTER_WORD));
    }
    
}