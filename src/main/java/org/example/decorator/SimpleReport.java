package org.example.decorator;

public class SimpleReport implements ReportComponent {
    @Override
    public String generate() {
        return "Это основной отчет";
    }
}
