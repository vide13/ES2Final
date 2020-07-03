package com.es3.objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class ListUsers {
    private final Integer page;
    private final Integer per_page;
    private final Integer total;
    private final Integer total_pages;
    private final ArrayList<Data> data;

    public ListUsers(Integer page, Integer per_page, Integer total, Integer total_pages, ArrayList<Data> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
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

    public ArrayList<Data> getData() {
        return data;
    }

    public JsonObject toJsonObject() {
        return new JsonParser().parse(new Gson().toJson(this)).getAsJsonObject();
    }

}
