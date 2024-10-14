package com.donate.donate_app.DTO;

public class WebhookDTO {
    String payload;
    String signature;

    public WebhookDTO(String payload, String signature) {
        this.payload = payload;
        this.signature = signature;
    }

    public WebhookDTO() {
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
