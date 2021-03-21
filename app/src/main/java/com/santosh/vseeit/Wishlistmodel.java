package com.santosh.vseeit;

public class Wishlistmodel {


    private int productimage;
    private String productTitle;
    private int freecoupon;
    private String rating;
    private int ttlrating;
    private String proprice;
    private String cutprice;
    private String paymentmethod;

    public Wishlistmodel(int productimage, String productTitle, int freecoupon, String rating, int ttlrating, String proprice, String cutprice, String paymentmethod) {
        this.productimage = productimage;
        this.productTitle = productTitle;
        this.freecoupon = freecoupon;
        this.rating = rating;
        this.ttlrating = ttlrating;
        this.proprice = proprice;
        this.cutprice = cutprice;
        this.paymentmethod = paymentmethod;
    }

    public int getProductimage() {
        return productimage;
    }

    public void setProductimage(int productimage) {
        this.productimage = productimage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getFreecoupon() {
        return freecoupon;
    }

    public void setFreecoupon(int freecoupon) {
        this.freecoupon = freecoupon;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getTtlrating() {
        return ttlrating;
    }

    public void setTtlrating(int ttlrating) {
        this.ttlrating = ttlrating;
    }

    public String getProprice() {
        return proprice;
    }

    public void setProprice(String proprice) {
        this.proprice = proprice;
    }

    public String getCutprice() {
        return cutprice;
    }

    public void setCutprice(String cutprice) {
        this.cutprice = cutprice;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

}
