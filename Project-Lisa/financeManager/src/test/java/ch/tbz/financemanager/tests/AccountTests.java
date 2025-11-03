package ch.tbz.financemanager.tests;

import ch.tbz.financemanager.exception.BudgetExceededException;
import ch.tbz.financemanager.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class AccountTests {

    @Test
    public void testAddIncomeIncreasesBalance() {
        Account acc = new Account("Test", 100, 1234);
        Transaction income = new Income(200, LocalDate.now(), "Bonus", false);
        acc.addTransaction(income);
        assertEquals(300, acc.getBalance());
    }

    @Test
    public void testAddExpenseDecreasesBalance() {
        Account acc = new Account("Test", 500, 1234);
        Transaction expense = new Expense(-100, LocalDate.now(), "Food", "Groceries", true);
        acc.addTransaction(expense);
        assertEquals(400, acc.getBalance());
    }

    @Test
    public void testBudgetExceededThrowsException() {
        Account acc = new Account("Test", 1000, 1234);
        acc.setBudget(new Budget(50));

        assertThrows(BudgetExceededException.class, () -> {
            acc.addTransaction(new Expense(-100, LocalDate.now(), "Too much", "Fun", false));
        });
    }

    @Test
    public void testRecurringIncomeDetection() {
        Income i = new Income(1000, LocalDate.now(), "Salary", true);
        assertTrue(i.isRecurring());
    }
}
