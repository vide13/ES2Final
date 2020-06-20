package com.es2.data;

import com.es2.data.Resource;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class ResourcePage {
    private final Integer page;
    private final Integer per_page;
    private final Integer total;
    private final Integer total_pages;
    private final ArrayList<Resource> data;

    public ResourcePage(Integer page, Integer per_page, Integer total, Integer total_pages, ArrayList<Resource> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }

    public JsonObject toJsonObject() {
        return new JsonParser().parse(new Gson().toJson(this)).getAsJsonObject();
    }

    public ArrayList<Resource> getData() {
        return data;
    }
}
