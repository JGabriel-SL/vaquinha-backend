package com.donate.donate_app.DTO;


public class PaymentDTO {
    private Integer amount;
    private Long crowdfunding_id;
    private String type;

    public PaymentDTO(Integer amount, Long crowdfunding_id, String type) {
        this.amount = amount;
        this.crowdfunding_id = crowdfunding_id;
        this.type = type;
    }

    public PaymentDTO() {
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
}
