package org.example.decorator;

public class FooterDecorator extends ReportDecorator {
    public FooterDecorator(ReportComponent decoratedReport) {
        super(decoratedReport);
    }

    @Override
    public String generate() {
        return super.generate() + "\nПодпись: © 2025 MyCompany";
    }
}
