package org.example;

import org.example.adapter.PaymentAdapter;
import org.example.adapter.StripePaymentAdapter;
import org.example.config.AppConfig;
import org.example.decorator.*;
import org.example.event.EventService;
import org.example.factory.*;
import org.example.observer.*;
import org.example.service.ReportService;
import org.example.strategy.CSVReportStrategy;
import org.example.strategy.JSONReportStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class SpringPatternsApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(SpringPatternsApplication.class);
    private final AppConfig appConfig;

    @Autowired
    public SpringPatternsApplication(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringPatternsApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        logger.info("Запуск демонстрации паттернов в Spring!");

        // Decorator
        logger.info("\nПроверка паттерна Декоратор");
        ReportComponent report = new SimpleReport();
        logger.info("Обычный отчет:\n{}", report.generate());
        ReportComponent signedReport = new FooterDecorator(report);
        logger.info("Отчет с подписью:\n{}", signedReport.generate());
        ReportComponent timestampedReport = new TimestampDecorator(signedReport);
        logger.info("Отчет с временной меткой:\n{}", timestampedReport.generate());

        // Observer
        logger.info("\nПроверка паттерна Наблюдатель (Observer)");
        EventManager eventManager = new EventManager();
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");
        eventManager.subscribe(observer1);
        eventManager.subscribe(observer2);
        eventManager.notifyObservers("Новое событие в системе!");
        eventManager.unsubscribe(observer1);
        eventManager.notifyObservers("Еще одно событие, но уже с одним подписчиком!");

        // Factory
        logger.info("\nПроверка паттерна Factory");
        OrderFactory orderFactory = new OrderFactory();
        Order order1 = orderFactory.createOrder(OrderType.STANDARD);
        Order order2 = orderFactory.createOrder(OrderType.EXPRESS);
        logger.info("Создан заказ: {}", order1);
        logger.info("Создан заказ: {}", order2);

        // Strategy
        logger.info("\nПроверка паттерна Strategy");
        ReportService reportService = new ReportService(new CSVReportStrategy());
        logger.info("CSV Отчет: {}", reportService.generateReport());
        reportService.setReportStrategy(new JSONReportStrategy());
        logger.info("JSON Отчет: {}", reportService.generateReport());

        // Adapter
        logger.info("\nПроверка паттерна Adapter");
        PaymentAdapter paymentAdapter = new StripePaymentAdapter();
        double amount = 100.50;
        paymentAdapter.processPayment(amount);

        // Event
        logger.info("\nПроверка паттерна Event");
        EventService eventService = new EventService();
        eventService.publishEvent("Заказ отправлен!");

        // Singleton
        logger.info("\nПроверка паттерна Singleton");
        logger.info("Конфигурация загружена: {}", appConfig);
    }
}
