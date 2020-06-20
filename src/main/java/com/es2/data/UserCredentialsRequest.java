package com.es2.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class UserCredentialsRequest {
    private final String email;
    private final String password;

    public UserCredentialsRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public JsonObject toJsonObject() {
        return new JsonParser().parse(new Gson().toJson(this)).getAsJsonObject();
    }
}
