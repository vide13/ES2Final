package com.es2.objects;

@SuppressWarnings("unused")
public class UserData {
    private final Integer id;
    private final String email;
    private final String first_name;
    private final String last_name;
    private final String avatar;


    public UserData(Integer id, String email, String first_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}