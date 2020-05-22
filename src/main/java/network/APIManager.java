package network;

import com.es2.login.UserJob;
import retrofit2.Call;
import retrofit2.http.*;

public interface APIManager {
    /**
     * TODO
     *
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

    /**
     * - Criar um utilizador
     * @param user - User to create
     * @return userId, name, job,createdAt
     */
    @POST("/api/users") Call<CreateUserAPIResponse> createUser(@Body UserJob user);



    /**
     * - List a given number of users per page
     *
     * @param per_page - number of users per page
     * @param page     - page number
     * @return - given number of users per page
     */
    @GET("/api/users") Call<UsersApiResponse> getUsers(@Query("per_page") int per_page,
        @Query("page") int page);

    @GET("/api/users/{id}") Call<UserApiResponse> getUser(@Path("id") long id);

}
