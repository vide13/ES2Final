import java.util.ArrayList;

public class User {
    Integer id;
    String email;
    String first_name;
    String last_name;
    String avatar;
    String token;

    public User(Integer id, String email, String first_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public User(String email, String password) {
        this.email = email;
        this.token = "QpwL5tke4Pnpja7X4";
        this.id = 4;
    }

    public ArrayList<String> returnRegister() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(id.toString());
        arrayList.add(token);
        return arrayList;
    }

    public String getToken() {
        return token;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String returnLogin() {
        return token;
    }
}
