package org.example.factory;

public class StandardOrder implements Order {
    @Override
    public String getType() {
        return "Standard Order";
    }

    @Override
    public double getPrice() {
        return 100.0;
    }
}
