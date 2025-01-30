package org.example.adapter;

public class StripePaymentAdapter implements PaymentAdapter {
    @Override
    public void processPayment(double amount) {
        System.out.println("Оплата через Stripe: $" + amount);
    }
}
