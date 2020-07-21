package com.es2.objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SingleUser {
    private final UserData data;

    public SingleUser(UserData data) {
        this.data = data;
    }

    public UserData getData() {
        return data;
    }

    public JsonObject toJsonObject() {
        return new JsonParser().parse(new Gson().toJson(this)).getAsJsonObject();
    }

}
