package com.es2.client;

import com.es2.exceptions.InvalidEmailException;
import com.es2.exceptions.InvalidJobException;
import com.es2.exceptions.InvalidNameException;
import com.es2.exceptions.InvalidPasswordException;
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
    static void setup() throws IOException, InvalidEmailException, InvalidPasswordException {
        client = Client.getClient();
        client.login("eve.holt@reqres.in", "cityslicka");
    }

    /**
     * White-Box Tests
     */

    @Test
    void successful() {
        assertDoesNotThrow(() -> client.createUser("morpheus", "leader"));
    }

    @Test
    void nullJob() {
        assertThrows(InvalidJobException.class, () -> client.createUser("morpheus", null));
    }

    @Test
    void blankJob() {
        assertThrows(InvalidJobException.class, () -> client.createUser("morpheus", " "));
    }

    @Test
    void nullName() {
        assertThrows(InvalidNameException.class, () -> client.createUser(null, "leader"));
    }

    @Test
    void blankName() {
        assertThrows(InvalidNameException.class, () -> client.createUser(" ", "leader"));
    }

    /**
     * Boundary-value analysis
     * <p>
     * Job Always Valid
     */

    @Test
    void lowerInvalidBoundaryName() {
        assertThrows(InvalidNameException.class, () -> client.createUser("a", "leader"));
    }

    @Test
    void lowerValidBoundaryName() {
        assertDoesNotThrow(() -> client.createUser("bb", "leader"));
    }

    @Test
    void upperValidBoundaryName() {
        assertDoesNotThrow(() -> client.createUser(FIFTY_CHARACTER_WORD, "leader"));
    }

    @Test
    void upperInvalidBoundaryName() {
        assertThrows(InvalidNameException.class, () -> client.createUser(FIFTY_ONE_CHARACTER_WORD, "leader"));
    }

    /**
     * Name Always Valid
     */

    @Test
    void lowerInvalidBoundaryJob() {
        assertThrows(InvalidJobException.class, () -> client.createUser("morpheus", "a"));
    }

    @Test
    void lowerValidBoundaryJob() {
        assertDoesNotThrow(() -> client.createUser("morpheus", "bb"));
    }

    @Test
    void upperValidBoundaryJob() {
        assertDoesNotThrow(() -> client.createUser("morpheus", FIFTY_CHARACTER_WORD));
    }

    @Test
    void upperInvalidBoundaryJob() {
        assertThrows(InvalidJobException.class, () -> client.createUser("morpheus", FIFTY_ONE_CHARACTER_WORD));
    }
}