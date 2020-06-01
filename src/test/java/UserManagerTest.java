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
        UserJob expected = new UserJob("morpheus", "leader", "49", "2020-05-31T11:29:47.033Z");
        UserJob actual = userManager.newUser();

        Assertions.assertEquals(expected.getCreatedAt(), actual.getCreatedAt());
    }

    @Test void getUserById() {
        UserManager userManager = UserManager.getInstance();
        User expected = new User(
                2,
                "janet.weaver@reqres.in",
                "Janet",
                "Weaver",
                "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"
        );
        User actual = userManager.getUserById();
        Assertions.assertEquals(expected.getId(), actual.getId());
        Assertions.assertEquals(expected.getEmail(), actual.getEmail());
        Assertions.assertEquals(expected.getFirst_name(), actual.getFirst_name());
        Assertions.assertEquals(expected.getLast_name(), actual.getLast_name());
        Assertions.assertEquals(expected.getAvatar(), actual.getAvatar());
    }

    //TODO - Test prints
    @Test void listUsers() {
        UserManager userManager = UserManager.getInstance();
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
        UserPage expected = new UserPage(2, 6, 12, 2, data_user);
        UserPage actual = userManager.listUsers();
        Assertions.assertEquals(expected.getPage(), actual.getPage());
        Assertions.assertEquals(expected.getPer_page(), actual.getPer_page());
        Assertions.assertEquals(expected.getTotal(), actual.getTotal());
        Assertions.assertEquals(expected.getTotal_pages(), actual.getTotal_pages());
        Assertions.assertEquals(expected.getData().get(0).id, actual.getData().get(0).id);
    }

    @Test void registerUserSuccessful() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertEquals("4", userManager.registerUser("eve.holt@reqres.in", "pistol").get("id"));
        Assertions.assertEquals("QpwL5tke4Pnpja7X4", userManager.registerUser("eve.holt@reqres.in", "pistol").get("token"));
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
    @Test
    void listResources() {
        UserManager userManager = UserManager.getInstance();
        Assertions.assertEquals(1, userManager.listResources().data.get(0).id);
        Assertions.assertEquals("cerulean", userManager.listResources().data.get(0).name);
        Assertions.assertEquals(2000, userManager.listResources().data.get(0).year);
        Assertions.assertEquals("#98B2D1", userManager.listResources().data.get(0).color);
        Assertions.assertEquals("17-2031", userManager.listResources().data.get(1).pantone_value);
    }

    @Test
    void getResourceById() {
        UserManager userManager = UserManager.getInstance();
        Page actual = userManager.getResourceById();

        Assertions.assertEquals(2, actual.getId());
        Assertions.assertEquals("fuchsia rose", actual.getName());
        Assertions.assertEquals(2001, actual.getYear());
        Assertions.assertEquals("#C74375", actual.getColor());
        Assertions.assertEquals("17-2031", actual.getPantone_value());
    }

    @Test
    void updateUser() {
    }

    @Test
    void singleUserNotFound() {
    }

    @Test
    void singleResourceNotFound() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void delayedResponse() {
    }


}
