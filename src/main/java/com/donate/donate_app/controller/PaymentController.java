package com.donate.donate_app.controller;

import com.donate.donate_app.DTO.PaymentDTO;
import com.donate.donate_app.entity.Crowdfunding;
import com.donate.donate_app.entity.Payment;
import com.donate.donate_app.mapping.PaymentMapping;
import com.donate.donate_app.repository.CrowdfundingRepository;
import com.donate.donate_app.repository.PaymentRepository;
import com.donate.donate_app.response.PaymentResponse;
import com.donate.donate_app.service.Firebase;
import com.donate.donate_app.service.Stripe;
import com.google.firebase.auth.FirebaseAuthException;
import com.stripe.model.checkout.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    CrowdfundingRepository crowdfundingRepository;

    @Autowired
    PaymentMapping paymentMapping;

    @Autowired
    Stripe stripe;

    @Autowired
    Firebase firebase;

    @PostMapping
    public PaymentResponse createPayment(@RequestBody PaymentDTO data, @RequestHeader String authorization) throws FirebaseAuthException {
        firebase.verifyFirebaseToken(authorization);
        Crowdfunding crowdfunding = crowdfundingRepository.findById(data.getCrowdfunding_id()).orElseThrow();
        Session paymentSession = stripe.GeneratePaymentLink(crowdfunding.getDescription(),data.getAmount());
        Payment newResponse = new Payment(data.getAmount(),crowdfunding,data.getType(),paymentSession.getUrl(), paymentSession.getId());
        paymentRepository.save(newResponse);
        PaymentResponse paymentResponse = paymentMapping.PaymentToResponse(newResponse);
        return paymentResponse;

    }



}
