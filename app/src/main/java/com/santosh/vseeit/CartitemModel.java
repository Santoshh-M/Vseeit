package com.santosh.vseeit;

public class CartitemModel {

    public static final int  CART_ITEM = 0;
    public static final int TOTAL_AMOUNT = 1;

    private int type;
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    ////// cart item
    private int productimg;
    private String productTitle;
    private String productprice;
    private String cuttedprice;
    private int freecoupon;
    private int proqtty;
    private int offrapplied;
    private int coupnapplied;

    public CartitemModel(int type, int productimg, String productTitle, String productprice, String cuttedprice, int freecoupon, int proqtty, int offrapplied, int coupnapplied, int totalItems, String ttlamount, String delivercrg, String savedamount) {
        this.type = type;
        this.totalItems = totalItems;
        Ttlamount = ttlamount;
        this.delivercrg = delivercrg;
        this.savedamount = savedamount;
        this.productimg = productimg;
        this.productTitle = productTitle;
        this.productprice = productprice;
        this.cuttedprice = cuttedprice;
        this.freecoupon = freecoupon;
        this.proqtty = proqtty;
        this.offrapplied = offrapplied;
        this.coupnapplied = coupnapplied;
    }

    public int getProductimg() {
        return productimg;
    }

    public void setProductimg(int productimg) {
        this.productimg = productimg;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public String getCuttedprice() {
        return cuttedprice;
    }

    public void setCuttedprice(String cuttedprice) {
        this.cuttedprice = cuttedprice;
    }

    public int getFreecoupon() {
        return freecoupon;
    }

    public void setFreecoupon(int freecoupon) {
        this.freecoupon = freecoupon;
    }

    public int getProqtty() {
        return proqtty;
    }

    public void setProqtty(int proqtty) {
        this.proqtty = proqtty;
    }

    public int getOffrapplied() {
        return offrapplied;
    }

    public void setOffrapplied(int offrapplied) {
        this.offrapplied = offrapplied;
    }

    public int getCoupnapplied() {
        return coupnapplied;
    }

    public void setCoupnapplied(int coupnapplied) {
        this.coupnapplied = coupnapplied;
    }


///// cart item

        ///////// cart total
        private int totalItems;
        private String Ttlamount;
        private String delivercrg;
        private String savedamount;

    public CartitemModel(int type, int totalItems, String ttlamount, String delivercrg, String savedamount) {
        this.type = type;
        this.totalItems = totalItems;
        Ttlamount = ttlamount;
        this.delivercrg = delivercrg;
        this.savedamount = savedamount;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public String getTtlamount() {
        return Ttlamount;
    }

    public void setTtlamount(String ttlamount) {
        Ttlamount = ttlamount;
    }

    public String getDelivercrg() {
        return delivercrg;
    }

    public void setDelivercrg(String delivercrg) {
        this.delivercrg = delivercrg;
    }

    public String getSavedamount() {
        return savedamount;
    }

    public void setSavedamount(String savedamount) {
        this.savedamount = savedamount;
    }
    //////// cart total

}
