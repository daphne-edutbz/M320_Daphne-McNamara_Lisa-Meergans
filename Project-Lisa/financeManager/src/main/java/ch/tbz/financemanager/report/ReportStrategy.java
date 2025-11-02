package ch.tbz.financemanager.report;

import ch.tbz.financemanager.model.Transaction;
import java.util.List;

public interface ReportStrategy {
    String generate(List<Transaction> transactions);
}
