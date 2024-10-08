package com.donate.donate_app.response;

import com.donate.donate_app.entity.Analisys;
import com.donate.donate_app.enums.StatusAnalisys;

public class AnalisysResponse {

    private Long id;
    private String crowdfunding_title;
    private Long crowdfunding_id;
    private String user_name;
    private Long user_id;
    private StatusAnalisys status;

    public AnalisysResponse() {}

    public AnalisysResponse(Analisys analisys) {
        this.id = analisys.getId();
        this.crowdfunding_title = analisys.getCrowdfunding_id().getTitle();
        this.crowdfunding_id = analisys.getCrowdfunding_id().getId();
        this.user_name = analisys.getUsers_id().getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrowdfunding_title() {
        return crowdfunding_title;
    }

    public void setCrowdfunding_title(String crowdfunding_title) {
        this.crowdfunding_title = crowdfunding_title;
    }

    public Long getCrowdfunding_id() {
        return crowdfunding_id;
    }

    public void setCrowdfunding_id(Long crowdfunding_id) {
        this.crowdfunding_id = crowdfunding_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public StatusAnalisys getStatus() {
        return status;
    }

    public void setStatus(StatusAnalisys status) {
        this.status = status;
    }
}
