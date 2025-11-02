package ch.tbz.financemanager.service;

import ch.tbz.financemanager.model.Expense;
import ch.tbz.financemanager.model.Income;
import ch.tbz.financemanager.model.Transaction;

import java.time.LocalDate;

public class TransactionFactory {

    public static Transaction createIncome(double amount, LocalDate date, String description, boolean recurring) {
        return new Income(amount, date, description, recurring);
    }

    public static Transaction createExpense(double amount, LocalDate date, String description, String category, boolean essential) {
        return new Expense(amount, date, description, category, essential);
    }
}
