package com.donate.donate_app.controller;

import com.donate.donate_app.repository.PaymentRepository;
import com.stripe.model.Event;
import com.stripe.net.Webhook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "endpoint")
public class EndpointStripe {

    @Autowired
    PaymentRepository paymentRepository;

    private static final String STRIPE_WEBHOOK_SECRET = "whsec_G6M6ZqgOPBGIdeHdu8d0ARYylAfDxK4N";

    @PostMapping("/updateTypePayment")
    public void updateTypePayment(
            @RequestBody String payload,
            @RequestHeader("Stripe-Signature") String sigHeader
    ){
        Event event = null;
        try {
            event = Webhook.constructEvent(
                    payload, sigHeader, STRIPE_WEBHOOK_SECRET
            );
        } catch (Exception e) {
            System.out.println("Error");
        }

        String eventType = event.getType();
        
         System.out.println(eventType);

    }
}
