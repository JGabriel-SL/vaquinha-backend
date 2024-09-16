package com.donate.donate_app.controller;

import com.donate.donate_app.DTO.PaymentDTO;
import com.donate.donate_app.entity.Crowdfunding;
import com.donate.donate_app.entity.Payment;
import com.donate.donate_app.mapping.PaymentMapping;
import com.donate.donate_app.repository.CrowdfundingRepository;
import com.donate.donate_app.repository.PaymentRepository;
import com.donate.donate_app.response.PaymentResponse;
import com.donate.donate_app.service.Stripe;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public PaymentResponse createPayment(@RequestBody PaymentDTO data){
        Crowdfunding crowdfunding = crowdfundingRepository.findById(data.getCrowdfunding_id()).orElseThrow();
        JsonObject jsonObject = JsonParser.parseString(stripe.GeneratePaymentLink(crowdfunding.getDescription(),data.getAmount())).getAsJsonObject();
        Payment newResponse = new Payment(data.getAmount(),crowdfunding,data.getType(),jsonObject.get("url").getAsString());
        paymentRepository.save(newResponse);
        PaymentResponse paymentResponse = paymentMapping.PaymentToResponse(newResponse);
        return paymentResponse;

    }


}
