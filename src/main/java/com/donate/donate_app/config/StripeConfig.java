package com.donate.donate_app.config;

import com.stripe.Stripe;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {
    public StripeConfig() {
        Stripe.apiKey = EnvironmentManager.getInstance().getEnv("STRIPE_API_KEY");
    }
}

