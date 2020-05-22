import java.util.ArrayList;
import java.util.HashMap;

public class UserManager {
    private static volatile UserManager userManager;
    ArrayList<User> myUsers = new ArrayList<>();
    HashMap<String, String> registeredUsers = new HashMap<>();
    ArrayList<Resource> myResources = new ArrayList<>();

    private UserManager() {
        //Prevent form the reflection api.
        if (userManager != null) {
            throw new RuntimeException(
                "Use getInstance() method to get the single instance of this class.");
        }
    }

    public static UserManager getInstance() {
        if (userManager == null) {
            synchronized (UserManager.class) {
                if (userManager == null)
                    userManager = new UserManager();
            }
        }
        return userManager;
    }

    /**
     * - Criar um utilizador
     *
     * @param id         - user id
     * @param email      - user email
     * @param first_name - user first name
     * @param last_name  - user last name
     * @param avatar     - user avatar link
     * @return - true if added whit success else false
     */
    public String newUser(Integer id, String email, String first_name, String last_name,
        String avatar) {
        myUsers.add(new User(id, email, first_name, last_name, avatar));
        registeredUsers.put(email,"password");
        return "201";
    }

    /**
     * - Consultar os dados de um utilizador
     *
     * @param id - user id
     * @return - returns user whit the given id or null
     */
    public String getUserById(Integer id) {
        for (User user : myUsers) {
            if (user.id.equals(id))
                return "200";
        }
        return "404";
    }

    /**
     * - Listar utilizadores
     */
    public String listUsers() {
        for (User user : myUsers) {
            System.out.println("User: [" + user.id + "]");
            System.out.println("Name: [" + user.first_name + " " + user.last_name + "]");
            System.out.println("Email: [" + user.email + "]");
            System.out.println("Avatar link: [" + user.avatar + "]");
        }
        return "200";
    }

    /**
     * - Registrar um utilizador de forma a poder aceder à aplicação
     *
     * @param email    - user email
     * @param password - user password
     * @return true if user added successfully, else false
     */
    public String registerUser(String email, String password) {
        if(registeredUsers.containsKey(email))
            return "400";
        else {
            registeredUsers.put(email, password);
            return "200";
        }
    }

    /**
     * - Autenticar um utilizador
     *
     * @param email    - user login email
     * @param password - user login password
     * @return true if authenticated successfully, else false
     */
    public String authUser(String email, String password) {
        if(registeredUsers.containsKey(email))
            if(registeredUsers.get(email).equals(password))
                return "200";
            else
                return "400";
        else
            return "400";
    }

    /**
     * - Listar recursos
     */
    public String listResources() {
        for (Resource resource : myResources) {
            System.out.println("User: [" + resource.id + "]");
            System.out.println("Name: [" + resource.name + "]");
            System.out.println("Pantone Value: [" + resource.pantone_value + "]");
            System.out.println("Year: [" + resource.year + "]");
        }
        return "200";
    }

    /**
     * - Consultar um recurso
     *
     * @param id - resource id
     * @return resource associated whit the given id or outOfBoundsCheckIndex meaning it doesnt exists
     */
    public String getResourceById(Integer id) {
        for (Resource resource : myResources) {
            if (resource.id.equals(id))
                return "200";
        }
        return null;
    }

    //Make singleton from serialize and deserialize operation.
    protected UserManager readResolve() {
        return getInstance();
    }
}
