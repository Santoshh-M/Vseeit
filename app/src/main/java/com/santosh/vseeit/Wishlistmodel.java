package com.santosh.vseeit;

public class Wishlistmodel {

    private String productimage;
    private String productTitle;
    private long freecoupon;
    private String rating;
    private long ttlrating;
    private String proprice;
    private String cutprice;
    private boolean COD;

    public Wishlistmodel(String productimage, String productTitle, long freecoupon, String rating, long ttlrating, String proprice, String cutprice, boolean cod) {
        this.productimage = productimage;
        this.productTitle = productTitle;
        this.freecoupon = freecoupon;
        this.rating = rating;
        this.ttlrating = ttlrating;
        this.proprice = proprice;
        this.cutprice = cutprice;
        this.COD = cod;

    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public long getFreecoupon() {
        return freecoupon;
    }

    public void setFreecoupon(long freecoupon) {
        this.freecoupon = freecoupon;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public long getTtlrating() {
        return ttlrating;
    }

    public void setTtlrating(long ttlrating) {
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

    public boolean isCOD() {
        return COD;
    }

    public void setCOD(boolean COD) {
        this.COD = COD;
    }
}
