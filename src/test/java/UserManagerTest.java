import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UserManagerTest {

    @Test void newUser() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertTrue(userManager
            .newUser(1, "teste@teste.com", "test_first_name", "test_last_name", "avatar_url"));
    }

    @Test void getUserById() {
        UserManager userManager = UserManager.getInstance();

        userManager
            .newUser(1, "teste1@teste.com", "test_first_name", "test_last_name", "avatar_url");
        userManager
            .newUser(2, "teste2@teste.com", "test_first_name", "test_last_name", "avatar_url");
        userManager
            .newUser(3, "teste3@teste.com", "test_first_name", "test_last_name", "avatar_url");

        Assertions.assertEquals(2, userManager.getUserById(2).id);
    }

    //TODO - Test prints
    @Test void listUsers() {
        UserManager userManager = UserManager.getInstance();
        userManager
            .newUser(1, "teste1@teste.com", "test_first_name", "test_last_name", "avatar_url");
        userManager.listUsers();
    }

    @Test void registerUser() {
        UserManager userManager = UserManager.getInstance();
        userManager.registerUser("register@test.com","1234");
        Assertions.assertTrue(userManager.registeredUsers.containsKey("register@test.com"));
    }

    @Test void authUser() {
        UserManager userManager = UserManager.getInstance();
        userManager.registerUser("register@test.com","1234");
        Assertions.assertTrue(userManager.authUser("register@test.com","1234"));
    }

    //TODO - Test resources
    @Test void listResources() {
        UserManager userManager = UserManager.getInstance();
        userManager.myResources.add(new Resource(1,"resource1","2000","blue","PANTONE 186 C"));
        userManager.listResources();
    }

    @Test void getResourceById() {
        UserManager userManager = UserManager.getInstance();
        userManager.myResources.add(new Resource(1,"resource1","2000","blue","PANTONE 186 C"));
        userManager.myResources.add(new Resource(2,"resource2","2000","blue","PANTONE 186 C"));
        userManager.myResources.add(new Resource(3,"resource3","2000","blue","PANTONE 186 C"));
        Assertions.assertEquals(2, userManager.getResourceById(2).id);
    }
}
