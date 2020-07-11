package com.es3.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LoginUserTest {

    String bigWord = "estastringtemmaisdecinquentacarcatereseserautilizadaparanomesejobs";
    String maximumWord = "esta_string_tem_exatamente_cinquenta_caracteres_ab";

    @Test
    void loginUserBigEmailBigPassword() {
        assertThrows(Error.class, () -> Client.login(bigWord, bigWord));
    }

    @Test
    void loginUserBigEmailBlankPassword() {
        assertThrows(Error.class, () -> Client.login(bigWord, "  "));
    }

    @Test
    void loginUserBigEmailEmptyPassword() {
        assertThrows(Error.class, () -> Client.login(bigWord, ""));
    }

    @Test
    void loginUserBigEmailGoodPassword() {
        assertThrows(Error.class, () -> Client.login(bigWord, "pistol"));
    }

    @Test
    void loginUserBigEmailNullPassword() {
        assertThrows(Error.class, () -> Client.login(bigWord, null));
    }

    @Test
    void loginUserBlankEmailBlankPassword() {
        assertThrows(Error.class, () -> Client.login("  ", "  "));
    }

    @Test
    void loginUserBlankEmailEmptyPassword() {
        assertThrows(Error.class, () -> Client.login("  ", ""));
    }

    @Test
    void loginUserBlankEmailGoodPassword() {
        assertThrows(Error.class, () -> Client.login("  ", "pistol"));
    }

    @Test
    void loginUserBlankEmailNullPassword(){
        assertThrows(Error.class, () -> Client.login("  ", null));
    }

    @Test
    void loginUserEmptyEmailBigPassword() {
        assertThrows(Error.class, () -> Client.login("", bigWord));
    }

    @Test
    void loginUserEmptyEmailBlankPassword(){
        assertThrows(Error.class, () -> Client.login("", "  "));
    }

    @Test
    void loginUserEmptyEmailEmptyPassword(){
        assertThrows(Error.class, () -> Client.login("", ""));
    }

    @Test
    void loginUserEmptyEmailGoodPassword(){
        assertThrows(Error.class, () -> Client.login("", "pistol"));
    }

    @Test
    void loginUserEmptyEmailNullPassword(){
        assertThrows(Error.class, () -> Client.login("", null));
    }

    @Test
    void loginUserGoodEmailBigPassword() {
        assertThrows(Error.class, () -> Client.login("eve.holt@reqres.in", bigWord));
    }

    @Test
    void loginUserGoodEmailBlankPassword(){
        assertThrows(Error.class, () -> Client.login("eve.holt@reqres.in", "  "));
    }

    @Test
    void loginUserGoodEmailEmptyPassword(){
        assertThrows(Error.class, () -> Client.login("eve.holt@reqres.in", ""));
    }

    @Test
    void loginUserNullEmailNullPassword(){
        assertThrows(Error.class, () -> Client.login(null, null));
    }

    @Test
    void loginUserNullEmailBigPassword(){
        assertThrows(Error.class, () -> Client.login(null, bigWord));
    }

    @Test
    void loginUserNullEmailBlankPassword(){
        assertThrows(Error.class, () -> Client.login(null, "  "));
    }

    @Test
    void loginUserNullEmailEmptyPassword(){
        assertThrows(Error.class, () -> Client.login(null, ""));
    }

    @Test
    void loginUserNullEmailGoodPassword(){
        assertThrows(Error.class, () -> Client.login(null, "pistol"));
    }

    @Test
    void loginUserGoodEmailNullPassword() {
        assertThrows(Error.class, () -> Client.login("eve.holt@reqres.in", null));
    }

    @Test
    void loginUserMaximumNameGoodJob() {
        assertDoesNotThrow(() -> Client.login(maximumWord, "pistol"));
    }

    @Test
    void loginUserMinimumNameGoodJob() {
        assertDoesNotThrow(() -> Client.login("a", "pistol"));
    }

    @Test
    void loginUserSuccessful() {
        assertDoesNotThrow(() -> Client.login("eve.holt@reqres.in", "pistol"));
    }
}