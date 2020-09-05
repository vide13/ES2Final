package com.es2.controller;

import com.es2.HTTPClient.Retrofit;
import com.es2.cache.CacheTest;
import com.es2.objects.*;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Objects;

public class ControllerAPI implements ControllerInterface {

    private final Endpoint endpoint = Retrofit.getClient().create(Endpoint.class);


    public static void main(String[] args) throws InterruptedException {
        CacheTest Cache = new CacheTest();
        System.out.println("\n\n==========Test1: TestAddRemoveObjects ==========");
        Cache.TestAddRemoveObjects();
        System.out.println("\n\n==========Test2: TestExpiredCacheObjects ==========");
        Cache.TestExpiredCacheObjects();
        System.out.println("\n\n==========Test3: TestObjectsCleanupTime ==========");
        Cache.TestObjectsCleanupTime();
    }


    @SuppressWarnings("rawtypes")
    void checkResponse(Response response) throws IOException {
        if (response.code() > 299) {
            throw new Error(Objects.requireNonNull(response.errorBody()).string());
        }
    }


    public ListResources listResourcesCacheTest(String token) throws IOException {
        Call<ListResources> request = endpoint.listResources(token,null,null);
        Response<ListResources> response = request.execute();
        checkResponse(response);
        assert response.body() != null;
        if (!response.body().getClass().equals(ListResources.class)) throw new Error("Invalid schema");
        return response.body();
    }

    @Override
    public UserJob createUser(String token, UserJob user) throws IOException {
        Call<UserJob> request = endpoint.createUser(token, user.toJsonObject());
        Response<UserJob> response = request.execute();
        checkResponse(response);
        assert response.body() != null;
        if (!response.body().getClass().equals(UserJob.class)) throw new Error("Invalid schema");
        return response.body();
    }

    @Override
    public ListResources listResources(String token) throws IOException {
        Call<ListResources> request = endpoint.listResources(token,null,null);
        Response<ListResources> response = request.execute();
        checkResponse(response);
        assert response.body() != null;
        if (!response.body().getClass().equals(ListResources.class)) throw new Error("Invalid schema");
        return response.body();
    }

    @Override
    public ListUsers listUsers(String token) throws IOException {
        Call<ListUsers> request = endpoint.listUsers(token);
        Response<ListUsers> response = request.execute();
        checkResponse(response);
        assert response.body() != null;
        if (!response.body().getClass().equals(ListUsers.class)) throw new Error("Invalid schema");
        return response.body();
    }

    @Override
    public Login login(Credentials credentials) throws IOException {
        Call<Login> request = endpoint.login(credentials.toJsonObject());
        Response<Login> response = request.execute();
        checkResponse(response);
        assert response.body() != null;
        if (!response.body().getClass().equals(Login.class)) throw new Error("Invalid schema");
        return response.body();
    }

    @Override
    public Register register(Credentials credentials) throws IOException {
        Call<Register> request = endpoint.register(credentials.toJsonObject());
        Response<Register> response = request.execute();
        checkResponse(response);
        assert response.body() != null;
        if (!response.body().getClass().equals(Register.class)) throw new Error("Invalid schema");
        return response.body();
    }

    @Override
    public SingleResource singleResource(String token, Integer id) throws IOException {
        Call<SingleResource> request = endpoint.singleResource(token, id);
        Response<SingleResource> response = request.execute();
        checkResponse(response);
        assert response.body() != null;
        if (!response.body().getClass().equals(SingleResource.class)) throw new Error("Invalid schema");
        return response.body();
    }

    @Override
    public SingleUser singleUser(String token, Integer id) throws IOException {
        Call<SingleUser> request = endpoint.singleUser(token, id);
        Response<SingleUser> response = request.execute();
        checkResponse(response);

        assert response.body() != null;
        if (!response.body().getClass().equals(SingleUser.class)) throw new Error("Invalid schema");
        return response.body();
    }
}