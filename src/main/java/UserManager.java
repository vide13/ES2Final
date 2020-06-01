import java.util.ArrayList;
import java.util.HashMap;

public class UserManager {
    private static volatile UserManager userManager;
    ArrayList<User> myUsers = new ArrayList<>();
    HashMap<String, String> registeredUsers = new HashMap<>();
    ArrayList<Resource> myResources = new ArrayList<>();

    private UserManager() {
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


    public UserJob newUser() {
        return new UserJob("morpheus", "leader", "49", "2020-05-31T11:29:47.033Z");
    }


    public User getUserById() {
        return new User(
                2,
                "janet.weaver@reqres.in",
                "Janet",
                "Weaver",
                "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"
        );
    }


    public UserPage listUsers() {
        ArrayList<User> data_user = new ArrayList<>();
        data_user.add(new User(
                7,
                "michael.lawson@reqres.in",
                "Michael",
                "Lawson",
                "https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg"));
        data_user.add(new User(
                8,
                "lindsay.ferguson@reqres.in",
                "Lindsay",
                "Ferguson",
                "https://s3.amazonaws.com/uifaces/faces/twitter/araa3185/128.jpg"));
        return new UserPage(2, 6, 12, 2, data_user);
    }


    public HashMap<String, String> registerUser(String email, String password) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", "4");
        hashMap.put("token", "QpwL5tke4Pnpja7X4");
        return hashMap;
    }


    public String authUser(String email, String password) {
        User user = new User(email, password);
        return (user.returnLogin());
    }


    public ResourcePage listResources() {
        ArrayList<Page> data_page = new ArrayList<>();
        data_page.add(new Page(
                1,
                "cerulean",
                2000,
                "#98B2D1",
                "15-4020"
        ));
        data_page.add(new Page(
                2,
                "fuchsia rose",
                2001,
                "#C74375",
                "17-2031"
        ));

        return new ResourcePage(2, 6, 12, 2, data_page);
    }


    public Page getResourceById() {
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
