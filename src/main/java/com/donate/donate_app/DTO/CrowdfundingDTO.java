package com.donate.donate_app.DTO;

import java.math.BigDecimal;

public class CrowdfundingDTO {
    private String title;
    private String description;
    private Long users_id;
    private BigDecimal goal_amount;

    public CrowdfundingDTO(String description, Long users_id, BigDecimal goal_amount, String title) {
        this.description = description;
        this.users_id = users_id;
        this.goal_amount = goal_amount;
        this.title = title;
    }

    public CrowdfundingDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Long users_id) {
        this.users_id = users_id;
    }

    public BigDecimal getGoal_amount() {
        return goal_amount;
    }

    public void setGoal_amount(BigDecimal goal_amount) {
        this.goal_amount = goal_amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
