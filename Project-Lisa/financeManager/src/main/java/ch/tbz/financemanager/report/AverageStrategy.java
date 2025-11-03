package ch.tbz.financemanager.report;

import ch.tbz.financemanager.model.Transaction;
import java.util.List;

public class AverageStrategy implements ReportStrategy {

    @Override
    public String generate(List<Transaction> transactions) {
        if (transactions.isEmpty()) return "No transactions available.";
        double sum = 0;
        for (Transaction t : transactions) {
            sum += t.getAmount();
        }
        return "Average Transaction Amount: " + (sum / transactions.size());
    }
}
