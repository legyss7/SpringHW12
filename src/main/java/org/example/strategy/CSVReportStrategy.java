package org.example.strategy;

import org.springframework.stereotype.Component;

@Component
public class CSVReportStrategy implements ReportStrategy {
    @Override
    public String generate() {
        return "CSV Report Content";
    }
}

