package com.donate.donate_app.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "crowdfunding_id")
    private Crowdfunding crowdfunding_id;
    private String type;
    private String url_payment;


    public Payment(Long id, Integer amount, Crowdfunding crowdfunding_id, String type, String url_payment) {
        this.id = id;
        this.amount = amount;
        this.crowdfunding_id = crowdfunding_id;
        this.type = type;
        this.url_payment = url_payment;
    }

    public Payment(Integer amount, Crowdfunding crowdfunding_id, String type, String url_payment) {
        this.amount = amount;
        this.crowdfunding_id = crowdfunding_id;
        this.type = type;
        this.url_payment = url_payment;
    }

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Crowdfunding getCrowdfunding_id() {
        return crowdfunding_id;
    }

    public void setCrowdfunding_id(Crowdfunding crowdfunding_id) {
        this.crowdfunding_id = crowdfunding_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl_payment() {
        return url_payment;
    }

    public void setUrl_payment(String url_payment) {
        this.url_payment = url_payment;
    }
}
