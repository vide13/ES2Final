package com.es2.cache;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class UserCredentials {
    private Integer id;
    private String email;
    private String password;
    private String token;

    public UserCredentials(Integer id, String email, String password, String token) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public JsonObject toJsonObject() {
        return new JsonParser().parse(new Gson().toJson(this)).getAsJsonObject();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}