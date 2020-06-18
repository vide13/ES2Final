package com.es2.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static final String BASE_URL = "https://reqres.in";

    private static final Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit != null)
            return retrofit;
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
