import java.util.ArrayList;

public class UserPage {
    Integer page;
    Integer per_page;
    Integer total;
    Integer total_pages;
    ArrayList<User> data;

    public UserPage(Integer page, Integer per_page, Integer total, Integer total_pages, ArrayList<User> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }
}
