package com.es3.controller;

import com.es3.HTTPClient.Retrofit;
import com.es3.objects.UserJob;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class ControllerAPI implements ControllerInterface {
    private final Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);


    void checkResponse(Response response) {
        if (response.code() > 299) {
            throw new Error();
        }
    }

    @Override
    public Response createUser(UserJob user) throws IOException {
        Call<JsonObject> request = endpoint.createUser(user.toJsonObject());
        Response response = request.execute();
        checkResponse(response);
        return response;
    }

    @Override
    public Response listUsers() throws IOException {
        Call<JsonObject> request = endpoint.listUsers();
        Response response = request.execute();
        checkResponse(response);
        return response;
    }
}
