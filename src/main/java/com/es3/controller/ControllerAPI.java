package com.es3.controller;

import com.es3.HTTPClient.Retrofit;
import com.es3.objects.ListUsers;
import com.es3.objects.SingleUser;
import com.es3.objects.UserJob;
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
    public SingleUser singleUser(Integer id) throws IOException {
        Call<SingleUser> request = endpoint.singleUser(id);
        Response<SingleUser> response = request.execute();
        checkResponse(response);
        return response.body();
    }

    @Override
    public ListUsers listUsers() throws IOException {
        Call<ListUsers> request = endpoint.listUsers();
        Response<ListUsers> response = request.execute();
        checkResponse(response);
        return response.body();
    }
}
