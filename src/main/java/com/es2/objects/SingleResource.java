package com.es2.objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@SuppressWarnings("unused")
public class SingleResource {
    private final ResourceData data;

    public SingleResource(ResourceData data) {
        this.data = data;
    }

    public ResourceData getData() {
        return data;
    }

    public JsonObject toJsonObject() {
        return new JsonParser().parse(new Gson().toJson(this)).getAsJsonObject();
    }

}