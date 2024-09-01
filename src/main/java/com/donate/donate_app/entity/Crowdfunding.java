package com.donate.donate_app.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "crowdfunding")
public class Crowdfunding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private OffsetDateTime created_at;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users_id;
    private BigDecimal current_amount = BigDecimal.valueOf(0);
    private BigDecimal goal_amount;

    public Crowdfunding(Long id, String description, OffsetDateTime created_at, Users users_id, BigDecimal current_amount, BigDecimal goal_amount) {
        this.id = id;
        this.description = description;
        this.created_at = created_at;
        this.users_id = users_id;
        this.current_amount = current_amount;
        this.goal_amount = goal_amount;
    }

    public Crowdfunding() {

    }
    public Crowdfunding(String description, Users users_id, BigDecimal goal_amount) {
        this.description = description;
        this.created_at = OffsetDateTime.now();
        this.users_id = users_id;
        this.goal_amount = goal_amount;
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

    public BigDecimal getCurrent_amount() {
        return current_amount;
    }

    public void setCurrent_amount(BigDecimal current_amount) {
        this.current_amount = current_amount;
    }

    public BigDecimal getGoal_amount() {
        return goal_amount;
    }

    public void setGoal_amount(BigDecimal goal_amount) {
        this.goal_amount = goal_amount;
    }
}
