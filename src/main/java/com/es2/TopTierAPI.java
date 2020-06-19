package com.es2;

import com.es2.Exceptions.InvalidArguments;
import com.es2.Exceptions.UserNotFoundException;
import com.es2.cache.UserManagerNotStatic;
import com.es2.data.User;
import com.es2.data.UserJob;
import com.es2.network.APIManager;
import com.es2.network.apiResponse.CreateUserAPIResponse;
import com.es2.network.apiResponse.UserApiResponse;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static com.es2.api.APIClient.getClient;
import static com.es2.data.HttpCodes.CREATED;
import static com.es2.data.HttpCodes.OK;

/**
 * Manages reqres.in/cache access and requests
 * <p>
 * <p>
 * Requirements:
 * <p>
 * - Criar um utilizador ✔
 * <p>
 * - Consultar os dados de um utilizador ✔
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

    /**
     * Criar um utilizador
     * Creates a new user and adds it to cache if successful
     *
     * @param name - New user name
     * @param job  - New user job
     * @return - response from reqres API
     */
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
        }
        return response;
    }

    /**
     * Consultar os dados de um utilizador
     * Check if users exists in cache and returns it,
     * if it doesnt exists in cache checks in reqres API and adds it to cache
     *
     * @param id - User id
     * @return - Response success whit user info or response whit fail code
     */
    Response<UserApiResponse> getUserById(Integer id) throws IOException, UserNotFoundException {
        APIManager service = getClient().create(APIManager.class);

        UserManagerNotStatic userManagerNotStatic = UserManagerNotStatic.getInstance();
        User user = userManagerNotStatic.singleUser(id);
        if (user != null) {
            return Response.success(OK, new UserApiResponse(user));
        }

        Call<UserApiResponse> callUser = service.getUser(1);
        Response<UserApiResponse> response = callUser.execute();
        if (response.code() == OK) {
            if (response.body() != null) {
                User reqresUser = response.body().getUser();
                userManagerNotStatic.createUser(
                        reqresUser.getId(),
                        reqresUser.getEmail(),
                        reqresUser.getFirst_name(),
                        reqresUser.getLast_name(),
                        reqresUser.getAvatar()
                );
                return response;
            }
        }
        throw new UserNotFoundException();
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