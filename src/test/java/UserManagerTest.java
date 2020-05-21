import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class UserManagerTest {

    @BeforeAll static void setUp() {
        UserManager userManager = UserManager.getInstance();
        userManager.myUsers.add(
            new User(1, "teste1@teste.com", "test_first_name", "test_last_name", "avatar_url"));
        userManager.myUsers.add(
            new User(2, "teste2@teste.com", "test_first_name", "test_last_name", "avatar_url"));
        userManager.myUsers.add(
            new User(3, "teste3@teste.com", "test_first_name", "test_last_name", "avatar_url"));
        userManager.registeredUsers.put("register@test.com", "1234");
        userManager.myResources.add(new Resource(1, "resource1", "2000", "blue", "PANTONE 186 C"));
    }

    @Test void newUser() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertTrue(userManager
            .newUser(1, "teste@teste.com", "test_first_name", "test_last_name", "avatar_url"));
    }

    @Test void getUserById() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertEquals(2, userManager.getUserById(2).id);
    }

    //TODO - Test prints
    @Test void listUsers() {
        UserManager userManager = UserManager.getInstance();
        userManager.listUsers();
    }

    @Test void registerUser() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertTrue(userManager.registeredUsers.containsKey("register@test.com"));
    }

    @Test void authUser() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertTrue(userManager.authUser("register@test.com", "1234"));
    }

    //TODO - Test resources
    @Test void listResources() {
        UserManager userManager = UserManager.getInstance();
        userManager.listResources();
    }

    @Test void getResourceById() {
        UserManager userManager = UserManager.getInstance();
        userManager.myResources.add(new Resource(4, "resource3", "2000", "blue", "PANTONE 186 C"));
        Assertions.assertEquals(4, userManager.getResourceById(4).id);
    }
}
