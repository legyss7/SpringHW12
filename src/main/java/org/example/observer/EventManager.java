package org.example.observer;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class EventManager {
    private final List<Observer> observers = new ArrayList<>();

    // Подписка на события
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    // Отписка от событий (добавляем этот метод)
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    // Уведомление всех подписчиков
    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}
