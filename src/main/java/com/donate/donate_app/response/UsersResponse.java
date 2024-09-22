package com.donate.donate_app.response;

public class UsersResponse {
    private Long id;
    private String name;
    private String email;
    private String auth_id;

    public UsersResponse(Long id, String name, String email, String auth_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.auth_id = auth_id;
    }

    public UsersResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(String auth_id) {
        this.auth_id = auth_id;
    }
}
