package com.es2.network.apiResponse;


import com.es2.data.User;

public class UserApiResponse {
    private User data;

    public UserApiResponse(User data) {
        this.data = data;
    }

    public User getUser() {
        return data;
    }
}
