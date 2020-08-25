package com.es2.objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class ListUsers {
    private final Integer page;
    private final Integer per_page;
    private final Integer total;
    private final Integer total_pages;
    private final ArrayList<UserData> data;

    public ListUsers(Integer page, Integer per_page, Integer total, Integer total_pages, ArrayList<UserData> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }

    public JsonObject toJsonObject() {
        return new JsonParser().parse(new Gson().toJson(this)).getAsJsonObject();
    }

}