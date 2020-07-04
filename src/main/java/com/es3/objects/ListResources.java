package com.es3.objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class ListResources {
    private final Integer page;
    private final Integer per_page;
    private final Integer total;
    private final Integer total_pages;
    ArrayList<ResourceData> data;

    public ListResources(Integer page, Integer per_page, Integer total, Integer total_pages, ArrayList<ResourceData> data) {
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
