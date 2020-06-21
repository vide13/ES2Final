package com.es2;

import com.es2.cache.UserManager;
import com.es2.data.Resource;
import com.es2.data.User;
import com.es2.data.UserCredentialsRequest;
import com.es2.data.UserJob;
import com.es2.network.APIManager;
import com.es2.network.apiResponse.*;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static com.es2.api.APIClient.getClient;
import static com.es2.data.HttpCodes.*;

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
 * - Listar utilizadores ✔
 * <p>
 * - Registrar um utilizador de forma a poder aceder à aplicação ✔
 * <p>
 * - Autenticar um utilizador ✔
 * <p>
 * - Listar recursos ✔
 * <p>
 * - Consultar um recurso ✔
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
    Response<CreateUserAPIResponse> newUser(String name, String job) throws IOException {
        if (name == null || job == null)
            return Response.error(SEMANTIC_ERROR, ResponseBody.create(
                    MediaType.parse("application/json"),
                    "Invalid Arguments")
            );
        if (name.isBlank() || job.isBlank())
            return Response.error(SEMANTIC_ERROR, ResponseBody.create(
                    MediaType.parse("application/json"),
                    "Empty Arguments")
            );

        APIManager service = getClient().create(APIManager.class);
        UserJob userJob = new UserJob(name, job);
        Call<CreateUserAPIResponse> callUser = service.createUser(userJob.toJsonObject());
        Response<CreateUserAPIResponse> response = callUser.execute();

        if (response.code() == CREATED) {
            UserManager userManager = UserManager.getInstance();
            if (response.body() != null) {
                userManager.newUser(
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
    Response<UserApiResponse> getUserById(Integer id) throws IOException {
        if (id == null) return Response.error(SEMANTIC_ERROR, ResponseBody.create(
                MediaType.parse("application/json"),
                "Invalid Argument")
        );

        UserManager userManager = UserManager.getInstance();
        User user = userManager.getUserById(id);
        if (user != null) {
            return Response.success(OK, new UserApiResponse(user));
        }

        APIManager service = getClient().create(APIManager.class);

        Call<UserApiResponse> callUser = service.getUser(id);
        Response<UserApiResponse> response = callUser.execute();
        if (response.code() == OK) {
            if (response.body() != null) {
                User reqresUser = response.body().getUser();
                userManager.createUserArray(
                        reqresUser.getId(),
                        reqresUser.getEmail(),
                        reqresUser.getFirst_name(),
                        reqresUser.getLast_name(),
                        reqresUser.getAvatar()
                );
            }
        }
        return response;
    }

    /**
     * Listar utilizadores
     *
     * @return UsersApiResponse - list of users
     */
    Response<UsersApiResponse> listUsers() throws IOException {
        APIManager service = getClient().create(APIManager.class);

        Call<UsersApiResponse> callUser = service.listUsers();
        return callUser.execute();
    }

    /**
     * Registrar um utilizador de forma a poder aceder à aplicação
     * <p>
     * Registers a new user and adds it to cache if the request is successful
     *
     * @param email    - New user email
     * @param password - New user password
     * @return response whit id and token if successful
     */
    Response<RegisterUserAPIResponse> registerUser(String email, String password) throws IOException {
        if (email == null || password == null) return Response.error(SEMANTIC_ERROR, ResponseBody.create(
                MediaType.parse("application/json"),
                "Invalid Argument")
        );
        if (email.isEmpty() || password.isEmpty()) return Response.error(SEMANTIC_ERROR, ResponseBody.create(
                MediaType.parse("application/json"),
                "Invalid Argument")
        );

        APIManager service = getClient().create(APIManager.class);

        UserCredentialsRequest userCredentials = new UserCredentialsRequest(email, password);
        Call<RegisterUserAPIResponse> callUser = service.registerUser(userCredentials.toJsonObject());
        Response<RegisterUserAPIResponse> response = callUser.execute();

        if (response.code() == OK) {
            UserManager userManager = UserManager.getInstance();
            if (response.body() != null) {
                userManager.registerUser(
                        response.body().getId(),
                        email,
                        password,
                        response.body().getToken());
            }
        }
        return response;
    }

    /**
     * Autenticar um utilizador
     * <p>
     * Checks cache for the user and returns a token, or if the user doesnt exists in cache
     * sends a request for reqres and returns the response
     *
     * @param email    - user login email
     * @param password - user login password
     * @return token if successful
     */
    Response<LoginUserAPIResponse> authUser(String email, String password) throws IOException {
        if (email == null || password == null) return Response.error(SEMANTIC_ERROR, ResponseBody.create(
                MediaType.parse("application/json"),
                "Invalid Argument")
        );
        if (email.isEmpty() || password.isEmpty()) return Response.error(SEMANTIC_ERROR, ResponseBody.create(
                MediaType.parse("application/json"),
                "Invalid Argument")
        );

        UserManager userManager = UserManager.getInstance();
        String token = userManager.authUser(email, password);
        if (token != null) {
            return Response.success(OK, new LoginUserAPIResponse(token));
        }

        APIManager service = getClient().create(APIManager.class);
        UserCredentialsRequest userCredentials = new UserCredentialsRequest(email, password);
        Call<LoginUserAPIResponse> callUser = service.loginUser(userCredentials.toJsonObject());
        //Cant add user to cache because we are missing user ID
        return callUser.execute();
    }

    /**
     * Listar recursos
     * <p>
     * Lists all resources in reqres
     *
     * @return ResourcesApiResponse whit the data field containing the resources
     */
    Response<ResourcesApiResponse> listResources() throws IOException {
        APIManager service = getClient().create(APIManager.class);

        Call<ResourcesApiResponse> callUser = service.listResources();
        return callUser.execute();
    }

    /**
     * Consultar um recurso
     * <p>
     * Checks if resource whit the given id exists in cache or, if not found sends a request to reqres
     *
     * @param id - resource id
     * @return ResourceApiResponse
     */
    Response<ResourceApiResponse> getResourceById(Integer id) throws IOException {
        if (id == null) return Response.error(SEMANTIC_ERROR, ResponseBody.create(
                MediaType.parse("application/json"),
                "Invalid Argument")
        );

        UserManager userManager = UserManager.getInstance();
        Resource resource = userManager.getResourceById(id);
        if (resource != null) {
            return Response.success(OK, new ResourceApiResponse(resource));
        }

        APIManager service = getClient().create(APIManager.class);
        Call<ResourceApiResponse> callResource = service.getResource(id);
        Response<ResourceApiResponse> response = callResource.execute();
        if (response.body() != null) {
            userManager.createResourceArray(
                    response.body().getData().getId(),
                    response.body().getData().getName(),
                    response.body().getData().getYear(),
                    response.body().getData().getColor(),
                    response.body().getData().getPantone_value()
            );
        }
        return response;
    }
}