package com.donate.donate_app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "analisys")
public class Analisys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "crowdfunding_id")
    private Crowdfunding crowdfunding_id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users_id;

    private String refuse_motive;
    private String status;

    public Analisys() {}

    public Analisys(Long id, Crowdfunding crowdfunding, Users users, String refuse_motive, String status) {
        this.id = id;
        this.crowdfunding_id = crowdfunding;
        this.users_id = users;
        this.refuse_motive = refuse_motive;
        this.status = status;
    }

    public Analisys(Crowdfunding crowdfunding, Users users, String refuse_motive, String status) {
        this.crowdfunding_id = crowdfunding;
        this.users_id = users;
        this.refuse_motive = refuse_motive;
        this.status = status;
    }

    public String getRefuse_motive() {
        return refuse_motive;
    }

    public void setRefuse_motive(String refuse_motive) {
        this.refuse_motive = refuse_motive;
    }

    public Users getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Users users_id) {
        this.users_id = users_id;
    }

    public Crowdfunding getCrowdfunding_id() {
        return crowdfunding_id;
    }

    public void setCrowdfunding_id(Crowdfunding crowdfunding_id) {
        this.crowdfunding_id = crowdfunding_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
