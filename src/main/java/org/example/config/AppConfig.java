package org.example.config;

import org.example.strategy.CSVReportStrategy;
import org.example.strategy.JSONReportStrategy;
import org.example.strategy.ReportStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ReportStrategy csvReportStrategy() {
        return new CSVReportStrategy();
    }

    @Bean
    public ReportStrategy jsonReportStrategy() {
        return new JSONReportStrategy();
    }
}
