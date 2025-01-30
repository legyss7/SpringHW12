package org.example.strategy;

import org.springframework.stereotype.Component;

@Component
public class JSONReportStrategy implements ReportStrategy {
    @Override
    public String generate() {
        return "{ \"report\": \"JSON Report Content\" }";
    }
}
