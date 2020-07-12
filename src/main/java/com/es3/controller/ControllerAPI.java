package com.es3.controller;

import com.es3.HTTPClient.Retrofit;
import com.es3.objects.*;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Objects;

public class ControllerAPI implements ControllerInterface {
    private final Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);


    @SuppressWarnings("rawtypes")
    void checkResponse(Response response) throws IOException {
        if (response.code() > 299) {
            throw new Error(Objects.requireNonNull(response.errorBody()).string());
        }
    }

    @Override
    public UserJob createUser(UserJob user) throws IOException {
        Call<UserJob> request = endpoint.createUser(null,user.toJsonObject());
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

    @Override
    public Register register(Credentials credentials) throws IOException {
        Call<Register> request = endpoint.register(credentials.toJsonObject());
        Response<Register> response = request.execute();
        checkResponse(response);
        return response.body();
    }

    @Override
    public Login login(Credentials credentials) throws IOException {
        Call<Login> request = endpoint.login(credentials.toJsonObject());
        Response<Login> response = request.execute();
        checkResponse(response);
        return response.body();
    }

    @Override
    public ListResources listResources() throws IOException {
        Call<ListResources> request = endpoint.listResources();
        Response<ListResources> response = request.execute();
        checkResponse(response);
        return response.body();
    }

    @Override
    public SingleResource singleResource(Integer id) throws IOException {
        Call<SingleResource> request = endpoint.singleResource(id);
        Response<SingleResource> response = request.execute();
        checkResponse(response);
        return response.body();
    }
}
