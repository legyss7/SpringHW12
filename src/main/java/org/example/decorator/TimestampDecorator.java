package org.example.decorator;

import java.time.LocalDateTime;

public class TimestampDecorator extends ReportDecorator {
    public TimestampDecorator(ReportComponent decoratedReport) {
        super(decoratedReport);
    }

    @Override
    public String generate() {
        return super.generate() + "\nВремя генерации: " + LocalDateTime.now();
    }
}
