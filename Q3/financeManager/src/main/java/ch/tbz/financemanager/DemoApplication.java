package ch.tbz.financemanager;

import ch.tbz.financemanager.model.*;
import ch.tbz.financemanager.report.*;
import ch.tbz.financemanager.exception.*;
import ch.tbz.financemanager.service.AccountManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class DemoApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountManager accountManager = AccountManager.getInstance();

        Account myAccount = createAccount(scanner);
        accountManager.addAccount(myAccount);

        setBudget(scanner, myAccount);

        addTransactions(scanner, myAccount);

        displayStatusAndReports(myAccount);

        scanner.close();
    }

    private static Account createAccount(Scanner scanner) {
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();

        double startBalance = 0;
        while (true) {
            try {
                System.out.print("Enter starting balance: ");
                startBalance = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return new Account(accountName, startBalance);
    }

    private static void setBudget(Scanner scanner, Account account) {
        double budgetLimit = 0;
        while (true) {
            try {
                System.out.print("Enter monthly budget: ");
                budgetLimit = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        account.setBudget(new Budget(budgetLimit));
    }

    private static void addTransactions(Scanner scanner, Account account) {
        boolean continueInput = true;

        while (continueInput) {
            try {
                System.out.print("Enter transaction type (Income/Expense): ");
                String type = scanner.nextLine();

                System.out.print("Enter amount: ");
                double amount = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter description: ");
                String description = scanner.nextLine();

                System.out.print("Enter date (YYYY-MM-DD): ");
                LocalDate date = LocalDate.parse(scanner.nextLine());

                if (type.equalsIgnoreCase("Income")) {
                    System.out.print("Is it recurring? (true/false): ");
                    boolean recurring = Boolean.parseBoolean(scanner.nextLine());
                    account.addTransaction(new Income(amount, date, description, recurring));

                } else if (type.equalsIgnoreCase("Expense")) {
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    System.out.print("Is it essential? (true/false): ");
                    boolean essential = Boolean.parseBoolean(scanner.nextLine());
                    account.addTransaction(new Expense(amount, date, description, category, essential));

                } else {
                    System.out.println("Invalid transaction type!");
                    continue;
                }

            } catch (InvalidTransactionException | BudgetExceededException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input: " + e.getMessage());
            }

            System.out.print("Add another transaction? (yes/no): ");
            String more = scanner.nextLine();
            if (!more.equalsIgnoreCase("yes")) {
                continueInput = false;
            }
        }
    }

    private static void displayStatusAndReports(Account account) {
        System.out.println("\nAccount balance after transactions: " + account.getBalance());
        System.out.println("Budget exceeded? " + !account.checkBudget());

        List<Transaction> transactions = account.getTransactions();

        ReportGenerator report = new ReportGenerator(new SumStrategy(), transactions);
        System.out.println("\n--- Sum Report ---");
        System.out.println(report.generateReport());

        report.setStrategy(new AverageStrategy());
        System.out.println("\n--- Average Report ---");
        System.out.println(report.generateReport());

        report.setStrategy(new TrendStrategy());
        System.out.println("\n--- Trend Report ---");
        System.out.println(report.generateReport());
    }
}
