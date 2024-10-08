package com.donate.donate_app.DTO;

public class UsersDTO {
    private String email;
    private String name;
    private String auth_id;

    public UsersDTO(String email, String name, String auth_id) {
        this.email = email;
        this.name = name;
        this.auth_id = auth_id;
    }

    public UsersDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String setAuth_id() {
        return auth_id;
    }

    public void setAuth_id(String auth_id) {
        this.auth_id = auth_id;
    }
}
