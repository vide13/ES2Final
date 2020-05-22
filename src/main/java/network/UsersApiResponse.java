package network;

import com.es2.login.User;

import java.util.List;

public class UsersApiResponse {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<User> data;

    public UsersApiResponse(int page, int per_page, int total, int total_pages, List<User> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }

    public String toJson() {
        return "UsersApiResponse [page=" + page + ", per_page=" + per_page + ", total=" + total
            + ", total_pages=" + total_pages + ", data=" + data + "]";
    }
}
