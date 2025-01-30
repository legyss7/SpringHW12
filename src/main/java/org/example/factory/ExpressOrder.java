package org.example.factory;

public class ExpressOrder implements Order {
    @Override
    public String getType() {
        return "Express Order";
    }

    @Override
    public double getPrice() {
        return 200.0;
    }
}
