package com.es2.network.apiResponse;

import com.es2.data.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.List;

public class UsersApiResponse {
    private final List<User> data = null;
    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;

    public JsonObject toJsonObject() {
        return new JsonParser().parse(new Gson().toJson(this)).getAsJsonObject();
    }
}
