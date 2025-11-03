package ch.tbz.financemanager.report;

import ch.tbz.financemanager.model.Transaction;
import java.util.List;

/**
 * Strategy Pattern is used here:
 * ReportStrategy is the interface (Strategy)
 * SumStrategy, AverageStrategy, TrendStrategy are concrete strategies
 *
 * Reason: Different reporting strategies can be swapped at runtime
 * without changing the code that uses them.
 */
public interface ReportStrategy {
    String generate(List<Transaction> transactions);
}
