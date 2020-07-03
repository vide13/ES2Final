package com.es3.controller;

import com.es3.HTTPClient.Retrofit;
import com.es3.objects.UserJob;
import com.es3.objects.UserPage;
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
    public UserJob createUser(UserJob user) throws IOException {
        Call<UserJob> request = endpoint.createUser(user.toJsonObject());
        Response<UserJob> response = request.execute();
        checkResponse(response);
        return response.body();
    }

    @Override
    public UserPage listUsers() throws IOException {
        Call<UserPage> request = endpoint.listUsers();
        Response<UserPage> response = request.execute();
        checkResponse(response);
        return response.body();
    }
}
