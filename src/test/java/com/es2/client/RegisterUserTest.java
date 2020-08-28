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
    private final String EIGHT_CHARACTER_WORD = "TestPassword";

    @BeforeAll
    static void setup() {
        client = Client.getClient();
    }

    @Test
    void Successful() {
        assertDoesNotThrow(() -> client.register("eve.holt@reqres.in", "TestPassword"));
    }

    @Test
    void NullPassword() {
        assertThrows(InvalidPasswordException.class, () -> client.register("eve.holt@reqres.in", null));
    }

    @Test
    void BlankPassword() {
        assertThrows(InvalidPasswordException.class, () -> client.register("eve.holt@reqres.in", " "));
    }

    @Test
    void NullEmail() {
        assertThrows(InvalidEmailException.class, () -> client.register(null, "TestPassword"));
    }

    @Test
    void BlankEmail() {
        assertThrows(InvalidEmailException.class, () -> client.register(" ", "TestPassword"));
    }

    /**
     * Boundary-value analysis
     * <p>
     * Password Always Valid
     */

    @Test
    void LowerInvalidBoundaryEmail() {
        assertThrows(InvalidEmailException.class, () -> client.register("aa", "TestPassword"));
    }

    @Test
    void LowerValidBoundaryEmail() {
        assertDoesNotThrow(() -> client.register("b@b", "TestPassword"));
    }

    @Test
    void UpperValidBoundaryEmail() {
        assertDoesNotThrow(() -> client.register(WORD_WHIT_128_CHARACTER, "TestPassword"));
    }

    @Test
    void UpperInvalidBoundaryEmail() {
        assertThrows(InvalidEmailException.class, () -> client.register(WORD_WHIT_128_CHARACTER + 1, "TestPassword"));
    }

    /**
     * Email Always Valid
     */

    @Test
    void LowerInvalidBoundaryPassword() {
        assertThrows(InvalidPasswordException.class, () -> client.register("eve.holt@reqres.in", "a"));
    }

    @Test
    void LowerValidBoundaryPassword() {
        assertDoesNotThrow(() -> client.register("eve.holt@reqres.in", EIGHT_CHARACTER_WORD));
    }

    @Test
    void UpperValidBoundaryPassword() {
        assertDoesNotThrow(() -> client.register("eve.holt@reqres.in", WORD_WHIT_128_CHARACTER));
    }

    @Test
    void UpperInvalidBoundaryPassword() {
        assertThrows(InvalidPasswordException.class, () -> client.register("eve.holt@reqres.in", WORD_WHIT_128_CHARACTER + 1));
    }
}