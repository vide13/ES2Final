package com.es2.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RegisterUserTest {

    private static Client client;
    String bigWord = "estastringtemmaisdecinquentacarcatereseserautilizadaparanomesejobs";
    String maximumWord = "esta_string_tem_exatamente_cinquenta_caracteres_ab";

    @BeforeAll
    static void setup() throws IOException {
        client = Client.getClient();
        client.login("eve.holt@reqres.in", "cityslicka");
    }

    @Test
    void createUserBlankEmailGoodPassword() {
        assertThrows(Error.class, () -> client.register("  ", "pistol"));
    }

    @Test
    void registerUserBigEmailBigPassword() {
        assertThrows(Error.class, () -> client.register(bigWord, bigWord));
    }

    @Test
    void registerUserBigEmailBlankPassword() {
        assertThrows(Error.class, () -> client.register(bigWord, "  "));
    }

    @Test
    void registerUserBigEmailEmptyPassword() {
        assertThrows(Error.class, () -> client.register(bigWord, ""));
    }

    @Test
    void registerUserBigEmailGoodPassword() {
        assertThrows(Error.class, () -> client.register(bigWord, "pistol"));
    }

    @Test
    void registerUserBigEmailNullPassword() {
        assertThrows(Error.class, () -> client.register(bigWord, null));
    }

    @Test
    void registerUserBlankEmailBlankPassword() {
        assertThrows(Error.class, () -> client.register("  ", "  "));
    }

    @Test
    void registerUserBlankEmailEmptyPassword() {
        assertThrows(Error.class, () -> client.register("  ", ""));
    }

    @Test
    void registerUserBlankEmailNullPassword() {
        assertThrows(Error.class, () -> client.register("  ", null));
    }

    @Test
    void registerUserEmptyEmailBigPassword() {
        assertThrows(Error.class, () -> client.register("", bigWord));
    }

    @Test
    void registerUserEmptyEmailBlankPassword() {
        assertThrows(Error.class, () -> client.register("", "  "));
    }

    @Test
    void registerUserEmptyEmailEmptyPassword() {
        assertThrows(Error.class, () -> client.register("", ""));
    }

    @Test
    void registerUserEmptyEmailGoodPassword() {
        assertThrows(Error.class, () -> client.register("", "pistol"));
    }

    @Test
    void registerUserEmptyEmailNullPassword() {
        assertThrows(Error.class, () -> client.register("", null));
    }

    @Test
    void registerUserGoodEmailBigPassword() {
        assertThrows(Error.class, () -> client.register("eve.holt@reqres.in", bigWord));
    }

    @Test
    void registerUserGoodEmailBlankPassword() {
        assertThrows(Error.class, () -> client.register("eve.holt@reqres.in", "  "));
    }

    @Test
    void registerUserGoodEmailEmptyPassword() {
        assertThrows(Error.class, () -> client.register("eve.holt@reqres.in", ""));
    }

    @Test
    void registerUserGoodEmailNullPassword() {
        assertThrows(Error.class, () -> client.register("eve.holt@reqres.in", null));
    }

    @Test
    void registerUserMaximumNameGoodJob() {
        assertDoesNotThrow(() -> client.register(maximumWord, "pistol"));
    }

    @Test
    void registerUserMinimumNameGoodJob() {
        assertDoesNotThrow(() -> client.register("a", "pistol"));
    }

    @Test
    void registerUserNullEmailBigPassword() {
        assertThrows(Error.class, () -> client.register(null, bigWord));
    }

    @Test
    void registerUserNullEmailBlankPassword() {
        assertThrows(Error.class, () -> client.register(null, "  "));
    }

    @Test
    void registerUserNullEmailEmptyPassword() {
        assertThrows(Error.class, () -> client.register(null, ""));
    }

    @Test
    void registerUserNullEmailGoodPassword() {
        assertThrows(Error.class, () -> client.register(null, "pistol"));
    }

    @Test
    void registerUserNullEmailNullPassword() {
        assertThrows(Error.class, () -> client.register(null, null));
    }

    @Test
    void registerUserSuccessful() {
        assertDoesNotThrow(() -> client.register("eve.holt@reqres.in", "pistol"));
    }
}