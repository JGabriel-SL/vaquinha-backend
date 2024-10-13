package com.donate.donate_app.DTO;

public class RequestLoginAIDTO {
    private String name;
    private String password;

    public RequestLoginAIDTO() {}

    public RequestLoginAIDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
