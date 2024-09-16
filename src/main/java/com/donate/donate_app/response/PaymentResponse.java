package com.donate.donate_app.response;

public class PaymentResponse {
    private Integer amount;
    private Long crowdfunding_id;
    private String type;
    private String url;

    public PaymentResponse(Integer amount, Long crowdfunding_id, String type, String url) {
        this.amount = amount;
        this.crowdfunding_id = crowdfunding_id;
        this.type = type;
        this.url = url;
    }

    public PaymentResponse() {
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getCrowdfunding_id() {
        return crowdfunding_id;
    }

    public void setCrowdfunding_id(Long crowdfunding_id) {
        this.crowdfunding_id = crowdfunding_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
