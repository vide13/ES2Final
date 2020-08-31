package com.es2.client;

import com.es2.exceptions.InvalidEmailException;
import com.es2.exceptions.InvalidPasswordException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LoginUserTest {

    private static Client client;
    String bigWord = "estastringtemmaisdecinquentacarcatereseserautilizadaparanomesejobs";
    String maximumWord = "esta_string_tem_exatamente_cinquenta_caracteres_ab";

    @BeforeAll
    static void setup() {
        client = Client.getClient();
    }

    @Test
    void Successful() {
        assertDoesNotThrow(() -> client.login("eve.holt@reqres.in", "TestPassword"));
    }

    @Test
    void NullPassword() {
        assertThrows(InvalidPasswordException.class, () -> client.login("eve.holt@reqres.in", null));
    }

    @Test
    void BlankPassword() {
        assertThrows(InvalidPasswordException.class, () -> client.login("eve.holt@reqres.in", " "));
    }

    @Test
    void NullEmail() {
        assertThrows(InvalidEmailException.class, () -> client.login(null, "TestPassword"));
    }

    @Test
    void BlankEmail() {
        assertThrows(InvalidEmailException.class, () -> client.login(" ", "TestPassword"));
    }
}