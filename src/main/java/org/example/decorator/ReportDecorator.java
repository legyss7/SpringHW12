package org.example.decorator;

public abstract class ReportDecorator implements ReportComponent {
    protected ReportComponent decoratedReport;

    public ReportDecorator(ReportComponent decoratedReport) {
        this.decoratedReport = decoratedReport;
    }

    @Override
    public String generate() {
        return decoratedReport.generate();
    }
}
