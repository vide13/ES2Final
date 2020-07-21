package com.es2.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LoginUserTest {

    String bigWord = "estastringtemmaisdecinquentacarcatereseserautilizadaparanomesejobs";
    String maximumWord = "esta_string_tem_exatamente_cinquenta_caracteres_ab";

    private static Client client;

    @BeforeAll
    static void setup() throws IOException {
        client = Client.getClient();
        client.login("eve.holt@reqres.in", "cityslicka");
    }

    @Test
    void loginUserBigEmailBigPassword() {
        assertThrows(Error.class, () -> client.login(bigWord, bigWord));
    }

    @Test
    void loginUserBigEmailBlankPassword() {
        assertThrows(Error.class, () -> client.login(bigWord, "  "));
    }

    @Test
    void loginUserBigEmailEmptyPassword() {
        assertThrows(Error.class, () -> client.login(bigWord, ""));
    }

    @Test
    void loginUserBigEmailGoodPassword() {
        assertThrows(Error.class, () -> client.login(bigWord, "pistol"));
    }

    @Test
    void loginUserBigEmailNullPassword() {
        assertThrows(Error.class, () -> client.login(bigWord, null));
    }

    @Test
    void loginUserBlankEmailBlankPassword() {
        assertThrows(Error.class, () -> client.login("  ", "  "));
    }

    @Test
    void loginUserBlankEmailEmptyPassword() {
        assertThrows(Error.class, () -> client.login("  ", ""));
    }

    @Test
    void loginUserBlankEmailGoodPassword() {
        assertThrows(Error.class, () -> client.login("  ", "pistol"));
    }

    @Test
    void loginUserBlankEmailNullPassword(){
        assertThrows(Error.class, () -> client.login("  ", null));
    }

    @Test
    void loginUserEmptyEmailBigPassword() {
        assertThrows(Error.class, () -> client.login("", bigWord));
    }

    @Test
    void loginUserEmptyEmailBlankPassword(){
        assertThrows(Error.class, () -> client.login("", "  "));
    }

    @Test
    void loginUserEmptyEmailEmptyPassword(){
        assertThrows(Error.class, () -> client.login("", ""));
    }

    @Test
    void loginUserEmptyEmailGoodPassword(){
        assertThrows(Error.class, () -> client.login("", "pistol"));
    }

    @Test
    void loginUserEmptyEmailNullPassword(){
        assertThrows(Error.class, () -> client.login("", null));
    }

    @Test
    void loginUserGoodEmailBigPassword() {
        assertThrows(Error.class, () -> client.login("eve.holt@reqres.in", bigWord));
    }

    @Test
    void loginUserGoodEmailBlankPassword(){
        assertThrows(Error.class, () -> client.login("eve.holt@reqres.in", "  "));
    }

    @Test
    void loginUserGoodEmailEmptyPassword(){
        assertThrows(Error.class, () -> client.login("eve.holt@reqres.in", ""));
    }

    @Test
    void loginUserNullEmailNullPassword(){
        assertThrows(Error.class, () -> client.login(null, null));
    }

    @Test
    void loginUserNullEmailBigPassword(){
        assertThrows(Error.class, () -> client.login(null, bigWord));
    }

    @Test
    void loginUserNullEmailBlankPassword(){
        assertThrows(Error.class, () -> client.login(null, "  "));
    }

    @Test
    void loginUserNullEmailEmptyPassword(){
        assertThrows(Error.class, () -> client.login(null, ""));
    }

    @Test
    void loginUserNullEmailGoodPassword(){
        assertThrows(Error.class, () -> client.login(null, "pistol"));
    }

    @Test
    void loginUserGoodEmailNullPassword() {
        assertThrows(Error.class, () -> client.login("eve.holt@reqres.in", null));
    }

    @Test
    void loginUserMaximumNameGoodJob() {
        assertDoesNotThrow(() -> client.login(maximumWord, "pistol"));
    }

    @Test
    void loginUserMinimumNameGoodJob() {
        assertDoesNotThrow(() -> client.login("a", "pistol"));
    }

    @Test
    void loginUserSuccessful() {
        assertDoesNotThrow(() -> client.login("eve.holt@reqres.in", "pistol"));
    }
}