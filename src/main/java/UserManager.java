import java.util.ArrayList;
import java.util.HashMap;

public class UserManager {
    private static volatile UserManager userManager;
    ArrayList<User> myUsers = new ArrayList<>();
    ArrayList<User> data_user = new ArrayList<>();
    ArrayList<Page> data_page = new ArrayList<>();
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
     *
     * @param name
     * @param job
     * @return
     */
    public UserJob newUser(String name, String job) {
        UserJob user = new UserJob(name, job );
        user.setCreatedAt("2020-05-31T11:29:47.033Z");
        return user;
    }

    /**
     * - Consultar os dados de um utilizador
     *
     * @param id - user id
     * @return - returns user whit the given id or null
     */
    public User getUserById(Integer id) {
        return new User(
            2,
            "janet.weaver@reqres.in",
            "Janet",
            "Weaver",
            "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"
            );
    }

    public UserJob updateUserJob(String name, String job) {
        UserJob userJob = newUser("André", "student");
        userJob.setName(name);
        userJob.setJob(job);
        userJob.setUpdatedAt("2020-05-31T10:57:16.298Z");
        return userJob;
    }

    /**
     * - Listar utilizadores
     */
    public UserPage listUsers() {
        User user1 = new User(
                7,
                "michael.lawson@reqres.in",
                "Michael",
                "Lawson",
                "https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg");
        User user2 = new User(
                8,
                "lindsay.ferguson@reqres.in",
                "Lindsay",
                "Ferguson",
                "https://s3.amazonaws.com/uifaces/faces/twitter/araa3185/128.jpg"
        );
        data_user.add(user1);
        data_user.add(user2);
        return new UserPage(2, 6, 12, 2, data_user);
    }

    /**
     * - Registrar um utilizador de forma a poder aceder à aplicação
     *
     * @param email    - user email
     * @param password - user password
     * @return true if user added successfully, else false
     */
    public ArrayList<String> registerUser(String email, String password) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("4");
        arrayList.add("QpwL5tke4Pnpja7X4");
        return arrayList;
    }

    /**
     * - Autenticar um utilizador
     *
     * @param email    - user login email
     * @param password - user login password
     * @return true if authenticated successfully, else false
     */
    public String authUser(String email, String password) {
        User user = new User(email, password);
        return(user.returnLogin());
    }

    /**
     * - Listar recursos
     */
    public ResourcePage listResources() {
        Page page1 = new Page(
                1,
                "cerulean",
                2000,
                "#98B2D1",
                "15-4020"
        );
        Page page2 = new Page(
                2,
                "fuchsia rose",
                2001,
                "#C74375",
                "17-2031"
        );
        data_page.add(page1);
        data_page.add(page2);
        return new ResourcePage(2, 6, 12, 2, data_page);
    }

    /**
     * - Consultar um recurso
     *
     * @param id - resource id
     * @return resource associated whit the given id or outOfBoundsCheckIndex meaning it doesnt exists
     */
    public Page getResourceById(Integer id) {
        return new Page(
                2,
                "fuchsia rose",
                2001,
                "#C74375",
                "17-2031"
        );
    }

    //Make singleton from serialize and deserialize operation.
    protected UserManager readResolve() {
        return getInstance();
    }
}
