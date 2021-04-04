package com.santosh.vseeit;

public class HorizontalProductModel {

    private String productID;
    private String productimg;
    private String productitle;
    private String Productdis;
    private String productprice;

    public HorizontalProductModel(String productID, String productimg, String productitle, String productdis, String productprice) {
        this.productID = productID;
        this.productimg = productimg;
        this.productitle = productitle;
        Productdis = productdis;
        this.productprice = productprice;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productimg = productID;
    }

    public String getProductimg() {
        return productimg;
    }

    public void setProductimg(String productimg) {
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
