import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


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
        userManager.newUser("morpheus", "leader");
        
        UserJob user = new UserJob("morpheus", "leader");
        user.setCreatedAt("2020-05-31T11:29:47.033Z");

        Assertions.assertTrue(user.equals(userManager) );
    }

    @Test void getUserById() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertEquals("200", userManager.getUserById(2));
    }

    @Test void updateUserJob() {
        UserManager userManager = UserManager.getInstance();
        UserJob userJob = new UserJob("André", "student" );
        userJob.setName("morpheus");
        userJob.setJob("zion resident");
        userJob.setUpdatedAt("2020-05-31T10:57:16.298Z");
        Assertions.assertEquals(userJob, userManager.updateUserJob("morpheus", "zion resident"));
    }

    //TODO - Test prints
    @Test void listUsers() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertEquals("200", userManager.listUsers());
    }

    @Test void registerUserSuccessful() {
        UserManager userManager = UserManager.getInstance();
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("4");
        arrayList.add("QpwL5tke4Pnpja7X4");
        Assertions.assertEquals(arrayList, userManager.registerUser("eve.holt@reqres.in", "pistol"));
    }

    @Test void registerUserUnsuccessful() {
        UserManager userManager = UserManager.getInstance();
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("5");
        arrayList.add("QpwL5tke4Pnpja7X4");
        Assertions.assertNotEquals(arrayList, userManager.registerUser("eve.holt@reqres.in", "pistol"));
    }

    @Test void authUserSuccessful() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertEquals("QpwL5tke4Pnpja7X4", userManager.authUser("eve.holt@reqres.in", "pistol"));
    }

    @Test void authUserUnsuccessful() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertNotEquals("token_error", userManager.authUser("eve.holt@reqres.in", "pistol"));
    }

    //TODO - Test resources
    @Test void listResources() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertEquals("200", userManager.listResources());
    }

    @Test void getResourceById() {
        UserManager userManager = UserManager.getInstance();
        userManager.myResources.add(new Resource(4, "resource3", "2000", "blue", "PANTONE 186 C"));
        Assertions.assertEquals("200", userManager.getResourceById(4));
    }
}
