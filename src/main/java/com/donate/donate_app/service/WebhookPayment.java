package com.donate.donate_app.service;

import com.donate.donate_app.DTO.WebhookDTO;
import com.donate.donate_app.config.EnvironmentManager;
import com.donate.donate_app.entity.Crowdfunding;
import com.donate.donate_app.entity.Payment;
import com.donate.donate_app.repository.CrowdfundingRepository;
import com.donate.donate_app.repository.PaymentRepository;
import com.donate.donate_app.util.Constraints;
import com.stripe.model.Event;
import com.stripe.model.checkout.Session;
import com.stripe.net.Webhook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebhookPayment {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    CrowdfundingRepository crowdfundingRepository;

    public void updatePaymentComplete(WebhookDTO webhookDTO){

        Event event = null;
        try {
            event = Webhook.constructEvent(
                    webhookDTO.getPayload(), webhookDTO.getSignature(), EnvironmentManager.getInstance().getEnv("STRIPE_WEBHOOK_SECRET")
            );
        } catch (Exception e) {
            System.out.println("Error");
        }
        Session session = (Session) event.getDataObjectDeserializer().getObject().orElse(null);
        System.out.println(session.getId());
        Payment payment = paymentRepository.findByIdPayment(session.getId());
        System.out.println(payment);
        Crowdfunding crowdfunding = crowdfundingRepository.findById(payment.getCrowdfunding_id().getId()).orElseThrow();
        System.out.println(crowdfunding.getId());
        crowdfunding.setCurrent_amount(crowdfunding.getCurrent_amount()+payment.getAmount());
        System.out.println(crowdfunding.getCurrent_amount());
        crowdfundingRepository.save(crowdfunding);





    }
}
