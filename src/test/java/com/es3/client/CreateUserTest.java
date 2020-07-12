package com.es3.client;

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

    @Test
    void crateUserBigNameBlankJob() {
        assertThrows(Error.class, () -> client.createUser(bigWord, "  "));
    }

    @Test
    void createUserBigNameBigJob() {
        assertThrows(Error.class, () -> client.createUser(bigWord, bigWord));
    }

    @Test
    void createUserBigNameEmptyJob() {
        assertThrows(Error.class, () -> client.createUser(bigWord, ""));
    }

    @Test
    void createUserBigNameGoodJob() {
        assertThrows(Error.class, () -> client.createUser(bigWord, "leader"));
    }

    @Test
    void createUserBigNameNullJob() {
        assertThrows(Error.class, () -> client.createUser(bigWord, null));
    }

    @Test
    void createUserBlankNameBlankJob() {
        assertThrows(Error.class, () -> client.createUser("  ", "  "));
    }

    @Test
    void createUserBlankNameEmptyJob() {
        assertThrows(Error.class, () -> client.createUser("  ", ""));
    }

    @Test
    void createUserBlankNameGoodJob() {
        assertThrows(Error.class, () -> client.createUser("  ", "leader"));
    }

    @Test
    void createUserBlankNameNullJob() {
        assertThrows(Error.class, () -> client.createUser("  ", null));
    }

    @Test
    void createUserEmptyNameBigJob() {
        assertThrows(Error.class, () -> client.createUser("", bigWord));
    }

    @Test
    void createUserEmptyNameBlankJob() {
        assertThrows(Error.class, () -> client.createUser("", "  "));
    }

    @Test
    void createUserEmptyNameEmptyJob() {
        assertThrows(Error.class, () -> client.createUser("", ""));
    }

    @Test
    void createUserEmptyNameGoodJob() {
        assertThrows(Error.class, () -> client.createUser("", "leader"));
    }

    @Test
    void createUserEmptyNameNullJob() {
        assertThrows(Error.class, () -> client.createUser("", null));
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
    void createUserGoodNameEmptyJob() {
        assertThrows(Error.class, () -> client.createUser("morpheus", ""));
    }

    @Test
    void createUserGoodNameNullJob() {
        assertThrows(Error.class, () -> client.createUser("morpheus", null));
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
    void createUserNullNameBigJob() {
        assertThrows(Error.class, () -> client.createUser(null, bigWord));
    }

    @Test
    void createUserNullNameBlankJob() {
        assertThrows(Error.class, () -> client.createUser(null, "  "));
    }

    @Test
    void createUserNullNameEmptyJob() {
        assertThrows(Error.class, () -> client.createUser(null, ""));
    }

    @Test
    void createUserNullNameGoodJob() {
        assertThrows(Error.class, () -> client.createUser(null, "leader"));
    }

    @Test
    void createUserNullNameNullJob() {
        assertThrows(Error.class, () -> client.createUser(null, null));
    }

    @Test
    void createUserSuccessful() {
        assertDoesNotThrow(() -> client.createUser("morpheus", "leader"));
    }
}