package com.es3.HTTPClient;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {
    private static final String BASE_URL = "https://reqres.in";
    private static retrofit2.Retrofit retrofit;

    public static retrofit2.Retrofit getClient() {
        if (retrofit == null) {
            synchronized (retrofit2.Retrofit.class) {
                if (retrofit == null) {
                    retrofit = new retrofit2.Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }
}
