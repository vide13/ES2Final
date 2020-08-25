package com.es2.objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class UserJob {
    private String id;
    private String createdAt;
    private String name;
    private String job;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public JsonObject toJsonObject() {
        return new JsonParser().parse(new Gson().toJson(this)).getAsJsonObject();
    }
}
