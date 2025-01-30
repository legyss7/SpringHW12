package org.example.service;

import lombok.Setter;
import org.example.strategy.ReportStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Setter
@Service
public class ReportService {
    // Метод для смены стратегии во время выполнения
    private ReportStrategy reportStrategy;

    @Autowired
    public ReportService(@Qualifier("CSVReportStrategy") ReportStrategy reportStrategy) {
        this.reportStrategy = reportStrategy;
    }

    // Генерация отчета с текущей стратегией
    public String generateReport() {
        return reportStrategy.generate();
    }
}

