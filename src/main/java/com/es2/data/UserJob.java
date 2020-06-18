package com.es2.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class UserJob {
    private final String name;
    private final String job;

    public UserJob(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public JsonObject toJsonObject() {
        return new JsonParser().parse(new Gson().toJson(this)).getAsJsonObject();
    }
}
