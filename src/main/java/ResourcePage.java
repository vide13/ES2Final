import java.util.ArrayList;

public class ResourcePage {
    Integer page;
    Integer per_page;
    Integer total;
    Integer total_pages;
    ArrayList<Page> data;

    public ResourcePage(Integer page, Integer per_page, Integer total, Integer total_pages, ArrayList<Page> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }
}
