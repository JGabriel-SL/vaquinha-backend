package com.donate.donate_app.response;


import com.donate.donate_app.enums.StatusCrowdfunding;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class CrowdfundingResponse {
    private Long id;
    private String description;
    private OffsetDateTime created_at;
    private Integer current_amount;
    private Integer goal_amount;
    private StatusCrowdfunding status;

    public CrowdfundingResponse(Long id, String description, OffsetDateTime created_at, Integer current_amount, Integer goal_amount, StatusCrowdfunding status) {
        this.id = id;
        this.description = description;
        this.created_at = created_at;
        this.current_amount = current_amount;
        this.goal_amount = goal_amount;
        this.status = status;
    }

    public CrowdfundingResponse() {
    }

    public StatusCrowdfunding getStatus() {
        return status;
    }

    public void setStatus(StatusCrowdfunding status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(OffsetDateTime created_at) {
        this.created_at = created_at;
    }

    public Integer getCurrent_amount() {
        return current_amount;
    }

    public void setCurrent_amount(Integer current_amount) {
        this.current_amount = current_amount;
    }

    public Integer getGoal_amount() {
        return goal_amount;
    }

    public void setGoal_amount(Integer goal_amount) {
        this.goal_amount = goal_amount;
    }
}
