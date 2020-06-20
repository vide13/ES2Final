package com.es2.network.apiResponse;

public class LoginUserAPIResponse {
    private final String token;

    public LoginUserAPIResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
