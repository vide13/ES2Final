package com.es3.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreateUserTest {

    String bigWord = "estastringtemmaisdecinquentacarcatereseserautilizadaparanomesejobs";
    String maximumWord = "esta_string_tem_exatamente_cinquenta_caracteres_ab";

    @Test
    void createUserBigNameBigJob() {
        assertThrows(Error.class, () -> Client.createUser(bigWord, bigWord));
    }

    @Test
    void crateUserBigNameBlankJob() {
        assertThrows(Error.class, () -> Client.createUser(bigWord, "  "));
    }

    @Test
    void createUserBigNameEmptyJob() {
        assertThrows(Error.class, () -> Client.createUser(bigWord, ""));
    }

    @Test
    void createUserBigNameGoodJob() {
        assertThrows(Error.class, () -> Client.createUser(bigWord, "leader"));
    }

    @Test
    void createUserBigNameNullJob() {
        assertThrows(Error.class, () -> Client.createUser(bigWord, null));
    }

    @Test
    void createUserBlankNameBlankJob() {
        assertThrows(Error.class, () -> Client.createUser("  ", "  "));
    }

    @Test
    void createUserBlankNameEmptyJob() {
        assertThrows(Error.class, () -> Client.createUser("  ", ""));
    }

    @Test
    void createUserBlankNameGoodJob() {
        assertThrows(Error.class, () -> Client.createUser("  ", "leader"));
    }

    @Test
    void createUserBlankNameNullJob(){
        assertThrows(Error.class, () -> Client.createUser("  ", null));
    }

    @Test
    void createUserEmptyNameBigJob() {
        assertThrows(Error.class, () -> Client.createUser("", bigWord));
    }

    @Test
    void createUserEmptyNameBlankJob(){
        assertThrows(Error.class, () -> Client.createUser("", "  "));
    }

    @Test
    void createUserEmptyNameEmptyJob(){
        assertThrows(Error.class, () -> Client.createUser("", ""));
    }

    @Test
    void createUserEmptyNameGoodJob(){
        assertThrows(Error.class, () -> Client.createUser("", "leader"));
    }

    @Test
    void createUserEmptyNameNullJob(){
        assertThrows(Error.class, () -> Client.createUser("", null));
    }

    @Test
    void createUserGoodNameBigJob() {
        assertThrows(Error.class, () -> Client.createUser("morpheus", bigWord));
    }

    @Test
    void createUserGoodNameBlankJob(){
        assertThrows(Error.class, () -> Client.createUser("morpheus", "  "));
    }

    @Test
    void createUserGoodNameEmptyJob(){
        assertThrows(Error.class, () -> Client.createUser("morpheus", ""));
    }

    @Test
    void createUserNullNameNullJob(){
        assertThrows(Error.class, () -> Client.createUser(null, null));
    }

    @Test
    void createUserNullNameBigJob(){
        assertThrows(Error.class, () -> Client.createUser(null, bigWord));
    }

    @Test
    void createUserNullNameBlankJob(){
        assertThrows(Error.class, () -> Client.createUser(null, "  "));
    }

    @Test
    void createUserNullNameEmptyJob(){
        assertThrows(Error.class, () -> Client.createUser(null, ""));
    }

    @Test
    void createUserNullNameGoodJob(){
        assertThrows(Error.class, () -> Client.createUser(null, "leader"));
    }

    @Test
    void createUserGoodNameNullJob() {
        assertThrows(Error.class, () -> Client.createUser("morpheus", null));
    }

    @Test
    void createUserMaximumNameGoodJob() {
        assertDoesNotThrow(() -> Client.createUser(maximumWord, "leader"));
    }

    @Test
    void createUserMinimumNameGoodJob() {
        assertDoesNotThrow(() -> Client.createUser("a", "leader"));
    }

    @Test
    void createUserSuccessful() {
        assertDoesNotThrow(() -> Client.createUser("morpheus", "leader"));
    }
}