package com.es2.data;

public class UserCredentials {
    private final Integer id;
    private final String email;
    private final String password;
    private final String token;

    public UserCredentials(Integer id, String email, String password, String token) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }
}