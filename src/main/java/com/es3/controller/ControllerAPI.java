package com.es3.controller;

import com.es3.HTTPClient.Retrofit;
import com.es3.objects.UserJob;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class ControllerAPI implements ControllerInterface {
    @Override
    public Response createUser(UserJob user) throws IOException {
        Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);
        Call<JsonObject> request = endpoint.create(user.toJsonObject());
        Response response = request.execute();
        if (response.code() > 299) {
            throw new Error();
        }
        return response;
    }
}
