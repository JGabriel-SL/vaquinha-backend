package com.donate.donate_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@Service
public class Stripe {

    @Autowired
    FormDataForMap formDataForMap;

    public String GeneratePaymentLink(String name ,Integer unit_amount){
        try {
            // URL da API do Stripe
            String url = "https://api.stripe.com/v1/checkout/sessions";

            // Configuração da autenticação Basic com o API Key
            String authValue = "Basic " + java.util.Base64.getEncoder()
                    .encodeToString(("sk_test_51PrWJDEupnUDbsJNmVmKftVaP9Ythk2w5Gqbq6MRw26NQYsRa2uyIVYRl50qG9nO8mt5nPRSHwcN7jZ2DE8Xqbdb00uxWsVilO:").getBytes());

            // Dados do corpo da requisição em form-urlencoded
            String formData = formDataForMap.buildFormData(Map.of(
                    "payment_method_types[]", "card",
                    "line_items[][price_data][unit_amount]", String.format("%d",unit_amount),
                    "line_items[][price_data][currency]", "brl",
                    "line_items[][price_data][product_data][name]", String.format("%s",name),
                    "line_items[][quantity]", "1",
                    "mode", "payment",
                    "success_url", "https://yourdomain.com/success"
            ));

            // Construção da requisição HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .header("Authorization", authValue)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(formData))
                    .build();

            // Envio da requisição e obtenção da resposta
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Exibição da resposta
            return response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
