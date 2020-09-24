package com.es2.objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@SuppressWarnings("unused")
public class UserJob {
    private final String job;
    private final String name;
    private String id;
    private String createdAt;

    public UserJob(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public UserJob(String id, String createdAt, String name, String job) {
        this.id = id;
        this.createdAt = createdAt;
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public JsonObject toJsonObject() {
        return new JsonParser().parse(new Gson().toJson(this)).getAsJsonObject();
    }
}
