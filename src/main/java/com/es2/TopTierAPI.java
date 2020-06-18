package com.es2;

import com.es2.Exceptions.InvalidArguments;
import com.es2.cache.UserManagerNotStatic;
import com.es2.data.UserJob;
import com.es2.network.APIManager;
import com.es2.network.apiResponse.CreateUserAPIResponse;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static com.es2.api.APIClient.getClient;
import static com.es2.data.HttpCodes.CREATED;

/**
 * Manages reqres.in/cache access and requests
 * <p>
 * <p>
 * Requirements:
 * <p>
 * - Criar um utilizador ✔
 * <p>
 * - Consultar os dados de um utilizador
 * <p>
 * - Listar utilizadores
 * <p>
 * - Registrar um utilizador de forma a poder aceder à aplicação
 * <p>
 * - Autenticar um utilizador
 * <p>
 * - Listar recursos
 * <p>
 * - Consultar um recurso
 */
public class TopTierAPI {

    private static TopTierAPI instance;

    private TopTierAPI() {
    }

    public static TopTierAPI getInstance() {
        if (instance == null) {
            synchronized (TopTierAPI.class) {
                if (instance == null) {
                    instance = new TopTierAPI();
                }
            }
        }
        return instance;
    }

    Response<CreateUserAPIResponse> newUser(String name, String job) throws IOException, InvalidArguments {
        if (name == null || job == null) throw new InvalidArguments();
        if (name.isEmpty() || job.isEmpty()) throw new InvalidArguments();

        APIManager service = getClient().create(APIManager.class);

        UserJob userJob = new UserJob(name, job);
        Call<CreateUserAPIResponse> callUser = service.createUser(userJob.toJsonObject());
        Response<CreateUserAPIResponse> response = callUser.execute();

        if (response.code() == CREATED) {
            UserManagerNotStatic userManagerNotStatic = UserManagerNotStatic.getInstance();
            if (response.body() != null) {
                userManagerNotStatic.createUserJob(
                        response.body().getId(),
                        userJob.getName(),
                        userJob.getJob(),
                        response.body().getCreatedAt()
                );
            }
            return response;
        }
        return response;
    }


    void getUserById() {

    }


    void listUsers() {

    }


    void registerUserSuccessful() {

    }


    void authUserSuccessful() {

    }


    void listResources() {

    }

    void getResourceById() {

    }
}