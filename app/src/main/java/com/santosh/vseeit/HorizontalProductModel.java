package com.santosh.vseeit;

public class HorizontalProductModel {

    private int productimg;
    private String productitle;
    private String Productdis;
    private String productprice;

    public HorizontalProductModel(int productimg, String productitle, String productdis, String productprice) {
        this.productimg = productimg;
        this.productitle = productitle;
        Productdis = productdis;
        this.productprice = productprice;
    }

    public int getProductimg() {
        return productimg;
    }

    public void setProductimg(int productimg) {
        this.productimg = productimg;
    }

    public String getProductitle() {
        return productitle;
    }

    public void setProductitle(String productitle) {
        this.productitle = productitle;
    }

    public String getProductdis() {
        return Productdis;
    }

    public void setProductdis(String productdis) {
        Productdis = productdis;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }
}
