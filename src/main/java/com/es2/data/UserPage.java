package com.es2.data;

import java.util.ArrayList;

public class UserPage {
    private final Integer page;
    private final Integer per_page;
    private final Integer total;
    private final Integer total_pages;
    private final ArrayList<User> data;

    public UserPage(Integer page, Integer per_page, Integer total, Integer total_pages, ArrayList<User> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public ArrayList<User> getData() {
        return data;
    }

}
