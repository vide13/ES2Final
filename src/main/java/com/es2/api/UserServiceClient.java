package com.es2.api;

import data.UserJob;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import network.APIManager;
import network.apiResponse.CreateUserAPIResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.es2.api.APIClient.getClient;

public class UserServiceClient {
    public static void main(String[] args) {

        APIManager service = getClient().create(APIManager.class);

        UserJob userJob = new UserJob("TestName", "tester");
        Call<CreateUserAPIResponse> callUser = service.createUser(userJob.toJsonObject());

        callUser.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<CreateUserAPIResponse> call, Response<CreateUserAPIResponse> response) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonOutput = gson.toJson(response.body());
                System.out.println(jsonOutput);
            }

            @Override
            public void onFailure(Call<CreateUserAPIResponse> call, Throwable throwable) {
                System.out.println("Errou");

            }
        });

//        try {
//            Response<CreateUserAPIResponse> response = callUser.execute();
//            CreateUserAPIResponse apiResponse = response.body();
//            if (apiResponse == null)   {
//                System.out.println("Errou");
//            } else {
//
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }
}
