package com.donate.donate_app.config;

import com.stripe.Stripe;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {
    public StripeConfig() {
        Stripe.apiKey = "sk_test_51PrWJDEupnUDbsJNmVmKftVaP9Ythk2w5Gqbq6MRw26NQYsRa2uyIVYRl50qG9nO8mt5nPRSHwcN7jZ2DE8Xqbdb00uxWsVilO";
    }
}

