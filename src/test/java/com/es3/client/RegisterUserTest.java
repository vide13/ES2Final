package com.es3.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RegisterUserTest {

    String bigWord = "estastringtemmaisdecinquentacarcatereseserautilizadaparanomesejobs";

    @Test
    void registerUserBigEmailBigPassword() {
        assertThrows(Error.class, () -> Client.register(bigWord, bigWord));
    }

    @Test
    void registerUserBigEmailBlankPassword() {
        assertThrows(Error.class, () -> Client.register(bigWord, "  "));
    }

    @Test
    void registerUserBigEmailEmptyPassword() {
        assertThrows(Error.class, () -> Client.register(bigWord, ""));
    }

    @Test
    void registerUserBigEmailGoodPassword() {
        assertThrows(Error.class, () -> Client.register(bigWord, "pistol"));
    }

    @Test
    void registerUserBigEmailNullPassword() {
        assertThrows(Error.class, () -> Client.register(bigWord, null));
    }

    @Test
    void registerUserBlankEmailBlankPassword() {
        assertThrows(Error.class, () -> Client.register("  ", "  "));
    }

    @Test
    void registerUserBlankEmailEmptyPassword() {
        assertThrows(Error.class, () -> Client.register("  ", ""));
    }

    @Test
    void createUserBlankEmailGoodPassword() {
        assertThrows(Error.class, () -> Client.register("  ", "pistol"));
    }

    @Test
    void registerUserBlankEmailNullPassword(){
        assertThrows(Error.class, () -> Client.register("  ", null));
    }

    @Test
    void registerUserEmptyEmailBigPassword() {
        assertThrows(Error.class, () -> Client.register("", bigWord));
    }

    @Test
    void registerUserEmptyEmailBlankPassword(){
        assertThrows(Error.class, () -> Client.register("", "  "));
    }

    @Test
    void registerUserEmptyEmailEmptyPassword(){
        assertThrows(Error.class, () -> Client.register("", ""));
    }

    @Test
    void registerUserEmptyEmailGoodPassword(){
        assertThrows(Error.class, () -> Client.register("", "pistol"));
    }

    @Test
    void registerUserEmptyEmailNullPassword(){
        assertThrows(Error.class, () -> Client.register("", null));
    }

    @Test
    void registerUserGoodEmailBigPassword() {
        assertThrows(Error.class, () -> Client.register("eve.holt@reqres.in", bigWord));
    }

    @Test
    void registerUserGoodEmailBlankPassword(){
        assertThrows(Error.class, () -> Client.register("eve.holt@reqres.in", "  "));
    }

    @Test
    void registerUserGoodEmailEmptyPassword(){
        assertThrows(Error.class, () -> Client.register("eve.holt@reqres.in", ""));
    }

    @Test
    void registerUserNullEmailNullPassword(){
        assertThrows(Error.class, () -> Client.register(null, null));
    }

    @Test
    void registerUserNullEmailBigPassword(){
        assertThrows(Error.class, () -> Client.register(null, bigWord));
    }

    @Test
    void registerUserNullEmailBlankPassword(){
        assertThrows(Error.class, () -> Client.register(null, "  "));
    }

    @Test
    void registerUserNullEmailEmptyPassword(){
        assertThrows(Error.class, () -> Client.register(null, ""));
    }

    @Test
    void registerUserNullEmailGoodPassword(){
        assertThrows(Error.class, () -> Client.register(null, "pistol"));
    }

    @Test
    void registerUserGoodEmailNullPassword() {
        assertThrows(Error.class, () -> Client.register("eve.holt@reqres.in", null));
    }

    @Test
    void registerUserSuccessful() {
        assertDoesNotThrow(() -> Client.register("eve.holt@reqres.in", "pistol"));
    }
}