package ch.tbz.financemanager.report;

import ch.tbz.financemanager.model.Transaction;
import java.util.List;

public class SumStrategy implements ReportStrategy {

    @Override
    public String generate(List<Transaction> transactions) {
        double total = 0;
        for (Transaction t : transactions) {
            total += t.getAmount();
        }
        return "Total Balance Change: " + total;
    }
}
