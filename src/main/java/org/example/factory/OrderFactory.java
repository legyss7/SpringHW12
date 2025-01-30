package org.example.factory;

import org.springframework.stereotype.Component;

@Component
public class OrderFactory {
    public Order createOrder(OrderType type) {
        return switch (type) {
            case STANDARD -> new StandardOrder();
            case EXPRESS -> new ExpressOrder();
            default -> throw new IllegalArgumentException("Неизвестный тип заказа: " + type);
        };
    }
}
