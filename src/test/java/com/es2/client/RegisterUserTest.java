package com.es2.client;

import com.es2.exceptions.InvalidEmailException;
import com.es2.exceptions.InvalidPasswordException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RegisterUserTest {

    private static Client client;
    private final String WORD_WHIT_128_CHARACTER = "esta_string_tem_exatamente_128_caracteres_zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
    private final String EIGHT_CHARACTER_WORD = "TestPass";
    private final String SEVEN_CHARACTER_WORD = "TestPas";

    @BeforeAll
    static void setup() {
        client = Client.getClient();
    }

    @Test
    void successful() {
        assertDoesNotThrow(() -> client.register("eve.holt@reqres.in", "TestPassword"));
    }

    @Test
    void nullPassword() {
        assertThrows(InvalidPasswordException.class, () -> client.register("eve.holt@reqres.in", null));
    }

    @Test
    void blankPassword() {
        assertThrows(InvalidPasswordException.class, () -> client.register("eve.holt@reqres.in", " "));
    }

    @Test
    void nullEmail() {
        assertThrows(InvalidEmailException.class, () -> client.register(null, "TestPassword"));
    }

    @Test
    void blankEmail() {
        assertThrows(InvalidEmailException.class, () -> client.register(" ", "TestPassword"));
    }

    /**
     * Boundary-value analysis
     * <p>
     * Password Always Valid
     */

    @Test
    void lowerInvalidBoundaryEmail() {
        assertThrows(InvalidEmailException.class, () -> client.register("aa", "TestPassword"));
    }

    @Test
    void lowerValidBoundaryEmail() {
        assertDoesNotThrow(() -> client.register("b@b", "TestPassword"));
    }

    @Test
    void upperValidBoundaryEmail() {
        assertDoesNotThrow(() -> client.register(WORD_WHIT_128_CHARACTER, "TestPassword"));
    }

    @Test
    void upperInvalidBoundaryEmail() {
        assertThrows(InvalidEmailException.class, () -> client.register(WORD_WHIT_128_CHARACTER + 1, "TestPassword"));
    }

    /**
     * Email Always Valid
     */

    @Test
    void lowerInvalidBoundaryPassword() {
        assertThrows(InvalidPasswordException.class, () -> client.register("eve.holt@reqres.in", SEVEN_CHARACTER_WORD));
    }

    @Test
    void lowerValidBoundaryPassword() {
        assertDoesNotThrow(() -> client.register("eve.holt@reqres.in", EIGHT_CHARACTER_WORD));
    }

    @Test
    void upperValidBoundaryPassword() {
        assertDoesNotThrow(() -> client.register("eve.holt@reqres.in", WORD_WHIT_128_CHARACTER));
    }

    @Test
    void upperInvalidBoundaryPassword() {
        assertThrows(InvalidPasswordException.class, () -> client.register("eve.holt@reqres.in", WORD_WHIT_128_CHARACTER + 1));
    }
}