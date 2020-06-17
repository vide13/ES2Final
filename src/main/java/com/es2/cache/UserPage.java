package com.es2.cache;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class UserPage {
    Integer page;
    Integer per_page;
    Integer total;
    Integer total_pages;
    ArrayList<User> data;

    public UserPage(Integer page, Integer per_page, Integer total, Integer total_pages, ArrayList<User> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }

    public JsonObject toJsonObject() {
        return new JsonParser().parse(new Gson().toJson(this)).getAsJsonObject();
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public ArrayList<User> getData() {
        return data;
    }
}
