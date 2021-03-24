package com.santosh.vseeit;

public class RewardModel {
    private String title;
    private String expriydate;
    private String couponbody;

    public RewardModel(String title, String expriydate, String couponbody) {
        this.title = title;
        this.expriydate = expriydate;
        this.couponbody = couponbody;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpriydate() {
        return expriydate;
    }

    public void setExpriydate(String expriydate) {
        this.expriydate = expriydate;
    }

    public String getCouponbody() {
        return couponbody;
    }

    public void setCouponbody(String couponbody) {
        this.couponbody = couponbody;
    }
}

