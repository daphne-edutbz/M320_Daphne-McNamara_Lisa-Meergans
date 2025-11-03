package ch.tbz.financemanager.report;

import ch.tbz.financemanager.model.Expense;
import ch.tbz.financemanager.model.Income;
import ch.tbz.financemanager.model.Transaction;
import java.util.List;

public class TrendStrategy implements ReportStrategy {

    @Override
    public String generate(List<Transaction> transactions) {
        long recurringCount = transactions.stream()
                .filter(t -> t instanceof Income i && i.isRecurring())
                .count();

        long essentialExpenses = transactions.stream()
                .filter(t -> t instanceof Expense e && e.isEssential())
                .count();

        return """
        --- Trend Report ---
        Recurring Incomes: %d
        Essential Expenses: %d
        """.formatted(recurringCount, essentialExpenses);
    }

}
