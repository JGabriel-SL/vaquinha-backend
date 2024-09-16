package com.donate.donate_app.mapping;

import com.donate.donate_app.entity.Payment;
import com.donate.donate_app.response.PaymentResponse;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapping {

    public PaymentResponse PaymentToResponse(Payment data){
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setAmount(data.getAmount());
        paymentResponse.setCrowdfunding_id(data.getCrowdfunding_id().getId());
        paymentResponse.setType(data.getType());
        paymentResponse.setUrl(data.getUrl_payment());

        return paymentResponse;
    }
}
