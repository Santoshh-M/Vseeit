package com.santosh.vseeit;

public class MyOrderItemModel {
    private int productimage;
    private String prouducttitle;
    private String Deliverystatus;
    private int rating;

    public MyOrderItemModel(int productimage, String prouducttitle, String deliverystatus, int rating) {
        this.productimage = productimage;
        this.prouducttitle = prouducttitle;
        Deliverystatus = deliverystatus;
        this.rating = rating;
    }

    public int getProductimage() {
        return productimage;
    }

    public void setProductimage(int productimage) {
        this.productimage = productimage;
    }

    public String getProuducttitle() {
        return prouducttitle;
    }

    public void setProuducttitle(String prouducttitle) {
        this.prouducttitle = prouducttitle;
    }

    public String getDeliverystatus() {
        return Deliverystatus;
    }

    public void setDeliverystatus(String deliverystatus) {
        Deliverystatus = deliverystatus;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
