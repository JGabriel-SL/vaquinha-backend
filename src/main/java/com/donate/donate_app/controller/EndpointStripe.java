package com.donate.donate_app.controller;
import com.donate.donate_app.DTO.WebhookDTO;
import com.donate.donate_app.service.WebhookPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "endpoint")
public class EndpointStripe {

    @Autowired
    WebhookPayment webhookPayment;

    @PostMapping("/updateTypePayment")
    public void updateTypePayment(
            @RequestBody String payload,
            @RequestHeader("Stripe-Signature") String sigHeader
    ){
        WebhookDTO webhookDTO = new WebhookDTO();
        webhookDTO.setPayload(payload);
        webhookDTO.setSignature(sigHeader);
        webhookPayment.updatePaymentComplete(webhookDTO);

    }
}
