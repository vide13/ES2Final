package com.es2.client;

import com.es2.exceptions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.naming.InvalidNameException;
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
    void Successful() {
        assertDoesNotThrow(() -> client.createUser("morpheus", "leader"));
    }

    @Test
    void NullJob() {
        assertThrows(NullJobException.class, () -> client.createUser("morpheus", null));
    }

    @Test
    void BlankJob() {
        assertThrows(InvalidJobException.class, () -> client.createUser("morpheus", " "));
    }

    @Test
    void NullName() {
        assertThrows(NullNameException.class, () -> client.createUser(null, "leader"));
    }

    @Test
    void BlankName() {
        assertThrows(InvalidNameException.class, () -> client.createUser(" ", "leader"));
    }

    /**
     * Boundary-value analysis
     * <p>
     * Job Always Valid
     */

    @Test
    void LowerInvalidBoundaryName() {
        assertThrows(InvalidNameException.class, () -> client.createUser("a", "leader"));
    }

    @Test
    void LowerValidBoundaryName() {
        assertDoesNotThrow(() -> client.createUser("bb", "leader"));
    }

    @Test
    void UpperValidBoundaryName() {
        assertDoesNotThrow(() -> client.createUser(FIFTY_CHARACTER_WORD, "leader"));
    }

    @Test
    void UpperInvalidBoundaryName() {
        assertThrows(InvalidNameException.class, () -> client.createUser(FIFTY_ONE_CHARACTER_WORD, "leader"));
    }

    /**
     * Name Always Valid
     */

    @Test
    void LowerInvalidBoundaryJob() {
        assertThrows(InvalidJobException.class, () -> client.createUser("morpheus", "a"));
    }

    @Test
    void LowerValidBoundaryJob() {
        assertDoesNotThrow(() -> client.createUser("morpheus", "bb"));
    }

    @Test
    void UpperValidBoundaryJob() {
        assertDoesNotThrow(() -> client.createUser("morpheus", FIFTY_CHARACTER_WORD));
    }

    @Test
    void UpperInvalidBoundaryJob() {
        assertThrows(InvalidJobException.class, () -> client.createUser("morpheus", FIFTY_ONE_CHARACTER_WORD));
    }
}