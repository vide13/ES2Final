package com.es2.login;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserServiceClient {
    public static void main(String[] args) {
		/*HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
		logging.setLevel(HttpLoggingInterceptor.Level.BASIC);*/

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        APIManager service = retrofit.create(APIManager.class);
		
		/*// Calling '/api/users'
		Call<UsersApiResponse> callSync = service.getUsers(10, 2);
		 
		try {
		    Response<UsersApiResponse> response = callSync.execute();
		    UsersApiResponse apiResponse = response.body();
		    System.out.println(apiResponse);
		} catch (Exception ex) { 
			ex.printStackTrace();
		}*/

        // Calling '/api/users/2'
        Call<UserApiResponse> callSync = service.getUser(2);

        try {
            Response<UserApiResponse> response = callSync.execute();
            UserApiResponse apiResponse = response.body();
            System.out.println(apiResponse);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
