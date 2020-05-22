package com.es2.login;

public class User {
    private long id;
    private String first_name;
    private String last_name;
    private String email;
    private String avatar;

    public User(long id, String first_name, String last_name, String email, String avatar) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.avatar = avatar;
    }


    @Override public String toString() {
        return "User [id=" + id + ", " + "first_name=" + first_name + ", " + "last_name="
            + last_name + ", " + "email=" + email + ", " + "avatar=" + avatar + "]";
    }
}
