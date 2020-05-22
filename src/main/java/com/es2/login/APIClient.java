package com.es2.login;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static final String BASE_URL = "https://reqres.in";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit != null)
            return retrofit;
        return new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build();
    }
}
