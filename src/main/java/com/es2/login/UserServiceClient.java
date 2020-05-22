package com.es2.login;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import network.APIManager;
import network.CreateUserAPIResponse;
import network.UsersApiResponse;
import retrofit2.Call;
import retrofit2.Response;

import static com.es2.login.APIClient.getClient;

public class UserServiceClient {
    public static void main(String[] args) {

        APIManager service = getClient().create(APIManager.class);

        Call<UsersApiResponse> callSync = service.getUsers(2, 1);

        try {
            Response<UsersApiResponse> response = callSync.execute();
            UsersApiResponse apiResponse = response.body();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonOutput = gson.toJson(apiResponse);
            System.out.println(jsonOutput);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Call<CreateUserAPIResponse> callUser = service.createUser(new UserJob("Test1","tester"));

        try {
            Response<CreateUserAPIResponse> response = callUser.execute();
            CreateUserAPIResponse  apiResponse = response.body();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonOutput = gson.toJson(apiResponse);
            System.out.println(jsonOutput);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
