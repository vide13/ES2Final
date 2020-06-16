package com.es2.cache;

import java.time.LocalDateTime;

public class UserJob {
    private String name;
    private String job;
    private final String id;
    private final String createdAt = LocalDateTime.now().toString();
    private String updatedAt;

    public UserJob(String name, String job) {
        this.name = name;
        this.job = job;
        this.id = "49";
        this.updatedAt = null;
    }

    public UserJob(String name, String job, String id) {
        this.name = name;
        this.job = job;
        this.id = id;
        this.updatedAt = null;
    }

    public String getName() {
        return name;
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

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
