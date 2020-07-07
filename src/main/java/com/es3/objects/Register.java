package com.es3.objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Register {
    private final Integer id;
    private final String token;

    public Register(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public JsonObject toJsonObject() {
        return new JsonParser().parse(new Gson().toJson(this)).getAsJsonObject();
    }
}
