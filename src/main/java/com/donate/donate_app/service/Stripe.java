package com.donate.donate_app.service;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.stereotype.Service;

@Service
public class Stripe {

    public Session GeneratePaymentLink(String name, Integer unitAmount) {
        try {
            // Criação dos parâmetros para a sessão de checkout
            SessionCreateParams params = SessionCreateParams.builder()
                    // Corrigido: Método correto para adicionar os tipos de métodos de pagamento
                    .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                    .setMode(SessionCreateParams.Mode.PAYMENT) // Modo de pagamento (compra única)
                    .setSuccessUrl("https://yourdomain.com/success") // URL de sucesso
                    .setCancelUrl("https://yourdomain.com/cancel")  // URL de cancelamento
                    .addLineItem(
                            SessionCreateParams.LineItem.builder()
                                    .setPriceData(
                                            SessionCreateParams.LineItem.PriceData.builder()
                                                    .setCurrency("brl") // Define a moeda como BRL
                                                    .setUnitAmount(Long.valueOf(unitAmount)) // O valor em centavos
                                                    .setProductData(
                                                            SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                    .setName(name) // Define o nome do produto
                                                                    .build()
                                                    )
                                                    .build()
                                    )
                                    .setQuantity(1L) // Quantidade de itens
                                    .build()
                    )
                    .build();

            // Criação da sessão de checkout
            Session session = Session.create(params);

            // Retorna a URL da sessão de checkout
            return session;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
