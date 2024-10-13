package com.donate.donate_app.DTO;

public class RequestAIDTO {
    private String title;
    private String content;
    private String cash;

    public RequestAIDTO(String title, String content, String cash) {
        this.title = title;
        this.content = content;
        this.cash = cash;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }



}
