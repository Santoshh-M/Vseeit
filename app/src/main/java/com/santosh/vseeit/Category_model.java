package com.santosh.vseeit;

public class Category_model {

    private String CategoryIconLink;
    private String CategoryName;

    public Category_model(String categoryIconLink, String categoryName) {
        CategoryIconLink = categoryIconLink;
        CategoryName = categoryName;
    }

    public String getCategoryIconLink() {
        return CategoryIconLink;
    }

    public void setCategoryIconLink(
            String categoryIconLink) {
        CategoryIconLink = categoryIconLink;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
