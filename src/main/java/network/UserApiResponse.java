package network;

import com.es2.login.User;

public class UserApiResponse {
    private User data;

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public String toJson() {
        return "UserApiResponse [data=" + data.toString() + "]";
    }
}
