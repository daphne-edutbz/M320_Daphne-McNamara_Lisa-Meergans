package ch.tbz.financemanager.controller;

import ch.tbz.financemanager.model.*;
import ch.tbz.financemanager.service.*;
import ch.tbz.financemanager.report.*;
import ch.tbz.financemanager.exception.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
// ================================================
// This project was partially assisted by ChatGPT.
// The AI helped with structuring reports, transaction handling,
// and generating example test code.
// ================================================

/**
 * Handles user interactions (console UI) for account and transaction management.
 */
public class AccountController {

    private final Scanner scanner = new Scanner(System.in);
    private final AccountManager accountManager = AccountManager.getInstance();
    private final ReportService reportService = new ReportService();

    public void startMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n===== Finance Manager =====");
            System.out.println("1. Create Account");
            System.out.println("2. Add Transaction");
            System.out.println("3. Show All Accounts");
            System.out.println("4. Generate Reports");
            System.out.println("5. Delete Account");
            System.out.println("6. Update Account");
            System.out.println("7. Show Transaction Statistics");
            System.out.println("8. Show Budget Status");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> createAccount();
                case "2" -> addTransactionToAccount();
                case "3" -> showAccounts();
                case "4" -> generateReports();
                case "5" -> deleteAccount();
                case "6" -> updateAccount();
                case "7" -> showTransactionStatistics();
                case "8" -> showBudgetStatus();
                case "9" -> running = false;
                default -> System.out.println("Invalid input. Please try again.");
            }

        }
        System.out.println("Program terminated.");
    }

    private void createAccount() {
        System.out.print("Account name: ");
        String name = scanner.nextLine();

        double startBalance = readDouble("Starting balance: ");
        int pin = (int) readDouble("Set a 4-digit PIN: ");

        Account account = new Account(name, startBalance, pin);

        double budgetLimit = readDouble("Monthly budget: ");
        account.setBudget(new Budget(budgetLimit));

        accountManager.addAccount(account);
        System.out.println("Account successfully created!");
    }


    private void addTransactionToAccount() {
        if (accountManager.getAccounts().isEmpty()) {
            System.out.println("No accounts exist yet.");
            return;
        }

        showAccounts();
        int index = (int) readDouble("Select account index: ") - 1;

        if (index < 0 || index >= accountManager.getAccounts().size()) {
            System.out.println("Invalid index.");
            return;
        }

        Account account = accountManager.getAccounts().get(index);
        System.out.print("Transaction type (Income/Expense): ");
        String type = scanner.nextLine();

        double amount = readDouble("Amount: ");
        System.out.print("Description: ");
        String description = scanner.nextLine();
        LocalDate date = LocalDate.now();

        try {
            Transaction transaction;
            if (type.equalsIgnoreCase("Income")) {
                boolean recurring = readBoolean("Recurring (true/false): ");
                transaction = TransactionFactory.createIncome(amount, date, description, recurring);
            } else if (type.equalsIgnoreCase("Expense")) {
                System.out.print("Category: ");
                String category = scanner.nextLine();
                boolean essential = readBoolean("Essential (true/false): ");
                transaction = TransactionFactory.createExpense(amount, date, description, category, essential);
            } else {
                System.out.println("Invalid transaction type!");
                return;
            }

            account.addTransaction(transaction);
            System.out.println("Transaction successfully added!");

        } catch (InvalidTransactionException | BudgetExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void showAccounts() {
        List<Account> accounts = accountManager.getAccounts();
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("\n--- Account Overview ---");
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            System.out.println((i + 1) + ". " + acc.getAccountName() +
                    " | Balance: " + acc.getBalance() +
                    " CHF | Within budget: " + acc.checkBudget());
        }
    }

    private void generateReports() {
        if (accountManager.getAccounts().isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        showAccounts();
        int index = (int) readDouble("Select account index: ") - 1;
        if (index < 0 || index >= accountManager.getAccounts().size()) {
            System.out.println("Invalid index.");
            return;
        }

        Account account = accountManager.getAccounts().get(index);
        List<Transaction> transactions = account.getTransactions();

        System.out.println("\n--- Report Selection ---");
        System.out.println("1. Sum Report");
        System.out.println("2. Average Report");
        System.out.println("3. Trend Report");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        ReportStrategy strategy = switch (choice) {
            case "1" -> new SumStrategy();
            case "2" -> new AverageStrategy();
            case "3" -> new TrendStrategy();
            default -> null;
        };

        if (strategy == null) {
            System.out.println("Invalid selection.");
            return;
        }

        String result = reportService.generateReport(transactions, strategy);
        System.out.println(result);
    }

    private void showTransactionStatistics() {
        if (accountManager.getAccounts().isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        showAccounts();
        int index = (int) readDouble("Select account index: ") - 1;
        if (index < 0 || index >= accountManager.getAccounts().size()) {
            System.out.println("Invalid index.");
            return;
        }

        Account account = accountManager.getAccounts().get(index);
        List<Transaction> transactions = account.getTransactions();

        System.out.println("\n--- Transaction Insights ---");
        System.out.println("1. Show essential expenses");
        System.out.println("2. Show recurring incomes");
        System.out.println("3. Show expenses above limit");
        System.out.print("Choose option: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1" -> transactions.stream()
                    .filter(t -> t instanceof Expense e && e.isEssential())
                    .forEach(System.out::println);

            case "2" -> transactions.stream()
                    .filter(t -> t instanceof Income i && i.isRecurring())
                    .forEach(System.out::println);

            case "3" -> {
                double limit = readDouble("Enter limit: ");
                transactions.stream()
                        .filter(t -> t instanceof Expense e && e.isAboveLimit(limit))
                        .forEach(System.out::println);
            }

            default -> System.out.println("Invalid choice.");
        }
    }

    // Utility input methods
    private double readDouble(String prompt) {
        // Clean-Code: keeps prompting user until valid number is entered
        // avoids duplicate code and ensures robustness
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private boolean readBoolean(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("true")) return true;
            if (input.equalsIgnoreCase("false")) return false;
            System.out.println("Please enter 'true' or 'false'.");
        }
    }

    private void deleteAccount() {
        if (accountManager.getAccounts().isEmpty()) {
            System.out.println("No accounts available to delete.");
            return;
        }

        System.out.print("Enter admin code to delete an account: ");
        String code = scanner.nextLine();

        if (!code.equals("123")) {
            System.out.println("Invalid code! Access denied.");
            return;
        }

        showAccounts();
        int index = (int) readDouble("Select account index to delete: ") - 1;

        if (index < 0 || index >= accountManager.getAccounts().size()) {
            System.out.println("Invalid index.");
            return;
        }

        Account accountToRemove = accountManager.getAccounts().get(index);
        accountManager.removeAccount(accountToRemove);

        System.out.println("Account '" + accountToRemove.getAccountName() + "' has been deleted.");
    }

    private void updateAccount() {
        if (accountManager.getAccounts().isEmpty()) {
            System.out.println("No accounts exist yet.");
            return;
        }

        showAccounts();
        int index = (int) readDouble("Select account index: ") - 1;

        if (index < 0 || index >= accountManager.getAccounts().size()) {
            System.out.println("Invalid index.");
            return;
        }

        Account account = accountManager.getAccounts().get(index);

        int enteredPin = (int) readDouble("Enter your PIN: ");
        if (enteredPin != account.getPin()) {
            System.out.println("Incorrect PIN! Update aborted.");
            return;
        }

        System.out.println("What would you like to update?");
        System.out.println("1. Account name");
        System.out.println("2. Budget limit");
        System.out.println("3. PIN code");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1" -> {
                System.out.print("New account name: ");
                String newName = scanner.nextLine();
                account.setAccountName(newName);
                System.out.println("Account name updated successfully!");
            }
            case "2" -> {
                double newLimit = readDouble("New budget limit: ");
                account.setBudget(new Budget(newLimit));
                System.out.println("Budget updated successfully!");
            }
            case "3" -> {
                int newPin = (int) readDouble("Enter new 4-digit PIN: ");
                account.setPin(newPin);
                System.out.println("PIN updated successfully!");
            }
            default -> System.out.println("Invalid selection.");
        }
    }

    private void showBudgetStatus() {
        if (accountManager.getAccounts().isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        showAccounts();
        int index = (int) readDouble("Select account index: ") - 1;

        if (index < 0 || index >= accountManager.getAccounts().size()) {
            System.out.println("Invalid index.");
            return;
        }

        Account account = accountManager.getAccounts().get(index);
        if (account.getBudget() == null) {
            System.out.println("This account has no budget set.");
            return;
        }

        account.getBudget().printBudgetStatus(account.getTransactions());
    }

}
