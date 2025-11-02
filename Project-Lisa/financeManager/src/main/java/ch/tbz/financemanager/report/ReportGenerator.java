package ch.tbz.financemanager.report;

import ch.tbz.financemanager.model.Transaction;
import java.util.List;

public class ReportGenerator implements Reportable {

    private ReportStrategy strategy;
    private List<Transaction> transactions;

    public ReportGenerator(ReportStrategy strategy, List<Transaction> transactions) {
        this.strategy = strategy;
        this.transactions = transactions;
    }

    public void setStrategy(ReportStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public String generateReport() {
        return strategy.generate(transactions);
    }
}
