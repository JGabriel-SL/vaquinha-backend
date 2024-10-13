package com.donate.donate_app.entity;
import com.donate.donate_app.enums.StatusCrowdfunding;
import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "crowdfunding")
public class Crowdfunding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Enumerated(EnumType.STRING)
    private StatusCrowdfunding status;

    private String description;
    private OffsetDateTime created_at;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users_id;

    private Integer current_amount = 0;
    private Integer goal_amount;

    public Crowdfunding(Long id, String description, OffsetDateTime created_at, Users users_id, Integer current_amount, Integer goal_amount, StatusCrowdfunding status, String title) {
        this.id = id;
        this.description = description;
        this.created_at = created_at;
        this.users_id = users_id;
        this.current_amount = current_amount;
        this.goal_amount = goal_amount;
        this.status = status;
        this.title = title;
    }

    public Crowdfunding() {

    }
    public Crowdfunding(String description, Users users_id, Integer goal_amount, String title) {
        this.description = description;
        this.created_at = OffsetDateTime.now();
        this.users_id = users_id;
        this.goal_amount = goal_amount;
        this.title = title;
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

    public Users getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Users users_id) {
        this.users_id = users_id;
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

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public StatusCrowdfunding getStatus() { return status; }

    public void setStatus(StatusCrowdfunding status) { this.status = status; }
}

